<%--
  Created by IntelliJ IDEA.
  User: KimShin
  Date: 9/26/2020
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KimShin
  Date: 9/26/2020
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../../bootstrap-4.5.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<style>
    .carousel-inner img{
        width: 100%;
        height: 100%;
        vertical-align: middle;
        horiz-align: center;
    }
    .carousel-inner h1{
        color: #17a2b8;
        font-weight: bold;
    }
    .nav-item a{
        font-size: large;
    }
    #jumbo-text{
        margin-left: 120px;
    }
    .display-4{
        margin-top: 40px;
    }
    .card{
        margin-left: 60px;
        margin-top: 30px;
    }
    .footer-img{
        margin-left: 70px;
    }
    .card-img-top{
        width: 260px;
        height: 320px;
    }
    .navbar-brand{
        padding: 0;
    }
</style>
<body>
    <nav class="navbar navbar-expand-sm bg-light navbar-light sticky-top">
        <a class="navbar-brand" href="#"><img src="https://i.pinimg.com/236x/35/93/fc/3593fc6c1af7ea7c1560cb08400d5694.jpg" width="50px" height="50px"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Menu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Discounts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Funfacts</a>
                </li>
                <li class="nav-item">

                <li class="nav-item">
                    <form method="post" action="/trangchu?action=logout" >
                        <button type="submit" class="btn btn-outline-danger" style="float: right; position:absolute ; right: 15px; top:auto" >Log out</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form method="post" action="/cart?action=listorder">
                        <button type="submit" class="btn btn-outline-danger" style="float: right; position:absolute ; right: 110px">List Order  <i class="fa fa-shopping-cart"></i></button>
                    </form>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#addNewProduct" style="float: right; position:absolute ; right: 242px">Create new product</button>
                </li>
