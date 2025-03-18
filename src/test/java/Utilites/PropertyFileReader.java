package Utilites;

import org.openqa.selenium.devtools.v85.io.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.StringConcatFactory;
import java.util.HashMap;
import java.util.Properties;

public class PropertyFileReader {

    static InputStream inputStream = null;

    public void readPropertyFile() {
        Properties file = new Properties();
        try{
            FileInputStream fis = new FileInputStream("/Users/nikhiljain/AutomationProject/V10SCP/src/test/resources/datafile.properties");
            file.load(fis);
            fis.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (inputStream != null) {
                try{
                    inputStream.close();
                }
                catch(Exception e){
                    e.printStackTrace();}
            }
        }
    }

    public String getUsername() throws FileNotFoundException {
        Properties file = new Properties();
        try{
            FileInputStream fis = new FileInputStream("/Users/nikhiljain/AutomationProject/V10SCP/src/test/resources/datafile.properties");
            file.load(fis);
            return file.getProperty("username");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPassword() throws FileNotFoundException {
        Properties file = new Properties();
        try{
            FileInputStream fis = new FileInputStream("/Users/nikhiljain/AutomationProject/V10SCP/src/test/resources/datafile.properties");
            file.load(fis);
            String value = file.getProperty("password");
            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getURL() throws FileNotFoundException {
        Properties file = new Properties();
        try{
            FileInputStream fis = new FileInputStream("/Users/nikhiljain/AutomationProject/V10SCP/src/test/resources/datafile.properties");
            file.load(fis);
            String value = file.getProperty("URL");
            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
