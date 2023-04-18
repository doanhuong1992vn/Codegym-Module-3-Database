package model.service;

import model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getProductById(long id);

    List<Product> getProductsByKeyword(String keyword);
}
