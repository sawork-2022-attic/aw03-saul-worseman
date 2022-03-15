package com.example.webpos.db;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PosInMemoryDB implements PosDB {
    private List<Product> products = new ArrayList<>();

    private Cart cart;

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Cart saveCart(Cart cart) {
        this.cart = cart;
        return this.cart;
    }

    @Override
    public Cart getCart() {
        return this.cart;
    }

    @Override
    public Product getProduct(String productId) {
        for (Product p : getProducts()) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    private PosInMemoryDB() {
        this.products.add(new Product("PD1", "Electric irons", 199, "1.jpg"));
        this.products.add(new Product("PD2", "Soybean Milk Machine", 299, "2.jpg"));
        this.products.add(new Product("PD3", "Bag", 499, "3.jpg"));
        this.products.add(new Product("PD4", "Iphone Xs", 3499, "4.jpg"));
        this.products.add(new Product("PD5", "Sofa", 19499, "5.jpg"));
        this.products.add(new Product("PD6", "Chair", 1499, "6.jpg"));
        this.products.add(new Product("PD7", "Watch", 4499, "7.jpg"));
        this.products.add(new Product("PD8", "iMac", 14999, "comp.png"));

    }

}
