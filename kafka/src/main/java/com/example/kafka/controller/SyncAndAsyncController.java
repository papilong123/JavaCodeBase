package com.example.kafka.controller;

import com.example.kafka.domain.Bar;
import com.example.kafka.service.SyncAndAsyncService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SyncAndAsyncController {

    @Autowired
    private final SyncAndAsyncService syncAndAsyncService;

    @PostMapping("/async")
    public void sendAsync(Bar bar){
        syncAndAsyncService.sendAsync(bar);
    }

    @PostMapping("/sync")
    public void sendSync(Bar bar){
        syncAndAsyncService.sendSync(bar);
    }

}
