package Modelos;

public class oferta{

	private String ncom;
	private int n_linea;
	private double precio;
	private int ngigas;
	private String regalos;
	private int nofer;
	private int premanencia;
	private int nmegas;
	
	
	
	public oferta(String ncom, int n_linea, double precio, int ngigas, String regalos, int nofer, int premanencia, int nmegas) {

		this.ncom = ncom;
		this.n_linea = n_linea;
		this.precio = precio;
		this.ngigas = ngigas;
		this.regalos = regalos;
		this.nofer = nofer;
		this.premanencia = premanencia;
		this.nmegas = nmegas;
		
		if (this.regalos.equalsIgnoreCase(null)) {
			regalos = "no incluye regalos";
		}
	}



	public int getPremanencia() {
		return premanencia;
	}



	public double getPrecio() {
		return precio;
	}

	public int getNmegas() {
		return nmegas;
	}



	@Override
	public String toString() {
		return "La compañia: " + ncom + ", ofrece " + n_linea + " numeros de lineas, a un precio de" + precio + " euros. \n Este precio incluye " + ngigas
				+ "G , esta oferta tine de regalo(" + regalos + "), y tiene una premanencia de" + premanencia + " años, con unos megas en casa de " + nmegas
				+ "G ";
	 
	}



	

}
