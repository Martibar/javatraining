package oca;

public class test1 {

	public static void main(String[] args) {
		
		Animal a = new Animal();
		Cosa c = new Cosa();
		Planeta p = new Planeta();
		
		
		imprimir(a);
		imprimir(c);
		//imprimir(p);
		
		System.out.println(a instanceof Describible); 
		System.out.println(c instanceof Describible); 
		System.out.println(p instanceof Describible); 
		
		System.out.println(a instanceof Object); 
		System.out.println(c instanceof Object); 
		System.out.println(p instanceof Object); 
		
		a.comer();
		c.romper();
		p.explotar();
		
		Describible a1 = new Animal();
		Describible c1 = new Cosa();
		// Describible p1 = new Planeta();
		
		System.out.println(a1.describir());
		
		a1 = new Cosa();
		
		System.out.println(a1.describir());
		System.out.println(c1.describir());
	}
	
	public static void imprimir(Describible x) {
		System.out.println(x.describir());
	}

}

interface Describible {
	String describir();
}

class Animal implements Describible {

	public String describir() {
		return "Este es un animal";
	}
	
	public void comer() {
		System.out.println("rico");
	}
	
}

class Cosa implements Describible {

	public String describir() {
		return "Esto es una cosa";
	}
	
	public void romper() {
		System.out.println("caro");
	}
	
}

class Planeta {
	
	public String describir() {
		return "Esto es un planeta";
	}
	
	public void explotar() {
		System.out.println("booom");
	}
}


