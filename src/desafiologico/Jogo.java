/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private List<Questao> questoes;
    private int acertos;
    private int erros;
    private int pontos;

    public Jogo() {
        questoes = new ArrayList<>();
        acertos = 0;
        erros = 0;
        pontos = 0;
        inicializarQuestoes();
    }

    private void inicializarQuestoes() {
        // Questões de Cultura
        questoes.add(new QuestaoCultura("Qual é a capital do Brasil?", new String[]{"Brasília", "Rio", "São Paulo", "Salvador"}, 0));
        questoes.add(new QuestaoCultura("Quem escreveu 'Dom Casmurro'?", new String[]{"Machado de Assis", "Carlos Drummond", "Monteiro Lobato", "Cecília Meireles"}, 0));
        questoes.add(new QuestaoCultura("Qual é o maior oceano do mundo?", new String[]{"Atlântico", "Índico", "Pacífico", "Ártico"}, 2));
        questoes.add(new QuestaoCultura("Em que ano o Brasil descobriu o ouro?", new String[]{"1500", "1695", "1822", "1700"}, 1));
        questoes.add(new QuestaoCultura("Qual é o maior país do mundo?", new String[]{"Brasil", "Rússia", "Canadá", "China"}, 1));
        questoes.add(new QuestaoCultura("Qual planeta é conhecido como Planeta Vermelho?", new String[]{"Terra", "Marte", "Júpiter", "Vênus"}, 1));

        // Questões de Matemática
        questoes.add(new QuestaoMatematica("Quanto é 5 + 7?", new String[]{"12", "10", "11", "13"}, 0));
        questoes.add(new QuestaoMatematica("Quanto é 9 x 3?", new String[]{"27", "21", "30", "26"}, 0));
        questoes.add(new QuestaoMatematica("Qual é a raiz quadrada de 64?", new String[]{"6", "8", "7", "9"}, 1));
        questoes.add(new QuestaoMatematica("Quanto é 15 - 4?", new String[]{"10", "11", "12", "13"}, 1));
        questoes.add(new QuestaoMatematica("Quanto é 20 ÷ 5?", new String[]{"2", "3", "4", "5"}, 2));
        questoes.add(new QuestaoMatematica("Qual é 7 + 6 x 2?", new String[]{"19", "20", "21", "18"}, 0));
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void marcarAcerto() {
        acertos++;
        pontos += 10;
    }

    public void marcarErro() {
        erros++;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean fimDoJogo() {
        return acertos >= 6 || erros >= 3;
    }
}
