package com.example.messaging.controller;

import java.util.ArrayList;

import com.example.messaging.model.NotifiTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationTaskController {

    @GetMapping("/notificationtask")
    public ArrayList<NotifiTask> notification(@RequestParam(value = "userId") int userId) {
        NotifiTask task = new NotifiTask(userId, "test");
        ArrayList<NotifiTask> list = new ArrayList<NotifiTask>();
        list.add(task);
        list.add(task);
        return list;
    }
}
