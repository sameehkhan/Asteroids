package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import java.util.Random;

public abstract class GameObject {

	private double locationX;
	private double locationY;
	private int color; 
	private Random rand = new Random();
	
	public GameObject(double x, double y, int r, int g, int b)
	{
		color = ColorUtil.rgb(r, g, b);
		locationX =x;
		locationY =y;
	}
	public GameObject(int r, int g, int b)
	{
		locationX = (double)rand.nextInt(1024);
		locationY = (double)rand.nextInt(768);
		color = ColorUtil.rgb(r, g, b);		
	}
	
	public void setLocationX(double x)
	{
		//verify within x bounds
		if (x >= 0.0 &&  x <= 1024.0)
		{
			locationX = x;
		} else if (x > 1024.0)
		{
			locationX = 1024.0;
		} else 
		{
			locationX = 0.0;
			
		}
	}	
	public void setLocationY(double y)	
	{
		//verify within y bounds
		if (y >= 0.0 && y <= 768)
		{
			locationY = y;
		} else if (y > 768.0)
		{
			locationY = 768.0;
		} else
		{
			locationY = 0.0;
		}

	}

	public double getLocationX()
	{
		return locationX;
	}
	public double getLocationY()
	{
		return locationY;
	}
	public void setColor(int r, int g, int b)
	{
		color = ColorUtil.rgb(r, g, b);

	}
	public int getRed()
	{
		return ColorUtil.red(color);
	}
	public int getGreen()
	{
		return ColorUtil.green(color);
	}
	public int getBlue()
	{
		return ColorUtil.blue(color);
	}
	public abstract String toString();
}
