package Proj2;// Application2.java
import java.io.*;
import java.lang.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Application2 {
	public static void main(String[] args) {
		PrintStream ss = System.out;
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nMedia Player - Queue Implementation");
		Date timenow = new Date();
		System.out.println("Date: " + timenow.toString());
		Queue<Song> playlist = new LinkedList<>();
		Map<String, Integer> hp = new HashMap<>();
		int choice = -1, currsize = 0;
		while (choice != 0) {
			System.out.println("\n1. Add a new Song\n2. Go to next Song\n3. What's the next song?\n4. Total length of Playlist\n5. Exit Music Player\nEnter your choice: ");
			try {
				choice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid Input :(");
				break;
			}
			switch (choice) {
			case 1: {
				currsize += 1;
				// int songRank = currsize;
				ss.println("Enter Song Name: ");
				String songName = scan.nextLine();
				ss.println("Enter Singer Name: ");
				String singerName = scan.nextLine();
				ss.println("Enter Song Duration (format: mins secs: ");
				int songMin = scan.nextInt(), songSec = scan.nextInt();
				boolean flag = true;
				if (hp.containsKey(songName)) {
					// int y = hp.get(songName);
					hp.putIfAbsent(songName, 1);
				}
				// } else {
				// 	hp.putIfAbsent(songName, 0);
				// }
				// scan.nextLine();
				Song elemsong = new Song(songName, singerName, songMin, songSec);
				if (hp.get(songName) == null) {
					playlist.offer(elemsong);
				}
				hp.put(songName, elemsong.getDuration());
				System.out.println(playlist);
				break;

			}
			case 2: {
				if (playlist.size() == 0) {
					System.out.println("Playlist is empty!");
					break;
				}
				Song dummy = playlist.poll();
				System.out.println("Removed: " + dummy);
				// int y = hp.get(songName);
				// if (y <= 1) {
				// 	y = 0;
				// } else {
				// 	y -= 1;
				// }
				// hp.put(dummy.audName, y);
				hp.put(dummy.audName, null);
				break;
			}
			case 3: {
				if (playlist.size() == 0) {
					System.out.println("No songs in playlist currently!");
					break;
				}
				System.out.println(playlist.peek());
				break;
			}
			case 4: {
				System.out.println("Total Duration of the playlist: ");
				int totdur = 0;
				for (Map.Entry<String, Integer> ele : hp.entrySet()) {
					Integer curdur = ele.getValue();
					totdur += curdur != null ? curdur : 0;
				}
				System.out.println(totdur);
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