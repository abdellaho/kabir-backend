package com.kabir.kabirbackend.service.serviceImpl;

import com.kabir.kabirbackend.entities.Pays;
import com.kabir.kabirbackend.repository.PaysRepository;
import com.kabir.kabirbackend.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaysServiceImpl implements PaysService {

    @Autowired
    PaysRepository paysRepository;

    @Override
    public Pays save(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public Pays update(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public boolean delete(String id) {
        try {
            paysRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }

    @Override
    public Optional<Pays> findById(String id) {
        return paysRepository.findById(id);
    }

    @Override
    public List<Pays> findByLib(String lib) {
        Pays pays = new Pays(null, lib);
        Example<Pays> example = Example.of(pays);
        return paysRepository.findAll(example);
    }
}
