package Objects;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class BankOperation {
    private String name;
    private int year;
    private double deposit = 0;
    private double withdraw;
    private double investPoup;
    private double investTea;
    private double investSelic;
    private double timeInvest;
    private final double selicTax = 10.8916;

    Date dataeHr = new Date();
    String hr = new SimpleDateFormat("HH:mm:ss").format(dataeHr);
    LocalDate date = LocalDate.now();


    public BankOperation(String name, int year, double deposit, double withdraw,double investSelic) {
        this.name = name;
        this.year = year;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.investSelic = investSelic;
    }

    public BankOperation(double investPoup, double timeInvest) {
        this.investPoup = investPoup;
        this.timeInvest = timeInvest;
    }


    public BankOperation(double valueofInvestTrea) {
        this.investTea = valueofInvestTrea;
    }

    public void setName() {
        this.name = name;
    }

    public void setInvestSelic(){
        this.investSelic = investSelic;
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

    public void setInvestTea(double investTeasure) {
        this.investTea = investTeasure;
    }

    public void setInvestSelic(double investSelic){
        this.investSelic = investSelic;
    }

    public double getInvestTreasure() {
        return investTea + investTea * 2 * 0.1146 * 3;
    }

    public double getInvestSavigins() {
        double i = investPoup + investPoup * timeInvest * 0.005141;
        String.format("%.2f%n", i);
        return i;
    }

    public double getSelicTax() {
        return selicTax * investSelic * 3 + investSelic;
    }


    public String toString() {
        return "<html>           EXTRACT         " +
                "<br>DATA:" +
                "<br>NAME: " + getName() +
                "<br>CURRENT BALANCE: " + "R$" +  getBalance() +
                "<br>WITHDRAW: " + "R$" + String.format("%.2f%n", withdraw) +
                "<br>              TIME: " + hr +
                "<br>              DATE:    " + date +
                "</html>";
    }
}
