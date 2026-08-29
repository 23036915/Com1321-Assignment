\# Com1321-Assignment - Inventory Management System

Student Number: 23036915

Name: Promise Manavhela 



\## Project Overview

This project is a Java Console Application for Product Inventory Management. It allows the user to manage products in a retail store. The application was built in NetBeans as per Com1321 assignment requirements.



It has 3 main classes: Products.java, ReportData.java, and Main.java



\## Class Breakdown



\### 1. Products.java - The Entity / Model Class

This class defines what a Product is. It holds all product information.

\- \*\*Attributes:\*\* productCode (String), productName (String), productCategory (String), productPrice (double), stockQuantity (int), supplier (String)

\- \*\*Constructor:\*\* `Products(String productCode, String productName, String productCategory, double productPrice, int stockQuantity, String supplier)` - initializes a new product.

\- \*\*Getters:\*\* `getProductCode()`, `getProductName()`, `getProductCategory()`, `getProductPrice()`, `getStockQuantity()`, `getSupplier()`

\- \*\*Setters:\*\* `setProductName()`, `setProductCategory()`, `setProductPrice()`, `setStockQuantity()`, `setSupplier()` - used to update product details.

\- \*\*toString() method:\*\* Overrides to display product details in the required assignment format:

&#x20; PRODUCT CODE >> ...

&#x20; PRODUCT NAME >> ...

&#x20; PRODUCT CATEGORY >> ...

&#x20; PRODUCT PRICE >> ...

&#x20; STOCK QUANTITY >> ...

&#x20; PRODUCT SUPPLIER >> ...



\### 2. ReportData.java - The Manager / Logic Class

This class handles all the business logic and stores products in an ArrayList.

\- \*\*Field:\*\* `ArrayList<Products> products` - holds all captured products.

\- \*\*Methods:\*\*

&#x20;   - `addProduct(Products p)`: Adds a new Products object to the ArrayList.

&#x20;   - `getProducts()`: Returns the full list of products.

&#x20;   - `searchProduct(String code)`: Loops through the ArrayList and finds a product by its productCode. Returns null if not found.

&#x20;   - `updateProduct(String code, String name, String category, double price, int qty, String supplier)`: Searches for the product and uses setters to update its values. Returns true if updated.

&#x20;   - `deleteProduct(String code)`: Removes the product from the ArrayList.

&#x20;   - `printReport()`: Prints every product using toString(), then calculates and displays TOTAL PRODUCT COUNT, TOTAL STOCK VALUE (price \* quantity), and AVERAGE PRODUCT VALUE.



\### 3. Main.java - The Application / Menu Class

This is the class that runs and interacts with the user.

\- \*\*Main Method:\*\* Contains `Scanner input` and a `while(true)` loop for the menu.

\- \*\*Menu Options:\*\*

&#x20;   1. Capture Product - Asks user for all 6 fields and creates a new Products object.

&#x20;   2. Search Product - Asks for product code and displays the product if found.

&#x20;   3. Update Product - Asks for code, then asks for new details.

&#x20;   4. Delete Product - Asks for code and deletes it.

&#x20;   5. Print Report - Calls `ReportData.printReport()` to show all products and summary.

&#x20;   6. Exit Application - Closes the scanner and exits with `System.exit(0)`.

\- \*\*Object Creation:\*\* Creates one object of ReportData: `ReportData reportData = new ReportData();`



\## How to Run

1\. Open NetBeans IDE

2\. File -> Open Project -> Select `Com1321-Assignment`

3\. Go to Source Packages -> main -> Right-click `Main.java` -> Run File

4\. Use the menu numbers 1-6 to navigate



\## Requirements



\- NetBeans IDE

\- GitHub for version control



\## Repository Structure

/Com1321-Assignment

&#x20; /src/main

&#x20;   Main.java

&#x20;   Products.java

&#x20;   ReportData.java

&#x20; README.md

