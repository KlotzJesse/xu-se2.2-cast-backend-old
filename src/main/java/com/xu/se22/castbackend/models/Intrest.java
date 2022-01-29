package com.xu.se22.castbackend.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Intrest {

    private final int AccountID;
    private final int InterestID;
    private String ResearchName;
    private String Topic;
    private String StudyIntegration;
    private double Datatype;
    private String EthicsMeasure;
    private String AcademicProgram;

}
