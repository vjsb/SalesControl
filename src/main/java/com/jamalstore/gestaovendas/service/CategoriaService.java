package com.jamalstore.gestaovendas.service;

import com.jamalstore.gestaovendas.entity.Categoria;
import com.jamalstore.gestaovendas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscaPorId(Long id){
        return categoriaRepository.findById(id);
    }

}
