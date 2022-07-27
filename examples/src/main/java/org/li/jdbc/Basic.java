package org.li.jdbc;

import java.sql.*;

public class Basic {
    public static void main(String[] args) {
        simpleJDBC("", "");
    }
    /**
     * 简单的JDBC
     */
    public static  void simpleJDBC(String user, String password) {
        // 这里使用本地mysql
        String url = "jdbc:mysql://43.135.50.171:3306/li_server";


        try (Connection connection = DriverManager.getConnection(url, user, password);) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery("SELECT id FROM `t_contract`")) {
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        System.out.println(id);
                    }
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
