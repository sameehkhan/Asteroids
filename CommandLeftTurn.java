package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandLeftTurn extends Command{
	private static GameWorld game;
	private static CommandLeftTurn left;
	private GameWorld gw;
		public CommandLeftTurn(GameWorld gw)
		{
			super("Left Turn");
			this.gw=gw;
		}
		public static CommandLeftTurn getInstance(GameWorld gw)
		{
			if (left == null)
			{
				left = new CommandLeftTurn(gw);
			}
			return left;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.steerLeft();;
			
		}

}