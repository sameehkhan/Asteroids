package com.mycompany.a1;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;

public class MapView extends Container implements Observer{
	
	private GameWorld gameWorld = null;
	public MapView(GameWorld myModel) 
	{ 
		gameWorld = myModel;
		myModel.addObserver(this); // registers as an Observer
	}


	public void update(Observable observable, Object data) {
		gameWorld.printMap();
	}
}
