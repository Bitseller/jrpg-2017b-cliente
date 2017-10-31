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

    private static final int TEXT_SIZE = 13;
    private static final int FILA_SEPARADOR = 8;
    private static final int FILA_SEGUNDA = 11;
    private static final int FRAME_ALTO = 300;
    private static final int FRAME_ANCHO = 450;
    private static final int LABEL_ALTO = 14;
    private static final int COLUMNA_SEPARADOR = 10;
    private static final int COLUMNA_SEGUNDA = 53;
    private static final int BOTON_ANCHO = 110;
    private static final int LABEL_ANCHO = 66;
    private static final int COLUMNA_PRIMERA = 23;
    private JPanel contentPane;
    private JTextField nombre;
    private JLabel destreza;
    private JLabel fuerza;
    private JLabel inteligencia;
    private JLabel salud;
    private JLabel energia;

    private JLabel lblFuerza;
    private JLabel lblDestreza;
    private JLabel lblInteligencia;
    private JLabel lblSalud;
    private JLabel lblEnergia;
    private JLabel lblNombre;
    private JLabel lblAceptar;
    private JButton btnAceptar;
    private JLabel lblRaza;
    private JLabel lblCasta;

    private JComboBox<String> cbxCasta;
    private JComboBox<String> cbxRaza;

    private final String[] vecSalud = {
        "55", "50", "60" };
    private final String[] vecEnergia = {
        "55", "60", "50" };
    private final String[] vecFuerza = {
        "15", "10", "10" };
    private final String[] vecDestreza = {
        "10", "10", "15" };
    private final String[] vecInteligencia = {
        "10", "15", "10" };

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

        iniciarVentana(cliente, personaje);
        iniciarLabels(cliente, personaje, gson);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(FRAME_ANCHO, FRAME_ALTO);
        contentPane.add(layeredPane);

        layeredPane.setLayer(lblAceptar, JLayeredPane.PALETTE_LAYER);
        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(MenuCreacionPj.class.getResource("/frames/menuBackground.jpg")));
        GroupLayout layout = new GroupLayout(layeredPane);

        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblRaza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(lblCasta, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(cbxRaza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(cbxCasta, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(fuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(destreza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(nombre, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(inteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(salud, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAceptar)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblEnergia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(energia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblRaza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCasta, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(cbxRaza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxCasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEGUNDA)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fuerza))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(destreza)
                        .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(inteligencia))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(salud)
                        .addGroup(layout.createParallelGroup(Alignment.CENTER)
                            .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAceptar, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                GroupLayout.PREFERRED_SIZE)))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblEnergia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(energia))
                )
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
        );
        layeredPane.setLayout(layout);
    }

    /**
     * Iniciar labels.
     *
     * @param cliente
     *            the cliente
     * @param personaje
     *            the personaje
     * @param gson
     *            the gson
     */
    private void iniciarLabels(final Cliente cliente, final PaquetePersonaje personaje, final Gson gson) {
        lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);
        lblFuerza.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        fuerza = new JLabel("15");
        fuerza.setForeground(Color.GREEN);

        lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);
        lblDestreza.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        destreza = new JLabel("10");
        destreza.setForeground(Color.GREEN);

        lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));
        lblInteligencia.setForeground(Color.WHITE);

        inteligencia = new JLabel("10");
        inteligencia.setForeground(Color.GREEN);

        lblSalud = new JLabel("Salud");
        lblSalud.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));
        lblSalud.setForeground(Color.WHITE);

        salud = new JLabel("55");
        salud.setForeground(Color.GREEN);

        lblEnergia = new JLabel("Energia");
        lblEnergia.setForeground(Color.WHITE);
        lblEnergia.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        energia = new JLabel("55");
        energia.setForeground(Color.GREEN);

        lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        nombre = new JTextField();
        nombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                crearPj(cliente, personaje, gson);
            }
        });
        //nombre.setColumns(10);

        lblAceptar = new JLabel("Aceptar");

        lblAceptar.setForeground(Color.WHITE);
        lblAceptar.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        // En caso de apretar el boton aceptar
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setFocusable(false);
        btnAceptar.setIcon(new ImageIcon(MenuCreacionPj.class.getResource("/frames/BotonMenu.png")));

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                crearPj(cliente, personaje, gson);

            }

        });

        lblRaza = new JLabel("Raza");
        lblRaza.setForeground(Color.WHITE);
        lblRaza.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        lblCasta = new JLabel("Casta");
        lblCasta.setForeground(Color.WHITE);
        lblCasta.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

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
    }

    /**
     * Iniciar ventana.
     *
     * @param cliente
     *            the cliente
     * @param personaje
     *            the personaje
     */
    private void iniciarVentana(final Cliente cliente, final PaquetePersonaje personaje) {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
            new Point(0, 0), "custom cursor"));

        // En caso de cerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                personaje.setNombre(nombre.getText());
                if (nombre.getText().equals("")) {
                    personaje.setNombre("nameless");
                }
                personaje.setRaza((String) cbxRaza.getSelectedItem());
                personaje.setSaludTope(Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
                personaje.setEnergiaTope(Integer.parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
                personaje.setCasta((String) cbxCasta.getSelectedItem());
                personaje.setFuerza(Integer.parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
                personaje.setDestreza(Integer.parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
                personaje.setInteligencia(Integer.parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
                synchronized (cliente) {
                    cliente.notify();
                }
                dispose();
            }
        });

        setTitle("WOME - Crear personaje");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(FRAME_ANCHO, FRAME_ALTO);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
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
     */
    protected void crearPj(final Cliente cliente, final PaquetePersonaje personaje, final Gson gson) {

        personaje.setNombre(nombre.getText());
        if (nombre.getText().equals("")) {
            personaje.setNombre("nameless");
        }
        personaje.setRaza((String) cbxRaza.getSelectedItem());
        personaje.setSaludTope(Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
        personaje.setEnergiaTope(Integer.parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
        personaje.setCasta((String) cbxCasta.getSelectedItem());
        personaje.setFuerza(Integer.parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
        personaje.setDestreza(Integer.parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
        personaje.setInteligencia(Integer.parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
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
