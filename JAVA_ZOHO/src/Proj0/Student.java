 package Proj0;

public class Student {
	String name;
	int age;
	int[] marks = new int[3];

	Student (String username, int userage, int usermarks[]) {
		name = username;
		age = userage;
		marks = usermarks.clone();
	}

	static double getaverage(int[] marks) {
		double tot = 0;
		for (int i = 0; i < 3; i++) {
			tot += marks[i];
		}
		return tot / 3;
	}

	@Override
	public String toString() {
		return name + " " + age + " " + "[" + marks[0] + "," + marks[1] + "," + marks[2] + "]";
	}
}