<%-- 
    Document   : productList
    Created on : Feb 17, 2018, 12:42:11 PM
    Author     : Cainebourne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Troy's Product Website</title>
  <link href="css/styles.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div id="container">

<h1><span class="graytext">PRODUCT LIST</span></h1>

<ul>
  <li><a href="index.html">Home</a></li>
  <li><a class="active" href="productlist.html">Product List</a></li>
  <li><a href="productdetail.html">Product Detail</a></li>
  <li><a href="shoppingcart.html">View Shopping Cart</a></li>
</ul>


<div id="section"><h2>Product List</h2>

<span id="content">
<ol>
<li>Product 1</li><button type="button">Click Me!</button><br>
<li>Product 2</li><button type="button">Click Me!</button><br>
<li>Product 3</li><button type="button">Click Me!</button>
</ol>
</span>

</div>

<div id="footer"><strong>Troy's Product Page 2018.</strong> All Right Reserved.</div>

</div>

    <table>
			<%
			List<Product> productList =
				(List<Product>) request.getAttribute("productList");
			for (Product product : productList){
			%>
			<tr>
				<td><%= product.getProductName() %></td>
				<td>
		<a href="?id=<%= product.getId() %>"></a>
				</td>
			</tr>
			<%
			}
			%>
		</table>
</body>

</html>
