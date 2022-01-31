package com.example.messaging.controller;

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
            This function only represents a prototype/example implementation, as no actual implementation exists
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
