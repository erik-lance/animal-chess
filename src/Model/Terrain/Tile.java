package Model.Terrain;
import Model.Animals.*;
/*
	This class represents each tile of the board game in which the pieces can occupy using the
	occupant Piece type variable. When this variable has a non-null element then it the boolean
	variable occupied changes into a value of true.
*/
public abstract class Tile{
	  private Piece occupant;
	  private boolean occupied;
	  /*This is the constructor for the abstract class Tile*/
	  public Tile(){
	  }
	  /*This function checks if the tiles is occupied according to the boolean variable occupied*/
	  public boolean checkOccupied(){
	    return occupied;
	  }
	  /*
		This function assigns mPiece to the variable occupant. It also checks if mPiece is 
		null or an actual piece because if it is null then it will change the boolean variable to false.
		
		@param mPiece moved Piece: Piece Class Type
	  */
	  public void setPiece(Piece mPiece){
	    occupant = mPiece;
	    if(mPiece != null)
	      occupied = true;
	    else
	      occupied = false;
	  }
	  /*This function returns the Piece type variable occupant
	   * @return occupant of tile of type piece
	   * */
	  public Piece getPiece(){
	    return occupant;
	  }
	}