

/*
 * All creatures will have an energy value
 * All creatures will start with 10 energy
 */
public class Creature extends GameObject{
	private int energy; //Current energy of the creature, used for various functions
	private int reproduceVal; //The energy value needed to be exceeded to create another creature object
	
	public Creature() {
		super();
		energy = 10;
		reproduceVal = 20;
	}
	public Creature(double xPos, double yPos, int energy, int reproduceVal) {
		super(xPos, yPos);
		this.energy = energy;
		this.reproduceVal = reproduceVal;
	}
	
	//Accessors and Mutators
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getReproduceVal() {
		return reproduceVal;
	}
	public void setReproduceVal(int reproduceVal) {
		this.reproduceVal = reproduceVal;
	}
	
	/*
	 * Possible candidates for die method
	 */
	//If a creature has 0 energy it will die
	//This system will also be used for consuming another creature
	//public void checkDie(Creature creature) {
	//	if(creature.getEnergy() <= 0)
	//		creature = null;
	//}
	
	//Same as above method only it places the object off map
	//Could add another method in main that checks for off map entities and garbage collects them
	public void checkDie() {
		double xPos = -1;
		double yPos = -1;
		if(getEnergy() <= 0) {
			setXPos(xPos);
			setYPos(yPos);
		}
	}
	
	/*
	 * Need code for collisions, two creatures should not occupy the same space!
	 */
}