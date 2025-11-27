/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {

    private List<Questao> questoes;
    private int indiceAtual = 0;
    private int pontuacao = 0;
    private String nomeJogador;

    public Jogo(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        this.questoes = new ArrayList<>();
        carregarPoolDeQuestoes();
        Collections.shuffle(this.questoes); // embaralha a ordem
       
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Questao getQuestaoAtual() {
        if (indiceAtual < questoes.size()) {
            return questoes.get(indiceAtual);
        }
        return null;
    }

    public boolean responder(String resposta) {
        Questao q = getQuestaoAtual();
        if (q == null) return false;
        boolean correta = q.estaCorreta(resposta);

        if (correta) {
            pontuacao += 10;
        }

        indiceAtual++;
        return correta;
    }

    public boolean acabou() {
        return indiceAtual >= questoes.size();
    }

    private void carregarPoolDeQuestoes() {
      
        // Matemática 
        questoes.add(new QuestaoMatematica(
                "Quanto é 5 + 7?",
                new String[]{"10", "12", "13", "14"},
                "12"));

        questoes.add(new QuestaoMatematica(
                "Quanto é 9 × 3?",
                new String[]{"18", "27", "36", "21"},
                "27"));

        questoes.add(new QuestaoMatematica(
                "Qual é a raiz quadrada de 81?",
                new String[]{"7", "8", "9", "10"},
                "9"));

        questoes.add(new QuestaoMatematica(
                "Quanto é 15 ÷ 3?",
                new String[]{"4", "5", "6", "3"},
                "5"));

        questoes.add(new QuestaoMatematica(
                "Quanto é 7 * 6?",
                new String[]{"42", "36", "48", "40"},
                "42"));

        questoes.add(new QuestaoMatematica(
                "Qual o próximo número: 2, 4, 6, __ ?",
                new String[]{"7", "8", "9", "10"},
                "8"));

        // Cultura geral
        questoes.add(new QuestaoCultura(
                "Qual é o maior planeta do sistema solar?",
                new String[]{"Saturno", "Terra", "Júpiter", "Marte"},
                "Júpiter"));

        questoes.add(new QuestaoCultura(
                "Quem pintou a Mona Lisa?",
                new String[]{"Van Gogh", "Leonardo da Vinci", "Picasso", "Michelangelo"},
                "Leonardo da Vinci"));

        questoes.add(new QuestaoCultura(
                "Qual o idioma oficial do Brasil?",
                new String[]{"Espanhol", "Inglês", "Português", "Francês"},
                "Português"));

        questoes.add(new QuestaoCultura(
                "Em que continente fica o Egito?",
                new String[]{"Ásia", "África", "Europa", "Oceania"},
                "África"));

        questoes.add(new QuestaoCultura(
                "Quem escreveu 'Dom Casmurro'?",
                new String[]{"Machado de Assis", "José de Alencar", "Carlos Drummond", "Clarice Lispector"},
                "Machado de Assis"));

        questoes.add(new QuestaoCultura(
                "Qual é a capital do Japão?",
                new String[]{"Seul", "Pequim", "Tóquio", "Xangai"},
                "Tóquio"));
    }
}
