package br.com.supermercado.tests.report.generator;

import br.com.supermercado.tests.report.html.HtmlTemplate;
import br.com.supermercado.tests.report.model.ResultadoTeste;

import java.util.List;

public class HtmlReportGenerator {

    public String gerar(List<ResultadoTeste> resultados) {

        HtmlTemplate template = new HtmlTemplate();

        return template.gerar(resultados);

    }

}