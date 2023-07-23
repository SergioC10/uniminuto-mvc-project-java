package com.uniminuto.clientsclipro.services;


import com.uniminuto.clientsclipro.models.ClientType;
import com.uniminuto.clientsclipro.models.Clients;
import com.uniminuto.clientsclipro.repositories.ClientRepository;
import com.uniminuto.clientsclipro.repositories.ClientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientTypeRepository clientTypeRepository;

    public ArrayList<Clients> getClients(){
       ArrayList<Clients> clientsList = (ArrayList<Clients>) clientRepository.findAll();
       clientsList.forEach(clients -> {
           ClientType ct = clientTypeRepository.findById(clients.getTypeId()).get();
           clients.setClientType(ct);
       });
       return clientsList;
    }

    public ArrayList<Clients> getClientsByRole(int roleId){
        ArrayList<Clients> clientsList = (ArrayList<Clients>) clientRepository.findByTypeId(roleId);
        clientsList.forEach(clients -> {
            ClientType ct = clientTypeRepository.findById(clients.getTypeId()).get();
            clients.setClientType(ct);
        });
        return clientsList;
    }

    public Clients saveClient(Clients client){
        return clientRepository.save(client);
    }

    public int deleteClient(int clientId){
        clientRepository.deleteById(clientId);

        Optional<Clients> client = clientRepository.findById(clientId);

        if(!client.isPresent()){
            return 1;
        } else {
            return 0;
        }
    }

    public Clients updateClient(Clients client) {
        return clientRepository.save(client);
    }
}
