package edu.wctc;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // public variable to check to see if a restart is needed if entering a wrong number
    public static int restart = 0;
    public static int total = 0;

    // runs the majority of the program
    public static void main(String[] args) {
        String[] questions = {"mild or spicy", "tea or coffee", "breakfast or brunch", "summer or winter", "paper or plastic"};
        int[] answerArray = new int[5];
        String questionPartOne = "Do you prefer ";
        Scanner answers = new Scanner(System.in);
        Scanner exitQuestion = new Scanner(System.in);
        int choiceNumber;
        boolean again = true;
        int exit = 1;


        while (again) {
            System.out.println("Welcome to the Preference Quiz!");
            System.out.println("--------------------------------");
            total = 0;
            restart = 0;
            for (int i = 0; i < questions.length; i++) {
                String question = Arrays.toString(new String[]{questions[i]}).replaceAll("\\[", "").replaceAll("\\]", "");
                System.out.println(questionPartOne + question + "?");
                System.out.println("Enter 0 for the preference on the left.");
                System.out.println("Enter 1 for the preference on the right.");
                int answer = Integer.parseInt(answers.nextLine());
                checkAnswer(answer);
                if (restart == 1) {
                    break;
                }
                answerArray[i] = answer;
            }


            if (restart != 1) {

                for (int j : answerArray) {
                    choiceNumber = Integer.parseInt(String.valueOf(j));
                    total += choiceNumber;
                }
                //System.out.println(total); //-- debugging for total

                calculatedPreference();

                while (exit != 0) {
                    System.out.println("Again? Enter 1 to play again, or enter 0 exit.");
                    exit = Integer.parseInt(exitQuestion.nextLine());
                    if (exit == 0) {
                        again = false;
                    } else if (exit > 1) {
                        checkAnswer(exit);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    // Checks to see if you entered a 0 or a 1 and kicks you out to restart if you did not
    public static void checkAnswer(int answer) {
        Scanner placeholder = new Scanner(System.in);

        if (answer != 0 && answer != 1) {
            System.out.println("Please enter 0 or 1.  Enter any key to continue.");
            placeholder.nextLine();
            restart = 1;
        }
    }

    // Calculates the total of your choices and outputs a response
    public static void calculatedPreference() {
        if (total > 3) {
            System.out.println("You prefer life to be spontaneous and active");
        } else if (total == 3) {
            System.out.println("You prefer a good balance in life");
        } else {
            System.out.println("You prefer life to be calm and organized");
        }
    }
}
