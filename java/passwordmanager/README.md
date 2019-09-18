# Password Manager

## Task

Create a password manager.

## Requirements

The command should have an interface that allows you to perform the following operations:
  * list   - list all the passwords stored in the manager
  * show   - show the password and username for the specified entry
  * add    - add a password entry
  * remove - remove a password entry
  * change - change either the username or password of an entry
  
## Stage 1 - command line app

  * store passwords in a file
  * don't worry too much about storing the passwords in plain text
  * complete the Password class in the skeleton
  * fill in the methods in the Application class, using main method to test them
  
## Stage 2 - iterate on command line app

  * Write the STDIN part that allows you to gather user input for password CRUD
  
## Stage 3 - Spring Boot App

  * Convert to Spring Boot application that stores passwords in MongoDB
  * Make sure passwords are encrypted
  
## Stage 4 - Iterate on Spring Boot App

  * Add REST API to the application
  * Add authorisation to the application
  * Use that authorisation for encrypting and decrypting
  
## Stage 5 - JavaScript frontend

  * Write a JavaScript frontend for the application
