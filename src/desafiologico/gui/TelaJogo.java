/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico.gui;

import desafiologico.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TelaJogo extends JFrame {
    private Jogo jogo;
    private int indiceAtual;
    private JLabel perguntaLabel;
    private JButton[] botoesOpcoes;

    public TelaJogo() {
        jogo = new Jogo();
        indiceAtual = 0;

        setTitle("Desafio Lógico Criativo - Jogo");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        perguntaLabel = new JLabel("", SwingConstants.CENTER);
        perguntaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(perguntaLabel, BorderLayout.NORTH);

        JPanel opcoesPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        botoesOpcoes = new JButton[4];
        for(int i=0; i<4; i++) {
            botoesOpcoes[i] = new JButton();
            final int opcao = i;
            botoesOpcoes[i].addActionListener(e -> responder(opcao));
            opcoesPanel.add(botoesOpcoes[i]);
        }
        add(opcoesPanel, BorderLayout.CENTER);

        mostrarQuestao();
    }

    private void mostrarQuestao() {
        List<Questao> questoes = jogo.getQuestoes();
        if(indiceAtual < questoes.size() && !jogo.fimDoJogo()) {
            Questao q = questoes.get(indiceAtual);
            perguntaLabel.setText(q.getCategoria() + ": " + q.getPergunta());
            String[] opcoes = q.getOpcoes();
            for(int i=0;i<4;i++) {
                botoesOpcoes[i].setText(opcoes[i]);
            }
        } else {
            TelaRanking ranking = new TelaRanking(jogo.getPontos());
            ranking.setVisible(true);
            this.dispose();
        }
    }

    private void responder(int opcao) {
        Questao q = jogo.getQuestoes().get(indiceAtual);
        if(q.verificarResposta(opcao)) {
            jogo.marcarAcerto();
            JOptionPane.showMessageDialog(this, "Acertou!");
        } else {
            jogo.marcarErro();
            JOptionPane.showMessageDialog(this, "Errou!");
        }
        indiceAtual++;
        mostrarQuestao();
    }
}
