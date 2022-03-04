package Proj4;	// if Editor == Sublime: Comment this line

import	java.io.*;
import	java.lang.*;
import	java.util.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String fname = "Your_Firstname";
    private String lname = "Your_Lastname";
    private String uname = "Your_Username";
    private String pwd = "Your_Password";
    private String city = "Your_City";
    private String email = "Your_Email";
    private String doj = "01/01/0000";
    SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");

//	User() function overloading
//	public User () {
//		this.fname = "Your_Firstname";
//		this.lname = "Your_Lastname";
//		this.uname = "Your_Username";
//		this.pwd = "Your_Password";
//		this.city = "Your_City";
//		this.email = "Your_Email";
//		this.doj = "01/01/0000";
//	}

    public User (String inp_fname, String inp_lname, String inp_uname, String inp_pwd, String inp_city, String inp_email, String inp_doj) {
        this.fname = inp_fname;
        this.lname = inp_lname;
        this.uname = inp_uname;
        this.pwd = Utils.hashMe(inp_pwd);		// user defined hashing algorithm
        this.city = inp_city;
        this.email = inp_email;
        this.doj = inp_doj;
    }
    // getters
    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public String getUname() {
        return this.uname;
    }

    public String getFullname() {
        return this.fname + this.lname;
    }

    public String getPwd() {
        return Utils.hashMe(this.pwd);
    }

    public String getCity() {
        return this.city;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getDoj() throws Exception {
        return dateformat1.parse(this.doj);
    }

    // setters
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPwd(String pwd) {
        this.pwd = Utils.hashMe(pwd);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", doj='" + doj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUname().equals(user.getUname()) || getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUname(), getEmail());
    }
}

/*

1
fname
lname
uname
pwd
city
email
15/07/2002
1
fname
lname
uname
pwd
city
email2
15/07/2002
0

 */
