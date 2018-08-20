package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandKillAsteroid extends Command{
	private static GameWorld game;
	private static CommandKillAsteroid kill;
	private GameWorld gw;
		public CommandKillAsteroid(GameWorld gw)
		{
			super("Kill Asteroid");
			this.gw=gw;
		}
		public static CommandKillAsteroid getInstance(GameWorld gw)
		{
			if (kill == null)
			{
				kill = new CommandKillAsteroid(gw);
			}
			return kill;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.removeAsteroid();
			
		}

}