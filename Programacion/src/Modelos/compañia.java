package Modelos;

public class compañia {
	private String nombre;
	private String cobertura;
	private String forma_de_pago;
	private int telefono;
	public compañia(String nombre, String cobertura, String forma_de_pago, int telefono) {
		super();
		this.nombre = nombre;
		this.cobertura = cobertura;
		this.forma_de_pago = forma_de_pago;
		this.telefono = telefono;
	}
	public String getForma_de_pago() {
		return forma_de_pago;
	}
	public int getTelefono() {
		return telefono;
	}
	public String getNombre() {
		return nombre;
	}
	
	
	
}
