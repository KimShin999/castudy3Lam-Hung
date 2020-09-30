package model;

import javax.persistence.criteria.Order;
import java.util.List;

public class Orders {
    private int orderId;
    private String nameCustomer;
    private String addressCustomer;
    private String numberPhoneCustomer;
    private List<Item> items;
    private double totalMoney;

    public Orders(){
    }

    public Orders(String nameCustomer, String addressCustomer, String numberPhoneCustomer){
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.numberPhoneCustomer = numberPhoneCustomer;
    }

    public Orders(String nameCustomer, String addressCustomer, String numberPhoneCustomer, List<Item> items){
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.numberPhoneCustomer = numberPhoneCustomer;
        this.items = items;
    }

    public Orders(int orderId,String nameCustomer, String addressCustomer, String numberPhoneCustomer, List<Item> items){
        this.orderId = orderId;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.numberPhoneCustomer = numberPhoneCustomer;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getNumberPhoneCustomer() {
        return numberPhoneCustomer;
    }

    public void setNumberPhoneCustomer(String numberPhoneCustomer) {
        this.numberPhoneCustomer = numberPhoneCustomer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
