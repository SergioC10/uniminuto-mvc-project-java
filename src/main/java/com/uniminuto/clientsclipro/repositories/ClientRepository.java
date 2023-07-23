package com.uniminuto.clientsclipro.repositories;

import com.uniminuto.clientsclipro.models.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Clients, Integer> {

    List<Clients> findByTypeId(int roleId);
}
