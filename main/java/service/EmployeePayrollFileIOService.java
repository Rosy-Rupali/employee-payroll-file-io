/**************************************************
 * Purpose : This class is Employee Payroll file IO Service
 * @author Rosy Rupali
 * @since 28-06-2021
 * @version 1.0
 *************************************************/
package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import model.EmployeePayrollData;

public class EmployeePayrollFileIOService {
	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	/**
	 * This method is used to write the data to the file
	 * 
	 * @param employePayrollList
	 */
	public void writeDataToFile(List<EmployeePayrollData> employePayrollList) {
		StringBuffer stringBuffer = new StringBuffer();
		employePayrollList.forEach(employee -> {
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
	 *  This method is used to read the data from file
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
	 * @return entries
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
