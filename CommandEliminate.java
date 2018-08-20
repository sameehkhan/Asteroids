package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandEliminate extends Command{
	private static GameWorld game;
	private static CommandEliminate eliminate;
	private GameWorld gw;
		public CommandEliminate(GameWorld gw)
		{
			super("Exterminate");
			this.gw=gw;
		}
		public static CommandEliminate getInstance(GameWorld gw)
		{
			if (eliminate == null)
			{
				eliminate = new CommandEliminate(gw);
			}
			return eliminate;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.asteroidCollison();
			
		}

}