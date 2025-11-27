/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico.gui;

import javax.swing.*;
import java.awt.*;

public class TelaInstrucoes extends JFrame {

    public TelaInstrucoes() {
        setTitle("Instruções - Desafio Lógico Criativo");
        setSize(520, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        JLabel titulo = new JLabel("Instruções do Jogo", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        String texto = ""
                + "Objetivo:\n"
                + "Responda às perguntas e acumule pontos. Cada resposta correta vale 10 pontos.\n\n"
                + "Regras:\n"
                + "- O jogo apresenta um total de 12 perguntas (matemática e cultura geral).\n"
                + "- A cada partida as perguntas vêm em ordem aleatória.\n"
                + "- Se errar 3 vezes, você perde.\n"
                + "- Ao final, sua pontuação é salva no ranking.\n\n"
                + "Como jogar:\n"
                + "1) Clique em Iniciar.\n"
                + "2) Digite seu nome (será salvo no ranking).\n"
                + "3) Responda as alternativas clicando nos botões.\n\n"
                + "- Boa sorte e divirta-se!";
        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(area), BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        JButton btnVoltar = new JButton("Voltar");
        JButton btnIniciar = new JButton("Instruções lidas - Iniciar");
        rodape.add(btnVoltar);
        rodape.add(btnIniciar);
        add(rodape, BorderLayout.SOUTH);

        btnVoltar.addActionListener(e -> dispose());
        btnIniciar.addActionListener(e -> {
            dispose();
            new TelaNome().setVisible(true);
        });
    }
}
