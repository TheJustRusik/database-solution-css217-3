package dev.kenuki;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.executeQuery("select * from %tablename%");

    }
}