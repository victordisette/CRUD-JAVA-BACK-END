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
            LivroModel livro1 = LivroModel.builder()
                    .titulo("O Poder do Hábito")
                    .autor("Charles Duhigg")
                    .isbn("978-8539003887")
                    .anoPublicacao("2012")
                    .disponivel(true)
                    .build();

            livroRepository.saveAll(Arrays.asList(
                    livro1
            ));
        }

    }


}



