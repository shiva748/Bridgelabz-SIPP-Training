import java.util.*;

class cinemaa{
	
	private boolean validate(String time) {
		int hour = Integer.parseInt(time.split(":")[0]), min = Integer.parseInt(time.split(":")[1]);
		if(hour > 23 || hour < 0 || min > 59 || min < 0) {
			return false;
		}
		return true;
	}
	
	private List<Movietime> timeTable;
	
	cinemaa () {
		timeTable = new ArrayList<>();
	}
	
	void addMovie(String title, String time) {
		try {
			if(!validate(time)) {
				throw new InvalidTimeFormatException("Please enter valid time");
			}
			timeTable.add(new Movietime(title, time));
		}catch(InvalidTimeFormatException ex) {
            System.out.println("Caught "+ex.getMessage());
		}
	}
	
	List<Movietime> searchMovie(String phrase) {
		List<Movietime> res = new ArrayList<>();
		for(Movietime mt: timeTable) {
			if(mt.title.contains(phrase)) {
				res.add(mt);
			}
		}
		return res;
	}
	
	List<Movietime> displayMovie(){
		return timeTable;
	}
}

class Movietime{
	
	String title;
	String time;
	
	Movietime(String title, String time){
		this.title = title;
		this.time = time;
	}
}

class InvalidTimeFormatException extends Exception {
    public  InvalidTimeFormatException(String m) {
        super(m);
    }
}

public class cinema {
	public static void main(String args[]) {
		cinemaa hall = new cinemaa();
		hall.addMovie("Avenger: age of ultron", "12:30");
		hall.addMovie("Avenger: the end game", "09:30");
		System.out.println(hall.searchMovie("Ave").getFirst().title);
	}
}