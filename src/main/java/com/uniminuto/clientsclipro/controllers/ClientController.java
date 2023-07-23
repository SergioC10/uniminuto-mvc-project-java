package com.uniminuto.clientsclipro.controllers;

import com.uniminuto.clientsclipro.models.Clients;
import com.uniminuto.clientsclipro.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;


    @GetMapping("/listClients")
    public ArrayList<Clients> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/listClientsByRole/{roleId}")
    public ArrayList<Clients> getClientsByRole(@PathVariable("roleId") int roleId){
        return clientService.getClientsByRole(roleId);
    }

    @PostMapping("/save-client")
    public Clients saveClient(@RequestBody Clients client){
        return clientService.saveClient(client);
    }

    @DeleteMapping("/delete-client/{clientId}")
    public int deleteClient(@PathVariable("clientId") int clientId){
        return clientService.deleteClient(clientId);
    }

    @PutMapping("/update-client")
    public Clients updateClient(@RequestBody Clients client){
        return clientService.updateClient(client);
    }

}
