package com.javaman.microservice.service;

import org.springframework.stereotype.Service;

/**
 * @author pengzhe
 * @date 2019-05-09 22:02
 * @description
 */
@Service
public class MicroSerice {

    public String microService(String param) {
        return param + " is OK";
    }

}
