package com.mycompany.a1;

public class Missile extends MoveableObject
{
	private int fuelLevel;
	
	public Missile(double x, double y, int d, int s)
	{
		super(x,y,0,0,0);
		super.setDirection(d);
		super.initialSpeed(s+3);
		setFuelLevel(10);
	}
	public void setFuelLevel(int f)
	{
		fuelLevel=f;
	}
	public int getFuelLevel()
	{
		return fuelLevel;
	}
	public void decrementFuel()
	{
		fuelLevel--;
	}
	public String toString()
	{
		return("Missile: loc="+super.getLocationX() +", " +super.getLocationY()+" color=["+ super.getRed()+", "+super.getGreen()+", "+super.getBlue()+"] speed="+super.getSpeed()+" dir="+super.getDirection()+" fuel="+getFuelLevel());
	}
}
