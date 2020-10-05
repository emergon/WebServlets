package emergon.dao;

import emergon.entity.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//this is my class
public class CustomerDao {

    private final String URL = "jdbc:mysql://localhost:3306/sales?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "root";

    //This is method findAll
    public List<Customer> findAll() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Customer> customers = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Connect to DB and get data
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT ccode, cname FROM customer");
            while (rs.next()) {
                int ccode = rs.getInt("ccode");
                String cname = rs.getString(2);
                Customer c = new Customer(ccode, cname);
                customers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return customers;
    }
}
