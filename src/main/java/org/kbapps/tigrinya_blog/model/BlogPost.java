package org.kbapps.tigrinya_blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.kbapps.tigrinya_blog.Auditable;

@Getter
@Setter
@Entity
public class BlogPost extends Auditable {

    @Column(nullable=false)
    private String title;
    private String body;
    private String summary;
    @ManyToOne
    private User author;
}
