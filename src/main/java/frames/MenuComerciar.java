package frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.google.gson.Gson;

import cliente.Cliente;
import dominio.Item;
import mensajeria.Comando;

/**
 * The Class MenuComerciar.
 */
public class MenuComerciar extends JFrame {

    private static final int ITEMS_MAX = 9;
    private static final int COLUMNA_SEPARADOR = 10;
    private static final int COLUMNA_SEGUNDA = 75;
    private static final int COLUMNA_PRIMERA = 25;
    private static final int FRAME_ALTO = 400;
    private static final int FRAME_ANCHO = 610;
    private static final int BOTON_ANCHO = 97;
    private static final int BOTON_CHICO_ANCHO = 51;
    private static final int LISTA_ANCHO = 157;
    private static final int LABEL_ANCHO = 56;
    private static final int BOTON_ALTO = 25;
    private static final int LISTA_ALTO = 162;
    private static final int LABEL_ALTO = 16;
    private static final int FRAME_COLUMNA1 = 13;
    private JPanel contentPane;
    private DefaultListModel<String> misItems = new DefaultListModel<String>();
    private DefaultListModel<String> dar = new DefaultListModel<String>();
    private DefaultListModel<String> obtener = new DefaultListModel<String>();
    private int cantListos = 0;
    private JLabel cantListo;
    private Item item1;
    private int count = 0;
    private final Gson gson = new Gson();
    private int sizeItems;
    private JCheckBox chckbxListo;
    private JLabel leyenda;

    private JButton btnCancelar;
    private JList<String> listMisItems;
    private JList<String> listADar;
    private JList<String> listAObtener;
    private JLabel lblMisItems;
    private JLabel lblItemsAIntercambiar;
    private JLabel lblItemsAObtener;
    private JLabel lblSalud;
    private JLabel lblEnerga;
    private JLabel lblFuerza;
    private JLabel lblDestreza;
    private JLabel lblInteligencia;
    private JLabel lblSaludEnemy;
    private JLabel lblEnergiaEnemy;
    private JLabel lblFzaEnemy;
    private JLabel lblDesEnemy;
    private JLabel lblIntEnemy;
    private JLabel lblListo;
    private JLabel bonusSalud;
    private JLabel bonusEnergia;
    private JLabel bonusFuerza;
    private JLabel bonusDes;
    private JLabel bonusInt;
    private JLabel saludEnemy;
    private JLabel energyEnemy;
    private JLabel fzaEnemy;
    private JLabel desEnemy;
    private JLabel intEnemy;

    private JLabel background;

    private JButton btnAgregar;
    private JButton btnSacar;

