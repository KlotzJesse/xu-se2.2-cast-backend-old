package com.xu.se22.castbackend.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Funding {

    private final int FundingID;
    private final int ProjectID;
    private Date Year;
    private double National;
    private double State;
    private double OrganizationsOrEU;
    private double DFG;
    private double Buisnesses;
    private double OtherFunders;


}
