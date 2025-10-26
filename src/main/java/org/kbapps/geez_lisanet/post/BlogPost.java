package org.kbapps.geez_lisanet.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.kbapps.geez_lisanet.Auditable;
import org.kbapps.geez_lisanet.user.User;

@Getter
@Setter
@Entity
public class BlogPost extends Auditable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String title;
    private String geezVersion;
    private String description;
    @Column(nullable=false)
    private String body;
    private String summary;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="authorId",unique=true, nullable=false)
    private User author;

}
