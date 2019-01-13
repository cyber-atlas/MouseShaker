package MouseShaker;

import java.awt.*;
import java.util.Random;

public class ShakerMain {


	public static void main(String[] args) throws InterruptedException, AWTException {
		//Creates a new random number generator
		Random rand = new Random();
		//Creates a new Java Robot so we can move the mouse
		Robot robo = new Robot();

		//True will always be true, this code will run until we stop the program
		while(true){

			//Gets the current mouse location and shows it to us an int
			//Stores the mouse location in mouseX
			int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();

			//Modulo (%) gives us the remainder
			//If remainder of %2 is 0, then the number is even, else it is odd
			//If location of mouseX is even, make the location increase by 1 (so it becomes odd)
			System.out.println("mouseX before" + mouseX);
			if (mouseX % 2 == 0 ){
				mouseX += 1;
			}
			//If the location of mouseX is odd, then decrease the location by 1 (thus making it even)
			else{
				mouseX-= 1;
			}
			System.out.println("mouseX after" + mouseX);

			//Get the y locaton of the mouse, we aren't going to change it
			int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
			//Move the mouse to the new location. It has the same Y, and has our changed X
			robo.mouseMove(mouseX, mouseY);

			//Number with the amount of time we want to pause the program after we move the mouse
			int delay;
//			System.out.println("Delay " + delay);
			//Sets the delay to a number that is between 1 minutes and 4 minutes represented in milliseconds
			//The number we put in as argument in next int is the maximum number we want to generate
			//By adding a number we are increasing the minimum number because we don't want to generate a number lower than 2 min
			//So we put in 2minutes as a max and add 2 minutes. So it is always betweeen 2 and 4 minutes (in ms)
			//Always going to be between 120,000 and 240,0000
			delay = rand.nextInt(120000) + 120000;
//			delay = rand.nextInt(20) + 20;
			System.out.println("Delay " + delay);
			//Pauses the program based on the delay we gave it
			Thread.sleep(delay);

		}
	}
}