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
                "D-vitamin",
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
        Product product5 = new Product(
                10,
                "Bajs",
                Categories.clothes,
                10,
                LocalDateTime.of(2023, 9, 8, 15, 0),
                LocalDateTime.of(2023, 9, 4, 16, 0)
        );
        Product product6 = new Product(
                10,
                "Bajsasasadas",
                Categories.clothes,
                10,
                LocalDateTime.of(2023, 9, 7, 15, 0),
                LocalDateTime.of(2023, 9, 4, 16, 0)
        );


        warehouse.addProduct(product2);
        warehouse.addProduct(product3);
        warehouse.addProduct(product4);
        warehouse.addProduct(product5);
        warehouse.addProduct(product6);

        // Example to show get map function
        Map<Character, Integer> mapExample = warehouse.getMap(warehouse);

        for (Map.Entry<Character, Integer> p : mapExample.entrySet()) {
            System.out.println("Key: " + p.getKey() + " : " + "Value " + p.getValue());
        }
    }
}


