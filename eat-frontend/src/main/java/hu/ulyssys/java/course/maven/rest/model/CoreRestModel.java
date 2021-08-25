package hu.ulyssys.java.course.maven.rest.model;

import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public abstract class CoreRestModel {
    private Long id;

    @PastOrPresent
    private Date createdDate;

    @PastOrPresent
    private Date modifiedDate;

    private Long createdById;

    private Long modifiedById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public Long getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Long modifiedById) {
        this.modifiedById = modifiedById;
    }
}