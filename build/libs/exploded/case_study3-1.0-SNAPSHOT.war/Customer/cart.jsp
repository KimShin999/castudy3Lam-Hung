<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 27/09/2020
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping cart</title>
    <link rel="stylesheet" href="../../../bootstrap-4.5.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/trangchu">Continue shopping</a>

    <table cellpadding="2" cellspacing="2" border="1">
        <tr>
            <th>Ice image</th>
            <th>Ice name</th>
            <th>Ice price</th>
            <th>Ice discount</th>
            <th>Ice quantity</th>
            <th>Price</th>
        </tr>
        <c:set var="total" value="0"></c:set>
        <c:set var="discount" value="0"></c:set>
        <c:set var="quantity" value="0"></c:set>
        <c:forEach var="item" items="${sessionScope.cart}">
            <c:set var="total" value="${total + item.iceCream.price *item.quantity}"></c:set>
            <c:set var="discount" value="${discount + (item.iceCream.price*item.quantity*item.iceCream.discount/100)}"></c:set>
            <c:set var="quantity" value="${quantity + item.quantity}"></c:set>

            <tr>
                <td><img src="${item.iceCream.src}" width="120px"></td>
                <td>${item.iceCream.name}</td>
                <td>${item.iceCream.price}</td>
                <td>${item.iceCream.discount}%</td>
                <td>
                    <a class="btn btn-outline-danger"  href="${pageContext.request.contextPath}/cart?action=remove&id=${item.iceCream.iceCreamId}">-</a>
                        ${item.quantity}
                    <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/cart?action=increase&id=${item.iceCream.iceCreamId}">+</a>
                </td>
                <td>${item.iceCream.price*item.quantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5" align="right">Discount</td>
            <td>${-discount}</td>
        </tr>
        <tr>
            <td colspan="5" align="right">Total</td>
            <td>${total - discount}</td>
        </tr>
    </table>


    <!-- Button to Open the Modal thanh toán-->
    <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#pay">
        Pay
    </button>

    <!-- The Modal thanh toán -->
    <form method="post" action="/cart?action=inforcustomer">
        <div class="modal" id="pay">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" >Enter your Imformation</h5>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label>Enter your name</label>
                            <input name="name" type="text" class="form-control" placeholder="Enter your name">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label >Enter your number phone</label>
                            <input name="number" type="number" class="form-control" placeholder="0999999999">
                        </div>
                        <div class="form-group">
                            <label >Enter your address</label>
                            <input name="address" type="text" class="form-control">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-outline-danger" onclick="return confirm('Order Successfully hjhj')">
                            đã xong
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>



</body>
</html>
<script src="../../../bootstrap-4.5.2-dist/js/bootstrap.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

