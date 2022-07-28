package com.sabrysolutions.voyager.backend.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.CountrySerializer;
import com.sabrysolutions.voyager.backend.Serializer.GuideExtraServiceSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "guide_extra_services")
@Getter
@Setter
@JsonSerialize(using = GuideExtraServiceSerializer.class)
@Proxy(lazy = false)
public class GuideExtraService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fees")
    private int fees;

    @JoinColumn(name = "extra_service_id", referencedColumnName = "id")
    @ManyToOne
    private ExtraService extraService;

    @JsonIgnore
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @ManyToOne
    private Profile profile;

}
