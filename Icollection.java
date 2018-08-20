package com.mycompany.a1;
import com.mycompany.a1.GameObject;

public interface Icollection {
	void addGameObject(GameObject gameObj);
	Iiterator getIterator();
}
