package classExercise;

import org.junit.Test;

public class ImdbJUnit extends ParentTest {	
		
	@Test
	public void testMovie() {
		
		searchMovie(MOVIE);
		validateMovie(MOVIE, YEAR);
		openMovie(MOVIE, YEAR);
		playTrailer();		
	}

}
