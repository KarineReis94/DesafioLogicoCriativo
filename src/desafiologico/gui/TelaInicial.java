/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico.gui;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

    private JButton btnIniciar;
    private JButton btnInstrucoes;
    private JButton btnSair;

    public TelaInicial() {

        setTitle("Desafio Lógico Criativo");
        setSize(420, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 200, 230)); // rosa claro 💗

        JLabel titulo = new JLabel("Desafio Lógico Criativo", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(40, 30, 340, 40);
        panel.add(titulo);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(140, 100, 140, 40);
        estilizarBotao(btnIniciar);
        panel.add(btnIniciar);

        btnInstrucoes = new JButton("Instruções");
        btnInstrucoes.setBounds(140, 150, 140, 40);
        estilizarBotao(btnInstrucoes);
        panel.add(btnInstrucoes);

        btnSair = new JButton("Sair");
        btnSair.setBounds(140, 200, 140, 40);
        estilizarBotao(btnSair);
        panel.add(btnSair);

        add(panel);

        btnIniciar.addActionListener(e -> {
            new TelaNome().setVisible(true);
            dispose();
        });

        btnInstrucoes.addActionListener(e -> new TelaInstrucoes().setVisible(true));

        btnSair.addActionListener(e -> System.exit(0));
    }

    private void estilizarBotao(JButton btn) {
        btn.setBackground(new Color(255, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
