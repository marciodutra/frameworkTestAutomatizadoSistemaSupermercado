package br.com.supermercado.tests.api;

import br.com.supermercado.api.ServiceFactory;
import br.com.supermercado.api.models.Caixa;
import br.com.supermercado.tests.report.listener.ReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ReportExtension.class)
public class CaixaApiTest extends BaseApiTest {

    @Test
    public void deveAbrirCaixaComSucesso() {

        Caixa caixa = ServiceFactory
                .caixaService()
                .abrirCaixa(200, token);

        assertNotNull(caixa);

        assertTrue(caixa.getId() > 0);

        assertEquals("aberto", caixa.getStatus());

        assertEquals("200.00", caixa.getValor_abertura());

        assertNotNull(caixa.getData_abertura());
    }

    @Test
    public void deveConsultarCaixaAtualComSucesso() {

        Caixa caixaAberto = ServiceFactory
                .caixaService()
                .abrirCaixa(200, token);


        Caixa caixaAtual = ServiceFactory
                .caixaService()
                .consultarCaixaAtual(token);


        assertNotNull(caixaAtual);

        assertEquals(
                caixaAberto.getId(),
                caixaAtual.getId()
        );

        assertEquals(
                "aberto",
                caixaAtual.getStatus()
        );
    }
}