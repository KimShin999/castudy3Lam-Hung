package service;

import model.IceCream;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IceCreamDAO implements IiceCreamDAO {
    private static final String UPDATE_ICECREAM = "update ice_cream SET category_id = ?, name = ?, discount = ?, ice_description = ?, price = ?, sold_quantity = ?, src = ? WHERE ice_cream_id = ? " ;
    private String jdbcURL="jdbc:mysql://localhost:3306/ice_cream_shop?userSSL=false";
    private String jdbcUsername = "root";
    private String jbdcPassword = "123456";


    public IceCreamDAO(){

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

    @Override
    public boolean insertIceCream(IceCream iceCream) throws SQLException {
        boolean isInsertIceCream = false;
        String query="{CALL insert_IceCream(?,?,?,?,?,?,?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, iceCream.getCategoryId());
            callableStatement.setString(2,iceCream.getName());
            callableStatement.setInt(3,iceCream.getDiscount());
            callableStatement.setString(4, iceCream.getDescription());
            callableStatement.setDouble(5,iceCream.getPrice());
            callableStatement.setString(6,iceCream.getSrc());
            callableStatement.setInt(7,iceCream.getSoldQuantity());
            callableStatement.executeUpdate();
        } catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return isInsertIceCream;
    }

    @Override
    public List<IceCream> selectAllIceCream() throws SQLException {
        ArrayList<IceCream> iceCreams = new ArrayList<>();
        String query = "{CALL select_all_ice_by_status()}";
//        String query = "{CALL select_all_ice()}";
        try(Connection connection =getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            System.out.println(callableStatement);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ice_cream_id");
                int category = resultSet.getInt("category_id");
                String name = resultSet.getString("name");
                int discount  = resultSet.getInt("discount");
                String iceDiscription = resultSet.getString("ice_description");
                double price = resultSet.getDouble("price");
                String imgSrc = resultSet.getString("src");
                int soldQuantity = resultSet.getInt("sold_quantity");
                iceCreams.add(new IceCream(id,category,name,price,discount,iceDiscription,soldQuantity,imgSrc));
            }
        } catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return iceCreams;
    }

    @Override
    public boolean deleteIceCream(int id) throws SQLException {
        boolean rowDeleted = false;
//        String query = "{CALL delete_ice(?)}";
        String query = "{CALL delete_ice_status(?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,id);
            System.out.println(callableStatement);
            rowDeleted = callableStatement.executeUpdate() >0;
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateIceCream(IceCream iceCream) throws SQLException {
        boolean updateIceCream ;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ICECREAM)) {
            preparedStatement.setInt(8,iceCream.getIceCreamId());
            preparedStatement.setInt(1, iceCream.getCategoryId());
            preparedStatement.setString(2, iceCream.getName());
            preparedStatement.setInt(3, iceCream.getDiscount());
            preparedStatement.setString(4, iceCream.getDescription());
            preparedStatement.setDouble(5, iceCream.getPrice());
            preparedStatement.setString(7, iceCream.getSrc());
            preparedStatement.setInt(6, iceCream.getSoldQuantity());
            updateIceCream = preparedStatement.executeUpdate()>0;
        }
        return updateIceCream;
    }

    @Override
    public IceCream searchIceCream(int id) {
        IceCream iceCream = null;
        String query = "{call search_ice_cream_by_id(?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                id = rs.getInt("ice_cream_id") ;
                int category = rs.getInt("category_id");
                String name = rs.getString("name");
                int discount = rs.getInt("discount");
                String ice_description = rs.getString("ice_description");
                int sold_quantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                String src = rs.getString("src");
                iceCream = new IceCream(id, category, name, price,discount, ice_description, sold_quantity, src);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return iceCream;
    }

    @Override
    public List<IceCream> searchIceCreamByCategory(int idCategory) throws SQLException {
        List<IceCream> iceCreams = new ArrayList<>();
        String query = "{Call get_ice_cream_by_category(?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1, idCategory);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("ice_cream_id") ;
                int category = rs.getInt("category_id");
                String name = rs.getString("name");
                int discount = rs.getInt("discount");
                String ice_description = rs.getString("ice_description");
                int sold_quantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                String src = rs.getString("src");
                iceCreams.add(new IceCream(id, category, name, price,discount, ice_description, sold_quantity, src));
            }
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return iceCreams;
    }

    @Override
    public List<IceCream> searchIceCreamByName(String name) throws SQLException {
        List<IceCream> iceCreams = selectAllIceCream();
        List<IceCream> iceCreamsName = new ArrayList<>();
        try {
            for (IceCream ice: iceCreams) {
                if (ice.getName().toLowerCase().contains(name.toLowerCase())){
                    iceCreamsName.add(ice);
                }
            }
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return iceCreamsName;
    }

    @Override
    public List<IceCream> sortIceCreamByPrice(String Price) throws SQLException {
        List<IceCream> iceCreams = new ArrayList<>();
        String query = "{Call sort_ice_cream_by_price()}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("ice_cream_id") ;
                int category = rs.getInt("category_id");
                String name = rs.getString("name");
                int discount = rs.getInt("discount");
                String ice_description = rs.getString("ice_description");
                int sold_quantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                String src = rs.getString("src");
                iceCreams.add(new IceCream(id, category, name, price,discount, ice_description, sold_quantity, src));
            }
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return iceCreams;
    }

    @Override
    public List<IceCream> sortIceCreambyQuantity(String Quantity) throws SQLException {
        List<IceCream> iceCreams = new ArrayList<>();
        String query = "{Call sort_ice_cream_by_quantity()}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);){
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("ice_cream_id") ;
                int category = rs.getInt("category_id");
                String name = rs.getString("name");
                int discount = rs.getInt("discount");
                String ice_description = rs.getString("ice_description");
                int sold_quantity = rs.getInt("sold_quantity");
                double price = rs.getDouble("price");
                String src = rs.getString("src");
                iceCreams.add(new IceCream(id, category, name, price,discount, ice_description, sold_quantity, src));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return iceCreams;
    }
}
