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
public class CustomerDao extends SuperDao{
    //This is method findAll
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn;
        try {
            conn = openConnection();
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
            closeConnections(stmt, rs);
        }
        return customers;
    }
}
