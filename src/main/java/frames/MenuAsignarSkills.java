package frames;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.google.gson.Gson;

import cliente.Cliente;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * The Class MenuAsignarSkills.
 */
public class MenuAsignarSkills extends JFrame implements MenuGenerico {

    private static final int FRAME_ALTO = 350;
    private static final int FRAME_ANCHO = 400;
    private static final int BOTON_ALTO = 23;
    private static final int BOTON_ANCHO = 110;
    private static final int FUENTE_SIZE = 15;
    private static final int LABEL_ALTO = 25;
    private static final int LABEL_ANCHO = 100;
    private static final int BOTON_CHICO_ANCHO = 34;
    private static final int PUNTOS_INICIALES = 10;

    private JPanel contentPane;
    private int puntosAsignarInicial = PUNTOS_INICIALES;
    private int puntosFuerzaInicial = 0;
    private int puntosDestrezaInicial = 0;
    private int puntosInteligenciaInicial = 0;
    private int puntosAsignar = puntosAsignarInicial;
    private int puntosFuerza = puntosFuerzaInicial;
    private int puntosDestreza = puntosDestrezaInicial;
    private int puntosInteligencia = puntosInteligenciaInicial;
    private final Gson gson = new Gson();

    /**
     * Declaracion de Botones.
     */
    private final JButton buttonConfirm = new JButton("Confirmar");
    private final JButton buttonCancel = new JButton("Cancelar");
    private final JButton buttonRestart = new JButton("Reiniciar");
    private final JButton buttonMinus = new JButton("");
    private final JButton buttonMinus1 = new JButton("");
    private final JButton buttonMinus2 = new JButton("");
    private final JButton buttonMore = new JButton("");
    private  final JButton buttonMore1 = new JButton("");
    private final JButton buttonMore2 = new JButton("");

