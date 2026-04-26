package day21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

    public static void main (String[] args) throws IOException {

        //location of properties file
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\config.properties");

        //Loading properties file
        Properties prop = new Properties();
        prop.load(file);

        //Reading data from properties file
        String url = prop.getProperty("appurl");
        String email = prop.getProperty("emailid");
        String pwd = prop.getProperty("password");
        String ordId = prop.getProperty("orderid");
        String custId = prop.getProperty("customerid");

        System.out.println(url + " " +  email + " " + pwd + " " + ordId + " " + custId);

        //Reading all the keys from properties file
        Set<String> keys1 = prop.stringPropertyNames();
        System.out.println("keys: " + keys1);
        //OR
        Set<Object> keys2= prop.keySet();
        System.out.println("keys: " + keys2);

        //Reading all the values from properties file
        Collection<Object> value = prop.values();
        System.out.println("value: " + value);



    }

}
