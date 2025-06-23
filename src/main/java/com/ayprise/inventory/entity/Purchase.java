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
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String orderNumber;

    private String vendorName;
    private LocalDate purchaseDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<PurchaseItem> items;

    public double getTotal() {
        return items.stream()
                .mapToDouble(item -> (item.getPrice() + item.getSalesTax()) * item.getQuantity())
                .sum();
    }
}
