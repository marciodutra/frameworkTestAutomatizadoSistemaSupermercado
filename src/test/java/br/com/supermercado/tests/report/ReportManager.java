package br.com.supermercado.tests.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.supermercado.tests.report.history.ReportHistoryManager;
import br.com.supermercado.tests.report.generator.HtmlReportGenerator;
import br.com.supermercado.tests.report.model.ResultadoTeste;
import br.com.supermercado.tests.report.browser.ReportBrowserManager;

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


        HtmlReportGenerator generator = new HtmlReportGenerator();

        String html = generator.gerar(resultados);


        try (Writer writer = new OutputStreamWriter(
                new FileOutputStream(arquivo),
                StandardCharsets.UTF_8)) {


            writer.write(html);


        } catch (IOException e) {

            throw new RuntimeException(
                    "Erro ao gerar relatório",
                    e
            );

        }


        ReportHistoryManager.salvar(arquivo);

        ReportBrowserManager.abrir(arquivo);
    }

}