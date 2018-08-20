package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandSound extends Command{
	private GameWorld gw;
	private static CommandSound sound;
	public CommandSound(GameWorld gw)
	{
		super("Toggle Sound ON/OFF");
		this.gw=gw;
	}
	public static CommandSound getInstance(GameWorld gw)
	{
		if(sound == null)
			sound = new CommandSound(gw);
		return sound;
	}
	public void actionPerformed(ActionEvent event)
	{
		if(gw.getSound()==false)
		{
			gw.setSoundOn(true);
		}
		else{
			gw.setSoundOn(false);
		}
	}

}