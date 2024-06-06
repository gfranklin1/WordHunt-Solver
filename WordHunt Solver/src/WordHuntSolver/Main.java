package WordHuntSolver;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 16 letters for the 4x4 grid:");

            String input = scanner.nextLine().replaceAll("\\s+", "");
            if (input.length() != 16) {
                System.out.println("You must enter exactly 16 letters.");
                return;
            }

            char[][] board = new char[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = input.charAt(i * 4 + j);
                }
            }

            System.out.println("4x4 Board:");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            WordHuntBot bot = new WordHuntBot("src/resources/wordlist.txt");

            Set<String> words = bot.findWords(board);
            ArrayList<String> sortedWords = new ArrayList<>(words);
            sortedWords.sort((a, b) -> Integer.compare(b.length(), a.length()));

            System.out.println("Top 100 longest words:");
            for (int i = 0; i < Math.min(100, sortedWords.size()); i++) {
                System.out.println(sortedWords.get(i));
            }
            if(words.isEmpty()) {
                System.out.println("No words found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
