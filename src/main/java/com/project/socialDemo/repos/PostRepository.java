package com.project.socialDemo.repos;

import com.project.socialDemo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
