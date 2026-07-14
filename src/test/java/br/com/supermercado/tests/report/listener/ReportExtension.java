package br.com.supermercado.tests.report.listener;

import br.com.supermercado.tests.report.ReportManager;
import br.com.supermercado.tests.report.ResultadoTeste;
import org.junit.jupiter.api.extension.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ReportExtension implements
        TestWatcher,
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback {


    private static final Map<String, Long> tempos = new HashMap<>();


    @Override
    public void beforeTestExecution(ExtensionContext context) {

        tempos.put(
                context.getUniqueId(),
                System.currentTimeMillis()
        );

        System.out.println(
                "Iniciando teste: "
                        + context.getDisplayName()
        );
    }



    @Override
    public void testSuccessful(ExtensionContext context) {

        ResultadoTeste resultado = criarResultado(context);

        resultado.setStatus("PASSOU");

        ReportManager.adicionarResultado(resultado);


        System.out.println(
                "Teste aprovado: "
                        + context.getDisplayName()
        );
    }



    @Override
    public void testFailed(
            ExtensionContext context,
            Throwable cause) {


        ResultadoTeste resultado = criarResultado(context);


        resultado.setStatus("FALHOU");

        resultado.setMensagemErro(
                cause.getMessage()
        );


        ReportManager.adicionarResultado(resultado);


        System.out.println(
                "Teste falhou: "
                        + context.getDisplayName()
        );
    }



    private ResultadoTeste criarResultado(
            ExtensionContext context) {


        ResultadoTeste resultado =
                new ResultadoTeste();


        resultado.setNomeTeste(
                context.getDisplayName()
        );


        resultado.setDataHora(
                LocalDateTime.now().toString()
        );


        Long inicio =
                tempos.get(
                        context.getUniqueId()
                );


        if (inicio != null) {

            long tempo =
                    System.currentTimeMillis()
                            - inicio;


            resultado.setTempoExecucao(
                    tempo
            );
        }


        return resultado;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {

        System.out.println(
                "Finalizando teste: " + context.getDisplayName()
        );
    }
}