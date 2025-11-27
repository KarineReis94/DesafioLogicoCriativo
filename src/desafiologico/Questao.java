/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico;

public abstract class Questao {
    private String enunciado;
    private String[] alternativas;
    private String respostaCorreta;

    public Questao(String enunciado, String[] alternativas, String respostaCorreta) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public boolean estaCorreta(String resposta) {
        return resposta.equalsIgnoreCase(respostaCorreta);
    }
}
