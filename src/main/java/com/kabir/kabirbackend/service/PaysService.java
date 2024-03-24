package com.kabir.kabirbackend.service;

import com.kabir.kabirbackend.entities.Pays;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PaysService {

    public Pays save(Pays pays);
    public Pays update(Pays pays);
    public boolean delete(String id);
    public List<Pays> getAllPays();

    public Optional<Pays> findById(String id);
    public List<Pays> findByLib(String lib);
}
