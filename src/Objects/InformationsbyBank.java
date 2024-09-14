package Objects;

import javax.swing.*;

public class InformationsbyBank {
        public String n1;
        public int n2;
        public double n3;

    public InformationsbyBank(String name, int year, double deposito) {
        this.n1  = name;
        this.n2  = year;
        this.n3  = deposito;
    }

    public InformationsbyBank() {

    }

    @Override
    public String toString() {
        return "<html>Dados:" +
                "<br>Nome: " + n1 +
                "<br>Idade: " + n2 +
                "<br>Saldo: " + n3 +
                "</html>";
    }


}
