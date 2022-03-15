package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PosServiceImp implements PosService {

    private PosDB posDB;

    @Autowired
    public void setPosDB(PosDB posDB) {
        this.posDB = posDB;
    }

    @Override
    public Cart getCart() {

        Cart cart = posDB.getCart();
        if (cart == null){
            cart = this.newCart();
        }
        return cart;
    }

    @Override
    public Cart newCart() {
        return posDB.saveCart(new Cart());
    }

    @Override
    public void checkout(Cart cart) {

    }

    @Override
    public int total(Cart cart) {
        //return posDB.getCart().total();
        int total = 0;
        for (int i = 0; i < cart.getItems().size(); i++) {
            total += cart.getItems().get(i).getQuantity() * cart.getItems().get(i).getProduct().getPrice();
        }
        return total;
    }

    @Override
    public boolean add(Product product, int amount) {
        return false;
    }

    @Override
    public boolean add(String productId, int amount) {

        Product product = posDB.getProduct(productId);
        if (product == null) return false;
        Item item = this.getCart().getItem(productId);
        if(item == null)
            this.getCart().addItem(new Item(product, amount));
        else
            item.setQuantity(item.getQuantity() + 1);
        return true;
    }

    public boolean deleteItem(String productId){
        Product product = posDB.getProduct(productId);
        if (product == null) return false;

        if(this.getCart().deleteItem(productId))
            return true;
        return false;
    }

    @Override
    public boolean removeProduct(String productId) {
        Product product = posDB.getProduct(productId);
        if (product == null) return false;
        Item item = this.getCart().getItem(productId);
        item.setQuantity(item.getQuantity() - 1);
        if(item.getQuantity() == 0)
            deleteItem(productId);
        return true;
    }

    @Override
    public List<Product> products() {
        return posDB.getProducts();
    }
}
