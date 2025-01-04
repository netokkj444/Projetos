package Jokenpo;

import Jokenpo.Entites.OperationsGame;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        OperationsGame op = new OperationsGame();
        char confirm = 'S';


        System.out.println("---------------------------------");
        System.out.println("    Welcome to Jokenpo Game!     ");
        System.out.println("---------------------------------");
        do {
            System.out.println();
            System.out.println("Paper(1),Rock(2) and Scissors(3)");
            System.out.print("Player 1 what's your move? ");
            int p1 = sc.nextInt();
            op.setPlayer1(p1);
            if (p1 > 3 || p1 < 1){
                do {
                    //Test if player 1's move is invalid
                    System.out.println("Invalid move!");
                    System.out.print("Type your move again: ");
                    p1 = sc.nextInt();
                    op.setPlayer1(p1);
                } while (p1 > 3 || p1 < 1);
            }
            System.out.print("Player 2 what's yout move? ");
            int p2 = rd.nextInt(1, 4);
            System.out.println(p2);
            op.setPlayer2(p2);
            System.out.println(op.getResult());
            System.out.println("Do you want continue? Y/N");
            confirm = sc.next().charAt(0);
        } while (confirm != 'N');
        System.out.println(op);
    }
}
