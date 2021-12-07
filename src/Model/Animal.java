package Model;

/**
Contains details on color,
position, team, status, rank
and movement of piece.

*/
public class Animal {

	private final String name;
	private String color;
	private int posX;
	private int posY;
	private int rank;
	private int denPos;
	private int denPosX;
	private int denPosY;
	private boolean isAlive;
	//boolean trapped;
	
	/**
	  Constructs animal object where it
	  determines its name, rank, color,
	  and position.
	
	  (For MCO1, only Lion and Dog is implemented.)
	
	  @param r rank (1-8)
	  @param c color
	  @param x position at X axis
	  @param y position ay Y axis
	*/
	public Animal(int r, String c, int x, int y) {
	  //trapped = false;
	  switch(r) {
	  	case 1:
	  		name = "Mouse";
	  		break;
	  	case 2:
	  		name = "Cat";
	  		break;
	  	case 3:
	  		name = "Wolf";
	  		break;
	  	case 4:
	    	name = "Dog";
	    	break;
	  	case 5:
	  		name = "Leopard";
	  		break;
	  	case 6:
	  		name = "Tiger";
	  		break;
	    case 7:
	    	name = "Lion";
	    	break;
	    case 9:
	    	name = "Elephant";
	    	break;
	    
	    default :
	      name = "Unknown";
	  }
	
	  //Precaution for failed animal instance
	  if (!name.equals("Unknown")) {
	    rank = r;
	    color = c;
	    posX = x;
	    posY = y;
	    isAlive = true;
	  }
	  else {
	    rank = -1;
	    color = "white";
	
	  }
	  
	  //Index starts from 0.
	  if (color.equals("red")) {
		  denPosX = 0;
		  denPosY = 3;
	  }
	  else if (color.equals("blue")) {
		  denPosX = 8;
		  denPosY = 3;
	  }
	 
	}
	
	/**
	  Sets position of this animal.
	  As of current development, the return
	  value only returns true. It will be used
	  to deny impossible movements in the future
	  (as there are no impossible movements at the moment)
	
	  @param d destination
	  @return succesful move
	*/
	public boolean setPos(int d) {
	  /**
	    River Exceptions:
	    Lion/Tiger can skip river tiles
	    Mouse can be on river tile
	  */
	  //pos = d;
	  return true;
	}
	
	/**
	  Gets the rank of the animal
	  @return rank
	*/
	public int getRank() {
	  return rank;
	}
	
	/**
	  Gets the position of animal
	  @return position
	*/
	public int getPos() {
	  return posX;
	}
	
	/**
	  Gets position of team den
	  @return den position
	*/
	public int getDenPos() {
	  return denPos;
	}
	
	/**
	  Gets status of body of animal
	  @return isAlive of animal
	*/
	public boolean getAlive() {
	  return isAlive;
	}
	
	/**
	  Kills animal from the game
	*/
	public void setAlive() {
	  isAlive = false;
	}
	
	/**
	  Gets name of animal
	  @return name of animal
	*/
	public String getName()
	{
	  return name;
	}
	
	/**
	  Gets color of animal
	  @return color of animal
	*/
	public String getColor() {
	  return color;
	}

}