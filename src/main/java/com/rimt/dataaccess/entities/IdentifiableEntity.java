package com.rimt.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@MappedSuperclass
public abstract class IdentifiableEntity {
	
	@Column(name = "created_on")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	protected DateTime createdOn;
	
	@PrePersist
	protected void prePersist(){
		createdOn = new DateTime();
	}
	
	public DateTime getCreatedOn() {
		return createdOn;
	}
	
	@Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        IdentifiableEntity entity = (IdentifiableEntity) obj;
        if (getId() == null && entity.getId() == null) {
            return false;
        }
        return new EqualsBuilder().append(getId(), entity.getId()).isEquals();
    }
	
	public abstract Long getId();
	
	@Override
	public int hashCode() {
	    return new HashCodeBuilder().append(getId()).hashCode();
	}

	@Override
	public String toString() {
	    return new ToStringBuilder(this).append("id", getId()).toString();
	}

	
}
