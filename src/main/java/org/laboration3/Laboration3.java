package org.laboration3;

import org.laboration3.entities.Categories;
import org.laboration3.entities.Product;
import org.laboration3.service.Warehouse;


import java.time.LocalDateTime;


public class Laboration3 {
    public static void main(String[] args) {
        System.out.println("Hello There!");

        Warehouse warehouse = new Warehouse();


        Product product2 = new Product(
                2,
                "D-vitamin",
                Categories.health,
                2,
                LocalDateTime.of(2023, 9, 4, 15,0),
                LocalDateTime.of(2023, 9, 4, 15,0)
        );
        Product product3 = new Product(
                7,
                "Knäskydd",
                Categories.workout,
                5,
                LocalDateTime.of(2023, 9, 4, 15,0),
                LocalDateTime.of(2023, 9, 4, 15,0)
        );
        Product product4 = new Product(
                7,
                "Byxa",
                Categories.clothes,
                5,
                LocalDateTime.of(2023, 9, 4, 15,0),
                LocalDateTime.of(2023, 9, 4, 16,0)
        );


        warehouse.addProduct(product2);
        warehouse.addProduct(product3);
        warehouse.addProduct(product4);

        for (Product product : warehouse.getProductBasedOnCategory(Categories.clothes)){

            System.out.println(product);
        }
    }
}

