package edu.student_order.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static Properties properties = new Properties();

    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/dao.properties"))) {
                properties.load(bufferedInputStream);
            } catch(Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return properties.getProperty(name);
    }
}
