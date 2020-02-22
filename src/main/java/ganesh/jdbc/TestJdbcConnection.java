package ganesh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?userSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successfull: " + jdbcUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
