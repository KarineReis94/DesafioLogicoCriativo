/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico;

public class QuestaoMatematica extends Questao {

    public QuestaoMatematica(String pergunta, String[] opcoes, int respostaCorreta) {
        super(pergunta, opcoes, respostaCorreta);
    }

    @Override
    public String getCategoria() {
        return "Matemática";
    }
}
