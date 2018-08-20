package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandFireMissiles extends Command{
	private static GameWorld game;
	private static CommandFireMissiles fire;
	private GameWorld gw;
		public CommandFireMissiles(GameWorld gw)
		{
			super("Fire Missile");
			this.gw=gw;
		}
		public static CommandFireMissiles getInstance(GameWorld gw)
		{
			if (fire == null)
			{
				fire = new CommandFireMissiles(gw);
			}
			return fire;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.createnewMissile();
			
		}

}