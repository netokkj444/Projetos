package Objects;

public class bankOperations {
    private String name;
    private int year;
    private final double deposito;
    private double saque;
    private double invest;
    private double tempoInvest;


    public bankOperations(String name, int year, double deposito, double saque, double invest,double tempoInvest){
        this.name = name;
        this.year = year;
        this.deposito = deposito;
        this.saque = saque;
        this.invest = invest;
        this.tempoInvest = tempoInvest;
    }

    public bankOperations(double deposito) {
        this.deposito = deposito;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return 2024 - year;

    }

    public double getSaldo() {
        return deposito - saque;
    }

    public double getInvestTesouro(){
        return invest*2*0.1146;
    }

   public double getInvest(){
        double i = invest + invest*tempoInvest*0.005141;
        return i;
   }


    public String toString(){
        return "<html>Dados:" +
                "<br>Nome: " + getName()+
                "<br>Idade: " + getYear() +
                "<br>Saldo atual: " + deposito+
                "<br>Saque: " + getSaldo() +
                "</html>" + getInvestTesouro();
    }
}
