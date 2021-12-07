import Model.Model;
import View.View;
/**
	The Animal Chess Game. Done in MVC Framework.
	@author Mangoba, Michael Jhullian G.
	@author Tiongquico, Erik Lance L.

*/
public class GUI {

	public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller c = new Controller(v, m);
	}

}
