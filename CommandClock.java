package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandClock extends Command 
{
	private GameWorld gw;
	
	public CommandClock(GameWorld gw)
	{
		super("Ticker");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.ticker();
	}
}
