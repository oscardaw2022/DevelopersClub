package Main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import bbdd.*;
import Modelos.*;
import Orden.*;

public class MenuGUI extends JFrame implements ActionListener {

	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn8, btn9, btn10,btn11;

	BD_Tintegrada bd = new BD_Tintegrada("tintegrada");

	public MenuGUI() {

		setTitle("DevelopersClub");
		boxsize();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Creamos el panel principal
		JPanel panelPrincipal = new JPanel(new GridLayout(3,2));
		JLabel usuario, contra;
		JTextField user = new JTextField(), pass = new JTextField();
		
	
		usuario = new JLabel("Introduzca el usuario");
		contra = new JLabel("Introduzca contraseña del usuario");
	
		JButton IniSes = new JButton("Iniciar Sesion");
		JButton CreSes = new JButton("Crear Usuario");
		
		panelPrincipal.add(usuario);
		panelPrincipal.add(user);
		panelPrincipal.add(contra);
		panelPrincipal.add(pass);
		panelPrincipal.add(IniSes);
		panelPrincipal.add(CreSes);
		
		IniSes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean inic= bd.IniSes(user.getText(),pass.getText());
				if (inic == null) {
					JOptionPane.showMessageDialog(null, "EL USUARIO INTRODUCIDO NO EXISTE");
				}else if(inic) {
					getContentPane().removeAll();
					getContentPane().revalidate();
					getContentPane().repaint();
					Menu();
				}else {
					JOptionPane.showMessageDialog(null, "EL CREDENCIALES INCORRECTAS");
				}
				
			}
		});
		CreSes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				CrearUsuario();
				
				
			}
		});
		
		
		
		// Añadimos el panel principal al JFrame
			getContentPane().add(panelPrincipal);

		// Hacemos visible la interfaz gráfica
			setVisible(true);

	}

	// Método que se ejecuta al hacer clic en algún botón
	public void actionPerformed(ActionEvent e) {

		JLabel  ptn8 = null;
		JButton sal = new JButton("Volver");
		Vector<oferta> comp = new Vector<oferta>();
		Vector<compañia> compa = new Vector<compañia>();
		if (e.getSource() == btn1) {
			boxsize();
			
			//listar compañias
			//Vector<compañia> compa = new Vector<compañia>();
			compa = bd.ListarComp();
			JPanel panelcaso1 = new JPanel(new GridLayout(compa.size() + 1, 0));
			
			
			
			Vector<JLabel> botones = new Vector<JLabel>();
			for (int i = 0; i < compa.size(); i++) {
				botones.add(i, new JLabel(compa.get(i).getNombre()));
			}

			setTitle("Compañías");

			for (int i = 0; i < botones.size(); i++) {
				panelcaso1.add(botones.get(i));
			}

			Limpieza(panelcaso1, sal);

		} else if (e.getSource() == btn2) {

			setTitle("Ofertas De las compañias");
			setSize(800, 600);
			setLocation(25, 100);

			comp = bd.MostrarComp();
			JPanel panelcaso2 = new JPanel(new GridLayout(comp.size() + 2, 1));
			Vector<JLabel> botones = new Vector<JLabel>();
			for (int i = 0; i < comp.size(); i++) {
				botones.add(i, new JLabel(comp.get(i).toString()));
			}
			ptn8 = new JLabel(" COMPAÑIAS: ");
			panelcaso2.add(ptn8);
			for (int i = 0; i < botones.size(); i++) {
				panelcaso2.add(botones.get(i));
			}
			Limpieza(panelcaso2, sal);

		} else if (e.getSource() == btn3) {

			setTitle("Precios ordenados en su máxima tarifa");
			setSize(800, 600);
			setLocation(25, 100);

			comp = bd.MostrarComp();
			Collections.sort(comp, new OrdenarPrecio());

			JPanel panelcaso2 = new JPanel(new GridLayout(comp.size() + 2, 1));

			Vector<JLabel> botones = new Vector<JLabel>();
			for (int i = 0; i < comp.size(); i++) {
				// botones.set(i,new JLabel (compa.get(i).getNombre()));
				botones.add(i, new JLabel(comp.get(i).toString()));
			}

			ptn8 = new JLabel(" COMPAÑIAS: ");
			panelcaso2.add(ptn8);
			for (int i = 0; i < botones.size(); i++) {
				panelcaso2.add(botones.get(i));
			}

			Limpieza(panelcaso2, sal);

		} else if (e.getSource() == btn4) {

			setTitle("Precios ordenados de las ofertas por Permanencia");
			setSize(800, 600);
			setLocation(25, 100);

			comp = bd.MostrarComp();
			Collections.sort(comp, new OrdenarPermanencia());

			JPanel panelcaso2 = new JPanel(new GridLayout(comp.size() + 2, 1));
			Vector<JLabel> botones = new Vector<JLabel>();

			for (int i = 0; i < comp.size(); i++) {
				botones.add(i, new JLabel(comp.get(i).toString()));
			}
			ptn8 = new JLabel(" COMPAÑIAS: ");
			panelcaso2.add(ptn8);
			for (int i = 0; i < botones.size(); i++) {
				panelcaso2.add(botones.get(i));
			}

			Limpieza(panelcaso2, sal);

		} else if (e.getSource() == btn5) {

			setTitle("Seleccione compañía");
			boxsize();

			Vector<JButton> boton = new Vector<JButton>();
			compa = bd.ListarComp();

			JPanel panelcaso2 = new JPanel(new GridLayout(compa.size() + 1, 1));

			for (int i = 0; i < compa.size(); i++) {
				boton.add(i, new JButton(compa.get(i).getNombre()));
			}

			for (int i = 0; i < compa.size(); i++) {
				Tarifa tar = bd.MostrarTar(compa.get(i).getNombre());

				boton.get(i).addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						JOptionPane.showMessageDialog(null, tar.toString());

					}
				});

			}

			for (int i = 0; i < boton.size(); i++) {
				panelcaso2.add(boton.get(i));
			}

			Limpieza(panelcaso2, sal);

		} else if (e.getSource() == btn6) {

			menubusqueda(sal);

		} else if (e.getSource() == btn8) {
			compa = bd.ListarComp();
			JPanel panelcaso1 = new JPanel(new GridLayout(compa.size() + 1, 0));
			
			Vector<JLabel> telf = new Vector<JLabel>();		
			for (int i = 0; i < compa.size(); i++) {
				telf.add(i,new JLabel("El telefono de contaco gratuio de la compañia " + compa.get(i).getNombre() + " es " + String.valueOf(compa.get(i).getTelefono())));	
			}
			for (int i = 0; i < telf.size(); i++) {
				panelcaso1.add(telf.get(i));
			}

			Limpieza(panelcaso1, sal);
			
		} else if (e.getSource() == btn9) {
			compa = bd.ListarComp();
			JPanel panelcaso1 = new JPanel(new GridLayout(compa.size() + 1, 0));
			
			Vector<JLabel> telf = new Vector<JLabel>();		
			for (int i = 0; i < compa.size(); i++) {
				telf.add(i,new JLabel("Informacion de pago de " + compa.get(i).getNombre() + " es " + compa.get(i).getForma_de_pago()));	
			}
			for (int i = 0; i < telf.size(); i++) {
				panelcaso1.add(telf.get(i));
			}

			Limpieza(panelcaso1, sal);
		} else if (e.getSource() == btn10) {
			getContentPane().removeAll();
			getContentPane().revalidate();
			getContentPane().repaint();

		}
	}

	public static void main(String[] args) {
		new MenuGUI();
	}

	public void boxsize() {
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

	public void Menu() {
		setTitle("Menu de opciones");
		boxsize();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Creamos el panel principal
		JPanel panelPrincipal = new JPanel(new GridLayout(10, 1));

		btn1 = new JButton("Ver las compañias");
		btn2 = new JButton("Ofertas de compañías");
		btn3 = new JButton("Ordenar por precio ofertas");
		btn4 = new JButton("Ordenar por duración de contrato");
		btn5 = new JButton("Tarifas");
		btn6 = new JButton("Buscar por megas");
		btn8 = new JButton("Telefono fijo");
		btn9 = new JButton("Información de forma de pago");
		btn11 = new JButton("Cerrar sesion");		
		btn10 = new JButton("Salir");
		

		// Asignamos un ActionListener a cada botón
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuGUI();
			}
		});

		// Añadimos los botones al panel principal
		panelPrincipal.add(btn1);
		panelPrincipal.add(btn2);
		panelPrincipal.add(btn3);
		panelPrincipal.add(btn4);
		panelPrincipal.add(btn5);
		panelPrincipal.add(btn6);
		panelPrincipal.add(btn8);
		panelPrincipal.add(btn9);
		panelPrincipal.add(btn11);
		panelPrincipal.add(btn10);

		// Añadimos el panel principal al JFrame
		getContentPane().add(panelPrincipal);

		// Hacemos visible la interfaz gráfica
		setVisible(true);

	}

	public void menubusqueda(JButton sal) {
		JPanel panelBusqueda = new JPanel(new GridLayout(3, 2));
		JLabel part1 = new JLabel("Introduzca el minimo de megas");
		boxsize();
		panelBusqueda.add(part1);
		Vector<JTextField> text = new Vector<JTextField>();

		setTitle("Seleccione el número de megas");
		// Caja de texto de búsqueda
		JTextField cajaTexto = new JTextField();
		cajaTexto.setPreferredSize(new Dimension(300, 30));
		panelBusqueda.add(cajaTexto, BorderLayout.CENTER);
		text.add(cajaTexto);

		JLabel part2 = new JLabel("Introduzca el maximo de megas");
		panelBusqueda.add(part2);

		JTextField cajaTexto2 = new JTextField();
		cajaTexto.setPreferredSize(new Dimension(300, 30));
		panelBusqueda.add(cajaTexto2, BorderLayout.CENTER);
		text.add(cajaTexto2);
		
		sal = new JButton("Menu");
		Limpieza(panelBusqueda, sal);
		
		JButton botonBusqueda = new JButton("Buscar");
		panelBusqueda.add(botonBusqueda);

		
		botonBusqueda.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String textoBusqueda = cajaTexto.getText();
				String textoBusqueda2 = cajaTexto2.getText();
				setTitle("Aqui se muestran los megas entre " + textoBusqueda + " y " + textoBusqueda2);
				Vector<oferta> bus = bd.BusquedaMegas(textoBusqueda, textoBusqueda2);
				JPanel panelBusqueda = new JPanel(new GridLayout(bus.size() + 1, 1));
				
				setSize(800, 600);
				setLocation(25, 100);
				Vector<JLabel> ofer = new Vector<JLabel>();
				for (int i = 0; i < bus.size(); i++) {
					ofer.add(new JLabel(bus.get(i).toString()));
				}

				for (int i = 0; i < ofer.size(); i++) {
					panelBusqueda.add(ofer.get(i));
				}
				JButton salida = new JButton("<- Atras");
				VolverAtras(panelBusqueda, salida);

			}
		});
		
	}

	public void Limpieza(JPanel panelcaso2, JButton sal) {

		panelcaso2.add(sal);
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane().add(panelcaso2);
		pack();
		setVisible(true);
		sal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				Menu();
			}
		});
	}

	public void VolverAtras(JPanel panelcaso2, JButton sal) {

		panelcaso2.add(sal);
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		getContentPane().add(panelcaso2);
		pack();
		setVisible(true);
		sal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				menubusqueda(sal);
			}
		});
	}
	public void CrearUsuario() {
		setTitle("DevelopersClub");
		boxsize();
		setLocationRelativeTo(null);
		JPanel panelPrincipal = new JPanel(new GridLayout(7,2));
		JLabel DNI, nom, ape,tel, corr,pass;
		JTextField pdni= new JTextField(),pnom= new JTextField();
		JTextField pape = new JTextField(),ptel= new JTextField()
				,pcorr= new JTextField(),ppass= new JTextField();
		JButton crear = new JButton("Crear"), volver = new JButton("<- Volver");
		DNI= new JLabel("Introduce DNI");
		nom= new JLabel("Introduce nombre");
		ape= new JLabel("Introduce apellidos");
		tel= new JLabel("Introduce telefono");
		corr= new JLabel("Introduce correo");
		pass= new JLabel("Introduce Contraseña");
		
		panelPrincipal.add(DNI);
		panelPrincipal.add(pdni);
		panelPrincipal.add(nom);
		panelPrincipal.add(pnom);
		panelPrincipal.add(ape);
		panelPrincipal.add(pape);
		panelPrincipal.add(tel);
		panelPrincipal.add(ptel);
		panelPrincipal.add(corr);
		panelPrincipal.add(pcorr);
		panelPrincipal.add(pass);
		panelPrincipal.add(ppass);
		panelPrincipal.add(volver);
		panelPrincipal.add(crear);
		
		
		
		
		
		crear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				
					int creacion = bd.CerSes(pdni.getText(), pnom.getText(), pape.getText(),Integer.parseInt(ptel.getText()), pcorr.getText(), ppass.getText());
					if (creacion == -1) {
						JOptionPane.showMessageDialog(null, "Falta el nombre de usuario");
					}else if(creacion == -2){
						
						JOptionPane.showMessageDialog(null, "Falta la contraseña");
						
					}else if(creacion == -3){
						
						JOptionPane.showMessageDialog(null, "Falta la DNI");
						
					}else if(creacion == -4){
						JOptionPane.showMessageDialog(null, "La longitud del DNI es incorrecta");
						
					}else if(creacion == 0) {
						JOptionPane.showMessageDialog(null, "Error 1, LLame a administrador del sistema");
					}
					
					else if(creacion == 1) {
						JOptionPane.showMessageDialog(null, "Usuario Creado correctamente");
						setVisible(false);
						new MenuGUI();
					}else {
						
						JOptionPane.showMessageDialog(null, "Error 2, LLame a administrador del sistema");
						
						
		
				}
					
				
				
			}
		});
		volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new MenuGUI();
			}
		});
		
		
		
		getContentPane().add(panelPrincipal);
		setVisible(true);
		
	}

}
