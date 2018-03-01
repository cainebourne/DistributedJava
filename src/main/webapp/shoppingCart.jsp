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
	<c:set var="cart" scope="page" value="${shoppingCart}" />
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
        <div class="table">
			<c:forEach var="prod" items="${cart.products}">
				<div class="row">
					<div class="id">
						<c:out value="${prod.product.productId}"/>
					</div>:
					<div class="name">
						<c:out value="${prod.product.productName}"/>
					</div>
					<br>
					<div class="price">
						<fmt:formatNumber value="${prod.product.price}" type="CURRENCY"/> *
						<c:out value="${prod.amount}"/> =
						<fmt:formatNumber value="${prod.product.price*prod.amount}" type="CURRENCY"/>
					</div>
				</div>
			</c:forEach>
            <input type="button" onclick="buttonClick()" value="Clear Cart">
        </div>
    </main>
</div>
<script src="js/site.js"></script>
</body>
</html>
