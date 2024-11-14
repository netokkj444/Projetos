package Bank.Objects;

import Bank.Objects.Objects.BankOperation;
import Bank.Objects.Objects.InformationsbyBank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class Bank {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Random numberAccout = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date now = new Date();
        List<BankOperation> list = new ArrayList<>();

        String currentyear = sdf.format(now);
        //int lowdate = Integer.parseInt(String.valueOf(currentyear));
        int age;
        Boolean test = null;
        String name;
        String Confirmdeposit;
        float deposit = 0;
        String confirmWithdraw;
        float withdraw = 0;
        int invest = 0;
        double valueofInvestSavings = 0;
        int timeofInvest = 0;
        String tp = "";
        double valueofInvestTrea = 0;
        int numberofAccount = numberAccout.nextInt(1000, 5000);

        System.out.println("Welcome to Bank of Holy Mary!");
        System.out.print("Do you want to register? Y/N ");
        String confirmAccount = sc.next();
        if (confirmAccount.equals("Y")) {
            System.out.println("Let's start your registration!");
            do {
                System.out.print("What's your name? ");
                name = sc.next();
                if (name.length() < 4){
                    System.out.println("Name incomplete,plase type again ");
                }
            } while (name.length() < 4);

            do {
                //verificasion case if date be invalid
                System.out.print("Enter the year you were born: ");
                Date dt = sdf.parse(sc.next());
                age = now.getYear() - dt.getYear();
                if (age > 120) {
                    System.out.print("Register not completed! " + "\n" +
                            "Reason: INVALID DATE ");
                    test = false;
                } else if (dt.after(now)) {
                    System.out.print("Register not completed! " + "\n" +
                            "Reason: INVALID DATE ");
                    test = false;
                } else if (age < 16) {
                    System.out.print("Register not completed! " + "\n" +
                            "Reason: INVALID DATE ");
                    test = false;
                }else {
                    test = true;
                }
                System.out.println();
            } while (test != true);
            System.out.print("Do you want to make an initial deposit? Y/N ");
            Confirmdeposit = sc.next();
            if (Confirmdeposit.equals("Y")) {
                System.out.print("Enter the deposit amount: ");
                deposit = sc.nextFloat();
                System.out.print("Do you want to make any withdrawals? Y/N ");
                confirmWithdraw = sc.next();
                if (confirmWithdraw.equals("Y")) {
                    do {
                        System.out.print("Balance: $" + deposit + "\nEnter the value of your " +
                                "loot: ");
                        deposit = sc.nextFloat();
                        if (withdraw > deposit) {
                            System.out.print("Invalid withdraw!");
                        }
                    } while (deposit < withdraw);
                }
            }
            sc.nextLine();
            System.out.print("Do you want to enter the investment field? Y/N ");
            String confirmInvest = sc.next();
            if (confirmInvest.equals("Y")) {
                System.out.println("We have the following investments" +
                        "\n1°.Savings" +
                        "\n2°.Treasury direct" +
                        "\n3°. Selic rate");
                invest = sc.nextInt();
                switch (invest) {
                    case 1:
                        System.out.println("""
                                You if\
                                selected SAVINGS
                                Enter the amount you want to invest: """);
                        valueofInvestSavings = sc.nextDouble();
                        System.out.println("How long do you intend to leave it for? (months) ");
                        timeofInvest = sc.nextInt();
                        BankOperation showinvestPoup = new BankOperation(valueofInvestSavings, timeofInvest);
                        System.out.println("The result of the investment was: " + String.format("%.2f%n", showinvestPoup.getInvestSavigins()));
                        break;
                    case 2:
                        System.out.println("NOTE: THE RESULTS OF THE INVESTMENT CAN ONLY BE WITHDRAWN IN 2027!");
                        System.out.print("You selected TREASURE DIRECT how much do you want to invest? ");
                        valueofInvestTrea = sc.nextDouble();
                        BankOperation showinvestTreasure = new BankOperation(valueofInvestTrea);
                        System.out.println("The result of investiment was: " + String.format("%.2f%n", showinvestTreasure.getInvestTreasure()));
                        break;
                    case 3:
                        System.out.println("NOTE: THE RESULT OF THE INVESTIMENT CAN ONLY WITHTDRAWN IN 2027!");
                        System.out.print("Enter the amount you want to invest:");
                        double valueSelic = sc.nextDouble();
                        BankOperation selic = new BankOperation(valueSelic);
                        System.out.println("The result: " + String.format("%.2f%n", selic.getInvestSelic()));
                        break;
                    default:
                        System.out.println("[ERROR] OPTION NO EXISTS");

                }
            }
            list.add(new BankOperation(deposit, withdraw));
            //  list.add(new InformationsbyBank(name, deposit, withdraw, date, numberofAccount));
            System.out.println("Do you want to issue your statement? Y/N ");

            JOptionPane.showMessageDialog(null, "Your registration has been completed!   Thank you for your preference!");
        } else {
            JOptionPane.showMessageDialog(null, "What a shame you didn't want to join us, come back soon!");
        }

        sc.close();

    }
}
