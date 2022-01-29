package com.xu.se22.castbackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PublicationID;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accountid", nullable = false)
    private Account account;
    private String Name;
    private int Year;
    private boolean TopFive;
    private String PublicationIndex;

}
