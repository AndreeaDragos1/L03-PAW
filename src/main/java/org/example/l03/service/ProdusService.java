package org.example.l03.service;

import org.example.l03.model.Produs;
import org.example.l03.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    public List<Produs> getAllProduse() {
        return produsRepository.findAll();
    }

    public Optional<Produs> getProdusById(Long id) {
        return produsRepository.findById(id);
    }

    public Produs createProdus(Produs produs) {
        return produsRepository.save(produs);
    }

    public Produs updateProdus(Long id, Produs produsDetails) {
        Produs produs = produsRepository.findById(id).orElseThrow();

        produs.setNume(produsDetails.getNume());
        produs.setPret(produsDetails.getPret());
        produs.setDescriere(produsDetails.getDescriere());

        return produsRepository.save(produs);
    }

    public void deleteProdus(Long id) {
        produsRepository.deleteById(id);
    }
}