package ProjetoBanco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        //List<> lista = new ArrayList<>();
        boolean testeCpf = true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("""
                -------------------------
                    Banco Santa Maria
                -------------------------
                Seja bem vindo!
                Vamos iniciar seu cadastro!
                """);
        System.out.println("Você é Pessoa Jurídica (PJ) ou Pessoa Física? (PF)? ");
        String pjoupf = sc.nextLine();
        if(pjoupf.equals("PF")) {
            System.out.print("Primeiro qual é o seu nome? ");
            String nome = sc.nextLine();
            System.out.print("Digite sua data de nascimento: ");
            Date datanasc = sdf.parse(sc.next());
            Pattern cpf = Pattern.compile("^[0-9]{3}[.][0-9]{3}[.][0-9]{3}-[0-9]{2}");
            System.out.print("Digite seu cpf: ");
            CharSequence charSequence = sc.next();
            Matcher matcher = cpf.matcher(charSequence);
        }
    }
}
