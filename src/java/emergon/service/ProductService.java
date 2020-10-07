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
}
