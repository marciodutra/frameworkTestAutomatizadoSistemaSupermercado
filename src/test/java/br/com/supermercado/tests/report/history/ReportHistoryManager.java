package br.com.supermercado.tests.report.history;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReportHistoryManager {


    private static final String CAMINHO_HISTORICO =
            "src/test/report/historico/";


    public static void salvar(File arquivo) {


        try {


            File pastaHistorico = new File(
                    CAMINHO_HISTORICO
            );


            pastaHistorico.mkdirs();



            String nomeArquivo =
                    "report_"
                            + LocalDateTime.now()
                            .format(
                                    DateTimeFormatter.ofPattern(
                                            "dd-MM-yyyy_HH-mm-ss"
                                    )
                            )
                            + ".html";



            File destino = new File(
                    pastaHistorico,
                    nomeArquivo
            );



            java.nio.file.Files.copy(
                    arquivo.toPath(),
                    destino.toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );


        } catch (IOException e) {


            throw new RuntimeException(
                    "Erro ao salvar histórico do relatório",
                    e
            );

        }

    }

}