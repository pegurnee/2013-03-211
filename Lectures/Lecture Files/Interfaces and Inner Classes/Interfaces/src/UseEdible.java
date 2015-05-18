
public class UseEdible {
	public static void main(String[] args) {
		Tiger tigger = new Tiger();
		Chicken little = new Chicken();
		Apple fruit1 = new Apple();
		Orange fruit2 = new Orange();
		
		System.out.println("tigger goes " + tigger.sound());
		System.out.println("little goes " + little.sound());
		
		System.out.print("How do you eat an apple? ");
		System.out.println(fruit1.howToEat());
		
		
		System.out.print("How do you eat an orange? ");
		System.out.println(fruit2.howToEat());
		
		System.out.print("How do you eat a chicken? ");
		System.out.println(little.howToEat());
	}

}
