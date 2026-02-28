package umg.edu.gt.queuehandler;
import umg.edu.gt.queuehandler.model.Song;
import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class Player {

	private QueueLinked<Song> highPriority;
	private QueueLinked<Song> normalPriority;
	private QueueLinked<Song> history;
	private int songsPlayed = 0;
	private long totalTimePlayed = 0;
	
	
	public Player() {
		this.highPriority = new QueueLinked<>();
		this.normalPriority = new QueueLinked<>();
		this.history = new QueueLinked<>();
		this.songsPlayed = 0;
		this.totalTimePlayed = 0;
	}
	
	public int getSongsPlayed() {
		return songsPlayed;
	}
	
	public long getTotalTimePlayed() {
		return totalTimePlayed;
		
	}
	
	
	
	public void addSong(Song song) {
		if (song.getPriority() == 1) {
			highPriority.enqueue(song);
			
		}else {
			normalPriority.enqueue(song);
		}
	}
	public void play() {
		while (!highPriority.isEmpty() || !normalPriority.isEmpty()) {
			Song currentSong;
			
			if (!highPriority.isEmpty()) {
				currentSong = highPriority.dequeue();
			}else {
				currentSong = normalPriority.dequeue();
			}
			
			System.out.println("Now Playing: " + currentSong);
			for (int seconds = 1; seconds <= currentSong.getDuration(); seconds++) {
				int totalchar = 10;  
				int progress = (seconds * totalchar) / currentSong.getDuration(); // En resumen multiplica los segundos actuales de la canciones por el numero de caracteres y luego los divide por la cantidad total de segundo que tiene la cancion.
				StringBuilder bar = new StringBuilder();
				for (int i = 1; i <= totalchar; i++) {
				    if (i <= progress) { //Siempre que i sea menor o igual que el progreso (La ecuacion) va a ir agregando un # mas
				        bar.append("#");
				    } else {
				        bar.append("-");
				    }
				}
				System.out.println("[" + bar + "] " + seconds + "s / " + currentSong.getDuration() + "s");

				try {
					Thread.sleep(1000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
			history.enqueue(currentSong);
			songsPlayed++;
			totalTimePlayed += currentSong.getDuration();
			System.out.println("Finished: " + currentSong.getTitle());
		}
		System.out.println("PlayList Finished.");
	
}
	
	public void printHistory() {
		System.out.println("\n ============= HISTORIAL DE CANCIONES REPRODUCIDAS ===============");
		QueueLinked<Song> pastsongs = new QueueLinked<>();
		int cont = 1;
		
		while (!history.isEmpty()) {
			Song song = history.dequeue();
			System.out.println("Song #" + cont + ": "+ song);
			pastsongs.enqueue(song);
			cont ++;
		}
		
		while (!pastsongs.isEmpty()) {
			history.enqueue(pastsongs.dequeue());
		}
		System.out.println("========================================================== \n");
	}
}
