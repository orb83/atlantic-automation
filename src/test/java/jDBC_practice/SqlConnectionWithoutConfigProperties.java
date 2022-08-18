package jDBC_practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SqlConnectionWithoutConfigProperties {
    private static final Logger LOGGER = LogManager.getLogger(SqlConnectionWithoutConfigProperties.class);

    private static Connection connect(){
        Connection conn =null;
        try{
            // Alternative declaration without config.properties file
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mortgage_calculator","postgres","7744");
        }catch (SQLException e){
            LOGGER.error("SQL Connection Exception" +e.getMessage());
        }
        return conn;
    }

    public static ResultSet readData(String SQL) throws SQLException {
       ResultSet rs = null;
        Connection conn =null;
        try {
            conn = connect();
            LOGGER.debug("Connection object value: " +conn);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
        }catch (SQLException e){
            LOGGER.error("SQL ResultSet Execution" + e.getMessage());
        }finally {
            conn.close();
        }return rs;
    }
}
