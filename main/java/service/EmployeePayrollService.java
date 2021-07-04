/**************************************************
 * Purpose :This class implement  Read and Write data of Employee Payroll in a file
 * @author Rosy Rupali
 * @since 28-06-2021
 * @version 1.0
 *************************************************/
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, REST_IO
	};

	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService() {

	}

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/**
	 * This is the main method which is use to call reading and writing data method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		employeePayrollService.readingData();
		employeePayrollService.writingData(IOService.CONSOLE_IO);
	}

	/**
	 * This method is used to count the entries.
	 */
	public long countEntries(IOService fileIO) {
		if (fileIO.equals(IOService.FILE_IO)) {
			return new EmployeePayrollFileIOService().countEntries();
		}
		return 0;
	}

	/**
	 * This method is used to write the employee payroll data.
	 */
	public void writingData(IOService fileIO) {
		if (fileIO.equals(IOService.CONSOLE_IO)) {
			System.out.println(employeePayrollList);
		} else if (fileIO.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeDataToFile(employeePayrollList);
		}
	}
	
	/**
	 * This method is used to read the employee payroll data.
	 */
	public void printData(IOService fileIO) {
		if(fileIO.equals(IOService.FILE_IO)){
			new EmployeePayrollFileIOService().printDataFromFile();
		}
	}

	/**
	 * This method is use to take employee details from console and add to the
	 * employee payroll list.
	 */
	private void readingData() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Employee ID: ");
		int id = input.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = input.next();
		input.nextLine();
		System.out.println("Enter Employee Salary: ");
		int salary = input.nextInt();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
		input.close();
	}

}
