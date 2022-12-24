import java.util.Random;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random randomPoint = new Random();
        Scanner userInput = new Scanner(System.in);
        int[][] randomNumber = new int[8][8];
        int num1, num2;
        int x = 8;
        int y = 0;
        int z = 0;
        int level = 1;
        int userNumberX = 0;
        int userNumberY = 0;
        int time = 5000;
        System.out.println("\nWelcome to Grid Flash! This is a game about memory and quick thinking. There is going to be a 8x8 grid that will appear for a short amount of time that looks like this:\n");
        while (x != 0) {
            System.out.print(x);
            for (int i = 0; i < randomNumber.length; i++) {
                System.out.print(" +");
            }
            System.out.print("\n");
            x -= 1;
        }
        System.out.println("  1 2 3 4 5 6 7 8");
        System.out.println("\nand there will be one character that stands out from the rest. Your job is to look at the grid that flashes on screen, and type in the correct coordinates of the contrasting character. Each time you guess correctly, you move to the next level and the showing time decreases.\n");
        System.out.print("\nPress enter to start level "+level+" ");
        String userAnswer = userInput.nextLine();
        System.out.println("");
        while (z == 0) {
            x = 8;
            num1 = randomPoint.nextInt(8);
            num2 = randomPoint.nextInt(8);
            randomNumber[num1][num2] = 1;
            while (x != 0) {
                System.out.print(x);
                for (int i = 0; i < randomNumber.length; i++) {
                    if (randomNumber[y][i] == 1) {
                        System.out.print(" X");
                    } else {
                        System.out.print(" +");
                    }
                }
                System.out.print("\n");
                x -= 1;
                y += 1;
            }
            System.out.println("  1 2 3 4 5 6 7 8");
            Thread.sleep(time);
            clrscr();
            System.out.print("\nWhat is the x coordinate of the odd one out: ");
            userNumberX = userInput.nextInt();
            System.out.print("\nWhat is the y coordinate of the odd one out: ");
            userNumberY = userInput.nextInt();
            if(userNumberX - 1 == num2 && 8 - userNumberY == num1){
                level += 1;
                System.out.print("\nCongratulations! You got the coordinates correct. \n\nPress enter to move on to level "+level+" ");
                userInput.nextLine();
                userAnswer = userInput.nextLine();
                System.out.println("");
                time = time - 300;
                randomNumber[num1][num2] = 0;
                y = 0;
            }
            else{
                System.out.println("\nUnfortunately, that is not the correct answer. The correct answer was " + (num2 +1) + " and " + (8 - num1) +". You managed to make it to level "+level+". Thanks for playing Grid Flash!");
                z += 1;
            }

        }
    }
    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}

