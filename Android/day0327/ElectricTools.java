package day0327;

public class ElectricTools extends test {
	public void send(dome dome) {
		dome.test();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectricTools a = new ElectricTools();
		test b = new test();
		a.send(b);
	}

}
