package temp;

public class StaticClass {

	int i = 0;
	static int j = 0;

	public static void main(String[] arg) {

		StaticClass obj = new StaticClass();
		StaticClass obj2 = new StaticClass();

		obj.name();
		obj.name();
		obj.name();

		obj2.name();

		nameStat();
		nameStat();
		nameStat();

		nameStat();
	}

	public void name() {
		i++;
		System.out.println("Value of i: " + i);

	}

	public static void nameStat() {
		j++;
		System.out.println("Value of j: " + j);
	}

}
