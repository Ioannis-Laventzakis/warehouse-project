package com.dci.java.data.test;

import com.dci.java.data.personnel.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// UserRepository class is responsible for managing the list of employees
public class UserRepository {
    // List of employees
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<Employee>();

    // Static block to load the employees from a JSON file
    static {
        BufferedReader reader = null;
        try {
            // Clear the list before loading
            EMPLOYEE_LIST.clear();

            // Read the JSON file
            reader = new BufferedReader(new FileReader("resources/personnel.json"));
            Object data = JSONValue.parse(reader);
            if (data instanceof JSONArray) {
                JSONArray dataArray = (JSONArray) data;
                for (Object obj : dataArray) {
                    if (obj instanceof JSONObject) {
                        JSONObject jsonData = (JSONObject) obj;
                        String userName = jsonData.get("user_name").toString();
                        String password = jsonData.get("password").toString();
                        // Create a new employee and add it to the list
                        Employee employee = new Employee(userName, password);
                        EMPLOYEE_LIST.add(employee);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    // Close the reader
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    // Method to get all employees
    public static List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    // Method to validate a user
    public static boolean isUserValid(String userName, String password) {
        List<Employee> employees = getAllEmployees();

        for (Employee employee : employees) {
            if (userName.equals(employee.getName())) {
                if (password.equals(employee.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to check if a user is an employee
    public static boolean isUserEmployee(String name) {
        List<Employee> employees = getAllEmployees();

        for (Employee employee : employees) {
            if (employee.isNamed(name)) {
                return true;
            }
        }
        return false;
    }

    // Method to get an employee by name
    public static Employee getEmployee(String name) {
        List<Employee> employees = getAllEmployees();

        for (Employee employee : employees) {
            if (employee.isNamed(name)) {
                return employee;
            }
        }
        return null;
    }
}