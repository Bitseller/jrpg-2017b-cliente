package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cliente.Cliente;
import mensajeria.Comando;
import mensajeria.PaquetePersonaje;

/**
 * The Class MenuCreacionPj.
 */
public class MenuCreacionPj extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JLabel destreza;
	private JLabel fuerza;
	private JLabel inteligencia;
	private JLabel salud;
	private JLabel energia;

	private JComboBox<String> cbxCasta;
	private JComboBox<String> cbxRaza;

	/**
	 * Instantiates a new menu creacion pj.
	 *
	 * @param cliente
	 *            the cliente
	 * @param personaje
	 *            the personaje
	 * @param gson
	 *            the gson
	 */
	public MenuCreacionPj(final Cliente cliente, final PaquetePersonaje personaje, final Gson gson) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		        new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(), new Point(0, 0),
		        "custom cursor"));

		final String[] vecSalud = {"55", "50", "60"};
		final String[] vecEnergia = {"55", "60", "50"};
		final String[] vecFuerza = {"15", "10", "10"};
		final String[] vecDestreza = {"10", "10", "15"};
		final String[] vecInteligencia = {"10", "15", "10"};

		// En caso de cerrar
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				personaje.setNombre(nombre.getText());
				if (nombre.getText().equals("")) {
					personaje.setNombre("nameless");
				}
				personaje.setRaza((String) cbxRaza.getSelectedItem());
				personaje.setSaludTope(Integer.parseInt(
						vecSalud[cbxRaza.getSelectedIndex()]));
				personaje.setEnergiaTope(Integer.parseInt(
						vecEnergia[cbxRaza.getSelectedIndex()]));
				personaje.setCasta((String) cbxCasta.getSelectedItem());
				personaje.setFuerza(Integer.parseInt(
						vecFuerza[cbxCasta.getSelectedIndex()]));
				personaje.setDestreza(Integer.parseInt(
						vecDestreza[cbxCasta.getSelectedIndex()]));
				personaje.setInteligencia(Integer.parseInt(
						vecInteligencia[cbxCasta.getSelectedIndex()]));
				synchronized (cliente) {
					cliente.notify();
				}
				dispose();
			}
		});

		setTitle("WOME - Crear personaje");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(450, 300);
		contentPane.add(layeredPane);

		JLabel lblNewLabel5 = new JLabel("Fuerza");
		lblNewLabel5.setForeground(Color.WHITE);
		lblNewLabel5.setFont(new Font("Tahoma", Font.PLAIN, 13));

		fuerza = new JLabel("15");
		fuerza.setForeground(Color.GREEN);

		JLabel lblDestreza = new JLabel("Destreza");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setFont(new Font("Tahoma", Font.PLAIN, 13));

		destreza = new JLabel("10");
		destreza.setForeground(Color.GREEN);

		JLabel lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInteligencia.setForeground(Color.WHITE);

		inteligencia = new JLabel("10");
		inteligencia.setForeground(Color.GREEN);

		JLabel lblSalud = new JLabel("Salud");
		lblSalud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalud.setForeground(Color.WHITE);

		salud = new JLabel("55");
		salud.setForeground(Color.GREEN);

		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setForeground(Color.WHITE);
		lblEnergia.setFont(new Font("Tahoma", Font.PLAIN, 13));

		energia = new JLabel("55");
		energia.setForeground(Color.GREEN);

		JLabel lblNewLabel4 = new JLabel("Nombre");
		lblNewLabel4.setForeground(Color.WHITE);
		lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		nombre = new JTextField();
		nombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				crearPj(cliente, personaje, gson, vecSalud, vecEnergia,
						vecFuerza, vecDestreza, vecInteligencia);
			}
		});
		nombre.setColumns(10);

		JLabel lblAceptar = new JLabel("Aceptar");
		layeredPane.setLayer(lblAceptar, 1);
		lblAceptar.setForeground(Color.WHITE);
		lblAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));

		// En caso de apretar el boton aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFocusable(false);
		btnAceptar.setIcon(new ImageIcon(MenuCreacionPj.class.getResource("/frames/BotonMenu.png")));

		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				crearPj(cliente, personaje, gson, vecSalud, vecEnergia,
						vecFuerza, vecDestreza, vecInteligencia);

			}

		});

		JLabel lblNewLabel = new JLabel("Raza");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblCasta = new JLabel("Casta");
		lblCasta.setForeground(Color.WHITE);
		lblCasta.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbxCasta = new JComboBox<>();
		cbxCasta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				fuerza.setText(vecFuerza[cbxCasta.getSelectedIndex()]);
				destreza.setText(vecDestreza[cbxCasta.getSelectedIndex()]);
				inteligencia.setText(vecInteligencia[cbxCasta.getSelectedIndex()]);
			}
		});
		cbxCasta.addItem("Guerrero");
		cbxCasta.addItem("Hechicero");
		cbxCasta.addItem("Asesino");

		cbxRaza = new JComboBox<>();
		cbxRaza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				salud.setText(vecSalud[cbxRaza.getSelectedIndex()]);
				energia.setText(vecEnergia[cbxRaza.getSelectedIndex()]);
			}
		});
		cbxRaza.addItem("Humano");
		cbxRaza.addItem("Elfo");
		cbxRaza.addItem("Orco");

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MenuCreacionPj.class
				.getResource("/frames/menuBackground.jpg")));
		GroupLayout glLayeredPane = new GroupLayout(layeredPane);
		glLayeredPane.setHorizontalGroup(glLayeredPane
				.createParallelGroup(Alignment.LEADING)
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(33).addComponent(lblNewLabel,
		                GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(32)
		                .addComponent(cbxRaza, GroupLayout.PREFERRED_SIZE,
		                		76, GroupLayout.PREFERRED_SIZE).addGap(53)
		                .addComponent(cbxCasta, GroupLayout.PREFERRED_SIZE,
		                		76, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(33).addComponent(lblNewLabel5,
		                GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(33)
		                .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE,
		                		60, GroupLayout.PREFERRED_SIZE)
		                .addGap(17).addComponent(destreza, GroupLayout.PREFERRED_SIZE,
		                		22, GroupLayout.PREFERRED_SIZE)
		                .addGap(75)
		                .addComponent(lblNewLabel4, GroupLayout.PREFERRED_SIZE,
		                		60, GroupLayout.PREFERRED_SIZE)
		                .addGap(10).addComponent(nombre, GroupLayout.PREFERRED_SIZE,
		                		122, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(33)
		                .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE,
		                		66, GroupLayout.PREFERRED_SIZE)
		                .addGap(11)
		                .addComponent(inteligencia, GroupLayout.PREFERRED_SIZE, 22,
		                		GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(33)
		                .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE,
		                		46, GroupLayout.PREFERRED_SIZE).addGap(31)
		                .addComponent(salud, GroupLayout.PREFERRED_SIZE,
		                		22, GroupLayout.PREFERRED_SIZE).addGap(98)
		                .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE,
		                		153, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(110)
		        		.addComponent(energia,
		                GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(161)
		        		.addComponent(lblCasta,
		                GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(280)
		        		.addComponent(lblAceptar))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(33)
		        		.addComponent(lblEnergia,
		                GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(110)
		        		.addComponent(fuerza,
		                GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		        .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE,
		        		444, GroupLayout.PREFERRED_SIZE));
		glLayeredPane.setVerticalGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(23)
		                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE,
		                		14, GroupLayout.PREFERRED_SIZE)
		                .addGap(11)
		                .addGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
		                        .addComponent(cbxRaza, GroupLayout.PREFERRED_SIZE,
		                        		GroupLayout.DEFAULT_SIZE,
		                                GroupLayout.PREFERRED_SIZE)
		                        .addComponent(cbxCasta, GroupLayout.PREFERRED_SIZE,
		                        		GroupLayout.DEFAULT_SIZE,
		                                GroupLayout.PREFERRED_SIZE))
		                .addGap(32)
		                .addComponent(lblNewLabel5, GroupLayout.PREFERRED_SIZE, 14,
		                		GroupLayout.PREFERRED_SIZE)
		                .addGap(8)
		                .addGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
		                        .addGroup(glLayeredPane.createSequentialGroup()
		                        		.addGap(4).addComponent(lblDestreza,
		                                GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		                        .addGroup(glLayeredPane.createSequentialGroup()
		                        		.addGap(5).addComponent(destreza))
		                        .addGroup(glLayeredPane.createSequentialGroup()
		                        		.addGap(3).addComponent(lblNewLabel4,
		                                GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		                        .addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
		                                GroupLayout.PREFERRED_SIZE))
		                .addGap(9)
		                .addGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
		                        .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, 22,
		                                GroupLayout.PREFERRED_SIZE)
		                        .addGroup(glLayeredPane.createSequentialGroup()
		                        		.addGap(5).addComponent(inteligencia)))
		                .addGap(1)
		                .addGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
		                        .addGroup(glLayeredPane.createSequentialGroup()
		                        		.addGap(9).addComponent(lblSalud,
		                                GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		                        .addGroup(glLayeredPane.createSequentialGroup()
		                        		.addGap(9).addComponent(salud))
		                        .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE,
		                        		23, GroupLayout.PREFERRED_SIZE))
		                .addGap(11).addComponent(energia))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(23)
		        		.addComponent(lblCasta,
		                GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(173)
		        		.addComponent(lblAceptar,
		                GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(204)
		        		.addComponent(lblEnergia,
		                GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		        .addGroup(glLayeredPane.createSequentialGroup().addGap(102)
		        		.addComponent(fuerza))
		        .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE,
		        		271, GroupLayout.PREFERRED_SIZE));
		layeredPane.setLayout(glLayeredPane);
	}

	/**
	 * Crear pj.
	 *
	 * @param cliente
	 *            the cliente
	 * @param personaje
	 *            the personaje
	 * @param gson
	 *            the gson
	 * @param vecSalud
	 *            the vec salud
	 * @param vecEnergia
	 *            the vec energia
	 * @param vecFuerza
	 *            the vec fuerza
	 * @param vecDestreza
	 *            the vec destreza
	 * @param vecInteligencia
	 *            the vec inteligencia
	 */
	protected void crearPj(final Cliente cliente, final PaquetePersonaje personaje, final Gson gson,
	        final String[] vecSalud, final String[] vecEnergia,
	        final String[] vecFuerza, final String[] vecDestreza,
	        final String[] vecInteligencia) {

		personaje.setNombre(nombre.getText());
		if (nombre.getText().equals("")) {
			personaje.setNombre("nameless");
		}
		personaje.setRaza((String) cbxRaza.getSelectedItem());
		personaje.setSaludTope(Integer.parseInt(
				vecSalud[cbxRaza.getSelectedIndex()]));
		personaje.setEnergiaTope(Integer.parseInt(
				vecEnergia[cbxRaza.getSelectedIndex()]));
		personaje.setCasta((String) cbxCasta.getSelectedItem());
		personaje.setFuerza(Integer.parseInt(
				vecFuerza[cbxCasta.getSelectedIndex()]));
		personaje.setDestreza(Integer.parseInt(
				vecDestreza[cbxCasta.getSelectedIndex()]));
		personaje.setInteligencia(Integer.parseInt(
				vecInteligencia[cbxCasta.getSelectedIndex()]));
		try {

			// Le envio los datos al servidor
			cliente.getPaquetePersonaje().setComando(Comando.CREACIONPJ);
			cliente.getSalida().writeObject(gson.toJson(cliente.getPaquetePersonaje()));
			dispose();
		} catch (JsonSyntaxException | IOException esd) {
			JOptionPane.showMessageDialog(null, "Error al crear personaje");

		}
	}
}
