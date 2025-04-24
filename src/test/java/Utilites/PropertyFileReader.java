package Utilites;
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
    public String getInvalidUsernameMessage() throws FileNotFoundException {
        Properties file = new Properties();
        try{
            FileInputStream fis = new FileInputStream("/Users/nikhiljain/AutomationProject/V10SCP/src/test/resources/datafile.properties");
            file.load(fis);
            String value = file.getProperty("InvalidUsernameAndPassword");
            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCSPUsername() throws FileNotFoundException {
        Properties file = new Properties();
        try{
            FileInputStream fis = new FileInputStream("/Users/nikhiljain/AutomationProject/V10SCP/src/test/resources/datafile.properties");
            file.load(fis);
            return file.getProperty("CSP_Username");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCSPPassword() throws FileNotFoundException {
        Properties file = new Properties();
        try{
            FileInputStream fis = new  FileInputStream("/Users/nikhiljain/AutomationProject/V10SCP/src/test/resources/datafile.properties");
            file.load(fis);
            return file.getProperty("CSP_Password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCSPURL() throws FileNotFoundException {
        Properties file = new Properties();
        try{
            FileInputStream fis = new FileInputStream("/Users/nikhiljain/AutomationProject/V10SCP/src/test/resources/datafile.properties");
            file.load(fis);
            String value = file.getProperty("CSP_URL");
            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
