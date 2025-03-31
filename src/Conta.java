public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected Cliente cliente;
    protected Banco banco;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.saldo = 0.0;
    }

    // Implementações dos métodos de IConta
    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
        } else {
            saldo += valor;
            System.out.println("Aguarde enquanto processamos seu depósito...");
            System.out.println("Depósito de " + valor + " realizado com sucesso.");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Aguarde enquanto processamos sua transferência...");
            System.out.println("Transferência de " + valor + " realizada com sucesso.");
        }
    }

    @Override
    public void imprimirExtrato() {
        imprimirInformacoesExtrato();
    }

    protected void imprimirInformacoesExtrato() {
        System.out.println(String.format("Agência: %s", this.agencia));
        System.out.println(String.format("Número da Conta: %s", this.numeroConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    // Setters para banco e cliente
    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}