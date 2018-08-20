package com.mycompany.a1;
import java.util.Iterator;
import java.util.Vector;
import com.mycompany.a1.GameObject;


public class SpaceGameCollection implements Icollection
	{
	private Vector <GameObject> collection;
	
	public SpaceGameCollection()
	{
		collection = new Vector<GameObject>();	
	}
	
	public void add(GameObject newObject){
		collection.addElement(newObject);
	}
	public boolean remove(GameObject obj)
	{
		return collection.remove(obj);
	}
	
	public Iiterator getIterator() 
	{
		return new GameObjectIterator();
	}
	public int size()
	{
		return collection.size();
	}
	private class GameObjectIterator implements Iiterator{
		private int curElement;
		public GameObjectIterator(){
			curElement = -1;
		}
		public boolean hasNext() 
		{
			if (collection.size()<= 0)
			{
				return false;
			}
			if (curElement == collection.size()-1)
			{
				return false;
			}
			return true;
			}
		public GameObject next() {
			
			curElement ++;
			return(collection.elementAt(curElement));
		}
		public void remove() {
			
		}
		@Override
		public GameObject getNext() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		}
		@Override
		public void addGameObject(GameObject gameObj) {
		// TODO Auto-generated method stub
		
		}
}
