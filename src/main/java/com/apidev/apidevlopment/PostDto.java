package com.apidev.apidevlopment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostDto {
    @NotEmpty
    @Size(min = 2,message = "title is should be 2 character")
    private String title;
    @NotEmpty
    @Size(min = 4,message = "description is should be 4 character")

    private String description;
    @NotEmpty
    @Size(min = 4,message = "Content is should be 4 character")
    private  String Content;
    private  String message;


}
