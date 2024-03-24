package com.kabir.kabirbackend.service;

import com.kabir.kabirbackend.dto.VilleDTO;
import com.kabir.kabirbackend.entities.Pays;
import com.kabir.kabirbackend.entities.Ville;

import java.util.List;
import java.util.Optional;

public interface VilleService {

    public VilleDTO save(VilleDTO ville);
    public VilleDTO update(VilleDTO ville);
    public boolean delete(String id);
    public List<VilleDTO> getAllVille();

    public Optional<VilleDTO> findById(String id);
    public List<VilleDTO> findByLib(String lib);
}
