/**************************************************
 * Purpose : POJO of Employee Payroll Data
 * @author Rosy Rupali
 * @since 28-06-2021
 * @version 1.0
 *************************************************/
package model;

public class EmployeePayrollData {
	private int id;
	private String name;
	private double salary;
	
	public EmployeePayrollData(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	
	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + this.id + ", name=" + this.name + ", salary=" + this.salary + "]";
	}

}
