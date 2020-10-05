package emergon.dao;

import emergon.entity.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class CustomerDao {
    
    private final String URL = "jdbc:mysql://localhost:3306/sales?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "1234";
    
    public List<Customer> findAll(){
        //Connect to DB and get data
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return null;
    }
}
