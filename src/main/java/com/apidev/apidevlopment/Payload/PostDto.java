package com.apidev.apidevlopment.Payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class PostDto {
    private long id;
    @NotEmpty
    @Size(min = 2)
    private String title;
    @NotEmpty
    @Size(min = 4)

    private String description;
    @NotEmpty
    @Size(min = 4,message = "Content is should be 4 character")
    private  String Content;
    private  String message;


}
