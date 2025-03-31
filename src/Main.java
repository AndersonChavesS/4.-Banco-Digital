import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Banco banco = new Banco();
        banco.setNome("Banco Digital");


        System.out.println("Bem-vindo ao " + banco.getNome());
        System.out.println("Escolha uma opção:");
        System.out.println("1. Criar Conta Corrente");
        System.out.println("2. Criar Conta Poupança");
        System.out.println("3. Sair");
        int opcao = teclado.nextInt();
        teclado.nextLine(); // Consumir a nova linha
        if (opcao == 1) {
            System.out.println("Digite o nome do Titular da conta:");
            String nomeTitular = teclado.nextLine();
            Cliente cliente = new Cliente();
            cliente.setNome(nomeTitular);
            Conta contaCorrente = new ContaCorrente(cliente);
            System.out.println("Criando Conta Corrente...");
            do {
                System.out.println("Para Depositar, digite 1 \nPara Sacar, digite 2\nPara Transferir, digite 3\nPara Imprimir Extrato, digite 4\nPara Sair, digite 5");
                int acao = teclado.nextInt();

                teclado.nextLine(); // Consumir a nova linha
                if (acao == 1) {
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito = teclado.nextDouble();
                    contaCorrente.depositar(valorDeposito);
                } else if (acao == 2) {
                    System.out.println("Digite o valor a ser sacado:");
                    double valorSaque = teclado.nextDouble();
                    contaCorrente.sacar(valorSaque);
                } else if (acao == 3) {
                    System.out.println("Digite o valor a ser transferido:");
                    double valorTransferencia = teclado.nextDouble();
                    Conta contaDestino = new ContaPoupanca(cliente);
                    contaCorrente.transferir(valorTransferencia, contaDestino);
                } else if (acao == 4) {
                    contaCorrente.imprimirExtrato();
                } else if (acao == 5) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (true);


        } else if (opcao == 2) {
            System.out.println("Digite o nome do Titular da conta:");
            String nomeTitular = teclado.nextLine();
            Cliente cliente = new Cliente();
            cliente.setNome(nomeTitular);
            Conta contaPoupanca = new ContaPoupanca(cliente);
            System.out.println("Criando Conta Poupança...");

            do {
                System.out.println("Para Depositar, digite 1 \nPara Sacar, digite 2\nPara Transferir, digite 3\nPara Imprimir Extrato, digite 4\nPara Sair, digite 5");
                int acao = teclado.nextInt();

                teclado.nextLine(); // Consumir a nova linha
                if (acao == 1) {
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito = teclado.nextDouble();
                    contaPoupanca.depositar(valorDeposito);
                } else if (acao == 2) {
                    System.out.println("Digite o valor a ser sacado:");
                    double valorSaque = teclado.nextDouble();
                    contaPoupanca.sacar(valorSaque);
                } else if (acao == 3) {
                    System.out.println("Digite o valor a ser transferido:");
                    double valorTransferencia = teclado.nextDouble();
                    int numeroContaDestino = teclado.nextInt();
                    Conta contaDestino = new ContaPoupanca(cliente);
                    contaPoupanca.transferir(valorTransferencia, contaDestino);
                } else if (acao == 4) {
                    contaPoupanca.imprimirExtrato();
                } else if (acao == 5) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (true);

        } else {
            System.out.println("Saindo...");
            return;
        }


    }
}