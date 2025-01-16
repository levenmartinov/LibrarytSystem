// File: Address.java (renamed from Adress.java)
package com.tpe.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(nullable = false)
    @NotBlank(message = "City cannot be blank!")
    private String city;

    @Column(nullable = false)
    @NotBlank(message = "Street cannot be blank!")
    private String street;

    @Column(nullable = false)
    @NotBlank(message = "Number cannot be blank!")
    private String number;

    @Column(nullable = false)
    @NotBlank(message = "Zip Code cannot be blank!")
    private String zipCode;
}
