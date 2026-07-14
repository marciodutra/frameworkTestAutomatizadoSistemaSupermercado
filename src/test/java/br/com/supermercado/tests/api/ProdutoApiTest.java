package br.com.supermercado.tests.api;

import br.com.supermercado.api.ServiceFactory;
import br.com.supermercado.api.models.Produto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import br.com.supermercado.tests.report.listener.ReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ReportExtension.class)
public class ProdutoApiTest extends BaseApiTest {

    @Epic("Supermercado API")
    @Feature("Produtos")
    @Story("Listar produtos cadastrados")
    @Test
    void deveListarProdutos() {

        List<Produto> produtos = ServiceFactory
                .produtoService()
                .listarProdutos(token);

        assertNotNull(produtos, "A lista de produtos não deve ser nula");
        assertFalse(produtos.isEmpty(), "A lista de produtos não deve estar vazia");

        Produto primeiroProduto = produtos.get(0);

        assertNotNull(primeiroProduto.getNome(), "O nome do produto não deve ser nulo");
        assertFalse(primeiroProduto.getNome().isBlank(), "O nome do produto não pode estar vazio");

        System.out.println("Primeiro produto: " + primeiroProduto.getNome());

        System.out.println("Quantidade de produtos: " + produtos.size());
    }

    @Epic("Supermercado API")
    @Feature("Produtos")
    @Story("Validar dados retornados dos produtos")
    @Test
    void deveValidarPrimeiroProdutoDaLista() {

        List<Produto> produtos = ServiceFactory
                .produtoService()
                .listarProdutos(token);

        Produto primeiroProduto = produtos.get(0);

        assertTrue(primeiroProduto.getId() > 0,
                "O ID do produto deve ser maior que zero");
    }

    @Epic("Supermercado API")
    @Feature("Produtos")
    @Story("Atualizar produto existente")
    @Test
    void deveAtualizarProduto() {

        Produto produto = new Produto();

        produto.setNome("Arroz Teste");
        produto.setCodigo_barras("123456");
        produto.setCategoria("Alimentos");
        produto.setPreco("10.00");
        produto.setEstoque(47);


        Produto produtoAtualizado = ServiceFactory
                .produtoService()
                .atualizarProduto(
                        2,
                        produto,
                        token
                );


        assertNotNull(produtoAtualizado);

        assertEquals(
                "Arroz Teste",
                produtoAtualizado.getNome()
        );


        System.out.println(
                "Produto atualizado: "
                        + produtoAtualizado.getNome()
        );
    }

    @Epic("Supermercado API")
    @Feature("Produtos")
    @Story("Cadastrar produto com dados válidos")
    @Test
    void deveCadastrarProduto() {

        Produto produto = new Produto();

        produto.setNome("Feijão Teste");
        produto.setCodigo_barras("789456");
        produto.setCategoria("Alimentos");
        produto.setPreco("8.50");
        produto.setEstoque(20);


        Produto produtoCadastrado = ServiceFactory
                .produtoService()
                .cadastrarProduto(
                        produto,
                        token
                );


        assertNotNull(produtoCadastrado);

        assertNotNull(
                produtoCadastrado.getId()
        );

        assertEquals(
                "Feijão Teste",
                produtoCadastrado.getNome()
        );


        System.out.println(
                "Produto cadastrado: "
                        + produtoCadastrado.getNome()
        );
    }
}