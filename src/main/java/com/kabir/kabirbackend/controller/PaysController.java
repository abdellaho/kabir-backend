package com.kabir.kabirbackend.controller;

import com.kabir.kabirbackend.entities.Pays;
import com.kabir.kabirbackend.service.serviceImpl.PaysServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequestMapping("/pays")
public class PaysController{

    @Autowired
    PaysServiceImpl paysService;

    @GetMapping
    public ResponseEntity<List<Pays>> getAllPays() {
        return ResponseEntity.ok(paysService.getAllPays());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pays> getPaysById(@PathVariable("id") String id) {
        Optional<Pays> optionalPays = paysService.findById(id);
        return optionalPays.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.badRequest().body(null));
    }

    @PostMapping
    public ResponseEntity<Pays> savePays(@RequestBody Pays pays) {
        try {
            Pays paysReturn = paysService.save(pays);
            return ResponseEntity.ok(paysReturn);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("")
    public ResponseEntity<Pays> updatePays(@Valid @RequestBody Pays pays) {
        try {
            Pays paysReturn = paysService.update(pays);
            return ResponseEntity.ok(paysReturn);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePays(@PathVariable("id") String id) {
        try {
            paysService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
