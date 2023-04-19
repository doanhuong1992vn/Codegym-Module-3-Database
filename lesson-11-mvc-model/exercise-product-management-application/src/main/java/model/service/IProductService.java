package model.service;

import model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getProductById(long id);
    List<Product> getProductsByKeyword(String keyword);
    void save(Product product);

    void editProductById(long id, String name, double price, String description, String producer);

    void deleteProductById(long id);
}
