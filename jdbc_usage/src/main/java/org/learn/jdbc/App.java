package org.learn.jdbc;

import java.sql.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //simple();
        SQLUtil.queryStudents(1, 3);
    }

    public static void simple() {
        // 这里使用本地mysql
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        // 填写自己的mysql的账号密码
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "root";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        System.out.println(id);
                        System.out.println(grade);
                        System.out.println(name);
                        System.out.println(gender);
                    }
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
