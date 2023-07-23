package com.uniminuto.clientsclipro.repositories;

import com.uniminuto.clientsclipro.models.ClientType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ClientTypeRepository extends CrudRepository<ClientType, Integer> {

    ArrayList<ClientType> findByActive(boolean active);
}
