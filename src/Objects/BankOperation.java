package Objects;

public class BankOperation {
    private String name;
    private int year;
    private double deposit = 0;
    private double withdraw;
    private double invest;
    private double timeInvest;

    public BankOperation() {

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
        String.format("%.2f%n",i);
        return i;
    }


    public String toString() {
        return "<html>Dados:" +
                "<br>Nome: " + getName() +
                "<br>Idade: " + getYear() +
                "<br>Saldo atual: " + getBalance()+
                "<br>Saque: " + withdraw +
                "<br> Poupança "+ getInvest() +
                "</html>";
    }
}
