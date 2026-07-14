package br.com.supermercado.tests.report;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportManager {

    private static final List<ResultadoTeste> resultados = new ArrayList<>();

    private static final String CAMINHO_REPORT =
            "src/test/report/index.html";


    public static void adicionarResultado(ResultadoTeste resultado) {
        resultados.add(resultado);
    }


    public static List<ResultadoTeste> getResultados() {
        return Collections.unmodifiableList(resultados);
    }


    public static void limpar() {
        resultados.clear();
    }


    public static void gerarHTML() {

        File arquivo = new File(CAMINHO_REPORT);

        arquivo.getParentFile().mkdirs();


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



        try (Writer writer = new OutputStreamWriter(
                new FileOutputStream(arquivo),
                StandardCharsets.UTF_8)) {


            writer.write("""
                    <!DOCTYPE html>
                    <html>
                    <head>

                    <meta charset="UTF-8">

                    <title>
                    Supermercado Test Framework Report
                    </title>


                    <style>

                    body {

                        margin:0;
                        padding:30px;

                        font-family:
                        'Segoe UI',
                        Arial,
                        sans-serif;

                        background:#0f172a;

                        color:#e2e8f0;

                    }


                    .container {

                        max-width:1200px;

                        margin:auto;

                    }



                    .header {

                        background:#1e293b;

                        padding:30px;

                        border-radius:15px;

                        box-shadow:
                        0 10px 30px rgba(0,0,0,0.3);

                        margin-bottom:25px;

                    }



                    h1 {

                        margin:0;

                        color:#38bdf8;

                    }


                    .subtitle {

                        margin-top:10px;

                        color:#94a3b8;

                    }



                    .cards {

                        display:flex;

                        gap:20px;

                        flex-wrap:wrap;

                        margin-bottom:30px;

                    }



                    .card {

                        flex:1;

                        min-width:200px;

                        background:#1e293b;

                        padding:25px;

                        border-radius:15px;

                        text-align:center;

                        box-shadow:
                        0 8px 20px rgba(0,0,0,0.25);

                    }



                    .number {

                        font-size:40px;

                        font-weight:bold;

                    }



                    .label {

                        color:#94a3b8;

                        margin-top:10px;

                    }



                    .total {
                        color:#38bdf8;
                    }


                    .success {
                        color:#22c55e;
                    }


                    .failure {
                        color:#ef4444;
                    }


                    .rate {
                        color:#facc15;
                    }


                    .table-container {

                        background:#1e293b;

                        padding:20px;

                        border-radius:15px;

                    }



                    table {

                        width:100%;

                        border-collapse:collapse;

                    }



                    th {

                        background:#334155;

                        padding:15px;

                        text-align:left;

                    }



                    td {

                        padding:15px;

                        border-bottom:
                        1px solid #334155;

                    }



                    tr:hover {

                        background:#273449;

                    }



                    .PASSOU {

                        color:#22c55e;

                        font-weight:bold;

                    }



                    .FALHOU {

                        color:#ef4444;

                        font-weight:bold;

                    }



                    .footer {

                        margin-top:25px;

                        text-align:center;

                        color:#64748b;

                    }


                    </style>

                    </head>


                    <body>


                    <div class="container">


                    <div class="header">

                    <h1>
                    🚀 Supermercado Test Framework
                    </h1>


                    <div class="subtitle">

                    API Automation Report

                    <br><br>

                    Executado em:
                    """);


            writer.write(
                    LocalDateTime.now()
                            .format(
                                    DateTimeFormatter.ofPattern(
                                            "dd/MM/yyyy HH:mm:ss"
                                    )
                            )
            );


            writer.write("""
                    </div>

                    </div>



                    <div class="cards">


                    <div class="card">

                    <div class="number total">
                    """);

            writer.write(String.valueOf(total));


            writer.write("""
                    </div>

                    <div class="label">
                    Total de testes
                    </div>

                    </div>





                    <div class="card">

                    <div class="number success">
                    """);

            writer.write(String.valueOf(passou));


            writer.write("""
                    </div>

                    <div class="label">
                    Passaram
                    </div>

                    </div>





                    <div class="card">

                    <div class="number failure">
                    """);

            writer.write(String.valueOf(falhou));


            writer.write("""
                    </div>

                    <div class="label">
                    Falharam
                    </div>

                    </div>





                    <div class="card">

                    <div class="number rate">
                    """);


            writer.write(
                    String.format("%.1f%%", percentual)
            );


            writer.write("""
                    </div>

                    <div class="label">
                    Sucesso
                    </div>

                    </div>


                    </div>





                    <div class="table-container">


                    <h2>
                    Detalhes da execução
                    </h2>


                    <table>


                    <tr>

                    <th>
                    Teste
                    </th>

                    <th>
                    Status
                    </th>

                    <th>
                    Duração
                    </th>

                    <th>
                    Erro
                    </th>

                    </tr>

                    """);



            for (ResultadoTeste resultado : resultados) {


                String status = resultado.getStatus();


                writer.write(

                        "<tr>" +

                                "<td>" +
                                resultado.getNomeTeste() +
                                "</td>" +

                                "<td class='" +
                                status +
                                "'>" +

                                ("PASSOU".equals(status)
                                        ? "✓ "
                                        : "✕ ") +

                                status +

                                "</td>" +


                                "<td>" +
                                formatarTempo(
                                        resultado.getTempoExecucao()
                                ) +
                                "</td>" +


                                "<td>" +

                                (resultado.getMensagemErro() == null
                                        ? "-"
                                        : resultado.getMensagemErro())

                                +

                                "</td>" +

                                "</tr>"

                );
            }



            writer.write("""
                    </table>


                    </div>


                    <div class="footer">

                    Supermercado Test Framework
                    - API Automation

                    </div>


                    </div>


                    </body>

                    </html>
                    """);



        } catch (IOException e) {

            throw new RuntimeException(
                    "Erro ao gerar relatório",
                    e
            );
        }



        abrirNoNavegador(arquivo);
    }





    private static void abrirNoNavegador(File arquivo) {

        try {

            if (Desktop.isDesktopSupported()) {

                Desktop.getDesktop()
                        .browse(
                                arquivo.toURI()
                        );

            }


        } catch (Exception e) {

            System.out.println(
                    "Não foi possível abrir relatório automaticamente"
            );

        }

    }





    private static String formatarTempo(long millis) {


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

}