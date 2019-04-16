package dai0402;

public class Person {
	public void send(Abstract tools) {
		tools.send();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		Realization reslization = new Realization();
		person.send(reslization);
	}

}
