import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ModelBall {
	private int x=5;
	private int y=24;
	private int locationChangeX = 1;
	private int locationChangeY = 1;	
	private int xMax = 12;
	private int yMax = 30;
	Clip clipbounce = null;
	//A number that x and y cannot ever take in this game so that we can initialize start

	public ModelBall(){}

	public void moveBall() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		File bounceSound = new File("Cartoon Boing.wav");
		AudioInputStream audioStreambounce = AudioSystem.getAudioInputStream(bounceSound);
		Clip clipbounce = AudioSystem.getClip();
		clipbounce.open(audioStreambounce);
		
		if (x >= (xMax-1)) {
			locationChangeX = -1;
		clipbounce.setMicrosecondPosition(0);
		clipbounce.start();
		}
        if(x <= 0) {
			locationChangeX = 1;
        clipbounce.setMicrosecondPosition(0);
		clipbounce.start();
		}
		if(y >= (yMax-1)) {
			locationChangeY = -1;
		clipbounce.setMicrosecondPosition(0);
		clipbounce.start();
		}
		if(y <= 1) {			
			locationChangeY = 1;
		clipbounce.setMicrosecondPosition(0);
		clipbounce.start();
		}
		x+=locationChangeX;
		y+=locationChangeY;
		
	}

	public void PaddleBounceleft() {
		locationChangeY = -1;
		locationChangeX = -1;
//		clipbounce.setMicrosecondPosition(0);
//		clipbounce.start();
	}

	public void PaddleBounceRight() {
		locationChangeY = -1;	
		locationChangeX = +1;
		//clipbounce.setMicrosecondPosition(0);
		//clipbounce.start();
	}

	public void PaddleBounceMiddle() {
		locationChangeY = -1;	
		locationChangeX = 0;
		//clipbounce.setMicrosecondPosition(0);
		//clipbounce.start();
	}

	public int getlocationchangeX() {
		return locationChangeX;
	}
	public void setlocationchangeX(int a) {
		locationChangeX = a;
	}
	public int getlocationchangeY() {
		return locationChangeY;
	}
	public void setlocationchangeY(int a) {
		locationChangeY = a;
	}

	public int gety() {
		return y;
	}

	public int getx() {
		return x;
	}

	public void sety(int a) {
		y = a;
	}

	public void setx(int b) {
		x = b;
	}

}
