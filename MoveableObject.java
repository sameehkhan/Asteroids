package com.mycompany.a1;
 
public abstract class MoveableObject extends GameObject{
              private int speed;//Moveable attributes for all Moveable items
              private int direction;
             
              //for ship
              public MoveableObject (double x, double y, int r, int g, int b)
              {
            	  super(x,y,r,g,b);
            	  
              }
              //asteroid, location is done so randomly
              public MoveableObject(int r, int g, int b)
              {
            	  super(r,g,b);
              }
              
              public void move()
              {             
                  
          		double oldX = super.getLocationX();
        		double oldY = super.getLocationY();
        		
        		double degree = Math.toRadians(90 - direction);
        		double deltaX = Math.round(Math.cos(degree) * 10.0 * speed)/ 10.0; 
        		double deltaY = Math.round(Math.sin(degree) * 10.0 * speed)/ 10.0;
        		double newX = Math.round((oldX + deltaX) * 10.0)/ 10.0; 
        		double newY = Math.round((oldY + deltaY) * 10.0)/ 10.0; 
        		super.setLocationX(newX); 
        		super.setLocationY(newY);
              }
              public void setDirection(int d)
              {
                           if (d>=0 && d<360)
                                         direction = d;
                           else if(d>=360)
                                         direction = d%360;
                           else
                           {
                        	   direction = d%360+360;
                           }
              }
              public int getDirection()
              {
                           return direction;
              }
              public void initialSpeed(int s)
              {
            	  if (s<0)
            	  {
            		speed = 0;
            	  }
            	  else if (s>10)
            	  {
            	  	speed = 10;
            	  }
            	  else
            	  {
            	  speed=s;
            	  }
              }
             
             
              public int getSpeed()
              {
                           return speed;
              }
}
