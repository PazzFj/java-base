package com.pazz.java.jdbc.mysql;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcScript {

    public static void main(String[] args) throws Exception {

//        Connection connection = JdbcUtil.getConnection();
//        PreparedStatement statement = null;
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from org_info");
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            System.out.println("pid: " + resultSet.getInt(1) + "pname: " + resultSet.getString(2));
//        }
//        JdbcUtil.close(connection, statement, null);

        // 读取文件
        File file = new File("C:\\Users\\pengjian.DESKTOP-JVRMU2E\\Desktop\\ttt.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        // 写入文件
        File file2 = new File("C:\\Users\\pengjian.DESKTOP-JVRMU2E\\Desktop\\ttt2.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

        String str;

        while ((str = br.readLine()) != null) {
            String sql = "INSERT INTO ORG_INFO(org_code, org_name) VALUES ('" + str.substring(0, str.indexOf(" ")) + "', '" + str.substring(str.indexOf(" ") + 1) + "');";
            bw.write(sql);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

}
