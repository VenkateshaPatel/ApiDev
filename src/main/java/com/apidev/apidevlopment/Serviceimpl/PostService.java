package com.apidev.apidevlopment.Serviceimpl;

import com.apidev.apidevlopment.Payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    void deletePost(long id);

   void findByID(long id);

    List<PostDto> getAllPost();
}
