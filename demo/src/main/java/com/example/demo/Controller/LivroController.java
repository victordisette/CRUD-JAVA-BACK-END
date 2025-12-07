package com.example.demo.Controller;

import com.example.demo.Model.LivroModel;
import com.example.demo.Repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@AllArgsConstructor
public class LivroController {

    private final LivroRepository livroRepository;


    @GetMapping
    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> getLivroById(@PathVariable Integer id) {
        return livroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<LivroModel> save(@RequestBody LivroModel livroModel) {
        LivroModel saved = livroRepository.save(livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<LivroModel> update(@PathVariable Integer id, @RequestBody LivroModel livroModel) {

        return livroRepository.findById(id).map(existing -> {

            if (livroModel.getTitulo() != null) {
                existing.setTitulo(livroModel.getTitulo());
            }
            if (livroModel.getAutor() != null) {
                existing.setAutor(livroModel.getAutor());
            }
            if (livroModel.getIsbn() != null) {
                existing.setIsbn(livroModel.getIsbn());
            }
            if (livroModel.getAnoPublicacao() != null) {
                existing.setAnoPublicacao(livroModel.getAnoPublicacao());
            }
            if (livroModel.getDisponivel() != null) {
                existing.setDisponivel(livroModel.getDisponivel());
            }

            LivroModel updated = livroRepository.save(existing);
            return ResponseEntity.ok(updated);

        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        if (!livroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
