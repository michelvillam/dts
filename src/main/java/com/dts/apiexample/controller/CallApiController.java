package com.dts.apiexample.controller;

import com.dts.apiexample.service.CallApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class CallApiController {

    static Logger logger = Logger.getLogger(CallApiController.class.getName());
    private CallApiService callApiService;

    public CallApiController(CallApiService callApiService) {

        this.callApiService = callApiService;
    }

    @GetMapping("/api")
    public String callApi(){
        logger.info("Calling api. ");
        return callApiService.CallApi();
    }
}
