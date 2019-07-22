package net.pazz.base;

import net.pazz.base.jdbc.JDBCHelp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCMain {

    public static void main(String[] args) throws Exception {

        Connection connection = JDBCHelp.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from org_info");
//
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            System.out.println("pid: " + resultSet.getInt(1) + "pname: " + resultSet.getString(2));
//        }
//        JDBCHelp.myClose(connection, preparedStatement, resultSet);

        File file = new File("C:\\Users\\pengjian.DESKTOP-JVRMU2E\\Desktop\\ttt.txt");
        File file2 = new File("C:\\Users\\pengjian.DESKTOP-JVRMU2E\\Desktop\\ttt2.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        PreparedStatement preparedStatement = null;
        while ((str = br.readLine()) != null) {
            if (str.length() <= 1) {
                continue;
            }
            String sql = "insert into org_info(org_code, org_name)values('" + str.substring(0, str.indexOf(" ")) + "', '" + str.substring(str.indexOf(" ") + 1) + "');";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.execute();
            bw.write(sql);
            bw.newLine();
        }

        JDBCHelp.myClose(connection, preparedStatement, null);
        br.close();
        bw.close();


    }

}
