package com.mycompany.a1;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Container;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.Layout;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Form;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import java.util.*;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;


public class Game extends Form
{
	//MapView map = new MapView();
	//PointsView pv = new PointsView();
	private MapView mv;
	private PointsView pv;
	private static int mapWidth;
	private static int mapHeight;
	private GameWorld gamew;
	private GameWorld gw;
	
	public Game() 
	{
		gw = new GameWorld();
		pv = new PointsView(gw);
		mv = new MapView(gw);
		Form title = new Form("Asteroid");
		this.setLayout(new BorderLayout());
		this.setTitle("Asteroid");
		
		Toolbar sideMenuToolbar = new Toolbar();
			sideMenuToolbar.getAllStyles().setPadding(0, 0, 0, 200);
			sideMenuToolbar.getAllStyles().setFgColor(ColorUtil.BLACK);
			sideMenuToolbar.getAllStyles().setBgColor(ColorUtil.WHITE);
			setToolBar(sideMenuToolbar);
			
			
			
			Button sideAbout = new Button("About");
			sideAbout.setCommand(CommandAbout.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideAbout);
			sideAbout.getAllStyles().setBgTransparency(255);
			
			CommandAbout newAbout = new CommandAbout(gw);
			sideAbout.setCommand(newAbout);
			
			
			
		Button sideShip = new Button("Add Ship");
			sideShip.setCommand(CommandAddShip.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideShip);
			sideShip.getAllStyles().setBgTransparency(255);
			
		CommandAddShip shipAdder = new CommandAddShip(gw);
		sideShip.setCommand(shipAdder);	
		
		addKeyListener('s',shipAdder);

		Button sideAsteroid = new Button("Add Asteroid");// add asteroid side panel button
			sideAsteroid.setCommand(CommandAddAsteroid.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideAsteroid);
			sideAsteroid.getAllStyles().setBgTransparency(255);
			
		CommandAddAsteroid asteroidCreator = new CommandAddAsteroid(gw);	
		sideAsteroid.setCommand(asteroidCreator);
		
		addKeyListener('a',asteroidCreator);

			
		Button sideSpaceStation = new Button("Add Space Station");// add space station side panel button
			sideSpaceStation.setCommand(CommandAddSpaceStation.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideSpaceStation);
			sideSpaceStation.getAllStyles().setBgTransparency(255);
			
		CommandAddSpaceStation spaceStationCreator = new CommandAddSpaceStation(gw);
		sideSpaceStation.setCommand(spaceStationCreator);
		
		addKeyListener('b',spaceStationCreator);

		Button sideSpeedIncrease = new Button("Increase Speed");//increase speed side toolbar button 
			sideSpeedIncrease.setCommand(CommandIncreaseSpeed.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideSpeedIncrease);
			sideSpeedIncrease.getAllStyles().setBgTransparency(255);
			
		CommandIncreaseSpeed speedIncreaser = new CommandIncreaseSpeed(gw);
		sideSpeedIncrease.setCommand(speedIncreaser);
		
		addKeyListener('i',speedIncreaser);

		Button sideSpeedDecrease = new Button("Decrease Speed");// decrease speed side toolbar button
			sideSpeedDecrease.setCommand(CommandDecreaseSpeed.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideSpeedDecrease);
			sideSpeedDecrease.getAllStyles().setBgTransparency(255);
		
			
		CommandDecreaseSpeed speedDecreaser = new CommandDecreaseSpeed(gw);
		sideSpeedDecrease.setCommand(speedDecreaser);
		
		addKeyListener('d',speedDecreaser);
			
		Button sideLeftTurn = new Button("Left Turn");
			sideLeftTurn.setCommand(CommandLeftTurn.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideLeftTurn);
			sideLeftTurn.getAllStyles().setBgTransparency(255);
			
		CommandLeftTurn leftTurner = new CommandLeftTurn(gw);
		sideLeftTurn.setCommand(leftTurner);

		addKeyListener('l',leftTurner);

		Button sideRightTurn = new Button("Right Turn");
  			sideRightTurn.setCommand(CommandRightTurn.getInstance(gw)); 
  			sideMenuToolbar.addComponentToSideMenu(sideRightTurn); 
  			sideRightTurn.getAllStyles().setBgTransparency(255);
  			
  		CommandRightTurn rightTurner = new CommandRightTurn(gw);
  		sideRightTurn.setCommand(rightTurner);	
  		
		addKeyListener('r',rightTurner);

  		Button sideFire = new Button("Fire"); 
  			sideFire.setCommand(CommandFireMissiles.getInstance(gw)); 
  			sideMenuToolbar.addComponentToSideMenu(sideFire); 
  			sideFire.getAllStyles().setBgTransparency(255); 
  			
  		CommandFireMissiles missileFire = new CommandFireMissiles(gw);
  		sideFire.setCommand(missileFire);
  		
		addKeyListener('f',missileFire);

  		Button sideHyperJump = new Button("Jump"); 
  			sideHyperJump.setCommand(CommandHyperJump.getInstance(gw)); 
  			sideMenuToolbar.addComponentToSideMenu(sideHyperJump); 
  			sideHyperJump.getAllStyles().setBgTransparency(255); 
  		
  		CommandHyperJump jumpCreator = new CommandHyperJump(gw);
  		sideHyperJump.setCommand(jumpCreator);
  		
		addKeyListener('j',jumpCreator);
	
  	  	Button sideKillAsteroid = new Button("Kill Asteroid"); 
  			sideKillAsteroid.setCommand(CommandKillAsteroid.getInstance(gw)); 
  			sideMenuToolbar.addComponentToSideMenu(sideKillAsteroid); 
  			sideKillAsteroid.getAllStyles().setBgTransparency(255); 
  			
  		CommandKillAsteroid asteroidKiller = new CommandKillAsteroid(gw);
  		sideKillAsteroid.setCommand(asteroidKiller);
  		
		addKeyListener('k',asteroidKiller);

  		Button sideCrashShip = new Button("Crash Ship"); 
  			sideCrashShip.setCommand(CommandShipCrash.getInstance(gw)); 
  			sideMenuToolbar.addComponentToSideMenu(sideCrashShip); 
  			sideCrashShip.getAllStyles().setBgTransparency(255); 	
  		
  		CommandShipCrash shipCrasher = new CommandShipCrash(gw);
  		sideCrashShip.setCommand(shipCrasher);
  		
		addKeyListener('c',shipCrasher);
	
  		Button sideLoadShip = new Button("Load Ship"); 
  			sideLoadShip.setCommand(CommandLoadMissiles.getInstance(gw)); 
  			sideMenuToolbar.addComponentToSideMenu(sideLoadShip); 
  			sideLoadShip.getAllStyles().setBgTransparency(255); 
  			
  		CommandLoadMissiles missileReloader = new CommandLoadMissiles(gw);
		sideLoadShip.setCommand(missileReloader);
		
		addKeyListener('n',missileReloader);
	
  		Button sideEliminate = new Button("Eliminate"); 
  			sideEliminate.setCommand(CommandEliminate.getInstance(gw)); 
  			sideMenuToolbar.addComponentToSideMenu(sideEliminate); 
  			sideEliminate.getAllStyles().setBgTransparency(255); 
  			
  		CommandEliminate exterminator = new CommandEliminate(gw);
  		sideEliminate.setCommand(exterminator);
  		
		addKeyListener('x',exterminator);
		
		
	
	
  		Button sideTicker = new Button("Ticker"); 
  		
  			sideTicker.setCommand(CommandClock(gw));
  			sideMenuToolbar.addComponentToSideMenu(sideTicker); 
  			sideTicker.getAllStyles().setBgTransparency(255);
  			  		
  			CommandClock tickTock = new CommandClock(gw);
  			sideTicker.setCommand(tickTock);
  			
		addKeyListener('t',tickTock);
		
		Button sideSound = new Button("Sound"); 
  		
			sideSound.setCommand(CommandSound.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideSound); 
			sideTicker.getAllStyles().setBgTransparency(255);
			  		
			CommandClock soundOnOff = new CommandClock(gw);
			sideTicker.setCommand(soundOnOff);


		Button sideQuit = new Button("Quit"); 
			sideQuit.setCommand(CommandQuit.getInstance(gw)); 
				sideMenuToolbar.addComponentToSideMenu(sideQuit); 
				sideQuit.getAllStyles().setBgTransparency(255);
				
				CommandQuit quitter = new CommandQuit(gw);
				sideQuit.setCommand(quitter);
		
		addKeyListener('q',quitter);
		
  	  		
  			
  			//points view and map view
  			add(BorderLayout.NORTH,pv);
  			
  			
  			//center container (mapview)		
  			Container centerContainer = new Container();
  			centerContainer.getAllStyles().setBorder(Border.createLineBorder( 4, ColorUtil.BLACK));
  			centerContainer.getAllStyles().setBgTransparency(255);
  			centerContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
  			centerContainer.add(mv);
  			this.add(BorderLayout.CENTER, centerContainer);
  			
  			mapWidth = centerContainer.getWidth();
  			mapHeight = centerContainer.getHeight();
  			
  			

		this.show();
		
		
	}
	private Command CommandClock(GameWorld gw2) {
		// TODO Auto-generated method stub
		return null;
	}
	public static int getMapWidth()
		{
			return mapWidth;
		}
		
