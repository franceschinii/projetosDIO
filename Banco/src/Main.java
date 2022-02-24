public class Main {
    public static void main(String[] args) {
        Cliente andre = new Cliente();
        andre.setNome("André");

        Conta cc = new ContaCorrente(andre);
        Conta poupanca = new ContaPoupanca(andre);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
