/*
Jeffrey Lange
jlange29@student.cccs.edu
Dice 30 Finals Assignment
CSC160680
4/26/2022
 */

import java.util.*;

class Main {
    static  int output;

    //text color declaration for player's names
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_CYAN = "\u001B[36m";



    public static void main(String[] args) {

        System.out.println(".######...####............####...#####...........#####...##..##...####...######.");
        System.out.println("....##...##..##..........##..##..##..##..........##..##..##..##..##........##...");
        System.out.println("...###...######..........##..##..#####...........#####...##..##...####.....##...");
        System.out.println(".....##..##..##..........##..##..##..##..........##..##..##..##......##....##...");
        System.out.println(".#####....####............####...##..##..........#####....####....####.....##...");
        System.out.println("................................................................................");

        Scanner input = new Scanner(System.in);
        System.out.println("Hello, what is the name of the first player?");
        String playerName1 = input.nextLine();

        System.out.println("What is the name of the second player?");
        String playerName2 = input.nextLine();

        //Sets player names using Player.class
        Player player1 = new Player();
        player1.setName(playerName1);
        Player player2= new Player();
        player2.setName(playerName2);

        //start both player's score to 0
        player1.setScore(0);
        player2.setScore(0);

        //Intro and rules

        System.out.println("Welcome players " + TEXT_YELLOW + player1.getName() + TEXT_RESET + " and "+ TEXT_BLUE + player2.getName() + TEXT_RESET + "!");
        System.out.println("The goal of this game is to accumulate a player score of exactly 30. The first player to score exactly 30 is the Winner!");
        System.out.println("You will roll a pair of dice, then you must choose the score of one of the dice or the total of the two dice. This value is added to your player score. If your score goes over 30, your score is reset to zero. Player turn changes after each roll of the dice. You win when you accumulate a score of exactly 30.");
        System.out.println("Here we go!");

        int total; //total of dice value

       while(player1.getScore() != 30 && player2.getScore() != 30) {
           System.out.println(TEXT_YELLOW + "Player " + player1.getName() + ", it is your turn!" + TEXT_RESET);
           System.out.println("Your score: " + player1.getScore());
           roll();
           total = player1.getScore() + output;
           player1.setScore(total);

           if(player1.getScore() == 30) {
               System.out.println(TEXT_YELLOW +"#########################################"+ TEXT_RESET);
               System.out.println(TEXT_YELLOW +"#########################################"+ TEXT_RESET);
               System.out.println(TEXT_YELLOW +"Your total: 30! Congratulations, " + player1.getName() + " - you WIN!!"+ TEXT_RESET);
               System.out.println(TEXT_YELLOW +"#########################################"+ TEXT_RESET);
               System.out.println(TEXT_YELLOW +"#########################################"+ TEXT_RESET);
               break;
           }
           if(player1.getScore() > 30){
               System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
               System.out.println("Your total: " + total +", your score is now reset to 0!");
               System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
               player1.setScore(0);
           }else{
               System.out.println(TEXT_YELLOW + "Your total: " + total + TEXT_RESET);
               System.out.println("----> Hint: You are " + (30 - player1.getScore()) + " away from winning!!");
           }

           System.out.println(TEXT_BLUE + "Player " + player2.getName() + ", it is your turn!" + TEXT_RESET);
           System.out.println("Your score: " + player2.getScore());
           roll();
           total = player2.getScore() + output;
           player2.setScore(total);

           if(player2.getScore() == 30) {
               System.out.println(TEXT_BLUE +"#########################################"+ TEXT_RESET);
               System.out.println(TEXT_BLUE +"#########################################"+ TEXT_RESET);
               System.out.println(TEXT_BLUE +"Your total: 30! Congratulations, " + player2.getName() + " - you WIN!!"+ TEXT_RESET);
               System.out.println(TEXT_BLUE +"#########################################"+ TEXT_RESET);
               System.out.println(TEXT_BLUE +"#########################################"+ TEXT_RESET);
               break;
           }
           if(player2.getScore() > 30){
               System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
               System.out.println("Your total: "+ total +", your score is now reset to 0!");
               System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
               player2.setScore(0);
           }else{
               System.out.println(TEXT_BLUE + "Your total: " + total + TEXT_RESET);
               System.out.println("----> Hint: You are " + (30 - player2.getScore()) + " away from winning!!");
           }

       } //end loop

    }

    static void roll(){
        int score = 0, min=1, max=6;
        int dice1, dice2;

        dice1 = min + (int)(Math.random() * ((max - min) + 1));
        dice2 = min + (int)(Math.random() * ((max - min) + 1));
        score+=dice1+dice2;
        System.out.println("Your roll:");
        System.out.println("Die 1: " + dice1);
        System.out.println("Die 2: " + dice2);
        System.out.println("Total: " + score);

        if(score == 12 || score == 2){
            System.out.println("---> That was a rare roll! There was a 1/36 chance of that roll with a probability of 2.778%");
        }else if(score == 3 || score == 11){
            System.out.println("---> This roll had the second lowest probability of 5.556%!");
        }else if(score == 4 || score == 10){
            System.out.println("---> This roll had the fourth highest probability of 8.333%!");
        }else if(score == 5 || score == 9){
            System.out.println("---> This roll had the third highest probability of 11.111%!");
        }else if(score == 6 || score == 8){
            System.out.println("---> This roll had the second highest probability of 13.889%!");
        }else if(score == 7){
            System.out.println("---> This roll had the highest probability of 16.667%!");
        }


    //Error handling requiring player to enter 1, 2 or 3 only and not other integers
    boolean pass = false;
    do {
        System.out.println("Do you wish to (1) Keep die 1, (2) Keep die 2, (3) Keep the total? (Respond with 1 or 2 or 3):");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        if (option == 1) {
            output = dice1; pass = true;
        } else if (option == 2) {
            output = dice2; pass = true;
        } else if (option == 3) {
            output = score; pass = true;
        }else{
            System.out.println("--> Sorry, that was an invalid entry.");
        }
    }while(!pass);


    }

}



