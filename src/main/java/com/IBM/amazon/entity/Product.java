package com.IBM.amazon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Product {

    @Id
    private String productId;
    private String title;
    private String description;
    private int price;
    private int discountedPrice;
    private int quantity;

}
