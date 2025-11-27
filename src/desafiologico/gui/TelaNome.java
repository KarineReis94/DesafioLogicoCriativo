/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico.gui;

import desafiologico.Jogo;   
import javax.swing.*;
import java.awt.*;

public class TelaNome extends JFrame {

    private JTextField campoNome;

    public TelaNome() {
        setTitle("Nome do Jogador");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lbl = new JLabel("Digite seu nome:", SwingConstants.CENTER);
        lbl.setBounds(50, 20, 250, 25);
        add(lbl);

        campoNome = new JTextField();
        campoNome.setBounds(50, 55, 250, 25);
        add(campoNome);

        JButton confirmar = new JButton("Confirmar");
        confirmar.setBounds(100, 100, 150, 30);
        add(confirmar);

        confirmar.addActionListener(e -> confirmar());
    }

    private void confirmar() {
        String nome = campoNome.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Digite um nome para continuar!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Jogo jogo = new Jogo(nome);

        new TelaJogo(jogo).setVisible(true);
        dispose();
    }
}

