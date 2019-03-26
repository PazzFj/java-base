package net.pazz.base;

import net.pazz.base.jdbc.JDBCHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMain {

    public static void main(String[] args) {

        Connection connection = JDBCHelp.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from person");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("pid: " + resultSet.getInt(1) + "pname: " + resultSet.getString(2));
            }
            JDBCHelp.myClose(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
