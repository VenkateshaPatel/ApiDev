package com.apidev.apidevlopment.Serviceimpl;

import com.apidev.apidevlopment.Entity.Post;
import com.apidev.apidevlopment.Exception.ResponseNotFoundException;
import com.apidev.apidevlopment.Payload.PostDto;
import com.apidev.apidevlopment.PostRepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceimpl implements PostService {
@Autowired
 private PostRepository postrepo;

    public PostServiceimpl(PostRepository postrepo) {
        this.postrepo = postrepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post save = postrepo.save(post);

      PostDto dto = new PostDto();
      dto.setContent(postDto.getContent());
      dto.setDescription(postDto.getDescription());
      dto.setTitle(postDto.getTitle());
      dto.setId(postDto.getId());
      return dto;
    }

    @Override
    public void deletePost(long id) {
       Post post = postrepo.findById(id).orElseThrow(
                ()-> new ResponseNotFoundException(("Post is not found:"+id)));

     postrepo.deleteById(id);





    }

    @Override
    public void findByID(long id) {

        Optional<Post> byid = postrepo.findById(id);
        if(byid.isPresent()) {
            postrepo.deleteById(id);
        }else{
            throw new ResponseNotFoundException("post is not found with id"+ id);



    }
}

    @Override
    public List<PostDto> getAllPost() {
        List<Post> dtos = postrepo.findAll();
        dtos.stream().map(p->MapToDto(p)).collect(Collectors.toList());

        return null;
    }

     PostDto MapToDto(Post p) {
        PostDto dto = new PostDto();
        dto.setId(p.getId());
        dto.setTitle(p.getTitle());
        dto.setContent(p.getContent());
        return dto;

    }

}
