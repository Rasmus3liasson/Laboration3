package org.laboration3;

import org.laboration3.entities.Product;
import org.laboration3.service.Warehouse;

import java.time.LocalDate;
import java.util.List;

public class Laboration3 {
    public static void main(String[] args) {
        System.out.println("Hello There!");

        Warehouse warehouse = new Warehouse();


        Product product2 = new Product(
                2,
                "dhskjd",
                "Category1",
                2,
                LocalDate.now(),
                LocalDate.now()
        );
        Product product3 = new Product(
                7,
                "phskjd",
                "Category1",
                5,
                LocalDate.now(),
                LocalDate.now()
        );
        Product product4 = new Product(
                7,
                "phskjd",
                "Category2",
                5,
                LocalDate.now(),
                LocalDate.now()
        );


        warehouse.addProduct(product2);
        warehouse.addProduct(product3);
        warehouse.addProduct(product4);

        warehouse.modifyProduct(2,"anders","Category1",7);


        for (Product product : warehouse.getProductBasedOnCategory("Category1")) {

            System.out.println(product);
        }
    }
}

