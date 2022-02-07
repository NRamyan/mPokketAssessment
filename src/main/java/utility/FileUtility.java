package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

    public static String getPropertyValue(String key) throws IOException {
        FileInputStream file=new FileInputStream(FilePath.PROPERTY_FILE);
        Properties properties=new Properties();
        properties.load(file);
        return properties.getProperty(key);
    }
}
