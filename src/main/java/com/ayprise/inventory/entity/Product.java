package com.ayprise.inventory.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a product in the inventory.
 * <p>
 * This class is used to model the essential properties of a product,
 * including its unique identifier, name, category, and description.
 * It is annotated for persistence with JPA.
 * <p>
 * Annotations:
 * - @Entity: Specifies that the class is an entity managed by JPA.
 * - @Table: Defines the table name in the database as "product".
 * - @Id: Marks the primary key field for the entity.
 * - @GeneratedValue: Specifies the generation strategy for the primary key value.
 * - @Getter, @Setter: Automatically generates getter and setter methods for all fields.
 * - @NoArgsConstructor: Generates a no-argument constructor.
 * - @RequiredArgsConstructor: Generates a constructor requiring arguments for final fields.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Builder(setterPrefix = "with")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;
    private String category;
    private String description;

}
