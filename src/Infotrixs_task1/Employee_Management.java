package Infotrixs_task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Employee_Management extends JFrame {

    private static final String FILE_PATH = "employees.dat";
    private List<Employee> employees;
    private JTextField idField, nameField, ageField, salaryField;

    public Employee_Management() {
        employees = new ArrayList<>();
        loadEmployeesFromFile();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Employee Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);
        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        buttonPanel.add(addButton);

        JButton viewButton = new JButton("View");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEmployees();
            }
        });
        buttonPanel.add(viewButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });
        buttonPanel.add(updateButton);
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	deleteEmployee();
            }
        });
        buttonPanel.add(deleteButton);
        
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		searchEmployee();
        	}
        });
        buttonPanel.add(searchButton);
        
        return buttonPanel;
    }

    private void addEmployee() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        double salary = Double.parseDouble(salaryField.getText());
        Employee newEmployee = new Employee(id, name, age, salary);
        employees.add(newEmployee);
        saveEmployeesToFile();
        JOptionPane.showMessageDialog(this, "Employee added successfully.");
        clearFields();
    }

    private void viewEmployees() {
        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No employees found.");
        } else {
            StringBuilder employeeInfo = new StringBuilder();
            for (Employee employee : employees) {
                employeeInfo.append(employee).append("\n");
            }
            JOptionPane.showMessageDialog(this, employeeInfo.toString(), "Employees", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateEmployee() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        double salary = Double.parseDouble(salaryField.getText());
        Employee updatedEmployee = new Employee(id, name, age, salary);

        Employee employeeToUpdate = findEmployeeById(id);
        if (employeeToUpdate != null) {
            employees.set(employees.indexOf(employeeToUpdate), updatedEmployee);
            saveEmployeesToFile();
            JOptionPane.showMessageDialog(this, "Employee updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Employee with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
    }


    private void deleteEmployee() {
        int id = Integer.parseInt(idField.getText());
        Employee employeeToDelete = findEmployeeById(id);
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            saveEmployeesToFile();
            JOptionPane.showMessageDialog(this, "Employee deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Employee with ID " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
    }

    private Employee findEmployeeById(int id) {
		return null;
	}

	private void searchEmployee() {
        String name = nameField.getText().trim();
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                foundEmployees.add(employee);
            }
        }

        if (foundEmployees.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No employees found with the name: " + name, "Not Found", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder employeeInfo = new StringBuilder();
            for (Employee employee : foundEmployees) {
                employeeInfo.append(employee).append("\n");
            }
            JOptionPane.showMessageDialog(this, employeeInfo.toString(), "Employees Found", JOptionPane.INFORMATION_MESSAGE);
        }
        clearFields();
    }

	private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        salaryField.setText("");
    }

    private void loadEmployeesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            
        }
    }

    private void saveEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Employee_Management();
            }
        });
    }
    
}

