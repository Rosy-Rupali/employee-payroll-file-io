/**************************************************
 * Purpose : Program is  to create a file for storing Employee Payroll data
 * @author Rosy Rupali
 * @since 28-06-2021
 * @version 1.0
 *************************************************/
package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.EmployeePayrollData;

public class EmployeePayrollFileIOService {
	//Creating a file name
	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	/**
	 * This method is used to write the data to the file
	 * 
	 * @param employePayrollList
	 */
	public void writeDataToFile(List<EmployeePayrollData> employePayrollDataList) {
		StringBuffer stringBuffer = new StringBuffer();
		employePayrollDataList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			stringBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), stringBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is to read data from file
	 */
	public void readDataFromFile() {
		List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).map(line -> line.trim())
					.forEach(line -> System.out.println(line));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *  This method is used to print the data from file
	 */
	public void printDataFromFile() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to count the entries to ensure the operation worked
	 * 
	 * @return entries into file
	 */
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}

}
