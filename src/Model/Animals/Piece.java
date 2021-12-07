package Model.Animals;
/*
	This class replaces the concept of pieces in a real life boardgame.
	Being an abstract class, it can be in the form of any of the 8 types
	of pieces. Each pieces' identifier is their color and rank. This class
	also stores their data on the board such as their coordinates, tile terrain,
	and as well as their status of either in play or not.
*/
public abstract class Piece{
	  private final String color;
	  private final int rank;
	  private String terrain;
	  private int[] cords;
	  private boolean alive;
	  
	  /*
		This is the constructor for abstract Class Piece. It requires the 
		Color and rank of the piece which it uses as the values of variables 
		color and rank. It then sets the default value of terrain into grass 
		and after which it initializes the cords integer array and finally 
		sets the boolean variable alive into true

		@param c Color: String Type
		@param r Rank: integer Type
	  */
	  public Piece(String c, int r){
	    color = c;
	    rank = r;
	    terrain = "Grass";
	    cords = new int[2];
	    alive = true;
	  }
	  /*
		This function sets the coordinates and terrain of the piece.

		@param r row: integer Type
		@param c column: integer Type
		@param t terrain: String Type
	  */
	  public void setCords(int r, int c, String t){
	    cords[0] = r;
	    cords[1] = c;
	    terrain = t;
	  }
	  /*This Function returns the integer array cords
	   * @return cords[2] where [0] is the Y coordinate and [1] is the X coordinate
	   * */
	  public int[] getCords(){
	    return cords;
	  }
	  /*This Function returns the terrain on which the piece is on
	   * @return terrain type of tile in string
	   * */
	  public String getTerrain(){
	    return terrain;
	  }
	  /*This Function returns the rank of the Piece
	   * @return rank integer of piece (1-8)
	   * */
	  public int getRank(){
	    return rank;
	  }
	  /*This Function returns the Color of the piece
	   * @return color string of piece
	   * */
	  public String getColor(){
	    return color;
	  }
	  /*This Function returns whether piece is alive or not (True or False)
	   * @return alive of piece whether it is still in game or not
	   * */
	  public boolean getAlive(){
	    return alive;
	  }
	  /*
	   * This Function sets the boolean variable alive to false signalling the death of the piece
	   * */
	  public void setDead(){
	    alive = false;
	  }
	  /*
	   * This Function sets the boolean variable alive to true signalling the piece is in Play
	   * */
	  public void setAlive(){
	    alive = true;
	  }
	}