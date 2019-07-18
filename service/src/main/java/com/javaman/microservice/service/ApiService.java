package com.javaman.microservice.service;

import com.javaman.microservice.api.service.MicroService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author pengzhe
 * @date 2019-05-09 23:44
 * @description
 */
@Service
public class ApiService {

    @Reference(version = "${dubbo.service.version}")
    private MicroService microSerice;

    public String microService() {
        return microSerice.fetchInfo(66);
    }

}
