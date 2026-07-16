package br.com.supermercado.tests.report.observation;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ObservacaoEditor {

    private static final Map<String, JTextArea> campos = new LinkedHashMap<>();

    public static void main(String[] args) {

        JFrame janela = new JFrame("Editor de Observações");

        janela.setSize(800, 500);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        adicionarCampo(
                painel,
                "deveAbrirCaixaComSucesso()"
        );

        adicionarCampo(
                painel,
                "deveConsultarCaixaAtualComSucesso()"
        );

        adicionarCampo(
                painel,
                "deveRealizarLoginComSucesso()"
        );

        adicionarCampo(
                painel,
                "deveAtualizarProduto()"
        );

        adicionarCampo(
                painel,
                "deveValidarPrimeiroProdutoDaLista()"
        );

        adicionarCampo(
                painel,
                "deveCadastrarProduto()"
        );

        adicionarCampo(
                painel,
                "deveListarProdutos()"
        );

        adicionarCampo(
                painel,
                "deveRegistrarVendaComSucesso()"
        );

        JScrollPane scroll = new JScrollPane(painel);

        JButton salvar = new JButton("Salvar");

        salvar.addActionListener(e -> {

            campos.forEach((teste, area) ->

                    ObservacaoManager.salvar(
                            teste,
                            area.getText()
                    )

            );

            JOptionPane.showMessageDialog(
                    janela,
                    "Observações salvas com sucesso!"
            );

        });

        janela.add(scroll, BorderLayout.CENTER);
        janela.add(salvar, BorderLayout.SOUTH);

        janela.setVisible(true);
    }

    private static void adicionarCampo(
            JPanel painel,
            String nomeTeste) {

        JLabel titulo = new JLabel(nomeTeste);

        JTextArea texto = new JTextArea(
                ObservacaoManager.buscar(nomeTeste)
        );

        campos.put(
                nomeTeste,
                texto
        );

        texto.setRows(3);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        painel.add(titulo);
        painel.add(new JScrollPane(texto));
        painel.add(Box.createVerticalStrut(15));
    }
}