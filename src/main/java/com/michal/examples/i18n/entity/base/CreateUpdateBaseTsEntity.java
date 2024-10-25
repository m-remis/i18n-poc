package com.michal.examples.i18n.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDateTime;

/**
 * @author Michal Remis
 */
@MappedSuperclass
public abstract class CreateUpdateBaseTsEntity implements Serializable {

    @Column(name = "creation_ts", updatable = false)
    private LocalDateTime creationTs;
    @Column(name = "update_ts")
    private LocalDateTime updateTs;

    public LocalDateTime getCreationTs() {
        return creationTs;
    }

    public LocalDateTime getUpdateTs() {
        return updateTs;
    }

    @PrePersist
    public void fillCreationTs() {
        if (this.creationTs == null) {
            this.creationTs = LocalDateTime.now(Clock.systemUTC());
        }
        fillUpdateTs();
    }

    @PreUpdate
    public void fillUpdateTs() {
        this.updateTs = LocalDateTime.now(Clock.systemUTC());
    }

}
