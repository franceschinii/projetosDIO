import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Olá bem vindo ao Banco Franceschini!");

        String clientName = JOptionPane.showInputDialog("Nome do novo cliente:");

        Cliente newClient = new Cliente();
        newClient.setNome(clientName);

        Conta cc = new ContaCorrente(newClient);
        Conta poupanca = new ContaPoupanca(newClient);

        int programExist = 0;

        do {
        String[] optionsConta = {"Conta Corrente", "Conta Poupança", "Sair"};
        int escolhaConta = JOptionPane.showOptionDialog(null, clientName + " por favor escolha uma conta:",
                "Tipos de Contas",  JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsConta, optionsConta[0]);

        if (escolhaConta == 0) {
            String[] optionscc = {"Saldo Atual", "Transferir", "Depositar", "Sair"};
            int escolhaccFuncoes = JOptionPane.showOptionDialog(null, clientName + " por favor escolha uma ação:",
                    "Funções Bancárias", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionscc, optionscc[0]);

            switch (escolhaccFuncoes) {
                case 0:
                    cc.imprimirccSaldo();
                    break;
                case 1:
                    double valorccTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Valor que você deseja transferir:"));
                    cc.transferir(valorccTransferencia, poupanca);
                    break;
                case 2:
                    double valorccDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor que você deseja depositar:"));
                    cc.depositar(valorccDeposito);
                    break;
                case 3:
                    programExist += 1;
                    break;
            }
        }
        else if (escolhaConta == 1) {
            String[] optionspp = {"Saldo Atual", "Transferir", "Depositar", "Sair"};
            int escolhappFuncoes = JOptionPane.showOptionDialog(null, clientName + " por favor escolha uma ação:",
                    "Funções Bancárias", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionspp, optionspp[0]);
            switch (escolhappFuncoes) {
                case 0:
                    poupanca.imprimirppSaldo();
                    break;
                case 1:
                    double valorppTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Valor que você deseja transferir:"));
                    poupanca.transferir(valorppTransferencia, cc);
                    break;
                case 2:
                    double valorppDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor que você deseja depositar:"));
                    poupanca.depositar(valorppDeposito);
                    break;
                case 3:
                    programExist += 1;
                    break;
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Saindo...");
            return;
         }
        }while (programExist == 0);
}
}