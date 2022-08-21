package com.project.socialDemo.repos;

import com.project.socialDemo.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
