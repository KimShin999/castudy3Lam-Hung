package service;

import model.IceCream;
import model.Item;
import model.Orders;

import javax.persistence.criteria.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/ice_cream_shop?userSSL=false";
    private String jdbcUsername = "root";
    private String jbdcPassword = "123456";


    public OrderDAO(){

    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jbdcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    public boolean insertOrder(Orders order)throws SQLException{
        boolean isInsertOrder = false;
        String query = "{CALL insert_order(?,?,?,?)}";
        double total = 0;
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setString(1, order.getNameCustomer());
            callableStatement.setString(2, order.getAddressCustomer());
            callableStatement.setString(3,order.getNumberPhoneCustomer());
            callableStatement.setDouble(4,total);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isInsertOrder;
    }

    public int selectLastId()throws SQLException{
        int lastID = 0;
        String query = "{CALL select_id_last()}";
        try(Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(query)){
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                lastID = resultSet.getInt("order_id");
            }
        }
        return lastID;
    }



    public List<Item> selectALLItem() throws SQLException{
        List<Item> items = new ArrayList<>();
        String query = "{CALL select_all_item()}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int item = resultSet.getInt("item_id");
                int orderid = resultSet.getInt("order_id");
                int ice_id = resultSet.getInt("ice_cream_id");
                double discount = resultSet.getDouble("pice_discount");
                int quality = resultSet.getInt("quality");
                double total = resultSet.getDouble("total_money");
                items.add(new Item(item,orderid,ice_id, quality));
            }
        }
        return items;
    }

    public List<Orders> selectAllOrder()throws SQLException {
        ArrayList<Orders> orders = new ArrayList<>();
        String query = "{CALL select_all()}";
        List<Item> itemALL = selectALLItem();
        List<Item> itemOrderID = null;
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int orderID = resultSet.getInt("order_id");
                String name = resultSet.getString("name_customer");
                String numberPhone = resultSet.getString("numberphone_customer");
                String address = resultSet.getString("address_customer");
                double total = resultSet.getDouble("total_money");
                for ( Item items: itemALL) {
                    itemOrderID = new ArrayList<>();
                    if (items.getOrderId() == orderID){
                        itemOrderID.add(items);
                    }
                }
                orders.add(new Orders(orderID, name,address, numberPhone, itemOrderID));
            }
        }

        return orders;
    }

}
