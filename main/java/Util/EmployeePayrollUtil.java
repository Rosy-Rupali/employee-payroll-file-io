/***********************************************
 * Purpose : To delete the files recursively         
 * @author  Rosy Rupali
 * @version 1.0
 * @since   28-06-2021          
 ***********************************************/
package Util;

import java.io.File;

public class EmployeePayrollUtil {

	public static boolean deleteFiles(File contentsToDelete) {
		File[] allContents = contentsToDelete.listFiles();
		if(allContents != null) {
			for(File file : allContents) {
				deleteFiles(file);
			}
		}
		return contentsToDelete.delete();
	}
}
