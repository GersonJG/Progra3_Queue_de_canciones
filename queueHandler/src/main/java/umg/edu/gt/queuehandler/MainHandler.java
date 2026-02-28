package umg.edu.gt.queuehandler;  

import umg.edu.gt.queuehandler.model.Song;
import umg.edu.gt.data_structure.queue.manual.QueueLinked;
import java.util.Scanner;

public class MainHandler {

	public static void main(String[] args) {
		
		Player player = new Player();
		player.addSong(new Song("S&M", "Rihana", 7, 1));
		player.addSong(new Song("A dios le pido ", "Juanes", 2, 2));
		player.addSong(new Song("MAMAMIA ", "Maneski", 5, 1));
		player.play();
		player.printHistory();
		System.out.println("Total canciones: " + player.getSongsPlayed());
		System.out.println("Tiempo total: " + player.getTotalTimePlayed() + "s");

	}

}