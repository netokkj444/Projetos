import Objects.BankOperations;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.*;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        String name = "";
        int data = 0;
        String dep;
        //Olá
        //tenho que usar + vetores
        float deposito = 0;
        String confirmSaque;
        float saque = 0;
        int invest = 0;
        double valordoInvest = 0;
        double tempo = 0;


        JOptionPane.showMessageDialog(null, "Bem vindo ao Banco de Deus!");
        String confirm = JOptionPane.showInputDialog(null, "Deseja realizar o cadastro? S/N");
        //falta algumas coisas para aprimorar!
        if (confirm.equals("S")) {
            JOptionPane.showMessageDialog(null, "Vamos iniciar o seu cadastro!");
            name = JOptionPane.showInputDialog(null, "Digite seu nome: ");
            data = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano que você nasceu: "));
            dep = JOptionPane.showInputDialog(null, "Deseja fazer um depósito inicial? S/N");

            if (dep.equals("S")) {
                deposito = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o valor do depósito: "));
            }
            confirmSaque = JOptionPane.showInputDialog(null, "Deseja realizar algum saque? S/N");
            if (confirmSaque.equals("S")) {

                saque = Float.parseFloat(JOptionPane.showInputDialog(null, "Saldo: " + deposito + "\nDigite o valor do seu " +
                        "saque: "));
                if (saque > deposito) {
                    JOptionPane.showMessageDialog(null, "Saque inválido!");
                }
            }
            String confirmInvest = JOptionPane.showInputDialog(null, "Deseja entrar na área de investimentos? S/N");
            if (confirmInvest.equals("S")) {
                invest = Integer.parseInt(JOptionPane.showInputDialog(null, "Temos os seguintes investimentos" +
                        "\n1°.Poupança" +
                        "\n2°.Tesouro direto" +
                        "\n3°. Taxa selic"));
                switch (invest) {
                    case 1:
                        valordoInvest = Double.parseDouble(JOptionPane.showInputDialog(null, "Você se" +
                                "ciou POUPANÇA" +
                                "\nDigite o valor que você deseja investir: "));
                        tempo = Integer.parseInt(JOptionPane.showInputDialog(null, "Pretende deixar por quantos " +
                                "meses? "));
                        BankOperations showinvest = new BankOperations(valordoInvest);
                        JOptionPane.showMessageDialog(null,"O resultado do seu investimento foi: "  +
                                "\n"+showinvest.getInvestPoupanca());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "OBS: O RESULTADO DO INVESTIMENTO SÓ PODERA SER RETIRADO EM 2027!");
                        valordoInvest = Double.parseDouble(JOptionPane.showInputDialog(null, "Você selecionou" +
                                "TESOURO DIRETO quanto deseja investir? "));
                        JOptionPane.showMessageDialog(null,"O resultado do seu investimento foi: ");
                        break;
                    case 3:
                        valordoInvest = Double.parseDouble(JOptionPane.showInputDialog(null,"Você selecionou TAXA SELIC" +
                                "quanto deseja investir? "));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"[ERROR] OPÇÃO NÃO EXISTE");

                }
            }
            BankOperations things = new BankOperations(name, data, deposito, saque, valordoInvest, tempo);
            JOptionPane.showMessageDialog(null, things);
        } else {
            JOptionPane.showMessageDialog(null, "Que pena que não quiz se juntar a nós volte sempre!");
        }

        sc.close();
    }
}
