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
}
