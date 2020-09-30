package service;

import model.Item;
import model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemDAO {

    private String jdbcURL="jdbc:mysql://localhost:3306/ice_cream_shop?userSSL=false";
    private String jdbcUsername = "root";
    private String jbdcPassword = "123456";


    public ItemDAO(){

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

    public boolean insertItem(Item item)throws SQLException{
        boolean IsInsertItem = false;
        double pricediscount = item.getIceCream().getDiscount() *item.getIceCream().getPrice()/100;
        double total = 0;
        String query = "{CALL insert_item(?,?,?,?,?)}";
        try (Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1, item.getOrderId());
            callableStatement.setInt(2, item.getIceCream().getIceCreamId());
            callableStatement.setDouble(3,pricediscount);
            callableStatement.setInt(4,item.getQuantity());
            callableStatement.setDouble(5, total);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return IsInsertItem;
    }

}
