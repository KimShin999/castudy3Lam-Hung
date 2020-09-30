package service;

import model.IceCream;
import model.Users;

import javax.xml.registry.infomodel.User;
import java.sql.*;

public class UserDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/ice_cream_shop?userSSL=false";
    private String jdbcUsername = "root";
    private String jbdcPassword = "123456";


    public UserDAO(){

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

    public Users searchUser(String name){
        Users users = null;
        String query = "Call search_User(?)";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setString(1, name);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("user_id");
                String name1 = rs.getString("user_name");
                String password = rs.getString("user_password");
                String email = rs.getString("user_email");
                users = new Users(id, name1, password, email);
            }
        }catch (SQLException e){
            e.printStackTrace();
            e.getMessage();
        }
        return  users;

    }

}
