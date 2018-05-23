package s_facebook;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class Facebook_logic extends Facebook_Methods {
	private static final String URL = "https://www.facebook.com/";
	
	@Test
	@FileParameters ("./data/sfacebook_params.csv")
	public void testFacebookAddFriend(String browser, String fUser, String fPass, String friend_Name, String friend_Details) {
		StartBrowser(browser, URL);
		
		if (LoginSucceeds(fUser, fPass)) {
			System.out.println("We're in!");
			AddFriend(friend_Name, friend_Details);
		}else {
			System.out.println("Login didn't work.");
			//Babye();
		}		
	}	
}
