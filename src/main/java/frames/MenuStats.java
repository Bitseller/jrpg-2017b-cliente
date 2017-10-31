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
public class MenuStats extends JFrame implements MenuGenerico {

    private JPanel contentPane;
    private PaquetePersonaje paquetePersonaje;
    private final double mod = 1.5;

    /**
     * Create the frame.
     *
     * @param cliente
     *            el cliente
     */
    public MenuStats(final Cliente cliente) {
        paquetePersonaje = cliente.getPaquetePersonaje();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400, 321);
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

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(Color.WHITE);

        JLabel lblCasta = new JLabel("Casta");
        lblCasta.setForeground(Color.WHITE);

        JLabel lblRaza = new JLabel("Raza");
        lblRaza.setForeground(Color.WHITE);

        JLabel lblNivel = new JLabel("Nivel");
        lblNivel.setForeground(Color.WHITE);

        JLabel lblExperiencia = new JLabel("Experiencia");
        lblExperiencia.setForeground(Color.WHITE);

        JLabel lblEnergia = new JLabel("Energia");
        lblEnergia.setForeground(Color.WHITE);

        JLabel lblSalud = new JLabel("Salud");
        lblSalud.setForeground(Color.WHITE);

        JLabel lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);

        JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);

        JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);

        JLabel lblAtaque = new JLabel("Ataque");
        lblAtaque.setForeground(Color.WHITE);

        JLabel lblDefensa = new JLabel("Defensa");
        lblDefensa.setForeground(Color.WHITE);

        JLabel lblMagia = new JLabel("Magia");
        lblMagia.setForeground(Color.WHITE);

        JLabel lblCantidadDeItems = new JLabel("Cantidad de Items");
        lblCantidadDeItems.setForeground(Color.WHITE);

        JLabel nmbPj = new JLabel(paquetePersonaje.getNombre());
        nmbPj.setForeground(Color.WHITE);
        nmbPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel cstPj = new JLabel(paquetePersonaje.getCasta());
        cstPj.setForeground(Color.WHITE);
        cstPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel rzPj = new JLabel(paquetePersonaje.getRaza());
        rzPj.setForeground(Color.WHITE);
        rzPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel saludPj = new JLabel(String.valueOf(paquetePersonaje.getSaludTope()));
        saludPj.setForeground(Color.WHITE);
        saludPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel fzaPj = new JLabel(String.valueOf(paquetePersonaje.getFuerza()));
        fzaPj.setForeground(Color.WHITE);
        fzaPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel dstzaPj = new JLabel(String.valueOf(paquetePersonaje.getDestreza()));
        dstzaPj.setForeground(Color.WHITE);
        dstzaPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel intPj = new JLabel(String.valueOf(paquetePersonaje.getInteligencia()));
        intPj.setForeground(Color.WHITE);
        intPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel cantItem = new JLabel(String.valueOf(paquetePersonaje.getCantItems()));
        cantItem.setForeground(Color.WHITE);
        cantItem.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel lvPj = new JLabel(String.valueOf(paquetePersonaje.getNivel()));
        lvPj.setForeground(Color.WHITE);
        lvPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel xpPj = new JLabel(String.valueOf(paquetePersonaje.getExperiencia()));
        xpPj.setForeground(Color.WHITE);
        xpPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel energiaPj = new JLabel(String.valueOf(paquetePersonaje.getEnergiaTope()));
        energiaPj.setForeground(Color.WHITE);
        energiaPj.setHorizontalAlignment(SwingConstants.RIGHT);

        int ataquePj = calcularAtaque(paquetePersonaje.getFuerza());
        JLabel ataPj = new JLabel(String.valueOf(ataquePj));
        ataPj.setForeground(Color.WHITE);
        ataPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel defPj = new JLabel(String.valueOf(paquetePersonaje.getDestreza()));
        defPj.setForeground(Color.WHITE);
        defPj.setHorizontalAlignment(SwingConstants.RIGHT);

        int intePj = calcularMagia(paquetePersonaje.getInteligencia());
        JLabel magicPj = new JLabel(String.valueOf(intePj));
        magicPj.setForeground(Color.WHITE);
        magicPj.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setIcon(new ImageIcon("recursos//volver.png"));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	 Pantalla.setMenuStats(null);
                dispose();
            }
        });
        JLabel background = new JLabel(new ImageIcon(imagenFondo.getScaledInstance(400, 350, Image.SCALE_DEFAULT)));
        GroupLayout glContentPane = new GroupLayout(contentPane);
        glContentPane.setHorizontalGroup(
            glContentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(nmbPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(26)
                    .addComponent(lvPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblCasta, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(cstPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addGap(94)
                    .addComponent(xpPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblRaza, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(rzPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(saludPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lblEnergia, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addGap(34)
                    .addComponent(energiaPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addGap(20)
                    .addComponent(fzaPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lblAtaque, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addGap(34)
                    .addComponent(ataPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(dstzaPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lblDefensa, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(26)
                    .addComponent(defPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(181)
                    .addComponent(lblMagia, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(43)
                    .addComponent(magicPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(glContentPane.createSequentialGroup()
                            .addGap(106)
                            .addComponent(cantItem, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblCantidadDeItems, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(140)
                    .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(181)
                    .addComponent(lblExperiencia, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(92)
                    .addComponent(intPj, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
        );
        glContentPane.setVerticalGroup(
            glContentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(24)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nmbPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lvPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGap(13)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblCasta, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cstPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(xpPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGap(13)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblRaza, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rzPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGap(13)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(saludPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEnergia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(energiaPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGap(13)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fzaPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAtaque, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ataPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGap(13)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(dstzaPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDefensa, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(defPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGap(13)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblMagia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(magicPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGap(13)
                    .addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(cantItem, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCantidadDeItems, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(198)
                    .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(256)
                    .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(53)
                    .addComponent(lblExperiencia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(198)
                    .addComponent(intPj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(glContentPane);
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

    @Override
    public JFrame getMenu() {
        return this;
    }
}
