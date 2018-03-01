<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1><span class="graytext">Troy's Computer Parts</span></h1>
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
            <h3>We Have Everything you need!</h3>
            <p>
		We have all parts needed to build a PC with more coming soon!
            </p>
	    <h3>
                 Find products if you know their Id
	    </h3>
	    <form method="post" action="Product">
		<input type="text" placeholder="Product Id" name="id" >
		<br>
		<input type="submit" value="submit">
	    </form>
        </main>
    </div>
    <script src="js/site.js"></script>
</body>

</div>

<div id="footer"><strong>Troy's Product Page 2018.</strong> All Right Reserved.</div>

</div>

</html>
