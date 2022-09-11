package framework;

import java.util.concurrent.TimeUnit;

public class GlobalVariables {
	
	public static final String PROJECT_DIR = System.getProperty("user.dir");
	public static final String SCREENSHOT_PATH = PROJECT_DIR+"\\Screenshots\\";
	public static final String REPORTS_PATH = PROJECT_DIR+"\\Reports\\";
	public static final String DATA_FILES_PATH = PROJECT_DIR+"\\src\\test\\resources\\datafiles\\";
	public static final String REPOSITORY_PATH = PROJECT_DIR+"\\src\\test\\resources\\repositories\\";
	public static final String CONFIG_FOLD_PATH = PROJECT_DIR+"\\src\\test\\resources\\config\\";
	public static final int IMPLICIT_TIME_OUT = 20;
	public static final TimeUnit IMPLICIT_TIME_UNIT = TimeUnit.SECONDS;
	public static final String EXECUTION_CONFIG_FILE = PROJECT_DIR+"\\src\\test\\resources\\config\\ExecutionConfiguration.properties";
	
}
