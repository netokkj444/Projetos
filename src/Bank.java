import Objects.BankOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.*;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat date02 = new SimpleDateFormat("yyyy");
        Date dataHoraAtual = new Date();
        String currentyear = date02.format(dataHoraAtual);
        int lowdate = Integer.parseInt(String.valueOf(currentyear));
        Locale.setDefault(Locale.US);
        int k;
        String name = "";
        int date = 0;
        String dep;
        float deposit = 0;
        String confirmSaque;
        float withdraw = 0;
        int invest = 0;
        double valueofInvest = 0;
        int time = 0;
        String tp = "";

        JOptionPane.showMessageDialog(null, "Bem vindo ao Banco de Deus!");
        String confirm = JOptionPane.showInputDialog(null, "Deseja realizar o cadastro? S/N");
        //falta algumas coisas para aprimorar!)
        if (confirm.equals("S")) {
            JOptionPane.showMessageDialog(null, "Vamos iniciar o seu cadastro!");
            name = JOptionPane.showInputDialog(null, "Digite seu nome: ");
            do {
                //Verificação de idade caso se for um "intruso"
                date = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano que você nasceu: "));
                k = lowdate - date;
                if (date >= lowdate) {
                    JOptionPane.showMessageDialog(null, "<html>Cadastro não concluíudo!" +
                            "<br>Motivo:DATA INVÁLIDA " +
                            "</html>");
                } else if (date < 1910) {
                    JOptionPane.showMessageDialog(null, "<html>Cadastro não concluíudo!" +
                            "<br>Motivo:DATA INVÁLIDA " +
                            "</html>");

                } else if (k < 16) {
                    JOptionPane.showMessageDialog(null, "<html>Cadastro não concluíudo!" +
                            "<br>Motivo:IDADE NÃO SUFICIENTE " +
                            "</html>");
                }
            } while (date >= lowdate || k < 16 || date < 1910);
            dep = JOptionPane.showInputDialog(null, "Deseja fazer um depósito inicial? S/N");

            if (dep.equals("S")) {
                deposit = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o valor do depósito: "));
            }

            confirmSaque = JOptionPane.showInputDialog(null, "Deseja realizar algum saque? S/N");
            if (confirmSaque.equals("S")) {

                withdraw = Float.parseFloat(JOptionPane.showInputDialog(null, "Saldo: " + deposit + "\nDigite o valor do seu " +
                        "saque: "));
                if (withdraw > deposit) {
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
                        valueofInvest = Double.parseDouble(JOptionPane.showInputDialog(null, "Você se" +
                                "lecinou POUPANÇA" +
                                "\nDigite o valor que você deseja investir: "));
                        time = Integer.parseInt(JOptionPane.showInputDialog(null, "Pretende deixar por quantos " +
                                "meses? "));
                        BankOperation showinvest = new BankOperation(valueofInvest, time);
                        //Valor da poupança Ok!
                        JOptionPane.showMessageDialog(null, "O resultado do investimento foi: " + showinvest.getInvest());

                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "OBS: O RESULTADO DO INVESTIMENTO SÓ PODERA SER RETIRADO EM 2027!");
                        valueofInvest = Double.parseDouble(JOptionPane.showInputDialog(null, "Você selecionou" +
                                "TESOURO DIRETO quanto deseja investir? "));
                        JOptionPane.showMessageDialog(null, "O resultado do seu investimento foi: ");
                        break;
                    case 3:
                        valueofInvest = Double.parseDouble(JOptionPane.showInputDialog(null, "Você selecionou TAXA SELIC" +
                                "quanto deseja investir? "));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "[ERROR] OPÇÃO NÃO EXISTE");

                }

            }
            BankOperation things = new BankOperation(name, date, deposit, withdraw, valueofInvest, time);
            String extratc = String.valueOf(JOptionPane.showConfirmDialog(null, "Você quer emitir seu extrato? "));
            if (extratc != null) {
                JOptionPane.showMessageDialog(null, things.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Seu cadastro foi finalizado! Ficamos agradecidos pela sua preferência!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Que pena que não quiz se juntar a nós volte sempre!");
        }

        sc.close();
    }
}
