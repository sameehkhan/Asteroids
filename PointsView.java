package com.mycompany.a1;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;


public class PointsView extends Container implements Observer
{
	private GameWorld gameWorld = null;

	private Label timeData;
	private Label scoreData;
	private Label soundData;
	private Label missileData;


	public PointsView(GameWorld myModel) 
	{ 
		gameWorld = myModel;

		
		myModel.addObserver(this); // registers as an Observer
		

		Label scoreLabel = new Label("Score: ");
		Label timeLabel = new Label("Elapsed Time: ");		
		Label soundLabel = new Label("Sound: ");
		Label missileLabel = new Label("Missiles: ");		

		
		timeData = new Label(String.valueOf(gameWorld.getTime()));
		scoreData = new Label(String.valueOf(gameWorld.getPoints()));
		if(gameWorld.getSound() == false){
			soundData = new Label("OFF");
		} else {
			soundData = new Label("ON");
		}
		missileData = new Label(String.valueOf(gameWorld.getMissileCount()));


		timeLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		timeData.getAllStyles().setFgColor(ColorUtil.BLUE);

		scoreLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		scoreData.getAllStyles().setFgColor(ColorUtil.BLUE);

		soundLabel.getAllStyles().setFgColor(ColorUtil.MAGENTA);
		soundData.getAllStyles().setFgColor(ColorUtil.MAGENTA);

		missileLabel.getAllStyles().setFgColor(ColorUtil.BLACK);
		missileData.getAllStyles().setFgColor(ColorUtil.BLACK);
		
		setLayout(new BoxLayout(BoxLayout.X_AXIS));
		getAllStyles().setPadding(LEFT, 100);		

		add(scoreLabel);
		add(scoreData);
		add(timeLabel);
		add(timeData);
        add(missileLabel);
        add(missileData);
		add(soundLabel);
        add(soundData);

	}

	public void update(Observable observable, Object data) {

		timeData.setText(String.valueOf(gameWorld.getTime()));
		timeData.getParent().revalidate();
		
		scoreData.setText(String.valueOf(gameWorld.getPoints()));
		scoreData.getParent().revalidate();
		
		missileData.setText(String.valueOf(gameWorld.getMissileCount()));
		missileData.getParent().revalidate();
		
		if(gameWorld.getSound() == false){
			soundData.setText("OFF");
		}
		else{
			soundData.setText("ON");
		}
		soundData.getParent().revalidate();		
	}


	}	
