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
        double valueofInvestSelic = 0;
        double valueofInvestTrea = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Bank of Holy Mary!");
        String confirm = JOptionPane.showInputDialog(null, "Do you want to register? Y/N");
        //falta algumas coisas para aprimorar!)
        if (confirm.equals("Y")) {
            JOptionPane.showMessageDialog(null, "Let's start your registration!");
            name = JOptionPane.showInputDialog(null, "What's your name? ");
            do {
                //Verificação de idade caso se for um "intruso"
                ;
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
                deposit = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the deposit amount:: "));
            }

            confirmWithdraw = JOptionPane.showInputDialog(null, "Do you want to make any withdrawals? Y/N");

            if (confirmWithdraw.equals("Y")) {
                do {
                    withdraw = Float.parseFloat(JOptionPane.showInputDialog(null, "Balance: $" + deposit + "\nEnter the value of your " +
                    "loot: "));
                    if (withdraw > deposit) {
                        JOptionPane.showMessageDialog(null, "Invalid withdraw!");
                    }
                } while (deposit < withdraw);

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
                            JOptionPane.showMessageDialog(null, "NOTE: YOU CAN ONLY WITHDRAW YOUR MONEY AFTER 3 YEARS!");
                            valueofInvestSelic = Double.parseDouble(JOptionPane.showInputDialog(null, "You selected SELIC TAX" +
                                    "how much do you want to invest? "));
                            BankOperation showinvestSelic = new BankOperation(valueofInvestSelic);

                            JOptionPane.showMessageDialog(null, "The result of investiment was: " + showinvestSelic.getSelicTax());

                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "[ERROR] OPTION NO EXISTS");

                    }

                }
                BankOperation things = new BankOperation(name, date, deposit, withdraw, valueofInvestSelic);
                String extratc = String.valueOf(JOptionPane.showConfirmDialog(null, "Do you want to issue your statement? "));
                if (extratc != null) {
                    JOptionPane.showMessageDialog(null, things.toString());
                }
                JOptionPane.showMessageDialog(null, "Your registration has been completed!   Thank you for your preference!");
            } else {
                JOptionPane.showMessageDialog(null, "What a shame you didn't want to join us, come back soon!");
            }

            sc.close();
        }
    }
}
