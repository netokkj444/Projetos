import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the value");
        double cap = sc.nextDouble();
        System.out.println("Type the time");
        int time = sc.nextInt();
        final double tax = 0.025;
        double tax2 = 1 + tax;
        double time2 = Math.pow(tax2,time);
        double resul = cap*time2;
        double fees = resul - cap;
        System.out.print("The fees is: " + String.format("%.2f%n",fees));
        System.out.print("\nThe resul: " + String.format("%.2f%n",resul));

    }
}
