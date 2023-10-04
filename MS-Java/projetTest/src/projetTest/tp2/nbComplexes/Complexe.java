package projetTest.tp2.nbComplexes;

public class Complexe {
	private double a = 0;
	private double b = 0;
	
	public Complexe(double unA, double unB) {
		a = unA;
		b = unB;
	}
	
	public double module() {
		return (a*a) + (b*b);
	}
	
	public double argument() {
		return Math.cos(a/(a + b));
	}
	
	public double argument1() {
		return Math.sin(b/(a + b));
	}
	
	public static Complexe somme(Complexe a1, Complexe a2) 
	{
		Complexe a3 = new Complexe(0,0);
		
		a3.a = a1.a + a2.a;
		a3.b = a1.b + a2.b;
		
		return a3;
		
	}
	
	public static Complexe multi(Complexe a1, Complexe a2) 
	{
		Complexe a3 = new Complexe(0,0);
		
		a3.a = a1.a * a2.a - a1.b * a2.b;
		a3.b = a1.a * a2.b + a1.b * a2.b;
		
		return a3;
	}
	
	public String toString() {
		return ""+a + " + "+b + "i";
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}
	
}
