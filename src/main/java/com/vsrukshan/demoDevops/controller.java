package com.vsrukshan.demoDevops;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class controller {

    @GetMapping
    public ResponseEntity<?> getMessage() {
        return new ResponseEntity<>("Demo Response for DevOps assignment", HttpStatusCode.valueOf(200));
    }
}
