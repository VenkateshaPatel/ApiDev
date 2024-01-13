package com.apidev.apidevlopment.PostController;

import com.apidev.apidevlopment.Payload.PostDto;
import com.apidev.apidevlopment.Serviceimpl.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class Pcontroller {
    private PostService postService;

    public Pcontroller(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPost(){

        List <PostDto> postDto=postService.getAllPost();
        return postDto;
    }
}
