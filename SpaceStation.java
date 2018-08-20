package com.mycompany.a1;
import java.util.Random;

public class SpaceStation extends FixedObject
{
	public Random rand = new Random();
	
	private int blinkRate;
	public SpaceStation()
	{
	super(0,76,153);
	blinkRate = rand.nextInt(10)+1;

	}
	public int getBlinkRate()
	{
		return blinkRate;
	}
	public String toString()
	{
		return("Station: loc="+super.getLocationX() +", " +super.getLocationY()+" color=["+ super.getRed()+", "+super.getGreen()+", "+super.getBlue()+"] rate="+getBlinkRate());
	}
}