package com.rimt.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@MappedSuperclass
public abstract class ModifiableEntity extends IdentifiableEntity {

    @Column(name = "updated_on")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime updatedOn;

    @Override
    protected void prePersist() {
        createdOn = new DateTime();
        updatedOn = createdOn;
    }

    @PreUpdate
    protected void preUpdate() {
    	updatedOn = new DateTime();
    }

    public DateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(DateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}

