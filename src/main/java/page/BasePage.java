package page;

import java.util.Random;

public class BasePage {

	public int generateRandomNumber(int boundryNumber) {
		Random ran = new Random();
		return ran.nextInt(boundryNumber);
	}
}
