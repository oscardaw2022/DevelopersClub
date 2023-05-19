package bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Modelos.*;

public class BD_Tintegrada extends BD_Conector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Tintegrada(String bbdd) {
		super(bbdd);
	}

	public Vector<oferta> MostrarComp() {
		Vector<oferta> comp = new Vector<oferta>();
		String cadena = "SELECT * FROM ofertas";

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			while (reg.next()) {
				comp.add(new oferta(reg.getString(1), reg.getInt(2), reg.getDouble(3), reg.getInt(4), reg.getString(5), reg.getInt(6), reg.getInt(7), reg.getInt(8)));
			}
			s.close();
			this.cerrar();
			return comp;
		} catch (SQLException e) {
			this.cerrar();
			return null;
		}

	}
	public Vector<compañia> ListarComp() {
		Vector<compañia> compa = new Vector<compañia>();
		String cadena = "SELECT * FROM compañias";

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			while (reg.next()) {
				compa.add(new compañia(reg.getString(1),reg.getString(2),reg.getString(3),reg.getInt(4)));
			}
			s.close();
			this.cerrar();
			return compa;
		} catch (SQLException e) {
			this.cerrar();
			return null;
		}

	}
	public Tarifa MostrarTar(String Ncom) {
		Tarifa tar=null;
		String cadena = "SELECT * FROM tarifa WHERE NCOM LIKE '" + Ncom +"'";

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next()) {
				tar = new Tarifa(reg.getString(1), reg.getInt(2), reg.getInt(3), reg.getInt(4), reg.getInt(5));
			}
			s.close();
			this.cerrar();
			return tar;
		} catch (SQLException e) {
			this.cerrar();
			return null;
		}

	}
	public Vector<oferta> BusquedaMegas(String megasmin, String megasmax) {
		
		if (megasmax.equalsIgnoreCase("")) {
			megasmax = "100000000";
		}
		if (megasmin.equalsIgnoreCase("")) {
			megasmin = "0";
		}
		String cadena = "SELECT * FROM ofertas WHERE Nmegas BETWEEN " + Integer.parseInt(megasmin) +" and " + Integer.parseInt(megasmax);
		Vector<oferta> bus = new Vector<oferta>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			while (reg.next()) {
				bus.add(new oferta(reg.getString(1), reg.getInt(2),reg.getDouble(3), reg.getInt(4), reg.getString(5),reg.getInt(6),reg.getInt(7),reg.getInt(8)));
			}
			s.close();
			this.cerrar();
			return bus;
		} catch (SQLException e) {
			this.cerrar();
			return null;
		}

	}
	public Boolean IniSes(String usu, String pass) {
		String passw = "";
		if (usu.equalsIgnoreCase("")){
			return null;
		}
		if (pass.equalsIgnoreCase("")) {
			return null;
		}
		String cadena = "Select * FROM usuarios WHERE nombre LIKE '"+usu+"'";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next()) {
				passw = reg.getString("password");
			}
			
			s.close();
			this.cerrar();
			
			if (passw.equalsIgnoreCase(pass)) {
				return true;
			}else {
				return false;
			}

		} catch (SQLException e) {
			this.cerrar();
			return null;
		}
	}
	
	public int CerSes(String dni,String nom, String ape, int tel,String corr, String pass) {
		if (nom.equalsIgnoreCase("")) {
			return -1;
		}
		if (pass.equalsIgnoreCase("")) {
			return -2;
		}
		if (dni.equalsIgnoreCase("")) {
			return -3;
		}
		if (dni.length() > 9) {
			return -4;
		}
		String cadena = "INSERT INTO USUARIOS VALUES('"+dni+"','"+nom+"','"+ape+"',"+tel+",'"+corr+"','"+pass+"')";
		try {
			this.abrir();
			s = c.createStatement();
			s.executeUpdate(cadena);
			return 1;
		} catch (SQLException e) {
			this.cerrar();
			return 0;
		}
		
	}

}
