import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Registrar venda");
            System.out.println("5 - Valor total do estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProduto();
                    break;
                case 4:
                    registrarVenda();
                    break;
                case 5:
                    mostrarValorTotal();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        entrada.close();
    }

    public static void cadastrarProduto() {
        System.out.println("\n--- Cadastro de produto ---");

        System.out.print("Código: ");
        int codigo = lerInteiro();

        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Já existe um produto com esse código.");
            return;
        }

        System.out.print("Nome: ");
        String nome = entrada.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("O nome não pode ficar vazio.");
            return;
        }

        System.out.print("Preço: ");
        double preco = lerDouble();

        if (preco <= 0) {
            System.out.println("O preço deve ser maior que zero.");
            return;
        }

        System.out.print("Quantidade em estoque: ");
        int quantidade = lerInteiro();

        if (quantidade < 0) {
            System.out.println("A quantidade não pode ser negativa.");
            return;
        }

        Produto produto = new Produto(codigo, nome, preco, quantidade);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void listarProdutos() {
        System.out.println("\n--- Produtos cadastrados ---");

        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
            return;
        }

        for (Produto produto : produtos) {
            produto.mostrarDados();
        }
    }

    public static void buscarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigo = lerInteiro();

        Produto produto = buscarPorCodigo(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            produto.mostrarDados();
        }
    }

    public static void registrarVenda() {
        System.out.print("Digite o código do produto: ");
        int codigo = lerInteiro();

        Produto produto = buscarPorCodigo(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Quantidade vendida: ");
        int quantidadeVendida = lerInteiro();

        if (quantidadeVendida <= 0) {
            System.out.println("A quantidade vendida deve ser maior que zero.");
            return;
        }

        if (quantidadeVendida > produto.getQuantidade()) {
            System.out.println("Venda recusada. Estoque insuficiente.");
            return;
        }

        produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
        System.out.println("Venda registrada com sucesso!");
        System.out.println("Quantidade restante: " + produto.getQuantidade());
    }

    public static void mostrarValorTotal() {
        double total = 0;

        for (Produto produto : produtos) {
            total += produto.calcularValorEstoque();
        }

        System.out.printf("Valor total do estoque: R$ %.2f%n", total);
    }

    public static Produto buscarPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public static int lerInteiro() {
        while (!entrada.hasNextInt()) {
            System.out.print("Digite um número inteiro válido: ");
            entrada.nextLine();
        }
        int valor = entrada.nextInt();
        entrada.nextLine();
        return valor;
    }

    public static double lerDouble() {
        while (!entrada.hasNextDouble()) {
            System.out.print("Digite um preço válido: ");
            entrada.nextLine();
        }
        double valor = entrada.nextDouble();
        entrada.nextLine();
        return valor;
    }
}
