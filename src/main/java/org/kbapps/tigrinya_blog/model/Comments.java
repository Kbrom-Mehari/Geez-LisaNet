package org.kbapps.tigrinya_blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.kbapps.tigrinya_blog.Auditable;
@Getter
@Setter
@Entity
public class Comments extends Auditable {
    @Column(nullable=false)
    private String content;
    @ManyToOne
    private BlogPost post;
    @ManyToOne
    private User author;
}
