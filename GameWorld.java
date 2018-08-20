package com.mycompany.a1;

import java.util.Iterator;
import java.util.Observable;

public class GameWorld extends Observable{
	private int shipCount=0;
	private Ship user;
	private int totalScore = 0;
	private int time = 0;
	private int lives = 3;
	private int asteroidCount = 0;
	private boolean soundOn;
	private SpaceGameCollection collection;
	
	
	public GameWorld()
	{
		collection = new SpaceGameCollection();
	}
	
	public void init()
	{}
	
	public int getTime()
	{
		return time;
	}
	
	//Game commands
	public void quit() 
	{
		System.out.println("Press 'y' to quit, 'n' to cancel");//Exit message, prompts the user if they are sure they want to quit.
		
		}
	public void quit2()//System exit function. Once confirmed, the game will exit.
	{
		System.exit(0);
	}
	public void increaseSpeed()
	{
		if (shipCount == 0)
		{
			System.out.println("There is no ship.");
		}
		else {
			user.increaseSpeed();
			System.out.println(user.toString());
		}
	}
	public void decreaseSpeed()
	{
		if (shipCount == 0)
		{
			System.out.println("There is no ship.");
		}
			else
			{	
			user.decreaseSpeed();
			System.out.println(user.toString());
	
			}
	}	
	public boolean getSound()
	{
		return soundOn;
	}
	
	public void setSoundOn(boolean s)
	{
		this.soundOn=s;
		updateWorld();
	}
	public void updateWorld()
	{
		setChanged();
		notifyObservers();
	}
	public void addAsteroid()
	{
		Asteroid asteroid = new Asteroid();
		collection.add(asteroid);
		asteroidCount++;
		System.out.println("Asteroid Created");
		System.out.println(asteroid.toString());
		updateWorld();
		
	}
	public void addSpaceStation()
	{
		SpaceStation spaceStation = new SpaceStation();
		collection.add(spaceStation);
		System.out.println("Space Station Added");
		System.out.println(spaceStation.toString());
		updateWorld();
	}
	public void addShip()// ship is created if it meets the criterion
	{
		if (shipCount<1)
		{
		user = new Ship();
		collection.add(user);
		shipCount++;
		System.out.println("Ship Created");
		System.out.println(user.toString());

		}
		else
		{
		System.out.println("Error: Ship cannot be created");	
		}
		updateWorld();
	}
	public void steerLeft()
	{
		user.steerLeft();
		System.out.println("Ship Steered Left");
		System.out.println(user.toString());
		updateWorld();
	}
	public void steerRight()
	{
		user.steerRight();
		System.out.println("Ship Steered Right");
		System.out.println(user.toString());
		updateWorld();
	}
	public void printMap()
	{
		System.out.println("Displaying Map:");
		
		Iiterator aIterator = collection.getIterator();
		while(aIterator.hasNext())
		{
			{
			GameObject item = (GameObject) aIterator.next();
			System.out.println(item.toString());
			}
			
		}
	}
	public int getPoints()
	{
		return totalScore;
	}
	public void printDisplay()
	{
		System.out.println("Score: " + totalScore); 
		System.out.println("Missile Count: " + user.getMissileCount());
		System.out.println("Elapsed Time: " + time);
	}
	public void reloadMiss()
	{ 
	    user.setMissileCount(10);
	    System.out.println("Missiles Reloaded");
	    System.out.println(user.toString());
		updateWorld();

	}
	public void hyperJump()
	{
		user.setLocationX(512);
		user.setLocationY(384);
		System.out.println(user.toString());
		updateWorld();

	}
	public void aboutPrompt()
	{
		new DisplayAbout();
	}
	public void ticker()
	{
		Iiterator aIterator = collection.getIterator();		
		while(aIterator.hasNext())
		{
			GameObject item = (GameObject) aIterator.getNext();
			if (item instanceof MoveableObject)
				{
					MoveableObject move = (MoveableObject)item;
					move.move();
				}
			if(item instanceof Missile)
			{
				((Missile) item).decrementFuel();
				if (((Missile) item).getFuelLevel() == 0)
				{
					collection.remove(item);
				}
			}
			if(item instanceof SpaceStation)
			{
				int rate = ((SpaceStation) item).getBlinkRate();
				if (time % rate == 0)
				{
					((SpaceStation) item).getBlinkRate();
				}
			}
		}
		time++;
		System.out.println("Clock has ticked");
		updateWorld();

			
	}
	public void deleteAMissile()
	{
		Iiterator aIterator = collection.getIterator();
		while (aIterator.hasNext()) 
		{ //remove 1 missile from collection
			GameObject item = (GameObject) aIterator.next();
			if(item instanceof Missile) {
				collection.remove(item);
				break;
			}
		}
	}
	public void asteroidCollison()
	{
		if (asteroidCount>2)
		{
			System.out.println("There are less than 2 asteroids");
		}
		else
		{
		deleteAsteroid();
		deleteAsteroid();
		}
		updateWorld();

	}
	public void removeAsteroid()
	{

		deleteAsteroid();
		deleteAMissile();
		totalScore++;
		updateWorld();
		
		}
	
	public void deleteAsteroid()
	{
		Iiterator aIterator = collection.getIterator();
		while (aIterator.hasNext()) 
		{ //remove 1 asteroid from collection
			GameObject item = (GameObject) aIterator.next();
			if(item instanceof Asteroid) {
				collection.remove(item);
				break;
			}
		}	
	}
	public void shipCrash()
	{
		if (asteroidCount > 0)
		{	
			deleteAsteroid();
			collection.remove(user);
			shipCount--;
			lives--;
		}
		else
		{
			System.out.println("There are no asteroids");
		}
		if (lives <= 0)
		{
			System.out.println("RIP. Quit to restart");
		}
		updateWorld();

	}
	public int getAsteroidCount()
	{
		return asteroidCount;
	}
	
	public int getMissileCount()
	{
		int missileCount=0;
		if (shipCount > 0)
		{
			 missileCount = user.getMissileCount();
		}
		return missileCount;
	}
	public void createnewMissile()
	{
		if (shipCount == 0)
		{
			System.out.println("No ships found.");
		} else 
			System.out.println("Missile fired");
		{
			double xValue = user.getLocationX();
			double yValue = user.getLocationY();
			int dir = user.getDirection();
			int speed = user.getSpeed();
			if(user.getMissileCount() > 0)
			{
				user.fireMissile();
				Missile missile = new Missile(xValue, yValue, dir, speed);
				collection.add(missile);
			} else {
				System.out.println("You are out of missiles.");
			}
		}
		updateWorld();

	}

	
}


