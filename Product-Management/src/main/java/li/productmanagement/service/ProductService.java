package li.productmanagement.service;

import li.productmanagement.dao.ProductDAO;
import li.productmanagement.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private Product product;
    @Autowired
    private ProductDAO productDAO;

    public int addProduct(String productName, String description, double price, String picture, int count, int categoryId) {
        product.setProductName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setPicture(picture);
        product.setCount(count);
        product.setCategoryId(categoryId);
        int result = productDAO.insert(product);
        return result;
    }

    public int deleteProduct(Integer id) {
        int result = productDAO.delete(id);
        return result;


    }

    public int editProduct(int id, String productName, String description, double price, String picture, int count, int categoryId) {
        product.setId(id);
        product.setProductName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setPicture(picture);
        product.setCount(count);
        product.setCategoryId(categoryId);
        int result = productDAO.update(product);
        return result;
    }


}
