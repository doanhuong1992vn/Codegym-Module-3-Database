package com.example.usermanager.dao;

import com.example.usermanager.model.CartLine;
import com.example.usermanager.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAll();

    void insertCartLine(int idProduct);

    List<CartLine> getCartLines();

    void removeCartLine(int idProduct);

    void updateQuantity(List<CartLine> cartLines);
}
