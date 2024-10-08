<h1>POS System - Spring</h1>

<h2>Backend API</h2>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

<h2>Introduction</h2>
<p style="font-size: 16px; font-weight: 100; line-height: 1.5">This is a Point of Sale (POS) system that allows for the
management of customers and items, placing orders, and viewing order details. The backend is built
using Spring, and the frontend is developed with HTML, CSS, and JavaScript.</p>

<h2>Features</h2>
<ol>
    <li style="font-weight: bold; margin-bottom: 10px">
        Customer Management 
            <p style="font-weight: lighter">Create, Read, Update, and Delete (CRUD) operations for customers.</p>
    </li>
    <li style="font-weight: bold; margin-bottom: 10px">
        Item Management
            <p style="font-weight: lighter">Create, Read, Update, and Delete (CRUD) operations for items.</p>
    </li>
    <li style="font-weight: bold; margin-bottom: 10px">
        Place Orders
            <p style="font-weight: lighter">Functionality to place new orders.</p>
    </li>
    <li style="font-weight: bold; margin-bottom: 10px">
        View Orders
            <p style="font-weight: lighter">Functionality to view all existing orders.</p>
    </li>
</ol>

<h2>Technologies Used</h2>
<ul>
    <li>Backend: Spring</li>
    <li>Database: MySQL</li>
</ul>

<h2>Installation</h2>
<h3>Prerequisites</h3>
<ul>
    <li>Java 17 or later</li>
    <li>Maven</li>
</ul>

<h2>Clone the repository</h2>
<p>git clone</p><a href="https://github.com/UchithmaSenevirathne/Spring-POS-Full-Stack.git">https://github.com/UchithmaSenevirathne/Spring-POS-Full-Stack.git</a>

<h2>API Endpoints</h2>
<h3>Customer Endpoints</h3>
<ul>
    <li>GET /customer: Retrieve all customers.</li>
    <li>POST /customer: Create a new customer.</li>
    <li>PUT /customer: Update an existing customer.</li>
    <li>DELETE /customer/{id}: Delete a customer by ID.</li>
</ul>

<h3>Item Endpoints</h3>
<ul>
    <li>GET /item: Retrieve all items.</li>
    <li>POST /item: Create a new item.</li>
    <li>PUT /item: Update an existing item.</li>
    <li>DELETE /item/{id}: Delete a item by ID.</li>
</ul>

<h3>Order Endpoints</h3>
<ul>
    <li>GET /order: Retrieve all order.</li>
    <li>POST /order: Create a new order.</li>
</ul>

<h2>Usage</h2>
<ol style="font-weight: bold">
    <li>Customer Management:
        <ul style="font-weight: lighter">
            <li>Navigate to the customer section on the frontend.</li>
            <li>Use the form to add a new customer or manage existing customers.</li>
        </ul>
    </li>
    <li>Item Management:
        <ul style="font-weight: lighter">
            <li>Navigate to the item section on the frontend.</li>
            <li>Use the form to add a new item or manage existing items.</li>
        </ul>
    </li>
    <li>Place Orders:
        <ul style="font-weight: lighter">
            <li>Navigate to the order section on the frontend.</li>
            <li>Select customers and items to place a new order.</li>
        </ul>
    </li>
    <li>View Orders:
        <ul style="font-weight: lighter">
            <li>Navigate to the view orders section on the frontend.</li>
            <li>View all existing orders with details.</li>
        </ul>
    </li>
</ol>

<h1>API Documentation</h1>

<a href="https://documenter.getpostman.com/view/35385637/2sA3s1mqs3">API Documentation</a>

<hr/>

<a href="https://github.com/UchithmaSenevirathne/POS-App-JavaEE/blob/backend/MIT%20License.md">MIT License</a>
<p>Copyright - 2024 - Present | Uchithma Senevirathne | All Rights Reserved</p>