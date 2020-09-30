package service;

import model.IceCream;

import javax.xml.registry.infomodel.User;
import java.sql.SQLException;
import java.util.List;

public interface IiceCreamDAO {
    public boolean insertIceCream(IceCream iceCream) throws SQLException;

    public List<IceCream> selectAllIceCream() throws SQLException;

    public boolean deleteIceCream(int id) throws SQLException;

    public boolean updateIceCream(IceCream iceCream) throws SQLException;

    public IceCream searchIceCream(int id)throws SQLException;

    public List<IceCream> searchIceCreamByCategory(int idCategory) throws SQLException;

    public List<IceCream> searchIceCreamByName(String name)throws SQLException;

    public List<IceCream> sortIceCreamByPrice(String Price)throws SQLException;

    public List<IceCream> sortIceCreambyQuantity(String Quantity)throws SQLException;
}
