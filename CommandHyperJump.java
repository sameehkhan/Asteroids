package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandHyperJump extends Command{
	private static GameWorld game;
	private static CommandHyperJump jump;
	private GameWorld gw;
		public CommandHyperJump(GameWorld gw)
		{
			super("Hyper Jump");
			this.gw=gw;
		}
		public static CommandHyperJump getInstance(GameWorld gw)
		{
			if (jump == null)
			{
				jump = new CommandHyperJump(gw);
			}
			return jump;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.hyperJump();
			
		}

}