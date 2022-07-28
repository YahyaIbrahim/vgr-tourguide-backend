package com.sabrysolutions.voyager.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "payments_info")
public class PaymentInfo extends AuditModel {

    @JoinColumn(name = "tourist_id", referencedColumnName = "id")
    @ManyToOne
    private Profile profile;

    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "valid_thru")
    private String validThru;

    @Column(name = "is_primary")
    private int isPrimary;

}
