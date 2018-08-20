package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandAbout extends Command{
	private static GameWorld game;
	private static CommandAbout about;
	private GameWorld gw;
		public CommandAbout(GameWorld gw)
		{
			super("About");
			this.gw=gw;
		}
		public static CommandAbout getInstance(GameWorld gw)
		{
			if (about == null)
			{
				about = new CommandAbout(gw);
			}
			return about;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			gw.aboutPrompt();
			
		}

}