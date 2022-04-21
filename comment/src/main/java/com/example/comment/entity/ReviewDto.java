package com.example.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ReviewDto {

    private String userFirstname;
    private String userLastname;
    private int productId;
    private String comment;

}
