package com.sabrysolutions.voyager.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"creationTime", "updateTime"},
        allowGetters = true
)

public abstract class AuditModel implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    private Long id;



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_time", nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date creationTime = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date updateTime = new Date();

    @Override
    public String toString() {
        return "AuditModel{" +
                "id=" + id +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}