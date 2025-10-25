package org.kbapps.tigrinya_blog.comment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.kbapps.tigrinya_blog.Auditable;
import org.kbapps.tigrinya_blog.post.BlogPost;
import org.kbapps.tigrinya_blog.user.User;

@Getter
@Setter
@Entity
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,length=1000)
    private String content;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="postId",nullable = false)
    private BlogPost post;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="authorId",unique = true, nullable = false)
    private User author;

}
