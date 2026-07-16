package br.com.supermercado.tests.report.observation;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ObservacaoManager {

    private static final Properties properties = new Properties();

    static {
        carregarObservacoes();
    }

    private static void carregarObservacoes() {

        try (InputStream input =
                     ObservacaoManager.class
                             .getClassLoader()
                             .getResourceAsStream("observacoes.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "Arquivo observacoes.properties não encontrado"
                );
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao carregar observações",
                    e
            );
        }
    }


    public static String buscar(String nomeTeste) {

        String observacao = properties.getProperty(nomeTeste);

        if (observacao == null || observacao.isBlank()) {
            return "-";
        }

        return observacao;
    }

    public static void salvar(String nomeTeste, String observacao) {

        properties.setProperty(
                nomeTeste,
                observacao
        );

        Path caminho =
                Paths.get(
                        "src/test/resources/observacoes.properties"
                );


        try (OutputStream output =
                     Files.newOutputStream(caminho)) {


            properties.store(
                    output,
                    "Arquivo de observações dos testes"
            );


        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao salvar observações",
                    e
            );
        }
    }
}