package com.ayprise.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public final class PurchaseItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    private PurchaseEntity purchase;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
    private int quantity;
    private double price;
    private double salesTax;

}