package com.michal.examples.i18n.entity;


import com.michal.examples.i18n.entity.base.CreateUpdateBaseTsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * @author Michal Remis
 */
@Entity
@Table(name = "i18n_messages")
public class I18NMessageEntity extends CreateUpdateBaseTsEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "locale")
    private String locale;
    @Column(name = "module")
    private String module;
    @Column(name = "key")
    private String key;
    @Column(name = "message")
    private String message;

    public I18NMessageEntity(String id, String customerId, String locale, String module, String key, String message) {
        this.id = id;
        this.customerId = customerId;
        this.locale = locale;
        this.module = module;
        this.key = key;
        this.message = message;
    }

    public I18NMessageEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        I18NMessageEntity that = (I18NMessageEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
