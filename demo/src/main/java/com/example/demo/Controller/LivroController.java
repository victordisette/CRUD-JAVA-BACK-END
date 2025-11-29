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
    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }
    @GetMapping("/id/{id}") //faz uma requesição
    public ResponseEntity<LivroModel> getLivroById(@PathVariable Integer id){
        return livroRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/create") //envia a resposta
    public ResponseEntity <LivroModel> save(@RequestBody LivroModel livroModel) {
        return ResponseEntity.ok(livroRepository.save(livroModel));
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<LivroModel> update(@PathVariable Integer id, @RequestBody LivroModel livroModel) {

        if (livroModel.getTitulo() != null) {
                livroModel.setTitulo(livroModel.getTitulo());
        }
        if (livroModel.getAutor() != null) {
            livroModel.setAutor(livroModel.getAutor());
        }
        if (livroModel.getIsbn() != null) {
            livroModel.setIsbn(livroModel.getIsbn());
        }
        if (livroModel.getAnoPublicacao() != null) {
            livroModel.setAnoPublicacao(livroModel.getAnoPublicacao());
        }
        if (livroModel.getDisponivel() != null) {
            livroModel.setDisponivel(livroModel.getDisponivel());
        }
        LivroModel updatedLivro = livroRepository.save(livroModel);
        return ResponseEntity.ok(updatedLivro);
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
