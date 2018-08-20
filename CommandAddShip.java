package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandAddShip extends Command{
	private static GameWorld game;
	private static CommandAddShip ship;
	private GameWorld gw;
		public CommandAddShip(GameWorld gw)
		{
			super("Add Ship");
			this.gw=gw;
		}
		public static CommandAddShip getInstance(GameWorld gw)
		{
			if (ship == null)
			{
				ship = new CommandAddShip(gw);
			}
			return ship;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.addShip();
			
		}

}