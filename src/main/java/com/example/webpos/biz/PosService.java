package com.example.webpos.biz;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;

import java.util.List;

public interface PosService {
    public Cart getCart();

    public Cart newCart();

    public void checkout(Cart cart);

    public int total(Cart cart);

    public boolean add(Product product, int amount);

    public boolean add(String productId, int amount);

    public boolean deleteItem(String productId);

    public boolean removeProduct(String prouductId);

    public List<Product> products();
}
