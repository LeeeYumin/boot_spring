package hw0826;

class Cat extends Animal {

	@Override
	void sound() {
		System.out.println("고양이는 냐옹");
	}
	
	void parentSound() {
		super.sound();
	}
	
}
