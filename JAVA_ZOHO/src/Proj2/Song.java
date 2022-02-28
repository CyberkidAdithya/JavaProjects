package Proj2;

// Application2Util.java
public class Song {
	String audName;
	String byName;

	Song (String soname, String siname) {
		this.audName = soname;	// 'this' keyword is not mandatory
		this.byName = siname;
	}

	@Override
	public String toString() {
		return audName + "-" + byName;
	}
}