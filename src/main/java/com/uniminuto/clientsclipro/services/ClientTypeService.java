package com.uniminuto.clientsclipro.services;


import com.uniminuto.clientsclipro.models.ClientType;
import com.uniminuto.clientsclipro.models.Clients;
import com.uniminuto.clientsclipro.repositories.ClientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientTypeService {

    @Autowired
    ClientTypeRepository clientTypeRepository;

    public ArrayList<ClientType> getClientTypeList(){
        return clientTypeRepository.findByActive(true);
    }


    public ArrayList<ClientType> getClientTypeList2(){
        return (ArrayList<ClientType>) clientTypeRepository.findAll();
    }
}
