package frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cliente.Cliente;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;

/**
 * The Class MenuStats.
 */
public class MenuStats extends JFrame {

    private static final int BOTON_ALTO = 25;
    private static final int FILA_SEPARADOR = 13;
    private static final int LABEL_ALTO = 16;
    private static final int COLUMNA_SEGUNDA = 12;
    private static final int FRAME_ALTO = 321;
    private static final int FRAME_ANCHO = 525;
    private static final int LABEL_ANCHO = 110;
    private static final int LABEL_NUMERO_ANCHO = 50;
    private static final int COLUMNA_PRIMERA = 24;
    private JPanel contentPane;
    private PaquetePersonaje paquetePersonaje;
    private final double mod = 1.5;

    private JLabel lblNombre;
    private JLabel lblCasta;
    private JLabel lblRaza;
    private JLabel lblNivel;
    private JLabel lblExperiencia;
    private JLabel lblEnergia;
    private JLabel lblSalud;
    private JLabel lblFuerza;
    private JLabel lblDestreza;
    private JLabel lblInteligencia;
    private JLabel lblAtaque;
    private JLabel lblDefensa;
    private JLabel lblMagia;
    private JLabel lblCantidadDeItems;
    private JLabel nmbPj;
    private JLabel cstPj;
    private JLabel rzPj;
    private JLabel saludPj;
    private JLabel fzaPj;
    private JLabel dstzaPj;
    private JLabel intPj;
    private JLabel cantItem;
    private JLabel lvPj;
    private JLabel xpPj;
    private JLabel energiaPj;
    private JLabel ataPj;
    private JLabel defPj;
    private JLabel magicPj;
    private JButton btnVolver;
    private JLabel background;
    private GroupLayout layout;

