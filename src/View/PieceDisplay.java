package View;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

@SuppressWarnings("serial")
/**
 * A JLabel piece used for display on view. Earns an image icon
 * based on the animal's rank constructed onto it, as well as color.
 * */
public class PieceDisplay
		extends JLabel {
	
	protected int rank;
	protected String colS;
	
	//private Path path;
	
	/**
	 * Constructs a new piece using rank and color.
	 * @rank r determines the type of animal
	 * @rank c determines the team or color of the animal
	 * */
	public PieceDisplay(int r, String c) {
	    //setOpaque(true);
	    
	    setPreferredSize(new Dimension(50,50));
	    Color color = (c.equals("Red")) ? Color.red : Color.blue;
	    colS = c;
	    rank = r;
	    //setBackground(color);
	    
	    URL imgIcon = null;
	    if (color == Color.red) { 
	    	if 		(r == 1) {imgIcon = getClass().getResource("icons/MouseRed.png");}
	    	else if (r == 2) {imgIcon = getClass().getResource("icons/CatRed.png");}
	    	else if (r == 3) {imgIcon = getClass().getResource("icons/WolfRed.png");}
	    	else if (r == 4) {imgIcon = getClass().getResource("icons/DogRed.png");}
	    	else if (r == 5) {imgIcon = getClass().getResource("icons/LeopardRed.png");}
	    	else if (r == 6) {imgIcon = getClass().getResource("icons/TigerRed.png");}
	    	else if (r == 7) {imgIcon = getClass().getResource("icons/LionRed.png");}
	    	else if (r == 8) {imgIcon = getClass().getResource("icons/ElephantRed.png");}
	    	else 			{imgIcon = getClass().getResource("icons/Unknown.png");}
	    }
	    else {
	    	if 		(r == 1) {imgIcon = getClass().getResource("icons/MouseBlue.png");}
	    	else if (r == 2) {imgIcon = getClass().getResource("icons/CatBlue.png");}
	    	else if (r == 3) {imgIcon = getClass().getResource("icons/WolfBlue.png");}
	    	else if (r == 4) {imgIcon = getClass().getResource("icons/DogBlue.png");}
	    	else if (r == 5) {imgIcon = getClass().getResource("icons/LeopardBlue.png");}
	    	else if (r == 6) {imgIcon = getClass().getResource("icons/TigerBlue.png");}
	    	else if (r == 7) {imgIcon = getClass().getResource("icons/LionBlue.png");}
	    	else if (r == 8) {imgIcon = getClass().getResource("icons/ElephantBlue.png");}
	    	else 			{imgIcon = getClass().getResource("icons/Unknown.png");}
	    }
	    setIcon(new ImageIcon(imgIcon));
	    
	    //setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    revalidate();
	    repaint();
	}
	
	/**
	 * Gets the color of the animal to determine the team.
	 * @return colS the color and side of the animal
	 * */
	public String getColor() {
		return colS;
	}
	
	/**
	 * Gets the rank of animal for reference.
	 * @return rank of animal to distinguish type of animal
	 * */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Changes the piece's skin based on rank and color provided.
	 * @param r rank of piece, which determines the type of animal
	 * @param c color of piece, which determines the team of animal
	 * */
	public void setRank(int r, String string) {
		URL imgIcon = null;
		if (string == "Red") { 
	    	if 		(r == 1) {imgIcon = getClass().getResource("icons/MouseRed.png");}
	    	else if (r == 2) {imgIcon = getClass().getResource("icons/CatRed.png");}
	    	else if (r == 3) {imgIcon = getClass().getResource("icons/WolfRed.png");}
	    	else if (r == 4) {imgIcon = getClass().getResource("icons/DogRed.png");}
	    	else if (r == 5) {imgIcon = getClass().getResource("icons/LeopardRed.png");}
	    	else if (r == 6) {imgIcon = getClass().getResource("icons/TigerRed.png");}
	    	else if (r == 7) {imgIcon = getClass().getResource("icons/LionRed.png");}
	    	else if (r == 8) {imgIcon = getClass().getResource("icons/ElephantRed.png");}
	    	else 			{imgIcon = getClass().getResource("icons/Unknown.png");}
	    }
	    else {
	    	if 		(r == 1) {imgIcon = getClass().getResource("icons/MouseBlue.png");}
	    	else if (r == 2) {imgIcon = getClass().getResource("icons/CatBlue.png");}
	    	else if (r == 3) {imgIcon = getClass().getResource("icons/WolfBlue.png");}
	    	else if (r == 4) {imgIcon = getClass().getResource("icons/DogBlue.png");}
	    	else if (r == 5) {imgIcon = getClass().getResource("icons/LeopardBlue.png");}
	    	else if (r == 6) {imgIcon = getClass().getResource("icons/TigerBlue.png");}
	    	else if (r == 7) {imgIcon = getClass().getResource("icons/LionBlue.png");}
	    	else if (r == 8) {imgIcon = getClass().getResource("icons/ElephantBlue.png");}
	    	else 			{imgIcon = getClass().getResource("icons/Unknown.png");}
	    }
		
		setIcon(new ImageIcon(imgIcon));
	}
	  

	  
	  

}
