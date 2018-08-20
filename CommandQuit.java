package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;


public class CommandQuit extends Command{
	private static GameWorld game;
	private static CommandQuit quit;
	private GameWorld gw;
		public CommandQuit(GameWorld gw)
		{
			super("Quit");
			this.gw=gw;
		}
		public static CommandQuit getInstance(GameWorld gw)
		{
			if (quit == null)
			{
				quit = new CommandQuit(gw);
			}
			return quit;
		}
		
		public void actionPerformed( ActionEvent e ){
			TextField myText = new TextField();	//Text field to hold the value
			Dialog.show("Are You Sure You Wish to Exit? Write Yes if so.", myText, new Command( "Enter" ) );
			String value = myText.getText();
			value = value.toUpperCase();
			
			if ( value.equals("Y") || value.equals("YES") ){
				System.exit(1);	
			}
			else if ( value.equals("N") || value.equals("NO") ){
			}
			else{
				System.out.println( "Invalid response. Ignoring input." );
			}}

}