package tests.employeeManagement;

import java.io.IOException;
import java.util.HashMap;

import exceptions.FieldInDataFileNotFoundException;
import framework.DataUtil;
import framework.GlobalVariables;

public class SampleTestCases_XL {

	public static void main(String[] args) throws IOException, FieldInDataFileNotFoundException {
		DataUtil excel = new DataUtil();
		String xlPath = GlobalVariables.DATA_FILES_PATH+"EmpManagement.xlsx";
		HashMap<String, String> tcData = excel.getTCData(xlPath, "CreateEmp", "emp005");
		
		System.out.println(tcData.get("FIRST_NAME"));

	}

}
