package com.example.usermanager.model;

import com.example.usermanager.dao.IProductDAO;
import com.example.usermanager.dao.ProductDAO;

import java.util.List;

public class CartLineService {

    public float getTotalPrice(List<CartLine> cartLines) {
        float totalPrice = 0;
        for (CartLine cartLine : cartLines) {
            totalPrice += cartLine.getTotalPrice();
        }
        return totalPrice;
    }

    public void setCartLines(String[] quantities, List<CartLine> cartLines) {
        for (int i = 0; i < cartLines.size(); i++) {
            cartLines.get(i).setQuantity(Integer.parseInt(quantities[i]));
        }
        IProductDAO productDAO = new ProductDAO();
        productDAO.updateQuantity(cartLines);
    }
}
