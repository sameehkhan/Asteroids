package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandLoadMissiles extends Command{
	private static GameWorld game;
	private static CommandLoadMissiles load;
	private GameWorld gw;
		public CommandLoadMissiles(GameWorld gw)
		{
			super("Load Missiles");
			this.gw=gw;
		}
		public static CommandLoadMissiles getInstance(GameWorld gw)
		{
			if (load == null)
			{
				load = new CommandLoadMissiles(gw);
			}
			return load;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.reloadMiss();;
			
		}

}