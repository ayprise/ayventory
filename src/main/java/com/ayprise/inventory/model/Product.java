package com.ayprise.inventory.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a product in the inventory.
 *
 * This class is used to model the essential properties of a product,
 * including its unique identifier, name, category, and description.
 * It is annotated for persistence with JPA.
 *
 * The class utilizes Lombok annotations for boilerplate reduction,
 * providing automatic generation of getter and setter methods, a no-argument
 * constructor, and a required-arguments constructor.
 *
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
@Table(name = "product")
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;
    private String category;
    private String description;

}
