package com.example.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ProductDto {

    private int productId;
    private String description;
    private double price;
    private ProductCommentDto productRating;

}
