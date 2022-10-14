/*
 * InternationalMovie.java
 * qian2z final submission 19 Oct
 */
public class InternationalMovie extends Movie {

	private String language;
	
	public InternationalMovie() {
		
	}
	
	public InternationalMovie(String title, String rating, int sessionNo, String language) {
		super(title, rating, sessionNo);
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}
	
	

}