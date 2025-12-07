package com.example.demo.Model;

import com.example.demo.Model.LivroModel;
import com.example.demo.Repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final LivroRepository livroRepository;

    @Override
    public void run(String... args) throws Exception {

        if (livroRepository.count() == 0) {

            // Livro 1: Negócios/Hábitos
            LivroModel livro1 = LivroModel.builder()
                    .titulo("O Poder do Hábito")
                    .autor("Charles Duhigg")
                    .isbn("978-8539003887")
                    .anoPublicacao("2012")
                    .disponivel(true)
                    .build();

            // Livro 2: História/Ciência
            LivroModel livro2 = LivroModel.builder()
                    .titulo("Sapiens: Uma Breve História da Humanidade")
                    .autor("Yuval Noah Harari")
                    .isbn("978-8535928185")
                    .anoPublicacao("2014")
                    .disponivel(true)
                    .build();

            // Livro 3: Ficção Distópica (Indisponível)
            LivroModel livro3 = LivroModel.builder()
                    .titulo("1984")
                    .autor("George Orwell")
                    .isbn("978-8535914843")
                    .anoPublicacao("1949")
                    .disponivel(false)
                    .build();

            // Livro 4: Ficção Política
            LivroModel livro4 = LivroModel.builder()
                    .titulo("A Revolução dos Bichos")
                    .autor("George Orwell")
                    .isbn("978-8535909870")
                    .anoPublicacao("1945")
                    .disponivel(true)
                    .build();

            // Livro 5: Romance Clássico
            LivroModel livro5 = LivroModel.builder()
                    .titulo("Dom Casmurro")
                    .autor("Machado de Assis")
                    .isbn("978-8583861218")
                    // .anoPublicacao(null) // Adicionando a possibilidade de nulo, se o Model permitir
                    .disponivel(true)
                    .build();

            // Livro 6: Fantasia Épica
            LivroModel livro6 = LivroModel.builder()
                    .titulo("O Hobbit")
                    .autor("J.R.R. Tolkien")
                    .isbn("978-8533615560")
                    .anoPublicacao("1937")
                    .disponivel(true)
                    .build();

            // Livro 7: Ciência/Psicologia
            LivroModel livro7 = LivroModel.builder()
                    .titulo("Rápido e Devagar: Duas Formas de Pensar")
                    .autor("Daniel Kahneman")
                    .isbn("978-8539003832")
                    .anoPublicacao("2011")
                    .disponivel(true)
                    .build();

            // Livro 8: Poesia/Drama (Indisponível)
            LivroModel livro8 = LivroModel.builder()
                    .titulo("Auto da Compadecida")
                    .autor("Ariano Suassuna")
                    .isbn("978-8572328224")
                    .anoPublicacao("1955")
                    .disponivel(false)
                    .build();

            // Livro 9: Autoajuda
            LivroModel livro9 = LivroModel.builder()
                    .titulo("A Coragem de Ser Imperfeito")
                    .autor("Brené Brown")
                    .isbn("978-8543105742")
                    .anoPublicacao("2010")
                    .disponivel(true)
                    .build();


            livroRepository.saveAll(Arrays.asList(
                    livro1,
                    livro2,
                    livro3,
                    livro4,
                    livro5,
                    livro6,
                    livro7,
                    livro8,
                    livro9
            ));
        }

    }

}