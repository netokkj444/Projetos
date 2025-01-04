package Jokenpo.Entites;

public class OperationsGame {
    private int player1;
    private int player2;
    private int pointsp1;
    private int pointsp2;
    final int rock = 2;
    final int paper = 1;
    final int scissors = 3;
    boolean test = false;

    public int getPlayer1() {
        return player1;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public void setPlayer2(int player2) {
        this.player2 = player2;
    }

    public String getResult() {
        switch (player1) {
            //Here player number 1 was used as a reference to obtain the result
            case (rock):
                if (player1 == rock && player2 == paper) {
                    pointsp2++;
                    return "Player 2 win!";
                } else if (player1 == player2) {
                    return "Draw!";
                } else {
                    pointsp1++;
                    return "Player 1 win!";
                }
            case (paper):
                if (player1 == paper && player2 == scissors) {
                    pointsp2++;
                    return "Player 2 win!";
                } else if (player1 == player2) {
                    return "Draw!";
                } else {
                    pointsp1++;
                    return "Player 1 win!";
                }
            case (scissors):
                if (player1 == scissors && player2 == rock){
                    pointsp2 ++;
                    return "Player 2 win!";
                } else if (player1 == player2) {
                    return "Draw!";
                } else {
                    pointsp1++;
                    return "Player 1 win!";
                }
            default:
                return null;
        }
    }
    @Override
    public String toString() {
        if (pointsp1 > pointsp2){
            return "Player 1 win with " + pointsp1  + " points";
        } else {
            return "Player 2 win with " + pointsp2 + " points";
        }
    }
}
