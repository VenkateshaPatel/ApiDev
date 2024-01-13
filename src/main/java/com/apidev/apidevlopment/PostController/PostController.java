package com.apidev.apidevlopment.PostController;

import com.apidev.apidevlopment.Entity.Post;
import com.apidev.apidevlopment.Payload.PostDto;
import com.apidev.apidevlopment.Serviceimpl.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

            }

        PostDto dt = postService.createPost(postDto);
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted",HttpStatus.OK);
    }
    @PutMapping({"id"})
    public ResponseEntity<String> findByID(@PathVariable long id  ){
     postService.findByID(id);
     return new ResponseEntity<>("POSt is Found",HttpStatus.FOUND);

    }
    @GetMapping
    public List<PostDto> getAllPost(){

        List <PostDto> postDto=postService.getAllPost();
        return postDto;
    }

}
