package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandAddSpaceStation extends Command{
	private static GameWorld game;
	private static CommandAddSpaceStation station;
	private GameWorld gw;
		public CommandAddSpaceStation(GameWorld gw)
		{
			super("Add SpaceStation");
			this.gw=gw;
		}
		public static CommandAddSpaceStation getInstance(GameWorld gw)
		{
			if (station == null)
			{
				station = new CommandAddSpaceStation(gw);
			}
			return station;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.addSpaceStation();
			
		}

}
