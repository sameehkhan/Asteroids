package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandDecreaseSpeed extends Command{
	private static GameWorld game;
	private static CommandDecreaseSpeed decrease;
	private GameWorld gw;
		public CommandDecreaseSpeed(GameWorld gw)
		{
			super("Decrease Speed");
			this.gw=gw;
		}
		public static CommandDecreaseSpeed getInstance(GameWorld gw)
		{
			if (decrease == null)
			{
				decrease = new CommandDecreaseSpeed(gw);
			}
			return decrease;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.decreaseSpeed();
			
		}

}