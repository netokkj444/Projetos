package BankProject.Entites;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InformationBank {

    private float deposit = 0;
    private double withdraw;
    private double investSav;
    private double investTea;
    private float investSelic;
    private double timeInvest;
    private final double selicTax = 10.8916 / 100;

    LocalDate X1 = LocalDate.now();
    int X = Integer.parseInt(String.valueOf(X1.getYear()));
    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime x2 = LocalDateTime.now();
    String p = fmt1.format(x2);


    public InformationBank(float deposit, double withdraw) {
        this.deposit = deposit;
        this.withdraw = withdraw;
    }


    public InformationBank(double investSav, double timeInvest) {
        this.investSav = investSav;
        this.timeInvest = timeInvest;
    }

    public InformationBank(double valueofInvestTrea) {
        this.investTea = valueofInvestTrea;
    }

    public InformationBank(float valueSelic) {
        this.investSelic = valueSelic;
    }

    public double getBalance() {
        return deposit - withdraw;
    }

    public double getInvestTreasure() {
        return investTea + investTea * 2 * 0.1146 * 3;
    }

    public double getInvestSavigins() {
        double i = investSav + investSav * timeInvest * 0.005141;
        String.format("%.2f%n", i);
        return i;
    }

    public float getInvestSelic() {
        float sel = (float) (selicTax * investSelic* 3 + investSelic);
        return sel;
    }
}