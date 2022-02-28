package Proj0;

public class Triangle {
	int base, height;
	static int numofsides = 3;
	public Triangle (int usr_base, int usr_height) {
		this.base = usr_base;
		this.height = usr_height;
	}
	public float findArea () {
		return (this.base * this.height / 2);
	}
}