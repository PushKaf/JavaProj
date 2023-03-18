

/*
 * Producers will create energy
 * Producers will not have a move method but can still reproduce
 */
public class Producer extends Creature {
	private int growSpeed; //The amount of energy gained each cycle of growth
	
	public Producer() {
		super();
		growSpeed = 1;
	}
	public Producer(double xPos, double yPos, int energy, int reproduceVal, int growSpeed) {
		super(xPos, yPos, energy, reproduceVal);
		this.growSpeed = growSpeed;
	}
	
	public void grow() {
		setEnergy(getEnergy() + growSpeed);
	}
	
	public int getGrowSpeed() {
		return growSpeed;
	}
	public void setGrowSpeed(int growSpeed) {
		this.growSpeed = growSpeed;
	}
}