    /**
     * Create the frame.
     *
     * @param cliente
     *            the cliente
     */
    public MenuAsignarSkills(final Cliente cliente) {
        puntosAsignarInicial = cliente.getPaquetePersonaje().getPuntosSkill();
        puntosFuerzaInicial = cliente.getPaquetePersonaje().getFuerza();
        puntosDestrezaInicial = cliente.getPaquetePersonaje().getDestreza();
        puntosInteligenciaInicial = cliente.getPaquetePersonaje().getInteligencia();
        puntosAsignar = puntosAsignarInicial;
        puntosFuerza = puntosFuerzaInicial;
        puntosDestreza = puntosDestrezaInicial;
        puntosInteligencia = puntosInteligenciaInicial;

        if (cliente.getPaquetePersonaje().getNivel() == 1) {
            buttonRestart.setEnabled(false);
        }
        if (puntosAsignar == 0) {
            buttonMore.setEnabled(false);
            buttonMore1.setEnabled(false);
            buttonMore2.setEnabled(false);
            buttonMinus.setEnabled(false);
            buttonMinus1.setEnabled(false);
            buttonMinus2.setEnabled(false);
        } else if (puntosAsignar != 0) {
            buttonMinus.setEnabled(true);
            buttonMinus1.setEnabled(true);
            buttonMinus2.setEnabled(true);
            buttonMinus.setEnabled(true);
            buttonMinus1.setEnabled(true);
            buttonMinus2.setEnabled(true);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_ANCHO, FRAME_ALTO);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        setIconImage(Toolkit.getDefaultToolkit().getImage("recursos//1up.png"));
        setTitle("Asignar");
        //setBounds(100, 100, 298, 294);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //getContentPane().setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent arg0) {
                Pantalla.setMenuAsignar(null);
                dispose();
            }
        });

        final JLabel labelFuerza = new JLabel("");
        labelFuerza.setForeground(Color.WHITE);
        labelFuerza.setHorizontalAlignment(SwingConstants.CENTER);
        labelFuerza.setText(String.valueOf(puntosFuerzaInicial));

        final JLabel labelDestreza = new JLabel("");
        labelDestreza.setForeground(Color.WHITE);
        labelDestreza.setHorizontalAlignment(SwingConstants.CENTER);
        labelDestreza.setText(String.valueOf(puntosDestrezaInicial));

        final JLabel labelInteligencia = new JLabel("");
        labelInteligencia.setForeground(Color.WHITE);
        labelInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
        labelInteligencia.setText(String.valueOf(puntosInteligenciaInicial));

        final JLabel labelPuntos = new JLabel("");
        labelPuntos.setForeground(Color.WHITE);
        labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
        labelPuntos.setText(String.valueOf(puntosAsignarInicial));

        final JLabel lblCantidadDePuntos = new JLabel("Cantidad de Puntos a Asignar");
        lblCantidadDePuntos.setForeground(Color.WHITE);

        final JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);
        lblInteligencia.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);
        lblDestreza.setHorizontalAlignment(SwingConstants.CENTER);

        final JLabel lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);
        lblFuerza.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon iconoConfirm = new ImageIcon("recursos//botonMenu.png");
        buttonConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonConfirm.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonConfirm.setForeground(Color.WHITE);
        buttonConfirm.setIcon(iconoConfirm);
        buttonConfirm.setEnabled(false);
        buttonConfirm.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(final ActionEvent e) {
                puntosAsignarInicial = puntosAsignar;
                int bonusF = puntosFuerza - puntosFuerzaInicial;
                int bonusD = puntosDestreza - puntosDestrezaInicial;
                int bonusI = puntosInteligencia - puntosInteligenciaInicial;
                cliente.getPaquetePersonaje().setPuntosSkill(puntosAsignar);
                cliente.getPaquetePersonaje().useBonus(0, 0, bonusF, bonusD, bonusI);
                cliente.getPaquetePersonaje().removerBonus();
                cliente.getPaquetePersonaje().setComando(Comando.ACTUALIZARPERSONAJELV);
                try {
                    cliente.getSalida().writeObject(gson.toJson(cliente.getPaquetePersonaje()));
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar stats");

                }
                JOptionPane.showMessageDialog(null, "Se han actualizado tus atributos.");
                Pantalla.setMenuAsignar(null);
                dispose();
            }
        });

        ImageIcon iconoCancel = new ImageIcon("recursos//botonMenu.png");
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonCancel.setForeground(Color.WHITE);
        buttonCancel.setIcon(iconoCancel);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Pantalla.setMenuAsignar(null);
                dispose();
            }
        });

        /*
         * El boton de restart se encarga de colocar los puntos de skill
         * determinados dependiendo del nivel que posea el personaje y de la
         * Casta. Ademas se encarga de obtener los puntos de Skill
         * correspondientes para poder volverlos a asigar.
         */
        ImageIcon iconoRestart = new ImageIcon("recursos//botonMenu.png");
        buttonRestart.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonRestart.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonRestart.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonRestart.setForeground(Color.WHITE);
        buttonRestart.setIcon(iconoRestart);
        buttonRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                int fuerzaBase = 10;
                int destrezaBase = 10;
                int inteligenciaBase = 10;
                switch (cliente.getPaquetePersonaje().getCasta()) {
                    case "Guerrero":
                        fuerzaBase += 5;
                        break;

                    case "Hechicero":
                        inteligenciaBase += 5;
                        break;

                    default:
                        destrezaBase += 5;
                        break;
                }

                puntosAsignar = (cliente.getPaquetePersonaje().getNivel() - 1) * 3;
                //Multiplico por 3 ya que otorga 3 puntos por cada nivel obtenido.
                puntosFuerza = cliente.getPaquetePersonaje().getStatSkill("Fuerza") + fuerzaBase;
                puntosDestreza = cliente.getPaquetePersonaje().getStatSkill("Destreza") + destrezaBase;
                puntosInteligencia = cliente.getPaquetePersonaje().getStatSkill("Inteligencia") + inteligenciaBase;

                labelPuntos.setText(String.valueOf(puntosAsignar));
                labelFuerza.setText(String.valueOf(puntosFuerza));
                labelDestreza.setText(String.valueOf(puntosDestreza));
                labelInteligencia.setText(String.valueOf(puntosInteligencia));

                buttonConfirm.setEnabled(true);
                buttonMinus.setEnabled(false);
                buttonMinus1.setEnabled(false);
                buttonMinus2.setEnabled(false);

                if (puntosAsignar != 0) {
                    buttonMore.setEnabled(true);
                    buttonMore1.setEnabled(true);
                    buttonMore2.setEnabled(true);
                }
            }
        });

        ImageIcon icono1 = new ImageIcon("recursos//botonMenoss.png");
        buttonMinus.setIcon(icono1);
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (puntosFuerza > puntosFuerzaInicial) {
                    puntosFuerza--;
                    if (puntosAsignar == 0) {
                        if (puntosInteligencia != 200) {
                            buttonMore2.setEnabled(true);
                        }
                        if (puntosDestreza != 200) {
                            buttonMore1.setEnabled(true);
                        }
                    } else {
                        buttonMore.setEnabled(true);
                        buttonMore1.setEnabled(true);
                        buttonMore2.setEnabled(true);
                    }
                    puntosAsignar++;
                    if (puntosAsignar == puntosAsignarInicial) {
                        buttonConfirm.setEnabled(false);
                    }
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelFuerza.setText(String.valueOf(puntosFuerza));
                    if (puntosFuerza == puntosFuerzaInicial) {
                        buttonMinus.setEnabled(false);
                        buttonMore.setEnabled(true);
                    } else if (puntosFuerza >= puntosFuerzaInicial) {
                        buttonMore.setEnabled(true);
                    }
                }
            }
        });

        buttonMinus1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(final ActionEvent e) {
                if (puntosDestreza > puntosDestrezaInicial) {
                    puntosDestreza--;
                    if (puntosAsignar == 0) {
                        if (puntosInteligencia != 200) {
                            buttonMore2.setEnabled(true);
                        }
                        if (puntosFuerza != 200) {
                            buttonMore.setEnabled(true);
                        }
                    } else {
                        buttonMore.setEnabled(true);
                        buttonMore1.setEnabled(true);
                        buttonMore2.setEnabled(true);
                    }
                    puntosAsignar++;
                    if (puntosAsignar == puntosAsignarInicial) {
                        buttonConfirm.setEnabled(false);
                    }
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelDestreza.setText(String.valueOf(puntosDestreza));
                    if (puntosDestreza == puntosDestrezaInicial) {
                        buttonMinus1.setEnabled(false);
                        buttonMore1.setEnabled(true);
                    } else if (puntosDestreza >= puntosDestrezaInicial) {
                        buttonMore1.setEnabled(true);
                    }
                }
            }
        });
        buttonMinus1.setIcon(icono1);

        buttonMinus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (puntosInteligencia > puntosInteligenciaInicial) {
                    puntosInteligencia--;
                    if (puntosAsignar == 0) {
                        if (puntosFuerza != 200) {
                            buttonMore.setEnabled(true);
                        }
                        if (puntosDestreza != 200) {
                            buttonMore1.setEnabled(true);
                        }
                    } else {
                        buttonMore.setEnabled(true);
                        buttonMore1.setEnabled(true);
                        buttonMore2.setEnabled(true);
                    }
                    puntosAsignar++;
                    if (puntosAsignar == puntosAsignarInicial) {
                        buttonConfirm.setEnabled(false);
                    }
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelInteligencia.setText(String.valueOf(puntosInteligencia));
                    if (puntosInteligencia == puntosInteligenciaInicial) {
                        buttonMinus2.setEnabled(false);
                        buttonMore2.setEnabled(true);
                    } else if (puntosInteligencia >= puntosInteligenciaInicial) {
                        buttonMore2.setEnabled(true);
                    }
                }
            }
        });
        buttonMinus2.setIcon(icono1);

        buttonMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (puntosAsignar != 0 && !labelFuerza.getText().equals("200")) {
                    puntosFuerza++;
                    puntosAsignar--;
                    buttonConfirm.setEnabled(true);
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelFuerza.setText(String.valueOf(puntosFuerza));
                    buttonMinus.setEnabled(true);
                    if (puntosAsignar == 0) {
                        buttonMore.setEnabled(false);
                        buttonMore1.setEnabled(false);
                        buttonMore2.setEnabled(false);
                    }
                }
                if (puntosAsignar == 0 || labelFuerza.getText().equals("200")) {
                    buttonMore.setEnabled(false);
                }
            }
        });
        ImageIcon icono2 = new ImageIcon("recursos//botonMass.png");
        buttonMore.setIcon(icono2);

        buttonMore1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (puntosAsignar != 0 && !labelDestreza.getText().equals("200")) {
                    puntosDestreza++;
                    puntosAsignar--;
                    buttonConfirm.setEnabled(true);
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelDestreza.setText(String.valueOf(puntosDestreza));
                    buttonMinus1.setEnabled(true);
                    if (puntosAsignar == 0) {
                        buttonMore.setEnabled(false);
                        buttonMore1.setEnabled(false);
                        buttonMore2.setEnabled(false);
                    }
                    if (puntosAsignar == 0 || labelDestreza.getText().equals("200")) {
                        buttonMore1.setEnabled(false);
                    }
                }
            }
        });
        buttonMore1.setIcon(icono2);

        buttonMore2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (puntosAsignar != 0 && !labelInteligencia.getText().equals("200")) {
                    puntosInteligencia++;
                    puntosAsignar--;
                    buttonConfirm.setEnabled(true);
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelInteligencia.setText(String.valueOf(puntosInteligencia));
                    buttonMinus2.setEnabled(true);
                    if (puntosAsignar == 0) {
                        buttonMore.setEnabled(false);
                        buttonMore1.setEnabled(false);
                        buttonMore2.setEnabled(false);
                    }
                    if (puntosAsignar == 0 || labelInteligencia.getText().equals("200")) {
                        buttonMore2.setEnabled(false);
                    }
                }
            }
        });
        buttonMore2.setIcon(icono2);

        final JLabel imageLabel = new JLabel(new ImageIcon("recursos//background.jpg"));
        imageLabel.setVisible(true);
        GroupLayout glContentPane = new GroupLayout(contentPane);
        glContentPane.setHorizontalGroup(
            glContentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(50)
                    .addComponent(labelFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(50)
                    .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(50)
                    .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(50)
                    .addComponent(labelInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(200)
                    .addComponent(buttonConfirm, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(12)
                    .addComponent(buttonMinus1, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(150)
                    .addComponent(buttonMore1, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(200)
                    .addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(12)
                    .addComponent(buttonMinus, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(39)
                    .addComponent(labelPuntos, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(200)
                    .addComponent(buttonRestart, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(12)
                    .addComponent(lblCantidadDePuntos, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO + BOTON_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(12)
                    .addComponent(buttonMinus2, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(50)
                    .addComponent(labelDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(150)
                    .addComponent(buttonMore, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(50)
                    .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(150)
                    .addComponent(buttonMore2, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        glContentPane.setVerticalGroup(
            glContentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(101)
                    .addComponent(labelFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                    .addGap(13)
                    .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                    .addGap(20)
                    .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                    .addComponent(labelInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(155)
                    .addComponent(buttonConfirm, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(159)
                    .addComponent(buttonMinus1, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(159)
                    .addComponent(buttonMore1, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(189)
                    .addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(92)
                    .addComponent(buttonMinus, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(41)
                    .addComponent(labelPuntos, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(121)
                    .addComponent(buttonRestart, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(13)
                    .addComponent(lblCantidadDePuntos, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(217)
                    .addComponent(buttonMinus2, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(159)
                    .addComponent(labelDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(92)
                    .addComponent(buttonMore, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(72)
                    .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glContentPane.createSequentialGroup()
                    .addGap(217)
                    .addComponent(buttonMore2, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(glContentPane);
    }

    @Override
    public JFrame getMenu() {
        return this;
    }
}
