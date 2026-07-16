package br.com.supermercado.tests.report.html;


public class CssTemplate {


    public static String gerar() {

        return """
                
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

                    margin-bottom:25px;

                }


                h1 {

                    color:#38bdf8;

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

                }


                .number {

                    font-size:40px;

                    font-weight:bold;

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


                table {

                    width:100%;

                    border-collapse:collapse;

                    background:#1e293b;

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


                .PASSOU {

                    color:#22c55e;

                    font-weight:bold;

                }


                .FALHOU {

                    color:#ef4444;

                    font-weight:bold;

                }

                """;

    }

}