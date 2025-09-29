import java.io.*;
    public class Driver {
	public static void main(String [] args) throws IOException{
	Polynomial p = new Polynomial();
	System.out.println(p.evaluate(3));
	double [] c1 = {6,5};
	int [] d1 = {0, 3};
	Polynomial p1 = new Polynomial(c1, d1);
	double [] c2 = {-2,-9};
	int [] d2 = {1,4};
	Polynomial p2 = new Polynomial(c2, d2);
	Polynomial s = p1.add(p2);
	File file1 = new File("file1.txt");
	Polynomial q = new Polynomial(file1);
	s.saveToFile("file2");
	System.out.println("There should be a file named file2 with the polynomial expression of polynomial s");
	System.out.println("Below are the three coefficients of polynomial q taken from file1");
	System.out.println(q.x[0]);
	System.out.println(q.x[1]);
	System.out.println("Below are the three powers of each coefficient of polynomial q taken from file1");
	System.out.println(q.y[0]);
	System.out.println(q.y[1]);   
	System.out.println("s(0.1) = " + s.evaluate(0.1));
	if(s.hasRoot(1)){
	    System.out.println("1 is a root of s");
	}       
	else{
	    System.out.println("1 is not a root of s");
	}
	Polynomial r = q.multiply(p2);
	System.out.println("Below are the 6 coefficients of polynomial r made by multiplying polynomial q with polynomial p2");
	System.out.println(r.x[0]);
	System.out.println(r.x[1]);
	System.out.println(r.x[2]);
	System.out.println(r.x[3]);
	System.out.println("Below are the 6 powers of each coefficient of polynomial r made by multiplying polynomial q with polynomial p2");
	System.out.println(r.y[0]);
	System.out.println(r.y[1]);
	System.out.println(r.y[2]);
	System.out.println(r.y[3]);
	System.out.println("r(0.1) = " + r.evaluate(0.1));
    }
}
