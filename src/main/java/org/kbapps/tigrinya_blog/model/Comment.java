package org.kbapps.tigrinya_blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.kbapps.tigrinya_blog.Auditable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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
    @JoinColumn(name="authorId",nullable = false)
    private User author;

}
