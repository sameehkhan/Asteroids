package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandAddAsteroid extends Command{
	private static GameWorld game;
	private static CommandAddAsteroid asteroid;
	private GameWorld gw;
		public CommandAddAsteroid(GameWorld gw)
		{
			super("Add Asteroid");
			this.gw=gw;
		}
		public static CommandAddAsteroid getInstance(GameWorld gw)
		{
			if (asteroid == null)
			{
				asteroid = new CommandAddAsteroid(gw);
			}
			return asteroid;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.addAsteroid();
			
		}

}
