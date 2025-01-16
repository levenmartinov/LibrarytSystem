// File: Book.java
package com.tpe.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Title cannot be blank!")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters!")
    @Column(nullable = false)
    private String title;

    @DecimalMin(value = "1", inclusive = true, message = "Pages must be greater than or equal to 1!")
    @Column(nullable = false)
    private Integer pages;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans;

    @Embedded
    private Address address;


}
