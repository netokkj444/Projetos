package Bank.Objects;

import Bank.Objects.Objects.BankOperation;
import Bank.Objects.Objects.InformationsbyBank;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random numberAccout = new Random();
        SimpleDateFormat date02 = new SimpleDateFormat("yyyy");
        Date dataHoraAtual = new Date();
        List<BankOperation> list = new ArrayList<>();
        String currentyear = date02.format(dataHoraAtual);
        int lowdate = Integer.parseInt(String.valueOf(currentyear));
        int age;
        String name = "";
        int date = 0;
        String dep;
        float deposit = 0;
        String confirmWithdraw;
        float withdraw = 0;
        int invest = 0;
        double valueofInvest = 0;
        int timeofInvest = 0;
        String tp = "";
        double valueofInvestTrea = 0;
        int numberofAccount = numberAccout.nextInt(1000,5000);

        JOptionPane.showMessageDialog(null, "Welcome to Bank of Holy Mary!");
        String confirm = JOptionPane.showInputDialog(null, "Do you want to register? Y/N");
        if (confirm.equals("Y")) {
            String bussines = JOptionPane.showInputDialog(null, "Do you want open Bussines Account?");
            if (bussines.equals("Y")) {
                JOptionPane.showMessageDialog(null, "Let's start your registration!");

            }
            JOptionPane.showMessageDialog(null, "Let's start your registration!");
            do {
                name = JOptionPane.showInputDialog(null, "What's your name? ");
            } while (name.length() > 5);

            do {
                //Verificação de idade caso se for uma idade não adequada
                date = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the year you were born: "));
                age = lowdate - date;
                if (date >= lowdate) {
                    JOptionPane.showMessageDialog(null, "<html>Register not completed!" +
                            "<br>Reason: INVALID DATE " +
                            "</html>");
                } else if (date < 1910) {
                    JOptionPane.showMessageDialog(null, "<html>Register not completed!" +
                            "<br>Reason: INVALID DATE " +
                            "</html>");

                } else if (age < 16) {
                    JOptionPane.showMessageDialog(null, "<html>Register not completed!" +
                            "<br>Reason: NOT ENOUGH AGE" +
                            "</html>");
                }

            } while (date >= lowdate || age < 16 || date < 1910);
            dep = JOptionPane.showInputDialog(null, "Do you want to make an initial deposit? Y/N");

            if (dep.equals("Y")) {
                deposit = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the deposit amount: "));

                confirmWithdraw = JOptionPane.showInputDialog(null, "Do you want to make any withdrawals? Y/N");

                if (confirmWithdraw.equals("Y")) {
                    do {
                        withdraw = Float.parseFloat(JOptionPane.showInputDialog(null, "Balance: $" + deposit + "\nEnter the value of your " +
                                "loot: "));
                        if (withdraw > deposit) {
                            JOptionPane.showMessageDialog(null, "Invalid withdraw!");
                        }
                    } while (deposit < withdraw);
                }
            }
            String confirmInvest = JOptionPane.showInputDialog(null, "Do you want to enter the investment field? Y/N");
            if (confirmInvest.equals("Y")) {
                invest = Integer.parseInt(JOptionPane.showInputDialog(null, "We have the following investments" +
                        "\n1°.Savings" +
                        "\n2°.Treasury direct" +
                        "\n3°. Selic rate"));
                switch (invest) {

                    case 1:
                        valueofInvest = Double.parseDouble(JOptionPane.showInputDialog(null, "You if" +
                                "selected SAVINGS" +
                                "\nEnter the amount you want to invest: "));
                        timeofInvest = Integer.parseInt(JOptionPane.showInputDialog(null, "How long do you intend to leave it for?" +
                                "months?"));
                        //Valor da poupança Ok!
                        BankOperation showinvestPoup = new BankOperation(valueofInvest, timeofInvest);
                        JOptionPane.showMessageDialog(null, "The result of the investment was: " + String.format("%.2f%n", showinvestPoup.getInvestSavigins()));

                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "NOTE: THE RESULTS OF THE INVESTMENT CAN ONLY BE WITHDRAWN IN 2027!");
                        valueofInvestTrea = Double.parseDouble(JOptionPane.showInputDialog(null, "Você selecionou " +
                                "TREASURE DIRECT how much do you want to invest? "));
                        BankOperation showinvestTreasure = new BankOperation(valueofInvestTrea);
                        JOptionPane.showMessageDialog(null, "The result of investiment was: " + showinvestTreasure.getInvestTreasure());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "NOTE: THE RESULT OF THE INVESTIMENT CAN ONLY WITHTDRAWN IN 2027!");
                        float valueSelic = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the amount you want to invest:"));
                        BankOperation selic = new BankOperation(valueSelic);
                        JOptionPane.showMessageDialog(null, "The result: " + String.format("%.2f%n", selic.getInvestSelic()));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "[ERROR] OPTION NO EXISTS");

                }

            }
            list.add(new InformationsbyBank(name, withdraw, deposit, date,numberofAccount));
            list.add(new BankOperation(deposit, withdraw));
            String extratc = String.valueOf(JOptionPane.showInputDialog(null, "Do you want to issue your statement? Y/N"));
            if (extratc.equals("Y")) {

            }
            JOptionPane.showMessageDialog(null, "Your registration has been completed!   Thank you for your preference!");
        } else {
            JOptionPane.showMessageDialog(null, "What a shame you didn't want to join us, come back soon!");
        }

        sc.close();

    }
}
