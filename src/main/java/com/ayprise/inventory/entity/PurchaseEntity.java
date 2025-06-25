package com.ayprise.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase")
@Builder(setterPrefix = "with")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String orderNumber;

    private String vendorName;
    private LocalDate purchaseDate;

    private double paymentAmount;
    private LocalDate paymentDate;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseItemEntity> items;

    public double getTotal() {
        return items.stream()
                .mapToDouble(item -> (item.getPrice() + item.getSalesTax()) * item.getQuantity())
                .sum();
    }
}
