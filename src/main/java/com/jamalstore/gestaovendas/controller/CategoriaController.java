package com.jamalstore.gestaovendas.controller;

import com.jamalstore.gestaovendas.entity.Categoria;
import com.jamalstore.gestaovendas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarTodas(){
        return categoriaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> buscaPorId(@PathVariable Long id){
        Optional<Categoria> categoria = categoriaService.buscaPorId(id);
        //ternario para avlidar se o response retorna 200 ou 404
        return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

}
