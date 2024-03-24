package com.kabir.kabirbackend.service.serviceImpl;

import com.kabir.kabirbackend.dto.VilleDTO;
import com.kabir.kabirbackend.entities.Pays;
import com.kabir.kabirbackend.entities.Ville;
import com.kabir.kabirbackend.repository.PaysRepository;
import com.kabir.kabirbackend.repository.VilleRepository;
import com.kabir.kabirbackend.service.VilleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Data @AllArgsConstructor
public class VilleServiceImpl implements VilleService {

    private VilleRepository villeRepository;
    private PaysRepository paysRepository;


    @Override
    public VilleDTO save(VilleDTO villeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pays pays = null;
        if(null != villeDTO.getPaysId()) {
            Optional<Pays> optionalPays = paysRepository.findById(villeDTO.getPaysId());
            if(optionalPays.isPresent()) pays = optionalPays.get();
        }
        Ville ville = modelMapper.map(villeDTO, Ville.class);
        ville.setPays(pays);

        Ville villeReturned = villeRepository.save(ville);
        return modelMapper.map(villeReturned, VilleDTO.class);
    }

    @Override
    public VilleDTO update(VilleDTO villeDTO) {
        return save(villeDTO);
    }

    @Override
    public boolean delete(String id) {
        try {
            villeRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<VilleDTO> getAllVille() {
        ModelMapper modelMapper = new ModelMapper();
        List<Ville> list = villeRepository.findAll();
        if(CollectionUtils.isNotEmpty(list)) {
            return list.stream().map(x -> modelMapper.map(x, VilleDTO.class)).toList();
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<VilleDTO> findById(String id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Ville> optionalVille = villeRepository.findById(id);
        return optionalVille.map(ville -> modelMapper.map(ville, VilleDTO.class));
    }

    @Override
    public List<VilleDTO> findByLib(String lib) {
        ModelMapper modelMapper = new ModelMapper();
        Ville ville = new Ville(null, lib, null);
        Example<Ville> villeExample = Example.of(ville);

        List<Ville> list = villeRepository.findAll(villeExample);
        if(CollectionUtils.isNotEmpty(list)) {
            return list.stream().map(x -> modelMapper.map(x, VilleDTO.class)).toList();
        }
        return Collections.emptyList();
    }
}
