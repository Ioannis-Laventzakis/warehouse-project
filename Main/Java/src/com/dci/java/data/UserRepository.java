package com.dci.java.data;

import com.dci.java.data.personnel.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<Employee> EMPLOYEE_LIST = new ArrayList<Employee>();

    static {
        BufferedReader reader = null;
        try {
            EMPLOYEE_LIST.clear();

            reader = new BufferedReader(new FileReader("resources/personnel.json"));
            Object data = JSONValue.parse(reader);
            if (data instanceof JSONArray) {
                JSONArray dataArray = (JSONArray) data;
                for (Object obj : dataArray) {
                    if (obj instanceof JSONObject) {
                        JSONObject jsonData = (JSONObject) obj;
                        String userName = jsonData.get("user_name").toString();
                        String password = jsonData.get("password").toString();
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
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

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

    public static boolean isUserEmployee(String name) {
        List<Employee> employees = getAllEmployees();

        for (Employee employee : employees) {
            if (employee.isNamed(name)) {
                return true;
            }
        }
        return false;
    }

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