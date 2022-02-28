package Proj2;// Application2.java
import java.io.*;
import java.lang.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Application2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nMedia Player - Queue Implementation");
		Date timenow = new Date();
		System.out.println("Date: " + timenow.toString());
		Queue<Song> playlist = new LinkedList<>();
		Map<String, Integer> hp = new HashMap<>();
		int choice = -1, currsize = 0;
		while (choice != 0) {
			System.out.println("\n1. Add a new Song\n2. Go to next Song\n3. What's the next song?\n4. Total number of Songs\n5. Exit Music Player\nEnter your choice: ");
			try {
				choice = scan.nextInt();
			} catch(Exception e) {
				System.out.println("Invalid Input :(");
				break;
			}
			switch (choice) {
			case 1: {
				currsize += 1;
				// int songRank = currsize;
				String songName = scan.next();
				String singerName = scan.next();
				boolean flag = true;
				if (hp.containsKey(songName)) {
					int y = hp.get(songName);
					hp.put(songName, y + 1);
				} else {
					hp.put(songName, 0);
				}
				scan.nextLine();
				if (hp.get(songName) == 0)
					playlist.offer(new Song(songName, singerName));
				System.out.println(playlist);
				break;

			}
			case 2: {
				if (playlist.size() == 0) {
					System.out.println("Playlist is empty!");
					break;
				}
				System.out.println("Removed: " + playlist.poll());
				break;
			}
			case 3: {
				if (playlist.size() == 0) {
					System.out.println("That was the last song!");
					break;
				}
				System.out.println(playlist.peek());
				break;
			}
			case 4: {
				System.out.println(playlist.size());
				break;
			}
			case 5: {
				choice = 0;
				break;
			}
			default: {
				System.out.println("Invalid Input!");
			}
			}
		}
	}
}