package com.example.usermanager.dao;

import com.example.usermanager.model.CartLine;
import com.example.usermanager.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/SHOPPING_CART_MANAGEMENT?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "123456";
    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> getAll() {
        final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_PRODUCT");
                String name = resultSet.getString("NAME");
                float price = resultSet.getFloat("PRICE");
                String description = resultSet.getString("DESCRIPTION");
                String imageUrl = resultSet.getString("IMAGE_URL");
                products.add(new Product(id, name, price, description, imageUrl));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void insertCartLine(int idProduct) {
        final String INSERT_CART_LINE = "INSERT INTO detail_cart_line (ID_PRODUCT, ID_CART, QUANTITY) VALUES (?, 1, ?) ON DUPLICATE KEY UPDATE QUANTITY = ?";
        final String SELECT_CART_LINE = "SELECT QUANTITY FROM detail_cart_line WHERE ID_PRODUCT = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_LINE)){
            preparedStatement.setInt(1, idProduct);
           ResultSet resultSet = preparedStatement.executeQuery();
           if (!resultSet.next()) {
               try (PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_CART_LINE)) {
                   preparedStatement2.setInt(1, idProduct);
                   preparedStatement2.setInt(2, 1);
                   preparedStatement2.setInt(3, 1);
                   preparedStatement2.executeUpdate();
               }
           } else if (resultSet.next()) {
               int quantity = resultSet.getInt("QUANTITY");
               try (PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_CART_LINE)) {
                   int newQuantity = quantity + 1;
                   preparedStatement2.setInt(1, idProduct);
                   preparedStatement2.setInt(2, newQuantity);
                   preparedStatement2.setInt(3, newQuantity);
                   preparedStatement2.executeUpdate();
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CartLine> getCartLines() {
        final String SELECT_CART_LINE = "SELECT PRODUCT.ID_PRODUCT, NAME, SUM(QUANTITY) AS QUANTITY, PRICE FROM detail_cart_line JOIN product ON PRODUCT.ID_PRODUCT = DETAIL_CART_LINE.ID_PRODUCT GROUP BY PRODUCT.ID_PRODUCT";
        List<CartLine> cartLines = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_LINE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idProduct = resultSet.getInt("ID_PRODUCT");
                String name = resultSet.getString("NAME");
                int quantity = resultSet.getInt("QUANTITY");
                float price = resultSet.getFloat("PRICE");
                cartLines.add(new CartLine(idProduct, name, quantity, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartLines;
    }

    @Override
    public void removeCartLine(int idProduct) {
        final String DELETE_CART_LINE = "DELETE FROM detail_cart_line WHERE ID_PRODUCT = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_LINE)) {
            preparedStatement.setInt(1, idProduct);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateQuantity(List<CartLine> cartLines) {
        final String INSERT_CART_LINE = "INSERT INTO detail_cart_line (ID_PRODUCT, ID_CART, QUANTITY) VALUES (?, 1, ?) ON DUPLICATE KEY UPDATE QUANTITY = ?";

    }
}
