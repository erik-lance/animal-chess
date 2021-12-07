package Model;
import java.util.ArrayList;
import Model.Animals.*;

/*
	This class replaces the Player in a real world game. Its identifier is its assigned color. It owns an arrayList of pieces in which
	are reflected on the board through copies. Each player has the same number of pieces and this class is used to manipulate the date 
	of the pieces' copies on the board.

*/
public class Player{
	  private String color;
	  private ArrayList<Piece> pieces;
	   /*
		This is the contructor for Player class. It needs a color parameter which it uses to construct and add the pieces of the player to the pieces array list. 

		@param c Color: String type
	  */
	  public Player(String c){
	    color = c;
	    pieces = new ArrayList<Piece>();
	    pieces.add(new Mouse(color));
	    pieces.add(new Cat(color));
	    pieces.add(new Wolf(color));
	    pieces.add(new Dog(color));
	    pieces.add(new Leopard(color));
	    pieces.add(new Tiger(color));
	    pieces.add(new Lion(color));
	    pieces.add(new Elephant(color));
	  }
	  /*
		This function returns the color of the Player
		@return player's color in String
	  */
	  public String getColor() {
		  return color;
	  }

	  /*
	    This function returns the piece of the player using the parameter rank. It expects that the parameter rank be between 1 and 8 as this signifies the rank of the requested piece. It returns the piece in the index of rank - 1.

	    @param rank: integer type
	    @return piece at certain rank
	  */
	  public Piece getPiece(int rank){
	    return pieces.get(rank - 1);
	  }
	  /*
	    This Function sets the piece of the given rank to dead signalling that it has been captured.

	    @param rank integer Type
	  */
	  public void togglePiece(int Rank){
	    pieces.get(Rank-1).setDead();
	  }
	  /*
	    This function checks if a player has won by checking if the player has a piece in the Den or if the opponent has all dead pieces through. Through a for loop running 8 times, it checks the terrain of the player's pieces if it is in a den and if yes it returns true signalling a winner. If no piece is in the den then it checks the opponents pieces if there is still a piece alive through a for loop running 8 times if not then it returns true.

	    @param opponent Player type Class
	    @return outcome true if den entered or wiped out enemies, false otherwise.
	  */
	  public boolean CheckWin(Player opponent){
	    //Checks if the Player has a Piece in the Den
	    for(int y = 1; y <= 8; y++)
	      if(pieces.get(y-1).getTerrain() == "Den")
	        return true;
	    //Checks if Opponent still has Pieces on the Board
	    for(int x = 1; x <= 8; x++)
	      if(opponent.getPiece(x).getAlive())
	        return false;
	    return true;
	  }
	   /*
		This function replaces a players action of moving a piece. It checks if the destination tile is occupied and if it is then it sets the piece to dead in the pieces of the opponent. It then sets the piece inside the origin tile to null signalling an empty tile. Lastly it updates the piece inside the destination tile as well as the coordinates of the moved piece using setTile() and setCords().

		@param board Board class Type
		@param mPiece moving Piece; Piece class Type
		@param newCords new Coordinates: integer[] Tyoe
		@param opponent Player class Type
	  */
	  public void movePiece(Board board, Piece mPiece, int[] newCords, Player opponent){
		    //Sets captured Opponent Piece to Dead (sets alive to false)
		  	int destX = newCords[0];
		  	int destY = newCords[1];
		  
		    if(board.getTile(newCords[0], newCords[1]).checkOccupied())
		      opponent.togglePiece(board.getTile(newCords[0], newCords[1]).getPiece().getRank());
		    //Sets Previous Tile's Piece to null
		    board.setTile(null, mPiece.getCords()[0], mPiece.getCords()[1]);
		    //Changes the Piece inside the destination Tile
		    board.setTile(mPiece, newCords[0], newCords[1]);
		    //Updates the New Cords and Terrain of the Moved Piece
		    pieces.get(mPiece.getRank() - 1).setCords(destX, destY, board.getTerrain(destX, destY));
	   }
}