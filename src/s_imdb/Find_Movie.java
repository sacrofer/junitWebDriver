package s_imdb;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class Find_Movie extends Imdb_Methods {
	private static final String URL = "http://imdb.com";
	
	@Test
	@FileParameters("./data/simdb_find_movie_params.csv")
	public void findMovie(String browser, String movieName, String movieYear, String movieDirector) {
		startBrowser(browser, URL);
		searchMovie(movieName, movieYear);
		verifyMovie (movieName, movieYear, movieDirector);
	}
}
