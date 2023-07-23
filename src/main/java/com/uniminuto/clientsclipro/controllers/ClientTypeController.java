package com.uniminuto.clientsclipro.controllers;


import com.uniminuto.clientsclipro.models.ClientType;
import com.uniminuto.clientsclipro.services.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientType")
public class ClientTypeController {

    @Autowired
    ClientTypeService clientTypeService;
    @GetMapping("listClientType")
    public ArrayList<ClientType> getClientTypeList(){
        return clientTypeService.getClientTypeList();
    }
}
