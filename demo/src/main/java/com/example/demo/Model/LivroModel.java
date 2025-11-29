package com.example.demo.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LivroModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo")
    private String  titulo;
    @Column(name = "autor")
    private String autor;
    @Column (name = "isbn")
    private String isbn;
    @Column (name = "anoPublicacao")
    private String anoPublicacao;
    @Column (name = "disponivel")
    private Boolean disponivel;


}



