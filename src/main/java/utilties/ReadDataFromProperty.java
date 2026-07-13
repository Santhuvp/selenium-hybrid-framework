package utilties;

import constants.Framework_Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProperty {

    public static Properties prop;
    public static void loadProperty() throws IOException {
        FileInputStream fis = new FileInputStream(Framework_Constants.PROPERTY_PATH);
        prop = new Properties();
        prop.load(fis);
    }
}
