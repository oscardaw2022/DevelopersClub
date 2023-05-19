package Modelos;

public class Tarifa {
	
	private String Ncom;
	private double M300;
	private	double	M500;
	private	double	M600;
	private	double	G1;
	public Tarifa(String ncom, double m300, double m500, double m600, double g1) {

		Ncom = ncom;
		M300 = m300;
		M500 = m500;
		M600 = m600;
		G1 = g1;
	}
	@Override
	public String toString() {
		return "Tarifas de la compañia " + Ncom + ", para 300 megas " + M300 + ", para 500 megas " + M500 + ","
				+ "para 600 megas " + M600 + ", para 1 giga" + G1 + ", todas estas tarifas pueden variar.";
	}
		
	

}
