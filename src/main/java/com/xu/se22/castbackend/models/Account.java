package com.xu.se22.castbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int AccountID;
    private String Name;
    private String Email;
    @Column(name = "usertype")
    private String UserType;
    private String Department;
    private String Promotion;
    @Column(name = "universityentry")
    private Date UniversityEntry;
    @Column(name = "publicationsbeforeuni")
    private int PublicationsBeforeUni;
    @Column(name = "academicemployment")
    private String AcademicEmployment;



    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Project> projects;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Publication> publications;



    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Handin> handins;

}
