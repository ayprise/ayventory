package com.ayprise.inventory.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseTests {

    Product switch2Product = Product.builder()
            .withName("Nintendo Switch 2 Mario Kart Bundle")
            .withCategory("Electronics")
            .withDescription("Nintendo Switch 2 Mario Kart Bundle")
            .build();
    Product airpodsProduct = Product.builder()
            .withName("Airpods Pro 2")
            .withCategory("Electronics")
            .withDescription("Apple Headphones")
            .build();


    PurchaseItem switch2Purchase1 = PurchaseItem.builder()
            .withProduct(switch2Product)
            .withPrice(499.99)
            .withQuantity(2)
            .withSalesTax(30.00)
            .build();
    PurchaseItem airpodsPurchase1 = PurchaseItem.builder()
            .withProduct(airpodsProduct)
            .withPrice(199.99)
            .withQuantity(1)
            .withSalesTax(12.00)
            .build();
    Purchase purchase1 = Purchase.builder()
            .withVendorName("Target")
            .withOrderNumber("TEST-001")
            .withPurchaseDate(java.time.LocalDate.now())
            .withReceipt(List.of(switch2Purchase1, airpodsPurchase1))
            .build();

    // Normal Case
    @Test
    void getTotalTest1() {
        double total = purchase1.getTotal();
        assertEquals(1271.97, total);
    }

    PurchaseItem switch2Purchase2 = PurchaseItem.builder()
            .withProduct(switch2Product)
            .withPrice(499.99)
            .withQuantity(0)
            .withSalesTax(30.00)
            .build();
    Purchase purchase2 = Purchase.builder()
            .withVendorName("Target")
            .withOrderNumber("TEST-002")
            .withPurchaseDate(java.time.LocalDate.now())
            .withReceipt(List.of(switch2Purchase2))
            .build();

    PurchaseItem switch2Purchase3 = PurchaseItem.builder()
            .withProduct(switch2Product)
            .withPrice(0.00)
            .withQuantity(1)
            .withSalesTax(30.00)
            .build();
    Purchase purchase3 = Purchase.builder()
            .withVendorName("Target")
            .withOrderNumber("TEST-003")
            .withPurchaseDate(java.time.LocalDate.now())
            .withReceipt(List.of(switch2Purchase3))
            .build();

    // No quantity, No price
    @Test
    void getTotalTest2() {
        double total = purchase2.getTotal();
        assertEquals(0, total);

        total = purchase3.getTotal();
        assertEquals(0, total);
    }

    Purchase purchase4 = Purchase.builder()
            .withVendorName("Target")
            .withOrderNumber("TEST-004")
            .withPurchaseDate(java.time.LocalDate.now())
            .withReceipt(List.of(switch2Purchase1, switch2Purchase2, switch2Purchase3))
            .build();

    // Mixed case
    @Test
    void getTotalTest3() {
        double total = purchase4.getTotal();
        assertEquals(1059.97, total);
    }

    PurchaseItem airpodsPurchase2 = PurchaseItem.builder()
            .withProduct(airpodsProduct)
            .withPrice(199.99)
            .withQuantity(2)
            .withSalesTax(0)
            .build();
    Purchase purchase5 = Purchase.builder()
            .withVendorName("Target")
            .withOrderNumber("TEST-005")
            .withPurchaseDate(java.time.LocalDate.now())
            .withReceipt(List.of(airpodsPurchase2))
            .build();
    Purchase purchase6 = Purchase.builder()
            .withVendorName("Target")
            .withOrderNumber("TEST-006")
            .withPurchaseDate(java.time.LocalDate.now())
            .withReceipt(List.of(airpodsPurchase1, airpodsPurchase2))
            .build();

    // No Sales Tax
    @Test
    void getTotalTest4() {
        double total = purchase5.getTotal();
        assertEquals(399.98, total);
        total = purchase6.getTotal();
        assertEquals(611.97, total);
    }
}
