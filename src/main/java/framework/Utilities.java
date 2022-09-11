package framework;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Utilities {
	
	public void createFolder(String foldPath) {
		File file = new File(foldPath);
		
		if (!file.exists()) {
			file.mkdirs();
		} else {
			System.out.println("Folder : " + foldPath+ " is already exists.");
		}
		
	}
	
	public void deleteAllFiles(String foldPath) {
		File file = new File(foldPath);
		
		if (file.exists()) {
			
			File[] allFiles = file.listFiles();
			for (File sub: allFiles) {
				sub.delete();
			}
		}
	}
	
	public boolean isFileExists(String filePath) {
		File file = new File(filePath);
		
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static String getTimeStamp() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int seconds = c.get(Calendar.SECOND);
	
		return  ""+day+month+hour+minute+seconds;
		
		
	}
	
	
	

}
