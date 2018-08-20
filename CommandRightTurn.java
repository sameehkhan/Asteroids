package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandRightTurn extends Command{
	private static GameWorld game;
	private static CommandRightTurn right;
	private GameWorld gw;
		public CommandRightTurn(GameWorld gw)
		{
			super("Right Turn");
			this.gw=gw;
		}
		public static CommandRightTurn getInstance(GameWorld gw)
		{
			if (right == null)
			{
				right = new CommandRightTurn(gw);
			}
			return right;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.steerRight();;
			
		}

}