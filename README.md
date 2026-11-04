# 🛒 ECART – Electronic Shopping Cart Application

### A Java-Based E-Commerce Web Application

**ECART** is a web-based Electronic Shopping Cart Application developed using Core Java and Advanced Java technologies. The application provides an online platform where customers can explore electronic products and make purchases, while administrators can manage products through a dedicated admin module.

The main objective of developing this project was to evaluate my practical understanding of Java concepts and implement the knowledge gained throughout my learning journey.

---

## 📌 Project Overview

ECART is designed with two major modules:

- **Admin Module:** Allows administrators to manage electronic products and maintain the product catalogue.
- **Customer Module:** Allows customers to register, log in, browse available products, and purchase products.

The application connects the frontend with the Java backend and Oracle Database to perform real-time data operations.

## ✨ Key Features

### 👨‍💻 Admin Module

- Admin Authentication and Login
- Admin Dashboard
- Add New Products
- View Available Products
- Update Existing Product Details
- Delete Products
- Manage Product Information

### 🛍️ Customer Module

- Customer Registration
- Customer Login
- Customer Dashboard
- Browse Available Products
- View Product Details
- Check Product Availability
- Purchase Products
- Automatic Stock Quantity Updates
- Purchase Confirmation

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Core Java | Backend programming |
| Java Servlets | HTTP request and response handling |
| JSP | Dynamic web page development |
| JDBC | Database connectivity |
| Oracle Database | Data storage and management |
| HTML5 | Web page structure |
| CSS3 | Styling and layout |
| JavaScript | Client-side functionality and validation |
| Apache Tomcat 9 | Web application server |

---

## 🏗️ Project Architecture

The application follows the **MVC (Model-View-Controller) architecture** to maintain separation of responsibilities and organize the application code.

The Java backend is primarily organized into three packages:

### 1. BEAN Package

Contains Java Bean classes that represent application data and help transfer information between different layers.

Examples:
- AdminBean.java
- CustomerBean.java
- ProductBean.java

### 2. DAO Package

DAO stands for Data Access Object.

This package handles database-related operations using JDBC and PreparedStatement.

Responsibilities:
- Database connectivity.
- Inserting records.
- Retrieving records.
- Updating records.
- Deleting records.

Examples:
- DBConnection.java
- AdminLoginDAO.java
- CustomerLoginDAO.java
- CustomerRegisterDAO.java
- AddProductDAO.java
- ViewProductDAO.java
- UpdateProductDAO.java
- DeleteProductDAO.java

### 3. SERVLET Package

Servlets act as controllers in the application.

They handle HTTP requests, process user actions, communicate with DAO classes, manage application flow, and redirect users to appropriate JSP pages.

Examples:
- AdminLoginServlet.java
- CustomerLoginServlet.java
- CustomerRegistrationServlet.java
- AddProductServlet.java
- ViewProductServlet.java
- EditProductServlet.java
- UpdateProductServlet.java
- DeleteProductServlet.java
- BuyProductServlet.java
- LogoutServlet.java

---

## 📂 Project Folder Structure

The project is organized into the following major directories and packages:

```text
ECART_Application/
│
├── Java Resources/
│   └── src/
│       └── [Java Packages]/
│           │
│           ├── bean/
│           │   ├── AdminBean.java
│           │   ├── CustomerBean.java
│           │   └── ProductBean.java
│           │
│           ├── dao/
│           │   ├── DBConnection.java
│           │   ├── DBInfo.java
│           │   ├── AdminLoginDAO.java
│           │   ├── CustomerLoginDAO.java
│           │   ├── CustomerRegisterDAO.java
│           │   ├── AddProductDAO.java
│           │   ├── ViewProductDAO.java
│           │   ├── UpdateProductDAO.java
│           │   ├── DeleteProductDAO.java
│           │   └── BuyProductServletDAO.java
│           │
│           └── servlet/
│               ├── AdminLoginServlet.java
│               ├── CustomerLoginServlet.java
│               ├── CustomerRegistrationServlet.java
│               ├── AddProductServlet.java
│               ├── ViewProductServlet.java
│               ├── EditProductServlet.java
│               ├── UpdateProductServlet.java
│               ├── DeleteProductServlet.java
│               ├── BuyProductServlet.java
│               ├── UpdateProductCustomerServlet.java
│               └── LogoutServlet.java
│
├── WebContent/
│   ├── index.html
│   ├── AdminLogin.html
│   ├── AdminHome.jsp
│   ├── AddProduct.html
│   ├── ViewProduct.jsp
│   ├── EditProduct.jsp
│   ├── UpdateProduct.jsp
│   ├── DeleteProduct.jsp
│   ├── CustomerLogin.html
│   ├── CustomerRegister.html
│   ├── CustomerHome.jsp
│   ├── ViewCustomerProduct.jsp
│   ├── BuyProduct.jsp
│   ├── OrderConfirmed.jsp
│   ├── Logout.jsp
│   │
│   └── WEB-INF/
│       └── web.xml
│
├── database/
│   └── ecart_database.sql
│
├── screenshots/
│   ├── homepage.png
│   ├── admin-login.png
│   ├── admin-dashboard.png
│   ├── add-product.png
│   ├── customer-registration.png
│   ├── customer-dashboard.png
│   └── product-catalogue.png
│
├── README.md
└── .gitignore
```

