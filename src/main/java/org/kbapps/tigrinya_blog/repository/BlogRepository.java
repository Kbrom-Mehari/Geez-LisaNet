package org.kbapps.tigrinya_blog.repository;

import org.kbapps.tigrinya_blog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogPost, Long> {

}
