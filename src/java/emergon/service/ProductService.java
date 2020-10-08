package emergon.service;

import emergon.dao.ProductDao;
import emergon.entity.Product;
import java.util.List;

public class ProductService {
    //CRUD
    ProductDao pdao = new ProductDao();
    
    public List<Product> getProducts(){
        return pdao.findAll();
    }

    public String deleteProduct(String pcode) {
        int code = Integer.parseInt(pcode);
        String message = pdao.delete(code);
        return message;
    }

    public void createProduct(String description, String price) {
        double timi = Double.parseDouble(price);
        Product product = new Product(description, timi);
        pdao.create(product);
    }

    public Product findProduct(String id) {
        int pcode = Integer.parseInt(id);
        Product p = pdao.findById(pcode);
        return p;
    }

    public boolean updateProduct(String pcode, String description, String price) {
        int code = Integer.parseInt(pcode);
        double timi = Double.parseDouble(price);
        Product p = new Product(code, description, timi);
        boolean result = pdao.update(p);
        return result;
    }
}
