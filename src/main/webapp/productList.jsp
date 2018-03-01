<%@page import="edu.wctc.dj.model.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Troy's Computer Parts</title>
    <link href="cssfolder/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div id="wrapper">
        <header>
            <h1>Troy's Computer Parts</h1>
        </header>
        <nav>
            <ul>
	    <li>
		<a href="index.jsp">Home</a>
	    </li>
            <li>
                <a href="productlist.jsp">Product List</a>
            </li>
	    <li>
		<li><a href="productInfo.jsp">Product Info</a></li>
	    </li>
	    <li>
		<a href="ShoppingCart">Shopping Cart</a>
	    </li>
            <li>
		<form action="ProductController" method="get" class="navSearchForm">
		    <input name="search" type="text" placeholder="Search">
		    <input type="submit" value="Search">
		</form>
	    </li>
	</ul>
        </nav>
        <main>
            <h3>Our Products</h3>
	    <div class="table">
		<c:forEach var="prod" items="${productList}">
		    <div class="row">
			<div class="id">
			    <c:out value="${prod.productId}"/>
			</div>:
			<div class="name">
			    <c:out value="${prod.productName}"/>
			</div>
			<br>
			<div class="description">
			    <c:out value="${prod.description}"/>
			</div>
			<div class="price">
			    <fmt:formatNumber value="${prod.price}" type="CURRENCY"/>
			</div>
		    </div>
			<br>
			<br>
		</c:forEach>
            </div>
        </main>
    </div>
    <script src="js/site.js"></script>
    </body>
</html>
