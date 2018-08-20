package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandIncreaseSpeed extends Command{
	private static GameWorld game;
	private static CommandIncreaseSpeed increase;
	private GameWorld gw;
		public CommandIncreaseSpeed(GameWorld gw)
		{
			super("Increase Speed");
			this.gw=gw;
		}
		public static CommandIncreaseSpeed getInstance(GameWorld gw)
		{
			if (increase == null)
			{
				increase = new CommandIncreaseSpeed(gw);
			}
			return increase;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.increaseSpeed();
			
		}

}