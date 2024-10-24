package Bank.Objects.Objects;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class InformationsbyBank extends BankOperation{
   public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   public static SimpleDateFormat sdf1 = new SimpleDateFormat(" HH:mm:ss");
    private String name;
    private int date;
    private int numberofAccount;
    private LocalDate localDate;
    private static LocalDateTime localDateTime;


    public InformationsbyBank(String name, double deposit, double withdraw, int date, int numberofAccount) {
        super(deposit, withdraw);
        this.name = name;
        this.date = date;
        this.numberofAccount = numberofAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getNumberofAccount() {
        return numberofAccount;
    }

    public void setNumberofAccount(int numberofAccount) {
        this.numberofAccount = numberofAccount;
    }

    @Override
    public String toString() {
        return "DATA: " +
                "NAME: " + name + "\n" +
                "BALANCE: " + getBalance() +
                "NUMBER OF ACCOUNT: " + numberofAccount +
                "DATE: " + sdf.format(localDate) +
                "HOUR: " + sdf1.format(localDateTime);
    }
}