    /**
     * Create the frame.
     *
     * @param cliente
     *            the cliente
     */
    public MenuStats(final Cliente cliente) {
        iniciarVentana(cliente);
        iniciarLabels();

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }
        //background = new JLabel();
        background = new JLabel(new ImageIcon(imagenFondo.getScaledInstance(FRAME_ANCHO, FRAME_ALTO,
            Image.SCALE_DEFAULT)));
        //background.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/menuBackground.jpg")));
        layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(nmbPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lvPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblCasta, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(cstPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(lblExperiencia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(xpPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblRaza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(rzPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(saludPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(lblEnergia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(energiaPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(fzaPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(lblAtaque, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ataPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(dstzaPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(lblDefensa, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(defPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(intPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(lblMagia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(magicPj, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblCantidadDeItems, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(cantItem, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nmbPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lvPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblCasta, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cstPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblExperiencia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(xpPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblRaza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rzPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(saludPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEnergia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(energiaPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fzaPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAtaque, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ataPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(dstzaPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDefensa, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(defPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(intPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMagia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(magicPj, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(cantItem, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCantidadDeItems, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE)))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(layout);
    }

    /**
     * Iniciar ventana.
     *
     * @param cliente
     *            the cliente
     */
    private void iniciarVentana(final Cliente cliente) {
        paquetePersonaje = cliente.getPaquetePersonaje();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(FRAME_ANCHO, FRAME_ALTO);
        this.setLocationRelativeTo(null);
        this.setTitle("Estadísticas");

        contentPane = new JPanel();
        setContentPane(contentPane);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                Pantalla.setMenuStats(null);
                dispose();
            }
        });
    }

    /**
     * Iniciar labels.
     */
    private void iniciarLabels() {
        lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(Color.WHITE);

        lblCasta = new JLabel("Casta");
        lblCasta.setForeground(Color.WHITE);

        lblRaza = new JLabel("Raza");
        lblRaza.setForeground(Color.WHITE);

        lblNivel = new JLabel("Nivel");
        lblNivel.setForeground(Color.WHITE);

        lblExperiencia = new JLabel("Experiencia");
        lblExperiencia.setForeground(Color.WHITE);

        lblEnergia = new JLabel("Energia");
        lblEnergia.setForeground(Color.WHITE);

        lblSalud = new JLabel("Salud");
        lblSalud.setForeground(Color.WHITE);

        lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);

        lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);

        lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);

        lblAtaque = new JLabel("Ataque");
        lblAtaque.setForeground(Color.WHITE);

        lblDefensa = new JLabel("Defensa");
        lblDefensa.setForeground(Color.WHITE);

        lblMagia = new JLabel("Magia");
        lblMagia.setForeground(Color.WHITE);

        lblCantidadDeItems = new JLabel("Cantidad de Items");
        lblCantidadDeItems.setForeground(Color.WHITE);

        nmbPj = new JLabel(paquetePersonaje.getNombre());
        nmbPj.setForeground(Color.WHITE);
        nmbPj.setHorizontalAlignment(SwingConstants.RIGHT);

        cstPj = new JLabel(paquetePersonaje.getCasta());
        cstPj.setForeground(Color.WHITE);
        cstPj.setHorizontalAlignment(SwingConstants.RIGHT);

        rzPj = new JLabel(paquetePersonaje.getRaza());
        rzPj.setForeground(Color.WHITE);
        rzPj.setHorizontalAlignment(SwingConstants.RIGHT);

        saludPj = new JLabel(String.valueOf(paquetePersonaje.getSaludTope()));
        saludPj.setForeground(Color.WHITE);
        saludPj.setHorizontalAlignment(SwingConstants.RIGHT);

        fzaPj = new JLabel(String.valueOf(paquetePersonaje.getFuerza() * paquetePersonaje.getMultiplicadorCheat()));
        fzaPj.setForeground(Color.WHITE);
        fzaPj.setHorizontalAlignment(SwingConstants.RIGHT);

        dstzaPj = new JLabel(String.valueOf(paquetePersonaje.getDestreza()));
        dstzaPj.setForeground(Color.WHITE);
        dstzaPj.setHorizontalAlignment(SwingConstants.RIGHT);

        intPj = new JLabel(String.valueOf(paquetePersonaje.getInteligencia()));
        intPj.setForeground(Color.WHITE);
        intPj.setHorizontalAlignment(SwingConstants.RIGHT);

        cantItem = new JLabel(String.valueOf(paquetePersonaje.getCantItems()));
        cantItem.setForeground(Color.WHITE);
        cantItem.setHorizontalAlignment(SwingConstants.RIGHT);

        lvPj = new JLabel(String.valueOf(paquetePersonaje.getNivel()));
        lvPj.setForeground(Color.WHITE);
        lvPj.setHorizontalAlignment(SwingConstants.RIGHT);

        xpPj = new JLabel(String.valueOf(paquetePersonaje.getExperiencia()));
        xpPj.setForeground(Color.WHITE);
        xpPj.setHorizontalAlignment(SwingConstants.RIGHT);

        energiaPj = new JLabel(String.valueOf(paquetePersonaje.getEnergiaTope()));
        energiaPj.setForeground(Color.WHITE);
        energiaPj.setHorizontalAlignment(SwingConstants.RIGHT);

        int ataquePj = calcularAtaque(paquetePersonaje.getFuerza());
        ataPj = new JLabel(String.valueOf(ataquePj));
        ataPj.setForeground(Color.WHITE);
        ataPj.setHorizontalAlignment(SwingConstants.RIGHT);

        defPj = new JLabel(String.valueOf(paquetePersonaje.getDestreza()));
        defPj.setForeground(Color.WHITE);
        defPj.setHorizontalAlignment(SwingConstants.RIGHT);

        int intePj = calcularMagia(paquetePersonaje.getInteligencia());
        magicPj = new JLabel(String.valueOf(intePj));
        magicPj.setForeground(Color.WHITE);
        magicPj.setHorizontalAlignment(SwingConstants.RIGHT);

        btnVolver = new JButton("Volver");
        btnVolver.setIcon(new ImageIcon("recursos//volver.png"));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Pantalla.setMenuStats(null);
                dispose();
            }
        });
    }

    /**
     * Calcular magia.
     *
     * @param inteligencia
     *            the inteligencia
     * @return the int
     */
    private int calcularMagia(final int inteligencia) {
        return (int) (inteligencia * mod);
    }

    /**
     * Calcular ataque.
     *
     * @param fuerza
     *            the fuerza
     * @return the int
     */
    private int calcularAtaque(final int fuerza) {
        return (int) (fuerza * mod);
    }
}
