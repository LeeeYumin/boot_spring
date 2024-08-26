package hw0826;

public class Employee {
	public int pay;

	void getSalary(int pay) {
		System.out.println(pay);
	}
}

class Manager extends Employee {

	public int bonus;

	void getSalary(int pay, int bonus) {
		System.out.println(pay + bonus);
	}

}
