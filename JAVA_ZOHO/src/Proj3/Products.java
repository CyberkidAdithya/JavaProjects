package Proj3;

import java.util.*;     // ArrayList, List

public class Products {
    private final List<Product> products = new ArrayList<Product>();

    public Products () {
        this.initStoreItems();
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void initStoreItems() {
        String [] productNames = {"Banana", "Mango", "Orange"};
        Double [] productPrice = {40.00d, 60.00d, 30.00d};
        Integer [] stock = {5, 5, 5};
        
        for (int i=0; i < productNames.length; i++) {
            this.products.add(new Product(i+1, productNames[i], productPrice[i], stock[i]));
        }
    }
}