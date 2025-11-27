/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiologico.gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TelaRanking extends JFrame {
    public TelaRanking(int pontos) {
        setTitle("Ranking - Desafio Lógico Criativo");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Pontuação Final: " + pontos, SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        JTextArea rankingArea = new JTextArea();
        rankingArea.setEditable(false);
        add(new JScrollPane(rankingArea), BorderLayout.CENTER);

        salvarPontuacao(pontos);
        rankingArea.setText(carregarPontuacoes());
    }

    private void salvarPontuacao(int pontos) {
        try (FileWriter fw = new FileWriter("ranking.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Jogador: " + pontos + " pontos\n");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private String carregarPontuacoes() {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ranking.txt"))) {
            String linha;
            while((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch(IOException e) {
            return "Nenhuma pontuação ainda.";
        }
        StringBuilder sb = new StringBuilder();
        for(String l : linhas) sb.append(l).append("\n");
        return sb.toString();
    }
}
