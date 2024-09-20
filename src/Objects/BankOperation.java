package Objects;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class BankOperation {
    private String name;
    private int year;
    private double deposit = 0;
    private double withdraw;
    private double invest;
    private double timeInvest;
    private String bankstatement;
    Date dataeHr = new Date();
    String hr = new SimpleDateFormat("HH:mm:ss").format(dataeHr);
    LocalDate date = LocalDate.now();

    public BankOperation(String bankstatement) {
        this.bankstatement = bankstatement;
    }

    public BankOperation(String name, int year, double deposit, double saque, double invest, double tempoInvest) {
        this.name = name;
        this.year = year;
        this.deposit = deposit;
        this.withdraw = saque;
        this.invest = invest;
        this.timeInvest = tempoInvest;
    }

    public BankOperation(double invest, double timeInvest) {
        this.invest = invest;
        this.timeInvest = timeInvest;
    }


    public BankOperation(double deposit) {
        this.deposit = deposit;
    }

    public void setName(){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return 2024 - year;
    }

    public double getBalance() {
        return deposit - withdraw;
    }

    public double getInvestTreasure() {
        return invest * 2 * 0.1146;
    }

    public double getInvest() {
        double i = invest + invest * timeInvest * 0.005141;
        String.format("%.2f%n", i);
        return i;
    }

    public void setBankstatement(String bankstatement) {
        this.bankstatement = bankstatement;
    }

    public String getBankstatementxtract() {
       return "<html> EXTRATO BANCÁRIO " +
                "<br>NOME: " + name +
                "<br>SALDO: " + getBalance()+
                "<br>SAQUE: " + withdraw+
                "<br>             " + dataeHr +
                "</html>";

    }


    public String toString() {
        return "<html>Dados:" +
                "<br>Nome: " + getName() +
                "<br>Saldo atual: " + getBalance() +
                "<br>Saque: " + withdraw +
                "<br>Horário:                                     " + hr +
                "<br>Data:                                         " + date +
                "</html>";
    }
}
