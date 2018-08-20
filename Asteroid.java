package com.mycompany.a1;
import java.util.Random;

public class Asteroid extends MoveableObject
{
	public Random rand = new Random();

	private int size;
	
	public Asteroid()
	{
		super(255,255,255);
		super.setDirection(rand.nextInt(360));
		size = rand.nextInt(25);
		super.initialSpeed(rand.nextInt(10));
	}
	public void setSize()
	{
		System.out.println("Size of Asteroid cannot be changed");
	}
	public int getSize()
	{
		return size;
	}
	public void changeDirection()
	{
		System.out.println("Direction cannot be changed");
	}
	public void setSpeed()
	{
		System.out.println("Speed cannot be changed");
	}
	public String toString()
	{
		return("Asteroid: loc="+super.getLocationX() +", " +super.getLocationY()+" color=["+ super.getRed()+", "+super.getGreen()+", "+super.getBlue()+"] speed="+super.getSpeed()+" dir="+super.getDirection()+" size="+getSize());
	}
}