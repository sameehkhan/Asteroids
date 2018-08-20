package com.mycompany.a1;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld 
{
	private GameWorld gwProxy;
	
	public GameWorldProxy(GameWorld gw)
	{
		gwProxy = gw;
	}
	public int getMissileCount()
	{
		return gwProxy.getMissileCount();
	}
	public int getClockTime()
	{
		return gwProxy.getTime();
	}
	public int getScores()
	{
		return gwProxy.getPoints();
	}
	public boolean getSoundOn()
	{
		return gwProxy.getSound();
	}
	
}