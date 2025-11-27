/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaInicial extends JFrame {
    public TelaInicial() {
        setTitle("Desafio Lógico Criativo");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Desafio Lógico Criativo", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        JTextArea instrucoes = new JTextArea(
            "Instruções:\n- Cada jogador deve acertar pelo menos 6 perguntas.\n- Se errar 3, perde.\n- Pontuação: 10 pontos por acerto.\n- Boa sorte!");
        instrucoes.setEditable(false);
        add(instrucoes, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        JButton iniciar = new JButton("Iniciar");
        JButton sair = new JButton("Sair");

        iniciar.addActionListener(e -> {
            TelaJogo jogo = new TelaJogo();
            jogo.setVisible(true);
            this.dispose();
        });

        sair.addActionListener(e -> System.exit(0));

        botoes.add(iniciar);
        botoes.add(sair);

        add(botoes, BorderLayout.SOUTH);
    }
}
