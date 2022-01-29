package com.xu.se22.castbackend.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Project {

    private final int AccountID;
    private final int ProjectID;
    private String ProjectName;
    private boolean InPlanning;
    private Date DateStart;
    private Date DateEnd;
    private Date DateSubmission;
    private Date DateDecision;
    private String Department;
    private String ThirdPartySupport;
    private int FundingByXU;
    private String PrincipleResponsible;
    private String PreviousScientificOutput;

}
