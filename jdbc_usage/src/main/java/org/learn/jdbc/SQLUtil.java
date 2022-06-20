package org.learn.jdbc;

import java.sql.*;

public class SQLUtil {

    public static void queryStudents(int gender, int grade) {
        String querySql = "SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?";
        //这里使用本地mysql
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        // 填写自己的mysql的账号密码
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "root";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(querySql)) {
                preparedStatement.setObject(1, gender);
                preparedStatement.setObject(2, grade);
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()){
                        System.out.println(rs.getLong("id"));
                        System.out.println(rs.getLong("grade"));
                        System.out.println(rs.getString("name"));
                        System.out.println(rs.getString("gender"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
