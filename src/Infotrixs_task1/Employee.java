package Infotrixs_task1;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: $" + salary;
    }


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setName(String newName) {
		// TODO Auto-generated method stub
		
	}


	public void setAge(String newAge) {
		// TODO Auto-generated method stub
		
	}


	public int getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setSalary(double newSalary) {
		// TODO Auto-generated method stub
		
	}
}