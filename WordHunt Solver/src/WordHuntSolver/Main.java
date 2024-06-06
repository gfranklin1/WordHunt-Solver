package WordHuntSolver;

import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("Enter letters for the grid (type 'q' to quit):");
				System.out.print("> ");

				String input = scanner.nextLine().replaceAll("\\s+", "").toUpperCase();
				if (input.equalsIgnoreCase("q")) {
					System.out.println("Quitting...");
					break;
				}

				int n = (int) Math.sqrt(input.length());

				while (true) {
					if (n * n != input.length()) {
						System.out.println(
								"You must enter a perfect square number of letters (e.g., 16 for 4x4, 25 for 5x5), or type 'q' to quit:");
						System.out.print("> ");
						input = scanner.nextLine().replaceAll("\\s+", "").toUpperCase();
						if (input.equalsIgnoreCase("q")) {
							System.out.println("Quitting...");
							return;
						}
						n = (int) Math.sqrt(input.length());
					} else {
						break;
					}
				}

				char[][] board = new char[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						board[i][j] = input.charAt(i * n + j);
					}
				}

				System.out.println("\n" + n + "x" + n + " Board:");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(board[i][j] + " ");
					}
					System.out.println();
				}

				WordHuntBot bot = new WordHuntBot("src/resources/wordlist.txt");

				Set<String> words = bot.findWords(board);
				ArrayList<String> sortedWords = new ArrayList<>(words);
				sortedWords.sort((a, b) -> Integer.compare(b.length(), a.length()));

				System.out.println("\nTop 100 longest words:");
				for (int i = 0; i < Math.min(100, sortedWords.size()); i++) {
					System.out.println(sortedWords.get(i));
				}
				if (words.isEmpty()) {
					System.out.println("No words found.");
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("Error reading word list file.");
		}
	}
}
