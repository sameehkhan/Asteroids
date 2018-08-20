package com.mycompany.a1;

public abstract class FixedObject extends GameObject
{
	private int identification; //id for every fixed object
	
	//Space Station
	public FixedObject (int r, int g, int b)
	{
		super(r,g,b);
		identification = identification +1;
	}
	public void setLocationX()
	{
		System.out.println("Error: Location cannot be set");
	}
	public void setLocationY()
	{
		System.out.println("Error: Location cannot be set");
	}
	public int getIdentification()
	{
		return identification;
	}
}
