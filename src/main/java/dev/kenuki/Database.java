package dev.kenuki;

import java.io.IOException;
import java.util.Properties;

public class Database {
    private static Database instance;
    private String hostname;
    private String username;
    private String password;
    private String databaseName;
    private Database() {
        loadConfiguration();
    }
    private void loadConfiguration() {
        Properties properties = new Properties();
        try {
            var stream = getClass().getClassLoader().getResourceAsStream("database.properties");
            if (stream == null) {
                System.err.println("Unable to find database_config.properties in resources.");
                return;
            }
            properties.load(stream);

            this.databaseName = properties.getProperty("dbname");
            this.hostname     = properties.getProperty("hostname");
            this.password     = properties.getProperty("password");
            this.username     = properties.getProperty("username");

            System.out.println("db name: " + databaseName + "\nhostname: " + hostname + "\npassword: " + password + "\nusername: " + username);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public synchronized void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }

    public String getHostname() {
        return hostname;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}

