package model;

public class IceCream {
    private int iceCreamId;
    private int categoryId;
    private String name;
    private double price;
    private String description;
    private int discount;
    private int soldQuantity;
    private String src;

    public IceCream(){
    }

    public IceCream(int categoryId, String name, double price, int discount, String description, String src, int soldQuantity){
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.src = src;
        this.discount = discount;
        this.soldQuantity = soldQuantity;
    }

    public IceCream(int iceCreamId,int categoryId, String name, double price, int discount, String description, int soldQuantity ,String src){
        this.iceCreamId = iceCreamId;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.soldQuantity = soldQuantity;
        this.src = src;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public int getIceCreamId() {
        return iceCreamId;
    }

    public void setIceCreamId(int iceCreamId) {
        this.iceCreamId = iceCreamId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
