package org.laboration3.service;

import org.laboration3.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Warehouse {
    Product product1 = new Product(
            5,
            "Example",
            "Category1",
            5,
            LocalDate.now(),
            LocalDate.now()
    );
    private final List<Product> productsArr = new ArrayList<>(Collections.singleton(product1));



    public void addProduct(Product p){
        // Check if name is not an empty string and id not exist
        if (!p.name().isEmpty() || !productsArr.contains(p)) {
            productsArr.add(p);
        }
    }

    public void modifyProduct(int productId, String newName, String newCategory, int newRating) {
        productsArr.stream()
                .filter(p -> p.id() == productId)
                .findFirst()
                .ifPresent(p -> {
            Product changedProduct = new Product(productId,newName,newCategory,newRating,p.createdDate(),LocalDate.now());
            // replacing with the modified product
            productsArr.set(productsArr.indexOf(p),changedProduct);
        });
    }


    public List<Product> getProductsArr() {
        return new ArrayList<>(productsArr);
    }

    public List<Product> getProductBasedOnCategory(String category) {
        List<Product> sortedByCategory = productsArr.stream()
                .filter(p -> p.category().equals(category))
                .sorted(Comparator.comparing(p-> p.name().toLowerCase()))
                .toList();
        return sortedByCategory;
    }
}