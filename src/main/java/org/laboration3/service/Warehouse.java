package org.laboration3.service;

import org.laboration3.entities.Categories;
import org.laboration3.entities.Product;


import java.time.LocalDateTime;
import java.util.*;
public class Warehouse {
    private Product product1 = new Product(
            5,
            "Tröja",
            Categories.clothes,
            5,
            LocalDateTime.of(2023, 9, 4, 15, 0),
            LocalDateTime.of(2023, 9, 4, 15, 0)
    );
    private final List<Product> productsArr = new ArrayList<>(Collections.singleton(product1));


    public void addProduct(Product p) {
        // Check if name is not an empty string and if id already exist
        if (!p.name().isEmpty() &&
                productsArr.stream()
                        .noneMatch(productId -> productId.id() == p.id())) {
            productsArr.add(p);
        }
    }

    public void modifyProduct(int productId, String newName, Categories newCategory, int newRating) {
        productsArr.stream()
                .filter(p -> p.id() == productId)
                .findFirst()
                .ifPresent(p -> {
                    Product changedProduct = new Product(productId, newName, newCategory, newRating, p.createdDate(), LocalDateTime.now());
                    // replacing with the modified product
                    productsArr.set(productsArr.indexOf(p), changedProduct);
                });
    }


    public List<Product> getProductsArr() {
        return new ArrayList<>(productsArr);
    }

    public List<Product> getProductBasedOnCategory(Categories category) {
        List<Product> sortedByCategory = productsArr.stream()
                .filter(p -> p.category().equals(category))
                .sorted(Comparator.comparing(p -> p.name().toLowerCase()))
                .toList();
        return sortedByCategory;
    }

    public List<Product> getProductCreatedAfterDate(LocalDateTime date) {
        List<Product> createdAfterDate = productsArr.stream()
                .filter(p -> p.createdDate().isAfter(date))
                .toList();
        return createdAfterDate;
    }

    public List<Product> getProductThatBeenModified() {
        List<Product> modifiedProducts = productsArr.stream()
                .filter(p -> !p.createdDate().isEqual(p.lastModifiedDate()))
                .toList();
        return modifiedProducts;
    }


    // VG assignments
    public List<Categories> getCategoriesWithProducts() {
        List<Categories> categoriesContainsProduct = new ArrayList<>();

        for (Product p : productsArr) {
            Categories category = p.category();
            // check if category exist before adding
            if (!categoriesContainsProduct.contains(category)) {
                categoriesContainsProduct.add(category);
            }
        }

        return categoriesContainsProduct;
    }

    public int getHowManyProductsRelatedToCategory(Categories category) {
        List<Product> productsInCategory = new ArrayList<>();

        for (Product p : productsArr) {
            if (p.category() == category) {
                productsInCategory.add(p);
            }
        }

        return productsInCategory.size();
    }

    public Map<Character, Integer> getMap() {
        //List with only the names
        List<String> productNames = new ArrayList<>();
        for (Product product : productsArr) {
            productNames.add(product.name());
        }

        Map<Character, Integer> map = new HashMap<>();
        for (String productName : productNames) {
            //Check to see it's not empty
            if (productName != null && !productName.isEmpty()) {
                char firstLetter = productName.charAt(0);

                // Sets the values to key and update map
                Integer count = map.get(firstLetter);
                if (count == null) {
                    map.put(firstLetter, 1);
                } else {
                    map.put(firstLetter, count + 1);
                }
            }
        }
        return map;
    }

    public List<Product> getRecentMaxRating() {
        List<Product> maxRatingProduct = productsArr.stream()
                .filter(p -> p.rating() == 10 &&
                        p.createdDate().getMonth() == LocalDateTime.now().getMonth())
                .sorted(Comparator.comparing(Product::createdDate).reversed())
                .toList();

        if (maxRatingProduct.isEmpty()) {
            System.out.println("Det fanns ingen produkt med högsta rating");
        }

        return maxRatingProduct;
    }
}
