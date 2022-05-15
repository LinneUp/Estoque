package src;
import src.db.EstoquesDB;
import src.db.ProdutosDB;
import src.db.UsuariosDB;
import src.models.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ProdutosDB produtosDB = new ProdutosDB();
    static UsuariosDB usuariosDB = new UsuariosDB();
    static EstoquesDB estoquesDB = new EstoquesDB();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pedido de Vendas");
        int option;
        do {
            System.out.println("1 - Cadastrar Produto ");
            System.out.println("2 - Verificar Produtos cadastrados ");
            System.out.println("3 - Cadastrar Usuario ADMINISTRADOR ");
            System.out.println("4 - Cadastrar Usuario CLIENTE ");
            System.out.println("5 - Listar todos os usuarios ");
            System.out.println("6 - Cadastrar novo estoque de produtos ");
            System.out.println("7 - Listar Todos os estoques ");
            System.out.println("0 - Sair do Programa ");

            System.out.println("Selecione a opção desejada: ");
            option = scanner.nextInt();


            process(option);
        } while (option != 0);

    }

    public static void process(int option) throws Exception {
        switch (option) {
            case 1: {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Qual a descrição que você deseja dar ao produto?");
                String descricao = scanner.nextLine();

                System.out.print("Qual o ID que você deseja dar ao produto?");
                int Id = scanner.nextInt();

                System.out.print("Insira o preço produto?");
                double preco = scanner.nextDouble();

                System.out.print("Insira a data de Validade?");
                String dataString = scanner.next();

                Date dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

                Produto novoProduto = new Produto(Id, descricao, preco, dataValidade);


                produtosDB.addNovoProduto(novoProduto);

                break;

            }
            case 2: {
                List<Produto> listaDeProdutos = produtosDB.getProdutosList();
                for (Produto produto : listaDeProdutos) {

                    System.out.println("---ID: " + produto.getId());
                    System.out.println("---Descrição: " + produto.getDescricao());
                    System.out.println("---Preço: " + produto.getPreco());
                    System.out.println("---Data de Validade: " + produto.getDataValidade());
                    System.out.println("----------------------");
                }

                break;
            }
            case 3: {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Qual o nome do usuario ADMINISTRADOR? ");
                String nome = scanner.nextLine();
                Admin novoAdmin = new Admin(nome);
                usuariosDB.addNovoUsuario(novoAdmin);

                break;
            }
            case 4: {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Qual o nome do usuario CLIENTE ? ");
                String nome = scanner.nextLine();
                Cliente novoCliente = new Cliente(nome);
                usuariosDB.addNovoUsuario(novoCliente);

                break;
            }
            case 5: {
                System.out.println("--------------------------------------");
                System.out.println("Listando Usuarios Cadastrados");
                System.out.println("--------------------------------------");
                for (Usuario usuario : usuariosDB.getUsuariosList()) {
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Tipo: " + usuario.getTipoUsuario());
                    System.out.println("--------------------------------------");
                }
                break;
            }
            case 6: {
                Scanner scanner = new Scanner(System.in);
                System.out.println("--------------------------------------");
                System.out.println("Cadastrando Estoque de Produtos " );
                System.out.println("--------------------------------------");

                System.out.println("Qual o Identificador do estoque: ");
                String Id = scanner.next();

                System.out.println("Qual Produto que será adicionado ao Estoque (Informe o ID): ");
                int produtoId = scanner.nextInt();

                Produto produto = produtosDB.getProdutoPorID(produtoId);
                System.out.println("Produto ID: " + produto.getId());
                System.out.println("Produto Descrição: " + produto.getDescricao());
                System.out.println("Produto Validade: " + produto.getDataValidade());
                System.out.println("Qual a Quantidade de produtos a ser adicionada em estoque: " + produto.getId());
                int quantidade = scanner.nextInt();

                Estoque novoEstoque = new Estoque(produto, quantidade, Id);
                estoquesDB.addNovoEstoque(novoEstoque);

                break;
            }
            case 7: {
                System.out.println("------------------------------");
                System.out.println("Listando Estoques Cadastrados ");
                for (Estoque estoque : estoquesDB.getEstoques()) {
                    System.out.println("ID: " + estoque.getId());
                    System.out.println("Produto: " + estoque.getProduto().getDescricao());
                    System.out.println("Preço: " + estoque.getProduto().getPreco());
                    System.out.println("Quantidade: " + estoque.getQuantidade());
                    System.out.println("-------------------------------------");


                    break;
                }
            }

        }
    }
}
