/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico;

public abstract class Questao {
    protected String pergunta;
    protected String[] opcoes;
    protected int respostaCorreta;

    public Questao(String pergunta, String[] opcoes, int respostaCorreta) {
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public boolean verificarResposta(int resposta) {
        return resposta == respostaCorreta;
    }

    public abstract String getCategoria();
}