<%--            <form class="form-inline my-2 my-lg-0" action="/Client?action=search" method="post">--%>
<%--                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">--%>
<%--                <button type="submit" class="btn btn-outline-secondary">TÌM KIẾM</button>--%>
<%--            </form>--%>
            </ul>
        </div>
    </nav>
    <!-- Image Slider-->
    <div id="demo" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
        </ul>
        <!-- The slideshow -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://wallpapershome.com/images/pages/pic_h/14666.jpg">
                <div class="carousel-caption">
                    <h1>LamThon Ice ''Shop</h1>
                    <h3>có mỗi con wave tàu</h3>
                    <button type="button" class="btn btn-outline-light btn-lg">Lam Thon</button>
                    <button type="button" class="btn btn-info btn-lg">Hung dzai</button>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://wallpapershome.com/images/pages/pic_h/15360.jpg">
            </div>
            <div class="carousel-item">
                <img src="https://wallpapershome.com/images/pages/pic_h/15363.jpg">
            </div>
        </div>
        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
    <!--Welcome-->
    <div class="container-fluid">
        <div class="row text-center">
            <div class="col-12">
                <h1 class="display-4">LamThon Ice''Shop</h1>
            </div>
            <hr>
            <div class="col-12">
                <p class="lead">Ra đời năm 2020 với bề dày lịch sử 2h , cùng với các nghệ nhân điêu nghệ nhất trong ngành
                    đã cho ra đời những sản phâm tinh túy nhất đến tay người tiêu dùng</p>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <c:forEach var="iceCream" items="${listIceCream}" >
                <div class="col-sm-6 col-md-4">
                    <div class="card"  style="width: 262px; height: 530px; margin-bottom: 50px">
                        <p hidden name="id" ><c:out value="${iceCream.iceCreamId}"/></p>
                        <img class="card-img-top" src="${iceCream.src}">
                        <div class="card-body">
                            <h4 class="card-title"><c:out value="${iceCream.name}"/></h4>
                            <h5><c:out value="${iceCream.price}"/> </h5>
                            <p class="card-text"><c:out value="${iceCream.description}"/></p>
                            <!-- Button to Open the Modal Update-->
                            <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#Update${iceCream.iceCreamId}">
                                Update
                            </button>
                            <!-- Button to Open the Modal Delete-->
                            <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#exampleModalDelete${iceCream.iceCreamId}">
                                Delete
                            </button>

                            <!-- The Modal Update -->

                                <div class="modal" id="Update${iceCream.iceCreamId}">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form method="post" action="/trangchu?action=update&id=${iceCream.iceCreamId}">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" >Menu Update Product</h5>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="form-group" hidden>
                                                        <label>IceCream Name:</label>
                                                        <input type="text" class="form-control" name="id" value=${iceCream.iceCreamId}/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IceCream Category:</label>
                                                        <select name="category">
                                                            <option value="1">1 - Kem que</option>
                                                            <option value="2">2 - Oc Que </option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IceCream Name:</label>
                                                        <input type="text" class="form-control" name="name" value=${iceCream.name}/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IceCream Image's src:</label>
                                                        <input type="text" class="form-control" name="src" value="${iceCream.src}"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IceCream price: </label>
                                                        <input type="number" class="form-control" name="price" value="${iceCream.price}"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IceCream discount: </label>
                                                        <input type="number" class="form-control" name="discount" value="${iceCream.discount}"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IceCream description: </label>
                                                        <input type="text" class="form-control" name="description" value="${iceCream.description}"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>IceCream Sold Quantity: </label>
                                                        <input type="text" class="form-control" name="soldQuantity" value="${iceCream.soldQuantity}"/>
                                                    </div>

                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-outline-danger">Save changes</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>


                            <!-- The Modal Delete -->
                            <div class="modal fade" id="exampleModalDelete${iceCream.iceCreamId}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <div class="container">
                                                <form action="/trangchu?action=delete&id=<c:out value="${iceCream.iceCreamId}"/>" method="post">
                                                    <div class="form-group">
                                                        <label>Bạn có chắc chắn muốn xóa chứ?</label>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
                                                        <button type="submit" class="btn btn-outline-danger">Delete</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row jumbotron">
            <div class="col"><a href="#"><img src="https://i.pinimg.com/236x/41/b0/ed/41b0edd10bd1fcca1833c2e651fcfdaa.jpg" width="70px" class="footer-img"></a></div>
            <div class="col"><a href="#"><img src="https://i.pinimg.com/236x/41/b0/ed/41b0edd10bd1fcca1833c2e651fcfdaa.jpg" width="70px" class="footer-img"></a></div>
            <div class="col"><a href="#"><img src="https://i.pinimg.com/236x/41/b0/ed/41b0edd10bd1fcca1833c2e651fcfdaa.jpg" width="70px" class="footer-img"></a></div>
        </div>
    </div>


    <!-- The Modal Update -->
    <form method="post" action="/trangchu?action=add">
        <div class="modal" id="addNewProduct">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" >Menu Create New Product</h5>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label>IceCream Category:</label>
                            <select name="category">
                                <option value="1">1 - Kem que</option>
                                <option value="2">2 - Oc Que </option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>IceCream Name:</label>
                            <input type="text" class="form-control" name="name">
                        </div>
                        <div class="form-group">
                            <label>IceCream Image's src:</label>
                            <input type="text" class="form-control" name="src">
                        </div>
                        <div class="form-group">
                            <label>IceCream price: </label>
                            <input type="number" class="form-control" name="price">
                        </div>
                        <div class="form-group">
                            <label>IceCream discount: </label>
                            <input type="number" class="form-control" name="discount">
                        </div>
                        <div class="form-group">
                            <label>IceCream description: </label>
                            <input type="text" class="form-control" name="description">
                        </div>
                        <div class="form-group">
                            <label>soldQuantity: </label>
                            <input type="number" class="form-control" name="soldQuantity">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
<%--                        <button type="submit" class="btn btn-primary">Create New</button>--%>
                        <button type="submit" class="btn btn-outline-danger" onclick="return confirm('Successfully hjhj')">
                            Create New
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>




</body>
<script src="../../../bootstrap-4.5.2-dist/js/bootstrap.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>