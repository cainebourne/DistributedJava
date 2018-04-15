
drop table Products;
drop table Customer;
drop table  ShoppingCart;


CREATE TABLE Products(
ProductID varchar(4) PRIMARY KEY,
ProductName varchar(50) NOT NULL,
Price decimal(5,2) NOT NULL,
Description varchar(32672)
);

CREATE TABLE Customer(
CustomerId int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
FirstName varchar(65) NOT NULL,
LastName varchar(65) NOT NULL,
MiddleName varchar(50)
);

CREATE TABLE ShoppingCart(
ShoppingCartId int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
fkCustomerId int REFERENCES edu.wctc.dj.CUSTOMER(CustomerId),
fkProductID varchar(4) REFERENCES edu.wctc.dj.PRODUCTS(ProductId),
Amount int
);

INSERT INTO edu.wctc.dj.Customer (FirstName, LastName, MiddleName)
	VALUES ('Troy', 'Wadina','C');

INSERT INTO edu.wctc.dj.Products
	VALUES("A01","Motherboard", 100, "Plug everything into this"),
	("B02","Ram", 50, "Random access memory"),
	("C03","Processor", 200, "The Brain of your computer"),
	("D04","Graphics Card", 5000, "For video games and to make the computer very expensive especially now that everyone is crytpo mining");

