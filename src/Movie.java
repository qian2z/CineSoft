/*
 * Movie.java
 * qian2z final submission 19 Oct
 */
public class Movie {
	
	protected String title;
	protected String rating;
	protected int sessionNo;
	
	public Movie() {
		
	}
	
	public Movie(String title, String rating, int sessionNo) {
		this.title = title;
		this.rating = rating;
		this.sessionNo = sessionNo;
	}
	
	public String getSession() {
		String text = "";
		
		if(this.sessionNo == 1) {
			text = "Morning (10am) ";
		}
		else if(this.sessionNo == 2) {
			text = "Afternoon (3pm) ";
		}
		else if(this.sessionNo == 3) {
			text = "Evening (8pm) ";
		}
		
		return text;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

}