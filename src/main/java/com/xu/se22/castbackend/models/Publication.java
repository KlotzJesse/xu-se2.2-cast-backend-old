package com.xu.se22.castbackend.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Publication {

    private final int AccountID;
    private final int PublicationID;
    private String Name;
    private int Year;
    private boolean TopFive;
    private String PublicationIndex;

}
