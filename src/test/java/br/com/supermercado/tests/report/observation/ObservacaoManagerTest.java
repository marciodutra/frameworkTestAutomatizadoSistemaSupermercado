package br.com.supermercado.tests.report.observation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObservacaoManagerTest {

    @Test
    void deveSalvarERecuperarObservacao() {

        String nomeTeste = "deveRegistrarVendaComSucesso()";
        String observacao = "Teste gravado automaticamente";

        ObservacaoManager.salvar(nomeTeste, observacao);

        String resultado = ObservacaoManager.buscar(nomeTeste);

        assertEquals(observacao, resultado);
    }
}