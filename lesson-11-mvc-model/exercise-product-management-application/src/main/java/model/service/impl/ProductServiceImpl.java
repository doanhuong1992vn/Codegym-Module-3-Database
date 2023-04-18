package model.service.impl;

import model.entity.Product;
import model.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private static final IProductService productService = new ProductServiceImpl();
    private ProductServiceImpl(){}
    public static IProductService getProductService() {
        return productService;
    }

    private static final List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Quần", 50000, "jeans, dài", "Hạnh Thông Tây"));
        products.add(new Product(2, "Áo sơ mi", 230000, "vải lụa mỏng, mát", "An Đông"));
        products.add(new Product(3, "Áo ba lỗ", 60000, "vải cotton thấm hút tốt", "Chợ Tân Bình"));
        products.add(new Product(4, "Mũ snap back", 100000, "hiphop style", "An Đông"));
        products.add(new Product(5, "Giày sneaker", 2500000, "nai kỳ sờ ta đỳ", "Kim Biên"));
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public List<Product> getProductsByKeyword(String keyword) {
        List<Product> productList = new ArrayList<>();
        String search = keyword.toUpperCase().trim();
        for (Product product : products) {
            if (product.getName().toUpperCase().contains(search)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
