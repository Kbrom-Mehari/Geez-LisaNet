package org.kbapps.tigrinya_blog.repository;

import org.kbapps.tigrinya_blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
   List<Comment> findCommentsByPostId(Long id);

}
