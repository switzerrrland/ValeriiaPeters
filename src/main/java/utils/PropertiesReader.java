package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties readProps(String pathToPropsFile) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(pathToPropsFile)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}