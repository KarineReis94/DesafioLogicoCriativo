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

    private String nome;
    private int pontuacao;
    private File arquivo = new File("ranking.txt");

    public TelaRanking(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;

        salvar();

        setTitle("Ranking dos Jogadores");
        setSize(450, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topo = new JPanel();
        topo.setBackground(new Color(180, 255, 180));
        JLabel titulo = new JLabel("Ranking dos Jogadores", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        topo.add(titulo);
        add(topo, BorderLayout.NORTH);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));

        StringBuilder texto = new StringBuilder();

        List<String> linhas = carregarRanking();
        for (String linha : linhas) {
            texto.append(linha).append("\n");
        }

        area.setText(texto.toString());
        add(new JScrollPane(area), BorderLayout.CENTER);

        JButton fechar = new JButton("Fechar");
        fechar.addActionListener(e -> System.exit(0));
        add(fechar, BorderLayout.SOUTH);
    }

    private void salvar() {
        try (FileWriter fw = new FileWriter(arquivo, true)) {
            fw.write(nome + ";" + pontuacao + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> carregarRanking() {
        List<String> lista = new ArrayList<>();

        try {
            if (!arquivo.exists()) return lista;

            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(";");

                if (partes.length == 2) {
                    lista.add(linha);
                }
            }

            br.close();

            lista.sort((a, b) -> {
                try {
                    int pa = Integer.parseInt(a.split(";")[1]);
                    int pb = Integer.parseInt(b.split(";")[1]);
                    return Integer.compare(pb, pa);
                } catch (Exception e) {
                    return 0;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
