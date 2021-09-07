package biosim;

import java.util.Random;

public class Animal {
	private String name;
	private String classAnimal;
	private double posXPe;
	private double posYPe;
	private double posXSa;
	private double posYSa;
	private double posXPa;
	private double posYPa;
	
	//Peixe
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getClassAnimal() {
		return classAnimal;
	}
	
	public void setClassAnimal(String classAnimal) {
		this.classAnimal = classAnimal;
	}
	
	public double getPosXPeixe() {
		return posXPe;
	}
	
	public void setPosXPeixe(double x) {
		this.posXPe = x;
	}
	
	public double getPosXSapo() {
		return posXSa;
	}
	
	public void setPosXSapo(double x) {
		this.posXSa = x;
	}
	
	public double getPosXPassaro() {
		return posXPa;
	}
	
	public void setPosXPassaro(double x) {
		this.posXPa = x;
	}
	
	public double getPosYPeixe() {
		return posYPe;
	}
	
	public void setPosYPeixe(double y) {
		this.posYPe = y;
	}
	
	public double getPosYSapo() {
		return posYSa;
	}
	
	public void setPosYSapo(double y) {
		this.posYSa = y;
	}
	
	public double getPosYPassaro() {
		return posYPa;
	}
	
	public void setPosYPassaro(double y) {
		this.posYPa = y;
	}
	
	//Peixe
	public void moverPeixe(double x, double y) {
		Random rand = new Random();
		int i = rand.nextInt(2);
		
		if (i == 0) {
			this.posXPe = x + 1;
		}
		else {
			this.posYPe = y + 1;
		}
	}
	
	//Sapo
	public void moverSapo(double x, double y) {
		Random rand = new Random();
		int i = rand.nextInt(2);
		
		if (i == 0) {
			this.posXSa = x + 1.5;
		}
		else {
			this.posYSa = y + 1.5;
		}
	}
	
	//Passaro
	public void moverPassaro(double x, double y) {
		Random rand = new Random();
		int i = rand.nextInt(2);
		
		if (i == 0) {
			this.posXPa = x + 3;
		}
		else {
			this.posYPa = y + 3;
		}
	}
}