		public static int getMapHeight()
		{
			return mapHeight;
		}
	
}

		
		/*play();
	}
	private void play()
	{
		Label myLabel=new Label("Enter a Command: "); 
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show(); 
		myTextField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				switch (sCommand.charAt(0)) 
				{

			case 'a':
			gw.addAsteroid();//Asteroids are created and placed in a random location
				break;
			case 'b':
			gw.addSpaceStation();//a space station is created every time
				break;
			case 's':
			gw.addShip();//adding a ship, if there is not one present
				break;
			case 'i':
			gw.increaseSpeed(); //increases speed of the ship by small amount
				break;
			case 'd':
			gw.decreaseSpeed();//decrease speed of the ship by small amount, but don't go negative
				break;
			case 'l':
			gw.steerLeft();//it will conduct a slight left turn on the ship
				break;
			case 'r':
			gw.steerRight();//there will be a small right turn on the ship
				break;
			case 'f':
			gw.createnewMissile();
				break;
			case 'j':
			gw.hyperJump(); //through hyperspace. Causes ship to jump instantly to initial default position
				break;
			case 'n':
			gw.reloadMiss();//reloads new supply of missiles into the ship
				break;
			case 'k':
			gw.removeAsteroid();//a missile has struck and killed an asteroid; tells the game world to remove a missile and an asteroid and to increment the player's score by some amount of your choosing
				break;
			case 'c':
			gw.shipCrash();//ship has crashed into an asteroid; tells the game world to remove a missile and an asteroid and to decrement the player's score.
				break;
			case 'x':
			gw.asteroidCollison();//two asteroids have collided with and exterminated each other, tell game world to remove two asteroids
				break;
			case 't':
			gw.ticker();				
				break;
			case 'p':
			gw.printDisplay();//print a display; giving current game state values
				break;
			case 'm':
			gw.printMap();//print a map showing current world state
				break;
			case 'q': //will ask the user if they want to quit, then will have to confirm
				gw.quit(); //displays the yes or no for if the user wants to quit
				final TextField myTextField2=new TextField(); //make new input
				addComponent(myTextField2); 
				removeComponent(myTextField); 
				show(); //the form will be update
				myTextField2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt2) 
					{
						String sCommand2=myTextField2.getText().toString();

						myTextField2.clear();
						
						if (sCommand2.charAt(0) == 'y')
								{
									gw.quit2();
								}
						else if (sCommand2.charAt(0) == 'n') //play will resume as normal
						{
							addComponent(myTextField);
							removeComponent(myTextField2);
							show();
						}

					}
				});
				break;
			
			}
			
			}
		}
	);
	}
	}*/
	