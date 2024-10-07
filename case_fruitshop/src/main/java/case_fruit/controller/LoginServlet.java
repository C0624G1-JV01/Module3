package case_fruit.controller;

import case_fruit.model.Account;
import case_fruit.model.User;
import case_fruit.service.IAccountService;
import case_fruit.service.IUserService;
import case_fruit.service.Impl.AccountService;
import case_fruit.service.Impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/" )
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();
    private IAccountService accountService = new AccountService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "login":
                request.getRequestDispatcher("user/dang-nhap.jsp").forward(request, response);
                break;
            case "logout":
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
                response.sendRedirect(request.getContextPath() + "/giao-dien/cua-hang/trang-chu.jsp");
                break;
            case "register":
                request.getRequestDispatcher("user/dang-ky.jsp").forward(request, response);
                break;
            case "edit":
                HttpSession editsession = request.getSession(false);
                User currentUser = (editsession != null) ? (User) editsession.getAttribute("currentUser") : null; // Lấy thông tin người dùng từ session

                if (currentUser != null) {
                    request.setAttribute("user", currentUser);
                    request.getRequestDispatcher("/user/sua-doi-thong-tin.jsp").forward(request, response); // Chuyển hướng đến trang sửa thông tin
                } else {
                    response.sendRedirect(request.getContextPath() + "/user/dang-nhap.jsp");
                }
                break;

            default:
                response.sendRedirect(request.getContextPath() + "/giao-dien/cua-hang/trang-chu.jsp");
                break;
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "login":
                handleLogin(req, resp);
                break;

            case "register":
                handleRegister(req, resp);
                break;

            case "edit-profile":
                handleEditProfile(req, resp);
                break;

            default:
                resp.sendRedirect(req.getContextPath() + "/giao-dien/cua-hang/trang-chu.jsp");
                break;
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account account = accountService.login(username, password);
        if (account != null) {
            User user = userService.getUserById(account.getUser_id());
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            session.setAttribute("currentAccount", account);
            resp.sendRedirect(req.getContextPath() + "/fruitshop?action=home");
        } else {
            req.setAttribute("error", "Thông tin đăng nhập không chính xác.");
            req.getRequestDispatcher("user/dang-nhap.jsp").forward(req, resp);
        }
    }


    private void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String regUsername = req.getParameter("regUsername");
        String regPassword = req.getParameter("regPassword");

        if (isAnyFieldEmpty(name, email, phone, regUsername, regPassword)) {
            req.setAttribute("error", "Tất cả các trường đều bắt buộc.");
            req.getRequestDispatcher("user/dang-ky.jsp").forward(req, resp);
            return;
        }

        User existingUser = userService.getUserByEmail(email);
        if (existingUser != null) {
            req.setAttribute("error", "Email này đã được sử dụng.");
            req.getRequestDispatcher("user/dang-ky.jsp").forward(req, resp);
            return;
        }

        User newUser = new User(0, name, email, phone, 1);
        int user_id = userService.addUser(newUser);
        if (user_id > 0) {
            Account newAccount = new Account(0, user_id, regUsername, regPassword);
            accountService.addAccount(newAccount);
            req.setAttribute("message", "Đăng ký thành công! Bạn có thể đăng nhập ngay bây giờ.");
            req.getRequestDispatcher("user/dang-nhap.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Đã xảy ra lỗi trong quá trình đăng ký. Vui lòng thử lại.");
            req.getRequestDispatcher("user/dang-ky.jsp").forward(req, resp);
        }
    }


    private void handleEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Account currentAccount = (Account) session.getAttribute("currentAccount");

            if (currentAccount == null) {
                resp.sendRedirect(req.getContextPath() + "/user/dang-nhap.jsp");
                return;
            }

            String newPhone = req.getParameter("phone");
            String oldPassword = req.getParameter("oldPassword");
            String newPassword = req.getParameter("newPassword");
            String confirmPassword = req.getParameter("confirmPassword");

            User currentUser = userService.getUserById(currentAccount.getUser_id());

            if (newPhone != null && !newPhone.trim().isEmpty()) {
                currentUser.setPhoneNumber(newPhone);
            }


            if (oldPassword != null && !oldPassword.trim().isEmpty() &&
                    newPassword != null && !newPassword.trim().isEmpty() &&
                    confirmPassword != null && !confirmPassword.trim().isEmpty()) {
                if (currentAccount.getsetPassword().equals(oldPassword)) {
                    if (newPassword.equals(confirmPassword)) {
                        currentAccount.setPassword(newPassword);
                    } else {
                        req.setAttribute("errorMessage", "Mật khẩu mới và xác nhận mật khẩu không khớp!");
                        req.getRequestDispatcher("/user/sua-doi-thong-tin.jsp").forward(req, resp);
                        return;
                    }
                } else {
                    req.setAttribute("errorMessage", "Mật khẩu cũ không đúng!");
                    req.getRequestDispatcher("/user/sua-doi-thong-tin.jsp").forward(req, resp);
                    return;
                }
            }

            userService.updateUser(currentUser);
            accountService.updateAccount(currentAccount);

            req.setAttribute("successMessage", "Cập nhật thông tin thành công!");
            req.getRequestDispatcher("/user/sua-doi-thong-tin.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/user/dang-nhap.jsp");
        }
    }




    private boolean isAnyFieldEmpty(String... fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}