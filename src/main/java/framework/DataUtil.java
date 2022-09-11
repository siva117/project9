package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exceptions.FieldInDataFileNotFoundException;

public class DataUtil {
	private XSSFSheet sheet;
	private XSSFWorkbook wb;
	
	
	public String getEnvConfigFile(String envName) {
		envName = (envName == null)?"QA":envName;
		String configFilePath;
		switch (envName.toUpperCase()) {
		case "QA":
			configFilePath = GlobalVariables.CONFIG_FOLD_PATH+"AppConfig_QA.properties";
			break;
		case "DEV":
			configFilePath = GlobalVariables.CONFIG_FOLD_PATH+"AppConfig_Dev.properties";
			break;
		default:
			configFilePath = GlobalVariables.CONFIG_FOLD_PATH+"AppConfig_Stage.properties";
			break;
			
		}
		
		return configFilePath;
	}
	
	public HashMap<String,String> getPropertiesData(String propertyFile){
		HashMap<String, String> propertyData = new HashMap<>();
		
		try {
			InputStream propFile = new FileInputStream(propertyFile);
			
			Properties props = new Properties();
			props.load(propFile);
	
			Set<Object> allProps = props.keySet();
			
			for (Object key: allProps) {
				String keyName = key.toString();
				String keyValue = props.getProperty(keyName);
				propertyData.put(keyName, keyValue);
			}
			
		} catch (IOException e) {
			System.out.println("Failed to read from properties file.");
		}
		
		return propertyData;
	}
	
	public HashMap<String, String> getTCData(String dataFilePath, String sheetName, String testCaseId ) throws IOException, FieldInDataFileNotFoundException{
		HashMap<String, String> tcData = new HashMap<>();
		try {
			FileInputStream file = new FileInputStream(new File(dataFilePath));
			wb = new XSSFWorkbook(file);
			sheet = wb.getSheet(sheetName);
			XSSFRow tcRow = sheet.getRow(getRowIndexByTCId(testCaseId));
			XSSFRow headerRow = sheet.getRow(0);
			
			int totalCols = headerRow.getLastCellNum();
			
			for (int i = 0; i<= totalCols-1; i++) {
				String header = getCellData(headerRow.getCell(i));
				String value = getCellData(tcRow.getCell(i));
				tcData.put(header, value);				
			}
			
		} catch(IOException e) {
			System.out.println("Unable to get the data from the file : " + dataFilePath+ '\n' + "Exception info : " + e.getMessage());
		} finally {
			wb.close();
		}
		
		
		
		return tcData;
	
		
	}
	
	private String getCellData(XSSFCell cell) {
		if (cell != null) {
			return cell.toString();
		} else {
			return "";
		}
		
	}
	
	
	private int getRowIndexByTCId(String tcId) throws FieldInDataFileNotFoundException {
		int rowIndex = -1;
		int lastRow = sheet.getLastRowNum();
		int tcIdColPos = getCellIndex("tc_id");
		
		for (int i = 1; i<= lastRow; i++) {
			XSSFCell cell = sheet.getRow(i).getCell(tcIdColPos);
			
			if (cell != null) {
				String actTcId = cell.toString();
				
				if (actTcId.trim().equalsIgnoreCase(tcId.trim())) {
					rowIndex = i;
					break;
				}
			}
			
			
		}
		
		return rowIndex;
	}
	
	private int getCellIndex(String colHeader) throws FieldInDataFileNotFoundException {
		int cellPos = -1;
		XSSFRow headerRow = sheet.getRow(0);
		int totalCols = headerRow.getLastCellNum();
		
		for (int i = 0; i <= totalCols-1; i++) {
			
			XSSFCell headerCell = headerRow.getCell(i);
			if (headerCell != null) {
				String headerVal = headerCell.toString();
				if (headerVal.trim().equalsIgnoreCase(colHeader.trim())) {
					cellPos = i;
					break;
				}
				
			}
		}
		
		if (cellPos == -1) {
			throw new FieldInDataFileNotFoundException("Given column header : " + colHeader+ " is not found in the data sheet.");
		}
		
		return cellPos;
	}
	
	

}
