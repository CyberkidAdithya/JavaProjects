package Proj2;

// Application2Util.java
public class Song {
	String audName;
	String byName;
	Integer audDur;

	Song (String soname, String siname, int sodurmin, int sodursec) {
		this.audName = soname;	// 'this' keyword is not mandatory
		this.byName = siname;
		this.audDur = sodurmin * 60 + sodursec;
	}

	public Integer getDuration() {
		return audDur;
	}

	@Override
	public String toString() {
		return audName + "-->" + byName + " [ " + audDur + " ]";
	}
}