    /**
     * Create the frame.
     *
     * @param cliente
     *            the cliente
     */
    public MenuComerciar(final Cliente cliente) {
        iniciarVentana(cliente);
        iniciarLabels(cliente);
        iniciarBotones(cliente);
        iniciarListas(cliente);

        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblMisItems, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEGUNDA)
                    .addComponent(lblItemsAIntercambiar, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblItemsAObtener, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(listMisItems, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSacar, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(listADar, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(listAObtener, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bonusSalud, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bonusFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(chckbxListo, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblSaludEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(saludEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(lblFzaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fzaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_PRIMERA)
                    .addComponent(lblEnerga, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bonusEnergia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bonusInt, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblListo, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cantListo, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                                GroupLayout.PREFERRED_SIZE)))
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(lblEnergiaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(energyEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(lblIntEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(intEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(COLUMNA_PRIMERA)
                        .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonusDes, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addGap(COLUMNA_SEPARADOR)
                        .addComponent(desEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDesEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                            GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(COLUMNA_SEPARADOR)
                    .addComponent(leyenda, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblMisItems, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblItemsAIntercambiar, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblItemsAObtener, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(listMisItems, GroupLayout.PREFERRED_SIZE, LISTA_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(BOTON_CHICO_ANCHO)
                            .addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, BOTON_ALTO,
                                GroupLayout.PREFERRED_SIZE)
                            .addGap(FRAME_COLUMNA1)
                            .addComponent(btnSacar, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                        .addComponent(listADar, GroupLayout.PREFERRED_SIZE, LISTA_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(listAObtener, GroupLayout.PREFERRED_SIZE, LISTA_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonusSalud, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonusFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(chckbxListo, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSaludEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(saludEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFzaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fzaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblEnerga, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonusEnergia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonusInt, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, BOTON_ALTO,
                                GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblListo, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                        GroupLayout.PREFERRED_SIZE))
                                .addComponent(cantListo, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                    GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lblEnergiaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(energyEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(intEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIntEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonusDes, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(desEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDesEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    //.addGap(FRAME_COLUMNA1)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(leyenda, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                )
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(layout);
    }

    /**
     * Iniciar labels.
     *
     * @param cliente
     *            the cliente
     */
    private void iniciarLabels(final Cliente cliente) {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setIcon(new ImageIcon("recursos//volver.png"));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                cliente.setM1(null);
                dispose();
            }
        });

        listMisItems = new JList<String>();

        listADar = new JList<String>();

        listAObtener = new JList<String>();

        lblMisItems = new JLabel("Mis Items");
        lblMisItems.setForeground(Color.WHITE);
        lblMisItems.setHorizontalAlignment(SwingConstants.CENTER);

        lblItemsAIntercambiar = new JLabel("Items a Dar");
        lblItemsAIntercambiar.setForeground(Color.WHITE);
        lblItemsAIntercambiar.setHorizontalAlignment(SwingConstants.CENTER);

        lblItemsAObtener = new JLabel("Items a Obtener");
        lblItemsAObtener.setForeground(Color.WHITE);
        lblItemsAObtener.setHorizontalAlignment(SwingConstants.CENTER);

        lblSalud = new JLabel("Salud");
        lblSalud.setForeground(Color.WHITE);

        lblEnerga = new JLabel("Energía");
        lblEnerga.setForeground(Color.WHITE);

        lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);

        lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);

        lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);

        lblSaludEnemy = new JLabel("Salud");
        lblSaludEnemy.setForeground(Color.WHITE);

        lblEnergiaEnemy = new JLabel("Energía");
        lblEnergiaEnemy.setForeground(Color.WHITE);

        lblFzaEnemy = new JLabel("Fuerza");
        lblFzaEnemy.setForeground(Color.WHITE);

        lblDesEnemy = new JLabel("Destreza");
        lblDesEnemy.setForeground(Color.WHITE);

        lblIntEnemy = new JLabel("Inteligencia");
        lblIntEnemy.setForeground(Color.WHITE);

        lblListo = new JLabel("Listo");
        lblListo.setForeground(Color.WHITE);

        bonusSalud = new JLabel("");
        bonusSalud.setForeground(Color.WHITE);
        bonusSalud.setHorizontalAlignment(SwingConstants.RIGHT);

        bonusEnergia = new JLabel("");
        bonusEnergia.setForeground(Color.WHITE);
        bonusEnergia.setHorizontalAlignment(SwingConstants.RIGHT);

        bonusFuerza = new JLabel("");
        bonusFuerza.setForeground(Color.WHITE);
        bonusFuerza.setHorizontalAlignment(SwingConstants.RIGHT);

        bonusDes = new JLabel("");
        bonusDes.setForeground(Color.WHITE);
        bonusDes.setHorizontalAlignment(SwingConstants.RIGHT);

        bonusInt = new JLabel("");
        bonusInt.setForeground(Color.WHITE);
        bonusInt.setHorizontalAlignment(SwingConstants.RIGHT);

        saludEnemy = new JLabel("");
        saludEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        saludEnemy.setForeground(Color.WHITE);

        energyEnemy = new JLabel("");
        energyEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        energyEnemy.setForeground(Color.WHITE);

        fzaEnemy = new JLabel("");
        fzaEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        fzaEnemy.setForeground(Color.WHITE);

        desEnemy = new JLabel("");
        desEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        desEnemy.setForeground(Color.WHITE);

        intEnemy = new JLabel("");
        intEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        intEnemy.setForeground(Color.WHITE);

        chckbxListo = new JCheckBox("Listo");
        chckbxListo.setForeground(Color.WHITE);
        chckbxListo.setBackground(Color.BLACK);
        // Arranca deshabilitada
        chckbxListo.setEnabled(false);

        leyenda = new JLabel("Recuerda que la máxima cantidad de items es 9");
        leyenda.setForeground(Color.WHITE);
        leyenda.setVisible(false);

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }

        background = new JLabel("");
        //background.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/menuBackground.jpg")));
        background.setIcon(new ImageIcon(MenuCarga.class.getResource("recursos//background.jpg")));

    }

    /**
     * Iniciar listas.
     *
     * @param cliente
     *            the cliente
     */
    private void iniciarListas(final Cliente cliente) {
        // List Listener para cargar stats del item mio clickeado
        listMisItems.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                if (arg0.getClickCount() == 1) {
                    if (listMisItems.getSelectedValue() != null) {
                        for (Item item : cliente.getPaquetePersonaje().getItems()) {
                            if (listMisItems.getSelectedValue().equals(item.getNombre())) {
                                bonusSalud.setText("+ " + item.getBonusSalud());
                                bonusEnergia.setText("+ " + item.getBonusEnergia());
                                bonusFuerza.setText("+ " + item.getBonusFuerza());
                                bonusDes.setText("+ " + item.getBonusDestreza());
                                bonusInt.setText("+ " + item.getBonusInteligencia());
                            }
                        }
                    }
                }
            }
        });

        // List Listener para cargar stats del item del enemigo clickeado
        listAObtener.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                if (arg0.getClickCount() == 1) {
                    if (obtener.size() != 0) {
                        //cambiar la variable del for each a la lista que va a venir del otro pj
                        for (Item item : cliente.getPaqueteComercio().getItemsAObtener()) {
                            if (listAObtener.getSelectedValue().equals(item.getNombre())) {
                                saludEnemy.setText("+ " + item.getBonusSalud());
                                energyEnemy.setText("+ " + item.getBonusEnergia());
                                fzaEnemy.setText("+ " + item.getBonusFuerza());
                                desEnemy.setText("+ " + item.getBonusDestreza());
                                intEnemy.setText("+ " + item.getBonusInteligencia());
                            }
                        }
                    }
                }
            }
        });

        //CARGO MIS ITEMS		
        for (Item item : cliente.getPaquetePersonaje().getItems()) {
            misItems.addElement(item.getNombre());
        }

        // Seteo la cantidad de mis items en mi mochila
        sizeItems = misItems.size();

        //Seteo de JList
        listMisItems.setModel(misItems);
        listADar.setModel(dar);
        listAObtener.setModel(obtener);

        cantListo = new JLabel("0/2");
        cantListo.setHorizontalAlignment(SwingConstants.RIGHT);
        cantListo.setForeground(Color.WHITE);

        chckbxListo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent arg0) {
                if (chckbxListo.isSelected()) {
                    // Si ya la persona con la que voy a comerciar esta en LISTO
                    if (cantListos == 1) {
                        cantListos++;
                        // Primero actualizo el label de cant Listos
                        cantListo.setText(cantListos + "/2");
                        // Le envio al otro que toque listo y esta 2/2 listo para trueque
                        cliente.getPaqueteComercio().aumentarListo();
                        cliente.getPaqueteComercio().setComando(Comando.ACTUALIZARCOMERCIO);
                        try {
                            cliente.getSalida().writeObject(gson.toJson(cliente.getPaqueteComercio()));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar comercio");
                        }
                        ////////
                        // Ahora le digo que haga el trueque
                        cliente.getPaqueteComercio().setComando(Comando.TRUEQUE);
                        // Le informo al otro que vamos a hacer el trueque
                        try {
                            cliente.getSalida().writeObject(gson.toJson(cliente.getPaqueteComercio()));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar comercio");
                        }
                        JOptionPane.showMessageDialog(cliente.getM1(), "Se ha realizado con exito el comercio");
                        dispose();
                    } else {
                        // Si todavía LISTO = 0, le informo al otro
                        cantListos++;
                        // Deshabilito los botones para que no pueda agregar nada
                        btnAgregar.setEnabled(false);
                        btnSacar.setEnabled(false);
                        cliente.getPaqueteComercio().aumentarListo();
                        cliente.getPaqueteComercio().setComando(Comando.ACTUALIZARCOMERCIO);
                        //Tambien le tiene que avisar el LISTO al otro jugador
                        try {
                            cliente.getSalida().writeObject(gson.toJson(cliente.getPaqueteComercio()));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar comercio");
                        }
                        cantListo.setText(cantListos + "/2");
                    }
                } else {
                    // Si habia clickeado LISTO, pero lo desclickie entonces le digo 
                    // que disminuya en el otro cliente
                    if (cantListos != 2) {
                        // Si no tenia nada en la lista no tengo que disminuir la cant
                        // de listos
                        cantListos--;
                        cliente.getPaqueteComercio().disminuirListo();
                        btnAgregar.setEnabled(true);
                        btnSacar.setEnabled(true);
                        cliente.getPaqueteComercio().setComando(Comando.ACTUALIZARCOMERCIO);
                        //Tambien le tiene que avisar el NO LISTO al otro jugador
                        try {
                            cliente.getSalida().writeObject(gson.toJson(cliente.getPaqueteComercio()));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar comercio");
                        }
                        cantListo.setText(cantListos + "/2");
                    }
                }
            }
        });
        chckbxListo.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Iniciar botones.
     *
     * @param cliente
     *            the cliente
     */
    private void iniciarBotones(final Cliente cliente) {
        btnAgregar = new JButton("-->");
        btnAgregar.setIcon(new ImageIcon("recursos//flechaDer.png"));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                if (listMisItems.getSelectedValue() != null) {
                    dar.addElement(listMisItems.getSelectedValue());
                    if (obtener.size() != 0) {
                        if (sizeItems - dar.size() + obtener.size() <= ITEMS_MAX) {
                            chckbxListo.setEnabled(true);
                            leyenda.setVisible(false);
                        }
                    }
                    // Pongo el primer item y pregunto si es igual al seleccionado
                    // Entonces mientras que sean distinto lo busca
                    // Cuando sea igual sale del while y lo agrega en la lista 
                    item1 = cliente.getPaquetePersonaje().getItems().get(count);
                    while (!item1.getNombre().equals(listMisItems.getSelectedValue())) {
                        count++;
                        item1 = cliente.getPaquetePersonaje().getItems().get(count);
                    }
                    count = 0;
                    cliente.getPaqueteComercio().getItemsADar().add(item1);
                    misItems.removeElement(listMisItems.getSelectedValue());
                    cliente.getPaqueteComercio().setComando(Comando.ACTUALIZARCOMERCIO);
                    try {
                        cliente.getSalida().writeObject(gson.toJson(cliente.getPaqueteComercio()));
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar comercio");
                    }
                    if (misItems.size() == 0) {
                        bonusSalud.setText("");
                        bonusEnergia.setText("");
                        bonusFuerza.setText("");
                        bonusDes.setText("");
                        bonusInt.setText("");
                    }
                }
            }
        });

        btnSacar = new JButton("<--");
        btnSacar.setIcon(new ImageIcon("recursos//flechaIzq.png"));
        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                if (listADar.getSelectedValue() != null) {
                    misItems.addElement(listADar.getSelectedValue());
                    for (Item item : cliente.getPaquetePersonaje().getItems()) {
                        if (item.getNombre().equals(listADar.getSelectedValue())) {
                            cliente.getPaqueteComercio().getItemsADar().remove(item);
                        }
                    }
                    dar.removeElement(listADar.getSelectedValue());
                    // Si saque el item y la lista no tiene nada deshabilito el check
                    if (dar.size() == 0) {
                        chckbxListo.setEnabled(false);
                    }
                    // Si los items en total es mayor a 9 no puedo comerciar
                    if (sizeItems - dar.size() + obtener.size() > ITEMS_MAX) {
                        chckbxListo.setEnabled(false);
                        leyenda.setVisible(true);
                    }
                    cliente.getPaqueteComercio().setComando(Comando.ACTUALIZARCOMERCIO);
                    try {
                        cliente.getSalida().writeObject(gson.toJson(cliente.getPaqueteComercio()));
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar comercio");
                    }
                    // Cuando paso un item de ofertar a no ofertado muestro el que movi
                    int i = misItems.size();
                    if (i >= 1) {
                        for (Item item : cliente.getPaquetePersonaje().getItems()) {
                            if (misItems.getElementAt(i - 1).equals(item.getNombre())) {
                                bonusSalud.setText("+ " + item.getBonusSalud());
                                bonusEnergia.setText("+ " + item.getBonusEnergia());
                                bonusFuerza.setText("+ " + item.getBonusFuerza());
                                bonusDes.setText("+ " + item.getBonusDestreza());
                                bonusInt.setText("+ " + item.getBonusInteligencia());
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * Iniciar ventana.
     *
     * @param cliente
     *            the cliente
     */
    private void iniciarVentana(final Cliente cliente) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(FRAME_ANCHO, FRAME_ALTO);
        this.setLocationRelativeTo(null);
        this.setTitle("Comercio");

        contentPane = new JPanel();
        setContentPane(contentPane);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                cliente.setM1(null);
                dispose();
            }
        });
    }

    /**
     * Gets the cant listos.
     *
     * @return the cant listos
     */
    public int getCantListos() {
        return cantListos;
    }

    /**
     * Sets the cant listos.
     *
     * @param cantListos
     *            the new cant listos
     */
    public void setCantListos(final int cantListos) {
        this.cantListos = cantListos;
    }

    /**
     * Gets the cant listo.
     *
     * @return the cant listo
     */
    public JLabel getCantListo() {
        return cantListo;
    }

    /**
     * Sets the obtener.
     *
     * @param obtener
     *            the new obtener
     */
    public void setObtener(final DefaultListModel<String> obtener) {
        this.obtener = obtener;
    }

    /**
     * Gets the obtener.
     *
     * @return the obtener
     */
    public DefaultListModel<String> getObtener() {
        return obtener;
    }

    /**
     * Gets the dar.
     *
     * @return the dar
     */
    public DefaultListModel<String> getDar() {
        return dar;
    }

    /**
     * Gets the size items.
     *
     * @return the size items
     */
    public int getSizeItems() {
        return sizeItems;
    }

    /**
     * Gets the chckbx listo.
     *
     * @return the chckbx listo
     */
    public JCheckBox getChckbxListo() {
        return chckbxListo;
    }

    /**
     * Gets the leyenda.
     *
     * @return the leyenda
     */
    public JLabel getLeyenda() {
        return leyenda;
    }
}
