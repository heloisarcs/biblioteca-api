package com.suaapi.controller;

import com.suaapi.model.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    // "Banco de dados" simulado em memória
    private final List<Livro> livros = new ArrayList<>();

    public LivroController() {
        livros.add(new Livro(1, "Dom Casmurro", "Machado de Assis", 1899));
        livros.add(new Livro(2, "Grande Sertão: Veredas", "Guimarães Rosa", 1956));
    }

    // GET /livros -> 200 OK
    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.ok(livros);
    }

    // POST /livros -> 201 CREATED
    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        livro.setId(livros.size() + 1); // simula a geração do ID
        livros.add(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }
}
