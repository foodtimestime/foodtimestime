package com.ahcdesign.foodtimestime.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConfigUtilities {
    public static String CONFIG_KEY = "config";
    public static String DB_CONFIG_KEY = "db";
    public static String HOSTNAME_KEY = "hostName";
    public static String PORT_KEY = "port";
    public static String DB_NAME_KEY = "databaseName";
    public static String USERNAME_KEY = "userName";
    public static String PASSOWRD_KEY = "password";

    public static final String getConfig() throws ConfigFileNotFoundException, IOException {
        try {
            String line;
            StringBuilder sb = new StringBuilder();

            ClassLoader classLoader = ConfigUtilities.class.getClassLoader();
            File file = new File(classLoader.getResource("configure/config.json").getFile());

            InputStreamReader configFileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(configFileReader);

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            return sb.toString();
        } catch (FileNotFoundException fnfe) {
            throw new ConfigFileNotFoundException("Config file not found.", fnfe.getCause());
        } catch (IOException ioex) {
            throw new IOException(ioex);
        }
    }

    protected static class ConfigFileNotFoundException extends Exception {

        ConfigFileNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
