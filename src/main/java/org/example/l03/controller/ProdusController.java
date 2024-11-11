package org.example.l03.controller;

import org.example.l03.model.Produs;
import org.example.l03.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    // Get all produse
    @GetMapping
    public List<Produs> getAllProduse() {
        return produsService.getAllProduse();
    }

    // Get produs by id
    @GetMapping("/{id}")
    public ResponseEntity<Produs> getProdusById(@PathVariable Long id) {
        return produsService.getProdusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create produs
    @PostMapping
    public Produs createProdus(@RequestBody Produs produs) {
        return produsService.createProdus(produs);
    }

    // Update produs
    @PutMapping("/{id}")
    public ResponseEntity<Produs> updateProdus(@PathVariable Long id, @RequestBody Produs produsDetails) {
        try {
            Produs updatedProdus = produsService.updateProdus(id, produsDetails);
            return ResponseEntity.ok(updatedProdus);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete produs
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable Long id) {
        produsService.deleteProdus(id);
        return ResponseEntity.noContent().build();
    }
}