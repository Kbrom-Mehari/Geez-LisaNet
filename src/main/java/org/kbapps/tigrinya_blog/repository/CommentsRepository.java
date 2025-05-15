package org.kbapps.tigrinya_blog.repository;

import org.kbapps.tigrinya_blog.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
