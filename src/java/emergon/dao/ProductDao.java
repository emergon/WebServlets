package emergon.dao;

import emergon.entity.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDao extends SuperDao{

    private final String FINDALL = "select pcode, pdescr, pprice from product;";
    
    public List<Product> findAll() {
    List<Product> products = new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn;
        try {
            conn = openConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int pcode = rs.getInt(1);
                String pdescr = rs.getString(2);
                double pprice = rs.getDouble(3);
                Product p = new Product(pcode, pdescr, pprice);
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(stmt, rs);
        }
        return products;}
    
}
