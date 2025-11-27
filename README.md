# Livrai Application

This README explains how to install, configure, and run the **Livrai** application in a local development environment. It’s intentionally concise and focused on the steps required to get the app running.

----------

## Prerequisites

-   **Java JDK 6 or newer**
    
-   **MySQL 8**
    
-   **Eclipse IDE** (with Maven support)
    
-   **Apache Tomcat 8.5**
    

----------

## 1. Database Setup

### Install MySQL 8

- Download and install MySQL 8 for your platform.

### Create a Database User

- Create a MySQL user with the privileges needed to create and modify the **livrai** database.

### Create the Database

- Create a new database named **livrai**.

### Apply the Initialization Script

- Run the SQL initialization script located at:  
`db/init-script.sql`

----------

## 2. Application Setup

### Install Eclipse

- Download and install Eclipse (requires JDK 6+).

### Import the Project

- Open Eclipse and import the project as a **Maven project**.

### Install Tomcat 8.5

- Download Apache Tomcat 8.5 and add it to Eclipse’s **Servers** view.

### Deploy the Application

- Add the **app** project to the Tomcat server within Eclipse.

### Configure Database Connection

Open the file **AbstractDao.java** and update the MySQL connection settings to match your environment:

   -   Port
   -  Username
   -  Password
    

----------

## 3. Running the Application

### Start the Server

- Start the Tomcat server from Eclipse.

### Access Livrai

- Open your browser and go to:  
**[http://localhost:8080/app](http://localhost:8080/app)**

----------

## 4. Create Initial Admin User

- Before the first login, you must create an administrator account in the database. Run the following SQL (replace `<email>` and `<password>` with real values):

    `INSERT  INTO  user (email, name, password, admin) VALUES ('<email>', 'Livrai', '<password>', TRUE);`
