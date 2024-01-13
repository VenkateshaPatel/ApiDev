package com.apidev.apidevlopment.PostRepository;

import com.apidev.apidevlopment.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
