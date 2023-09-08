package org.laboration3;

import org.junit.jupiter.api.Test;
import org.laboration3.entities.Categories;
import org.laboration3.entities.Product;
import org.laboration3.service.Warehouse;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WarehouseTest {

    Warehouse warehouse = new Warehouse();
    // Create test products
    Product product1 = new Product(1, "Hatt", Categories.clothes, 5, LocalDateTime.now(), LocalDateTime.now());
    Product product2 = new Product(1, "Tröja", Categories.clothes, 4, LocalDateTime.now(), LocalDateTime.now());
    Product product3 = new Product(2, "Balsam", Categories.health, 3, LocalDateTime.now(), LocalDateTime.now());
    Product product4 = new Product(8, "", Categories.health, 3, LocalDateTime.now(), LocalDateTime.now());
    Product product5 = new Product(4, "Football", Categories.sport, 5, LocalDateTime.now(), LocalDateTime.now());


    @Test
    void testAddProduct() {
        warehouse.addProduct(product1);
        warehouse.addProduct(product3);

        // Check if Products have been added
        assertThat(warehouse.getProductsArr()).contains(product1, product3);

        // Shows that function won't add products with same iD
        assertThrows(IllegalArgumentException.class, () -> {
            warehouse.addProduct(product2);
        });

        // Shows that product with empty string can't be added
        assertThrows(IllegalArgumentException.class, () -> {
            warehouse.addProduct(product4);
        });

        // Test to see that products 2 and 4 haven't been added
        assertThat(warehouse.getProductsArr()).doesNotContain(product2, product4);

    }

    @Test
    void testModifyProduct() {

        warehouse.addProduct(product1);
        warehouse.addProduct(product3);
        warehouse.addProduct(product5);

        // Product before modification
        Product product3BeforeModification = warehouse.getProductsArr().get(2);

        warehouse.modifyProduct(2, "Mascara", Categories.health, 5);

        Product modifiedProduct = warehouse.getProductsArr().stream()
                .filter(p -> p.id() == 2)
                .findFirst()
                .orElse(null);

        assertThat(modifiedProduct).isNotNull();
        assertThat(modifiedProduct.name()).isEqualTo("Mascara");
        assertThat(modifiedProduct.category()).isEqualTo(Categories.health);

        // Check that the old product don't exist in the warehouse
        assertThat(warehouse.getProductsArr()).doesNotContain(product3BeforeModification);

        // Error when trying to modify id that don't exist
        assertThrows(NoSuchElementException.class, () -> {
            warehouse.modifyProduct(98, "hej", Categories.health, 7);
        });
    }
}
