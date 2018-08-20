package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandShipCrash extends Command{
	private static GameWorld game;
	private static CommandShipCrash crash;
	private GameWorld gw;
		public CommandShipCrash(GameWorld gw)
		{
			super("Ship Crash");
			this.gw=gw;
		}
		public static CommandShipCrash getInstance(GameWorld gw)
		{
			if (crash == null)
			{
				crash = new CommandShipCrash(gw);
			}
			return crash;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.shipCrash();;
			
		}

}