Student CRUD Application

Overview
The StudentCrud application is a simple Java Swing-based GUI tool for managing student records in a PostgreSQL database. 
It allows users to add, update, and delete student information, including name, address, and phone number. 
The application uses JDBC to connect to a PostgreSQL database and perform CRUD (Create, Read, Update, Delete) operations.

Features
  ~Add a Student: Insert new student records into the database.
  ~Update a Student: Modify existing student records based on the student's name.
  ~Delete a Student: Remove student records from the database by name.
  
Prerequisites
  ~Java Development Kit (JDK): Make sure you have JDK 8 or later installed.
  ~PostgreSQL Database: Ensure PostgreSQL is installed and running.
  ~JDBC Driver: The PostgreSQL JDBC driver is required for database connectivity.

Usage
  ~Launch the Application: Execute the application to open the GUI.
  ~Add a Student: Enter the student's name, address, and phone number. Click the "Add" button to insert the record into the database.
  ~Update a Student: Enter the new address and phone number for an existing student. Click the "Update" button to modify the student's record.
  ~Delete a Student: Enter the name of the student to delete. Click the "Delete" button to remove the record from the database.

Error Handling
The application provides error messages if database operations fail, including issues with connectivity, SQL syntax errors, or non-existent records.

Acknowledgements
  ~PostgreSQL and the JDBC driver are used for database connectivity.
  ~Java Swing is used for the graphical user interface.