---

## 📸 Application Screenshots

### 1. Homepage

The homepage provides a clean and user-friendly interface with navigation options for Home, About Us, Contact, Customer Login, and Admin Login.

ECART Homepage
<img width="1917" height="1028" alt="image" src="https://github.com/user-attachments/assets/b381820b-4e16-478f-aaa3-901f0a39ecfe" />


### 2. Admin Login

The admin login page provides access to authorized store administrators.

ECART Admin Login
<img width="1917" height="1028" alt="image" src="https://github.com/user-attachments/assets/37cd42d2-0075-488e-a6e3-676774585c23" />


### 3. Admin Dashboard

The admin dashboard provides options to add new products and manage the existing product catalogue.

ECART Admin Dashboard
<img width="1917" height="1025" alt="image" src="https://github.com/user-attachments/assets/ec2ec885-61b8-4c5d-b997-71e4d1a0a99d" />


### 4. Product Management – Add Product

Administrators can add electronic products by entering product code, product name, company, price, and quantity.

ECART Add Product
<img width="1917" height="1031" alt="image" src="https://github.com/user-attachments/assets/e98dbd33-9ea3-4931-a3a9-7069f31158b1" />


### 5. Customer Registration

New customers can create an account by entering their username, password, personal details, address, email, and mobile number.

ECART Customer Registration
<img width="1917" height="1032" alt="image" src="https://github.com/user-attachments/assets/efbe7c43-6de7-4071-99e9-e61b9f7856e2" />


### 6. Customer Dashboard

After successful authentication, customers can access their dashboard and navigate to the available shopping options.

ECART Customer Dashboard
<img width="1917" height="1027" alt="image" src="https://github.com/user-attachments/assets/2dfb4d86-23c4-4522-aab7-af14702e176e" />


### 7. Customer Product Catalogue

Customers can explore the available electronic products, check prices and stock availability, and proceed with purchasing products.

ECART Product Catalogue
<img width="1917" height="1032" alt="image" src="https://github.com/user-attachments/assets/f4ba56d9-fc32-4a24-8923-9a44b450b657" />


---

## 🧠 Java Concepts Implemented

During the development of this project, I implemented and explored several important Java and web development concepts:

- Object-Oriented Programming (OOP)
- MVC Architecture
- Java Servlets
- JavaServer Pages (JSP)
- JDBC Connectivity
- CRUD Operations
- Session Management
- Cookies
- HTTP Request and Response Handling
- PreparedStatement
- Form Validation
- Database Operations
- Exception Handling

---

## 🗄️ Database

**Database:** Oracle Database

Oracle Database is used to store and manage application information.

Main database tables:

- ADMIN
- CUSTOMER
- PRODUCT

The Java application communicates with Oracle Database using JDBC.

---

## ⚙️ Installation and Setup

### Prerequisites

Make sure the following software is installed:

- JDK 8
- Apache Tomcat 9
- Oracle Database
- Oracle SQL Developer
- Eclipse IDE or another compatible Java Web IDE

### Step 1: Clone the Repository

```bash
git clone https://github.com/Mohan2410/ECART_Application.git
```

### Step 2: Import the Project

1. Open your Java IDE.
2. Import the cloned project as an existing web project.
3. Configure JDK 8.
4. Configure Apache Tomcat 9.

### Step 3: Configure Oracle Database

1. Open Oracle SQL Developer.
2. Create the required database tables.
3. Execute the SQL script from the database folder, if provided.
4. Configure your own Oracle database username and password.

### Step 4: Configure Database Connectivity

Update the database connection configuration in the appropriate Java database connection class.

Ensure that the Oracle JDBC driver is available in the project.

### Step 5: Run the Application

1. Configure the project on Apache Tomcat 9.
2. Start the Tomcat server.
3. Open your browser.
4. Access the application using your configured localhost URL.

---

## 🎯 Learning Outcomes

Developing ECART helped me gain practical experience in:

- Building Java-based web applications.
- Understanding MVC architecture.
- Implementing JDBC connectivity with Oracle Database.
- Performing database CRUD operations.
- Working with Java Servlets and JSP.
- Managing user sessions.
- Understanding cookies and HTTP communication.
- Integrating frontend and backend technologies.
- Developing an end-to-end web application.

---

## 🚀 Future Enhancements

Some features that can be considered for future development:

- Shopping Cart Functionality.
- Online Payment Gateway Integration.
- Advanced Product Search and Filtering.
- Product Categories.
- Order History and Tracking.
- Enhanced Security and Authentication.

---

## 👨‍💻 Author

**Mohan Gawande**

- GitHub: [Mohan2410](https://github.com/Mohan2410)
- LinkedIn: [Mohan Gawande](https://www.linkedin.com/in/mohan-gawande-java/)

---

⭐ If you find this project interesting, feel free to explore the repository and share your feedback!

**Thank you for visiting ECART – Electronic Shopping Cart Application!**
