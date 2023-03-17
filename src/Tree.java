

/*
 * A tree is a producer with a set reproduce value and grow speed configuration
 * Reproduce value and grow speed will be consistent for all Trees
 */
public class Tree extends Producer {
	public Tree(double xPos, double yPos) { //Only position is unique to each Tree
		super(xPos, yPos, 10, 20, 2); //Preset values for starting energy, reproduceVal, and growthSpeed
	}
	
	//Example of the inter-class update
	public void update() {
		System.out.println(getEnergy());
		grow();
		
		//Below is dummy code for creating a new Tree object
		if(getEnergy() >= getReproduceVal())
		{
			//Check if the space is occupied in final program!
			//Generate a random bordering position
			//Add new object to the master list
			Tree tree = new Tree(getXPos()+1, getYPos()+1);
			setEnergy(10); //Reset this tree's energy
		}
		
		System.out.println(getEnergy());
		checkDie();
	}
}