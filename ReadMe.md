# CAST Notification Service Backend
This repository contains a basic notification service for CAST.

## Known Issues and Limitations / State of the Project

Missing overall structure and implementation!  
No connection to other services.  
We are missing a working model and connection to real a database (no hosting was provided yet).  
It is not possible to fetch data and no cron jobs that would trigger delivery are implemented. 

## Usage

1. Start DB with docker: `docker-compose up -d`
2. Build and run with maven: `spring-boot:run`

## Build docker image

1. Build to jar with maven: `package`
2. Build local docker image: `docker build -t cast/notification-backend:latest .`

### _Contributors Docker_

| Name             | Email |
|------------------| ----- |
| Philipp Liermann | p.liermann@student.xu-university.de |

***

## Architecture / Documentation

### _JPA_

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

### _Contributors JPA_

| Name | Email |
| ---- | ----- |
| Tobias Schildbach | t.schildbach@student.xu-university.de |
| Tom Engelmann | t.engelmann@student.xu-university.de |


### _Contributors Email Service_

The email service takes in an email adress, a subject and a message, which will then send with a dedicated gmail the wanted email to the email adress.

| Name | Email |
| ---- | ----- |
| Jonah Ising | j.ising@student.xu-university.de |
***

### _API Routes_

The API route is responsible for returning outstanding assignments to the front end. It's reachable under "/api/NotificationTasks" and a request should be formated the following: "/api/NotificationTasks?userId=..." . The API routes sections consists out of two elements, one is the controller which is the request handler that initiates a new instance of the NotificationTask class. 

```java
package com.example.messaging.controller;

@RestController
public class NotificationTaskController {

    @GetMapping("/api/NotificationTasks")
    public ArrayList<NotificationTask> notification(@RequestParam(value = "userId") int userId) {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 2);
        Date date = c.getTime();

        NotificationTask task = new NotificationTask(0, "Example Task",
                "lorem lorem lorem", "/tasks/0", date);
        NotificationTask task2 = new NotificationTask(1, "Example Task 2",
                "lorem lorem lorem", "/tasks/1", date);
        ArrayList<NotificationTask> list = new ArrayList<>();
        list.add(task);
        list.add(task2);
        return list;
    }
}
```

```java
package com.example.messaging.model;

import java.util.Date;

public class NotificationTask {
    private long id;
    private String title;
    private String description;
    private String url;
    private Date deadline;

    public NotificationTask(long id, String title, String description, String url, Date deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.deadline = deadline;
    }

    //...

}
```

### _Contributors API_

| Name | Email |
| ---- | ----- |
| Maximilian Wagner | m.wagner@student.xu-university.de |
| Philipp Liermann | p.liermann@student.xu-university.de |

***
