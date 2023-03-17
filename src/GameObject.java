

/*
 * All objects in the simulation will need to contain a position on the grid
 */
public abstract class GameObject {
	private double xPos, yPos;
	
	public GameObject() {
		xPos = 0;
		yPos = 0;
	}
	public GameObject(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	//Accessors and Mutators
	public double getXPos() {
		return xPos;
	}
	public double getYPos() {
		return yPos;
	}
	public void setXPos(double xPos) {
		this.xPos = xPos;
	}
	public void setYPos(double yPos) {
		this.yPos = yPos;
	}
}