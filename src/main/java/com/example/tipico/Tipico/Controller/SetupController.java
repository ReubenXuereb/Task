package com.example.tipico.Tipico.Controller;

import com.example.tipico.Tipico.Service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/setup")
public class SetupController {

    private SetupService setupService;

    @Autowired
    public SetupController(SetupService setupService) {
        this.setupService = setupService;
    }

    @PostMapping
    public void setUpApp() {
        setupService.setupApplication();
    }
}
