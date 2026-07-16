package br.com.supermercado.tests.report.html;

import br.com.supermercado.tests.report.model.ResultadoTeste;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HtmlTemplate {

    public String gerar(List<ResultadoTeste> resultados) {

        int total = resultados.size();

        long passou = resultados.stream()
                .filter(r -> "PASSOU".equals(r.getStatus()))
                .count();

        long falhou = resultados.stream()
                .filter(r -> "FALHOU".equals(r.getStatus()))
                .count();

        double percentual = total == 0
                ? 0
                : (passou * 100.0) / total;

        StringBuilder html = new StringBuilder();

        html.append("""
                <!DOCTYPE html>
                <html>
                <head>

                <meta charset="UTF-8">

                <title>
                Supermercado Test Framework Report
                </title>
                """);

        html.append("""
        <style>
        """);

        html.append(CssTemplate.gerar());

        html.append("""
        </style>
        """);

        html.append("""
                </head>

                <body>

                <div class="container">

                <div class="header">

                <h1>
                🚀 Supermercado Test Framework
                </h1>

                <p>
                API Automation Report
                </p>

                <p>
                Executado em:
                """);

        html.append(
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "dd/MM/yyyy HH:mm:ss"
                                )
                        )
        );

        html.append("""
                </p>

                </div>

                <div class="cards">

                <div class="card">

                <div class="number total">
                """)
                .append(total)
                .append("""
                </div>

                <p>Total de testes</p>

                </div>

                <div class="card">

                <div class="number success">
                """)
                .append(passou)
                .append("""
                </div>

                <p>Passaram</p>

                </div>

                <div class="card">

                <div class="number failure">
                """)
                .append(falhou)
                .append("""
                </div>

                <p>Falharam</p>

                </div>

                <div class="card">

                <div class="number rate">
                """)
                .append(String.format("%.1f%%", percentual))
                .append("""
                </div>

                <p>Sucesso</p>

                </div>

                </div>

                <h2>
                Detalhes da execução
                </h2>

                <table>

                <tr>

                <th>Teste</th>

                <th>Status</th>

                <th>Duração</th>

                <th>Resultado</th>                

                </tr>
                """);

        for (ResultadoTeste resultado : resultados) {

            String status = resultado.getStatus();

            String mensagem;

            if ("PASSOU".equals(status)) {

                mensagem = mensagemSucesso(
                        resultado.getNomeTeste()
                );

            } else {

                mensagem = resultado.getMensagemErro();

                if (mensagem != null &&
                        mensagem.contains(" ==> ")) {

                    mensagem =
                            mensagem.substring(
                                    0,
                                    mensagem.indexOf(" ==> ")
                            );
                }
            }

            html.append("<tr>");

            html.append("<td>")
                    .append(resultado.getNomeTeste())
                    .append("</td>");

            html.append("<td class='")
                    .append(status)
                    .append("'>")
                    .append(status)
                    .append("</td>");

            html.append("<td>")
                    .append(formatarTempo(
                            resultado.getTempoExecucao()
                    ))
                    .append("</td>");

            html.append("<td>")
                    .append(mensagem)
                    .append("</td>");

            html.append("</tr>");

        }

        html.append("""
                </table>

                </div>

                </body>

                </html>
                """);

        return html.toString();

    }

        private String formatarTempo(long millis) {

            long segundos = millis / 1000;

            long minutos = segundos / 60;

            segundos = segundos % 60;

            if (minutos > 0) {

                return minutos +
                        "min " +
                        segundos +
                        "s";

            }

            if (segundos > 0) {

                return segundos + "s";

            }

            return millis + " ms";

        }

        private String mensagemSucesso(String nomeTeste) {

            switch (nomeTeste) {

                case "deveAbrirCaixaComSucesso()":
                    return "Caixa aberta com sucesso.";

                case "deveConsultarCaixaAtualComSucesso()":
                    return "Caixa consultado com sucesso.";

                case "deveRealizarLoginComSucesso()":
                    return "Login realizado com sucesso.";

                case "deveCadastrarProduto()":
                    return "Produto cadastrado com sucesso.";

                case "deveAtualizarProduto()":
                    return "Produto atualizado com sucesso.";

                case "deveListarProdutos()":
                    return "Produtos listados com sucesso.";

                case "deveValidarPrimeiroProdutoDaLista()":
                    return "Primeiro produto validado com sucesso.";

                case "deveRegistrarVendaComSucesso()":
                    return "Venda registrada com sucesso.";

                default:
                    return "Teste executado com sucesso.";
            }

        }

    }