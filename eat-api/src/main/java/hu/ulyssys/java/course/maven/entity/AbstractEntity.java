package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
public abstract class AbstractEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

*/

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}

