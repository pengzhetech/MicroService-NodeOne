package com.javaman.microservice.controller;

import com.javaman.microservice.service.MicroSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengzhe
 * @date 2019-05-09 22:03
 * @description
 */

@RestController
@RequestMapping("/api")
public class MicroController {

    @Autowired
    private MicroSerice microSerice;

    @GetMapping("/test")
    public String test() {
      return   microSerice.microService("哲哥");
    }

}
