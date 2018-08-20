package com.mycompany.a1;

public class Ship extends MoveableObject implements ISteerable {
	private int missileCount;

	public Ship ()
	{
		super(512,384,0,255,0);
		super.initialSpeed(0);
		setMissileCount(10);
		super.setDirection(0);
	}
	
	public void setMissileCount(int c)
	{
		missileCount = c;
	}
	public int getMissileCount()
	{
		return missileCount;
	}
	public void steerLeft()
	{
		super.setDirection((super.getDirection()-6));
	}
	public void steerRight()
	{
		super.setDirection(super.getDirection()+6);
	}
	public void fireMissile()
	{
		if (missileCount == 0)
				{
				System.out.print("You are out of Missiles");
				}
		else
				{
		missileCount--;
				}
	}
	public String toString()
	{
		return("Ship: loc="+super.getLocationX() +", " +super.getLocationY()+" color=["+ super.getRed()+", "+super.getGreen()+", "+super.getBlue()+"] speed="+super.getSpeed()+" dir="+super.getDirection()+" missiles="+getMissileCount());
	}

	public void increaseSpeed() 
	{
		super.initialSpeed(getSpeed()+1);	
	}

	public void decreaseSpeed()
	{
		super.initialSpeed(getSpeed()-1);	
	}
	
	public void reloadMiss() {
		setMissileCount(10);

	}		
}
