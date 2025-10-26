package org.kbapps.geez_lisanet.comment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.kbapps.geez_lisanet.Auditable;
import org.kbapps.geez_lisanet.post.BlogPost;
import org.kbapps.geez_lisanet.user.User;

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
