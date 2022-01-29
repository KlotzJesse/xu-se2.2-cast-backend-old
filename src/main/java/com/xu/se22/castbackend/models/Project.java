package com.xu.se22.castbackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ProjectID;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accountid", nullable = false)
    private Account account;
    @Column(name = "projectname")
    private String ProjectName;
    @Column(name = "inplanning")
    private boolean InPlanning;
    @Column(name = "datestart")
    private Date DateStart;
    @Column(name = "dateend")
    private Date DateEnd;
    @Column(name = "datesubmission")
    private Date DateSubmission;
    @Column(name = "datedecision")
    private Date DateDecision;
    private String Department;
    @Column(name = "thirdpartysupport")
    private String ThirdPartySupport;
    @Column(name = "fundingbyxu")
    private int FundingByXU;
    @Column(name = "principleresponsible")
    private String PrincipleResponsible;
    @Column(name = "previousscientificoutput")
    private String PreviousScientificOutput;

}
