
CREATE SCHEMA CAST_TEST;
USE CAST_TEST; 

#CREATE USER 'cast_server'@'localhost' IDENTIFIED BY 'cast_server1234';
#GRANT DELETE, INSERT, UPDATE, SELECT, EXECUTE ON CAST_TEST . * TO 'cast_server'@'localhost';

CREATE TABLE Accounts ( 
    AccountID int auto_increment Not Null, 
    Name varchar(100) Not Null, 
    Email varchar(100),
    UserType varchar(100),
    Department varchar(36), 
    Promotion varchar(100), 
    UniversityEntry date, 
    PublicationsBeforeUni int, 
    AcademicEmployment varchar(100) Not Null, 
    PRIMARY KEY (AccountID) 
 ); 

CREATE TABLE Intrests ( 
	AccountID int,
    InterestID int AUTO_INCREMENT NOT NULL, 
    ResearchName VARCHAR(100) NOT NULL, 
    Topic VARCHAR(100), 
    StudyIntegration VARCHAR(500), 
	Datatype DOUBLE, 
	EthicsMeasure VARCHAR(100), 	
	AcademicProgram VARCHAR(100), 
    PRIMARY KEY (InterestID),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)  
); 

CREATE TABLE Projects (
	AccountID int,
    ProjectID int not null auto_increment, 
    ProjectName varchar(100) not null, 
    InPlanning bool, 
    DateStart datetime, 
    DateEnd datetime, 
    DateSubmission date, 
    DateDecision date, 
    Department varchar(100), 
    ThirdPartySupport varchar(100), 
    FundingByXU int, 
    PrincipleResponsible varchar(100), 
    PreviousScientificOutput varchar(500), 
    PRIMARY KEY (ProjectID),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)  
); 

CREATE TABLE Fundings (
	FundingID int,
	ProjectID int, 
	Year Date,  
	National DOUBLE, 
	State DOUBLE,  
	OrganizationsOrEU DOUBLE,  
	DFG DOUBLE,  
	Buisnesses DOUBLE,  
	OtherFunders DOUBLE,  
    PRIMARY KEY (FundingID),
	FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID) 
); 

CREATE TABLE Publications ( 
    AccountID int Not Null, 
    PublicationID int auto_increment Not Null, 
    Name varchar(100) Not Null, 
    Year int, 
    TopFive Boolean, 
    PublicationIndex varchar(128), 
    PRIMARY KEY (PublicationID), 
    FOREIGN KEY(AccountID) references Accounts(AccountID) 
 );



#For Interests
CREATE TABLE ResearchPartners ( 
    ResearchPartnerID int AUTO_INCREMENT NOT NULL, 
    ResearchPartnerName VARCHAR(100) NOT NULL, 
    Position VARCHAR(3),  #int for internal, ext for external
    PRIMARY KEY (ResearchPartnerID), 
    Intrest int,
    FOREIGN KEY (Intrest) REFERENCES Intrests(InterestID)
); 

CREATE TABLE Programs ( 
    ProgramID int AUTO_INCREMENT NOT NULL, 
    ProgramName VARCHAR(100) NOT NULL, 
    Semester VARCHAR(50), 
    PRIMARY KEY (ProgramID) 
); 

CREATE TABLE ThirdPartySupports ( 
    ThirdPartySupportID int AUTO_INCREMENT NOT NULL, 
    ThirdPartySupportName VARCHAR(200) NOT NULL, 
    PRIMARY KEY (ThirdPartySupportID) 
); 

CREATE TABLE Engagements ( 
	ProgramID int, 
	ThirdPartySupportID int, 
    FOREIGN KEY (ProgramID) REFERENCES Programs(ProgramID), 
    FOREIGN KEY (ThirdPartySupportID) REFERENCES ThirdPartySupports(ThirdPartySupportID) 
); 

  

 


