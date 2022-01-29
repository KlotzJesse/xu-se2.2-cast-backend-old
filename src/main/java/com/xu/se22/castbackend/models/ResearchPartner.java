package com.xu.se22.castbackend.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResearchPartner {

    private final int ResearchPartnerID;
    private final int Intrest;
    private String ResearchPartnerName;
    private String Position;

}
