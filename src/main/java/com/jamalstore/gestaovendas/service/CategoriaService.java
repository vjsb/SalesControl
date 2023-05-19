package com.jamalstore.gestaovendas.service;

import com.jamalstore.gestaovendas.entity.Categoria;
import com.jamalstore.gestaovendas.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Optional<Categoria> buscaPorId(Long codigo){
        return categoriaRepository.findById(codigo);
    }

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save((categoria));
    }

    //copyProperties recebe o parametro categoria e o substitui pela categoriaSalvar que vem com os dados atualizados do bd
    //propriedade codigo é ignorada e não alterada
    public Categoria atualizar(Long codigo, Categoria categoria){
        Categoria categoriaSalvar = validarCategoriaExiste(codigo);
        BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");
        return categoriaRepository.save(categoriaSalvar);
    }

    //Valida a categoria buscada no bd, caso seja vazia lança uma exceção
    private Categoria validarCategoriaExiste(Long codigo){
        Optional<Categoria> categoria = buscaPorId(codigo);
        if (categoria.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        return categoria.get();
    }

}
