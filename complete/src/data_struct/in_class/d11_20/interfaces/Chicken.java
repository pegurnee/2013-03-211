package data_struct.in_class.d11_20.interfaces;

public class Chicken extends Animal implements Edible{
	@Override
	public String sound(){
		return "Cock-a-doodle-doo!";
	}
	
	@Override
	public String howToEat(){
		return "Roast it.";
	}

}
