package model;

public class Item {
    private IceCream iceCream;
    private int itemId;
    private int orderId;
    private int iceCreamId;
    private int quantity;
    private int price;

    public Item(){
    }

    public Item( int itemId, int orderId, int iceCreamId, int quantity, int price){
        this.itemId= itemId;
        this.orderId =orderId;
        this.iceCreamId =iceCreamId;
        this.quantity =quantity;
        this.price =price;
    }

    public Item(int itemId, int orderId, int iceCreamId, int quality){
        this.itemId=itemId;
        this.orderId = orderId;
        this.iceCreamId = iceCreamId;
        this.quantity = quality;
    }

    public Item(IceCream iceCream,int quantity){
        this.iceCream = iceCream;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getIceCreamId() {
        return iceCreamId;
    }

    public void setIceCreamId(int iceCreamId) {
        this.iceCreamId = iceCreamId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }
}
