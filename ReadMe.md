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


## _Contributors Email Service_

The email service takes in an email adress, a subject and a message, which will then send with a dedicated gmail the wanted email to the email adress.

| Name | Email |
| ---- | ----- |
| Jonah Ising | j.ising@student.xu-university.de |
***

## _API Routes_

The API route is responsible for returning outstanding assignments to the front end. It's reachable under "/api/NotificationTasks" and a request should be formated the following: "/api/NotificationTasks?userId=..." . The API routes sections consists out of two elements, one is the controller which is the request handler that initiates a new instance of the NotificationTask class. 

```package com.example.messaging.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.example.messaging.model.NotificationTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationTaskController {

    @GetMapping("/api/NotificationTasks")
    public ArrayList<NotificationTask> notification(@RequestParam(value = "userId") int userId) {

       /*
       TODO explain why this is like it is
        */


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

```
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }


}
```

## _Contributors API_

| Name | Email |
| ---- | ----- |
| Maximilian Wagner | m.wagner@student.xu-university.de |
| Philipp Liermann | p.liermann@student.xu-university.de |

***
