package case_fruit.model;

public class Product {
    private int product_id;
    private String name;
    private String description;
    private int price;
    private String image;
    private int category_id;

    public Product() {}

    public Product(int product_id, String name, String description, int price, String image, int category_id) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category_id = category_id;
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}