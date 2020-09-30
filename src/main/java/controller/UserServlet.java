package controller;

import model.IceCream;
import model.Users;
import service.IceCreamDAO;
import service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/trangchu")
public class UserServlet extends HttpServlet {

    private IceCreamDAO iceCreamDAO = new IceCreamDAO();
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "add":
                    insertIceCream(request,response);
                    break;
                case "delete":
                    deleteIceCream(request,response);
                    break;
                case "update":
                    updateIceCream(request,response);
                    break;
                case "logout" :
                    logout(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "checklogin":
                    checklogin(request,response);
                    break;
                case "search":
                    searchIceCream(request,response);
                    break;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "trangchuadmin":
                    listIceCreamAdmin(request,response);
                    break;
                default:
                    listIceCream(request, response);
                    break;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void listIceCream(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException{
        List<IceCream> iceCreamList = iceCreamDAO.selectAllIceCream();
        request.setAttribute("listIceCream", iceCreamList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer/trangchu.jsp");
        dispatcher.forward(request, response);
    }

    private void listIceCreamAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException{
        List<IceCream> iceCreamList = iceCreamDAO.selectAllIceCream();
        request.setAttribute("listIceCream", iceCreamList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Addmin/trangchuadmin.jsp");
        dispatcher.forward(request, response);
    }


    private void login(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("Addmin/login.jsp");
        dispatcher.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)throws  SQLException, IOException, ServletException{
        listIceCream(request,response);
    }

    private void checklogin(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        Users users = new Users();
        if (userDAO.searchUser(name) != null){
            users = userDAO.searchUser(name);
        }
        if (users.getUserPassword().equals(password)){
            try {
                listIceCreamAdmin(request,response);
            }catch (SQLException ex){
                ex.printStackTrace();
                ex.getMessage();
            }
        }else {
            try {
                login(request,response);
            }catch (Exception ex){
                ex.printStackTrace();
                ex.getMessage();
            }
        }
    }

    private void insertIceCream(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int categoryId = Integer.parseInt(request.getParameter("category"));
        String name = request.getParameter("name");
        String imgSrc = request.getParameter("src");
        int discount = Integer.parseInt(request.getParameter("discount"));
        double price = Double.parseDouble(request.getParameter("price"));
        String IceCreamDescription = request.getParameter("discount");
        int soldQuantity = Integer.parseInt(request.getParameter("soldQuantity"));
        IceCream newIceCream = new IceCream(categoryId, name, price,discount,IceCreamDescription,imgSrc, soldQuantity);
        iceCreamDAO.insertIceCream(newIceCream);
        listIceCreamAdmin(request,response);
    }

    private void  deleteIceCream(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        iceCreamDAO.deleteIceCream(id);
        listIceCreamAdmin(request,response);
    }

    private void updateIceCream(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int iceCreamId = Integer.parseInt(request.getParameter("id"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        String name = request.getParameter("name");
        String imgSrc = request.getParameter("src");
        int discount = Integer.parseInt(request.getParameter("discount"));
        double price = Double.parseDouble(request.getParameter("price"));
        String IceCreamDescription = request.getParameter("discount");
        int soldQuantity = Integer.parseInt(request.getParameter("soldQuantity"));
        IceCream updateIceCream = new IceCream(iceCreamId,categoryId, name, price,discount,IceCreamDescription,soldQuantity,imgSrc);
        iceCreamDAO.updateIceCream(updateIceCream);
        listIceCreamAdmin(request,response);
    }

    private void searchIceCream(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        String name = request.getParameter("search");
        List<IceCream> iceCreams = iceCreamDAO.searchIceCreamByName(name);
        request.setAttribute("listIceCream", iceCreams);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer/trangchu.jsp");
        dispatcher.forward(request, response);
    }

}
