package libraries;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtils {
      public static String getValue(String path, String key) {
    	  String data="";
    	  try {
    		  FileInputStream fin = new FileInputStream(path);
    		  Properties p = new Properties();
    		  p.load(fin);
    		  data = p.getProperty(key);
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  return data;
      }
      
      public static void getPhoto(WebDriver driver, String name) {
    	String dateTime=LocalDateTime.now().toString().replaceAll(":", "-");
  		TakesScreenshot t=(TakesScreenshot)driver;
  		File srcFile = t.getScreenshotAs(OutputType.FILE);
  		File destFile = new File(IAutoConstants.IMAGE_PATH+dateTime+name+".png");
  		try {
  			FileUtils.copyFile(srcFile, destFile);
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  		}
      }
}
