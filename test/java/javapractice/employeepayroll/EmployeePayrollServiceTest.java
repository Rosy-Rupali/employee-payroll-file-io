package javapractice.employeepayroll;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import model.EmployeePayrollData;
import service.EmployeePayrollService;

public class EmployeePayrollServiceTest {
	@Test
	public void givenThreeEmployees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmployees = { new EmployeePayrollData(1, "Rosy Rupali", 400000.00),
				new EmployeePayrollData(2, "Rohit Kumar", 200000.00),
				new EmployeePayrollData(3, "Anupama Singh", 300000.00) };
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
		employeePayrollService.writingData(EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		System.out.println("Total number of entries are: "+entries);
		Assert.assertEquals(3, entries);
	}

}
