/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package desafiologico.gui;

import desafiologico.Jogo;
import desafiologico.Questao;
import javax.swing.*;
import java.awt.*;

public class TelaJogo extends JFrame {

    private Jogo jogo;
    private JLabel lblEnunciado;
    private JButton[] botoes = new JButton[4];
    private JLabel lblTempo;

    private int tempoRestante = 10; // ⏱️ tempo por pergunta
    private Timer timer;

    public TelaJogo(Jogo jogo) {
        this.jogo = jogo;

        setTitle("Jogo");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(180, 210, 255)); // azul claro

        lblEnunciado = new JLabel("", SwingConstants.CENTER);
        lblEnunciado.setBounds(50, 30, 500, 40);
        lblEnunciado.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblEnunciado);

        lblTempo = new JLabel("Tempo: 10", SwingConstants.CENTER);
        lblTempo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTempo.setBounds(240, 70, 120, 30);
        add(lblTempo);

        for (int i = 0; i < 4; i++) {
            botoes[i] = new JButton();
            botoes[i].setBounds(150, 120 + (i * 60), 300, 40);
            estilizarBotao(botoes[i]);
            add(botoes[i]);

            int index = i;
            botoes[i].addActionListener(e -> responder(index));
        }

        carregarQuestao();
    }

    private void estilizarBotao(JButton btn) {
        btn.setBackground(new Color(120, 150, 255));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
    }

    private void iniciarTimer() {
        if (timer != null) timer.stop();

        tempoRestante = 10;
        lblTempo.setText("Tempo: " + tempoRestante);

        timer = new Timer(1000, e -> {
            tempoRestante--;
            lblTempo.setText("Tempo: " + tempoRestante);

            if (tempoRestante <= 0) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "⏳ Tempo esgotado!");
                jogo.responder("TEMPO"); 
                carregarQuestao();
            }
        });

        timer.start();
    }

    private void carregarQuestao() {
        Questao q = jogo.getQuestaoAtual();

        if (q == null) {
            new TelaRanking(jogo.getNomeJogador(), jogo.getPontuacao()).setVisible(true);
            dispose();
            return;
        }

        lblEnunciado.setText(q.getEnunciado());

        String[] alternativas = q.getAlternativas();
        for (int i = 0; i < 4; i++) {
            botoes[i].setText(alternativas[i]);
        }

        iniciarTimer();
    }

    private void responder(int index) {
        timer.stop();

        Questao q = jogo.getQuestaoAtual();
        String resposta = q.getAlternativas()[index];

        boolean correta = jogo.responder(resposta);

        if (correta) {
            JOptionPane.showMessageDialog(this, "✔ Você acertou!");
        } else {
            JOptionPane.showMessageDialog(this, "✖ Você errou!");
        }

        carregarQuestao();
    }
}
