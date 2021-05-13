package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

    public static Properties readProps(String pathToPropsFile) {

        //Map<String, String> props = new HashMap<>();
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(pathToPropsFile)) {



            // load a properties file
            prop.load(input);

            // get the property value and print it out
            //props.put("name", prop.getProperty("name"));
            //props.put("password", prop.getProperty("password"));
            //props.put("username", prop.getProperty("username"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }
}
