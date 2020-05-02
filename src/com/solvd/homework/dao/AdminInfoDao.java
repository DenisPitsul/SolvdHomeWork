package com.solvd.homework.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AdminInfoDao {
    private File file;

    public AdminInfoDao(String filePath) {
        this.file = new File(filePath);
    }

    public String getAllProperties() {
        Properties properties = new Properties();
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            properties.load(fileInputStream);
            for (Object key: properties.keySet()) {
                sb.append(key.toString()).append(" - ").append(properties.getProperty(key.toString()))
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String getValueFromProperties(String key) {
        Properties properties = new Properties();
        String value = "no information";
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            properties.load(fileInputStream);
            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;

    }

    public void setValueToProperties(String key, String value) {
        Properties properties = new Properties();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)){
            properties.setProperty(key, value);
            properties.store(fileOutputStream, "");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
