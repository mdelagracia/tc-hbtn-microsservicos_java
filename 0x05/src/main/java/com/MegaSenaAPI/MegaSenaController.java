package com.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value="/megaSena-api/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Boas-vindas!";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {

        List<Integer> numeros = new ArrayList<>();
        List<Integer> resultados = new ArrayList<>();
        for(int i = 1; i<=60; i++)
            numeros.add(i);

        for (int i = 1; i <= 6; i++) {
            Random roleta = new Random();
            Collections.shuffle(numeros);
           int sorteados = roleta.nextInt(numeros.size());
           resultados.add(sorteados);
           Collections.sort(resultados,Collections.reverseOrder());
        }
        return resultados;
    }
}