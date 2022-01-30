# ReadMe

***

## _JPA_

JPA (Java Persistence API) facilitates object-relational mapping
to manage relational data in Java applications. It provides a
platform to work directly with objects instead of using SQL statements.

For the CAST´s messaging service, JPA is used to persist data from
Java objects and the following two tables from the relational database:

```SQL
CREATE TABLE Accounts ( 
    AccountID int auto_increment Not Null, 
    Name varchar(100) Not Null, 
    Email varchar(100),
    UserType varchar(100),
    Department varchar(36), 
    Promotion int, 
    UniversityEntry date, 
    PublicationsBeforeUni int, 
    AcademicEmployment varchar(100) Not Null, 
    PRIMARY KEY (AccountID) 
 );
```

```SQL
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
```

## _Contributors JPA_

| Name | Email |
| ---- | ----- |
| Tobias Schildbach | t.schildbach@student.xu-university.de |
| Tom Engelmann | t.engelmann@student.xu-university.de |

***