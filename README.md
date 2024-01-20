# Summary of our Warehouse Project<br>

## Group distribution<br>
Ioannis, Robin, and Michelle. <br><br>
<br>
<br>
## Assignment structure<br>
The first two days were dedicated to structure the given assignment, make checklists with the tasks and get an overall insight of that we had to do.
We decided that we do not want to split the tasks since it would be more beneficial for us to go over every step for ourselves.
To get the full learning experience we decided that everyone should work on the task individually and in the end we would create a final application together.<br>
<br>
<br>
## The final application<br>
At the end we had two "final" versions. The one of Ioannis and Michelle and the one of Robin.<br>
We went through both applications and talked about the possibility's of combining them.
At the end Robin suggested that he could combine them together, which he did.<br>
<br>
<br>
## Project Summary: Warehouse Management System<br>
This Java project implements a simple Warehouse Management System with user authentication and inventory tracking. The system includes six classes:

### 1.User Class
Manages basic user information such as name and authentication status.
Allows users to authenticate (placeholder method), change their name, and provides a greeting and farewell message.

### 2.Employee Class (extends User)
Inherits from the User class and adds functionality for employee-specific actions.
Includes attributes like password, a list of employees they oversee (headOf), and a list of actions taken.
Overrides authentication method to compare passwords.
Allows employees to place orders, greet differently, and provides a summary of actions upon farewell.

### 3.Item Class
Represents an item in the warehouse with attributes like state, category, date of stock, and warehouse ID.
Provides methods to get and set item details.

### 4.Warehouse Class
Manages warehouse information, including an ID and a list of items in stock.
Includes methods to get the occupancy, add items, and search for items based on a category.

### 5.UserRepository Class
Loads and manages a list of employees from a JSON file (personnel.json).
Provides methods to check user validity, employee status, and retrieve employee details.

### 6.WarehouseRepository Class
Loads and manages a list of warehouses and items from a JSON file (stock.json).
Provides methods to get all items, unique warehouses, items by warehouse, unique categories, and items by category.

### Main Class: TheWarehouseManager

Implements a command-line interface for users (both guests and employees) to interact with the warehouse system.
Authenticates users, displays warehouse information, allows for item addition, ordering, and searching.

### Usage:

Run the TheWarehouseManager class to interact with the Warehouse Management System through the command line.

### Dependencies:

Requires Java and a JSON library for data loading from files.

### Note:

This project serves as a foundational example and can be extended for more complex warehouse management scenarios.