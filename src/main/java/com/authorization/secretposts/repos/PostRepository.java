package com.authorization.secretposts.repos;

import com.authorization.secretposts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
//    public Post getPostBySiteUser(String siteUser);
}
