package org.laboration3;

import org.laboration3.entities.Categories;
import org.laboration3.entities.Product;
import org.laboration3.service.Warehouse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public class Laboration3 {
    public static void main(String[] args) {
        System.out.println("Hello There!");

        Warehouse warehouse = new Warehouse();

        Product product2 = new Product(
                2,
                "h",
                Categories.health,
                2,
                LocalDateTime.of(2023, 9, 4, 15, 0),
                LocalDateTime.of(2023, 9, 4, 15, 0)
        );
        Product product3 = new Product(
                7,
                "Knäskydd",
                Categories.clothes,
                5,
                LocalDateTime.of(2023, 9, 4, 15, 0),
                LocalDateTime.of(2023, 9, 4, 15, 0)
        );
        Product product4 = new Product(
                10,
                "Byxa",
                Categories.clothes,
                10,
                LocalDateTime.of(2023, 9, 5, 15, 0),
                LocalDateTime.of(2023, 9, 4, 16, 0)
        );

        warehouse.addProduct(product2);
        warehouse.addProduct(product3);
        warehouse.addProduct(product4);



        // Example to show get map function
        Map<String, Integer> mapExample = warehouse.getMap();

        for (Map.Entry<String, Integer> p : mapExample.entrySet()) {
            System.out.println("Nyckel: " + p.getKey() + " : " + "Värde " + p.getValue());
        }

        warehouse.modifyProduct(7, "Äpple", Categories.sport, 2);

        List<Product> products = warehouse.getProductsArr();


        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}


