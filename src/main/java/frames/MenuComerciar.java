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

    private static final int FRAME_ALTO = 363;
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

    /**
     * Create the frame.
     *
     * @param cliente
     *            the cliente
     */
    public MenuComerciar(final Cliente cliente) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(FRAME_ANCHO, FRAME_ALTO);
        this.setLocationRelativeTo(null);
        this.setTitle("Comercio");

        contentPane = new JPanel();
        setContentPane(contentPane);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cliente.setM1(null);
                dispose();
            }
        });

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }

        final JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setIcon(new ImageIcon("recursos//volver.png"));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.setM1(null);
                dispose();
            }
        });

        final JList<String> listMisItems = new JList<String>();

        final JList<String> listADar = new JList<String>();

        final JList<String> listAObtener = new JList<String>();

        final JLabel lblMisItems = new JLabel("Mis Items");
        lblMisItems.setForeground(Color.WHITE);
        lblMisItems.setHorizontalAlignment(SwingConstants.CENTER);

        final JLabel lblItemsAIntercambiar = new JLabel("Items a Dar");
        lblItemsAIntercambiar.setForeground(Color.WHITE);
        lblItemsAIntercambiar.setHorizontalAlignment(SwingConstants.CENTER);

        final JLabel lblItemsAObtener = new JLabel("Items a Obtener");
        lblItemsAObtener.setForeground(Color.WHITE);
        lblItemsAObtener.setHorizontalAlignment(SwingConstants.CENTER);

        final JLabel lblSalud = new JLabel("Salud");
        lblSalud.setForeground(Color.WHITE);

        final JLabel lblEnerga = new JLabel("Energía");
        lblEnerga.setForeground(Color.WHITE);

        final JLabel lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);

        final JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);

        final JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);

        final JLabel lblSaludEnemy = new JLabel("Salud");
        lblSaludEnemy.setForeground(Color.WHITE);

        final JLabel lblEnergiaEnemy = new JLabel("Energía");
        lblEnergiaEnemy.setForeground(Color.WHITE);

        final JLabel lblFzaEnemy = new JLabel("Fuerza");
        lblFzaEnemy.setForeground(Color.WHITE);

        final JLabel lblDesEnemy = new JLabel("Destreza");
        lblDesEnemy.setForeground(Color.WHITE);

        final JLabel lblIntEnemy = new JLabel("Inteligencia");
        lblIntEnemy.setForeground(Color.WHITE);

        final JLabel lblListo = new JLabel("Listo");
        lblListo.setForeground(Color.WHITE);

        final JLabel bonusSalud = new JLabel("");
        bonusSalud.setForeground(Color.WHITE);
        bonusSalud.setHorizontalAlignment(SwingConstants.RIGHT);

        final JLabel bonusEnergia = new JLabel("");
        bonusEnergia.setForeground(Color.WHITE);
        bonusEnergia.setHorizontalAlignment(SwingConstants.RIGHT);

        final JLabel bonusFuerza = new JLabel("");
        bonusFuerza.setForeground(Color.WHITE);
        bonusFuerza.setHorizontalAlignment(SwingConstants.RIGHT);

        final JLabel bonusDes = new JLabel("");
        bonusDes.setForeground(Color.WHITE);
        bonusDes.setHorizontalAlignment(SwingConstants.RIGHT);

        final JLabel bonusInt = new JLabel("");
        bonusInt.setForeground(Color.WHITE);
        bonusInt.setHorizontalAlignment(SwingConstants.RIGHT);

        final JLabel saludEnemy = new JLabel("");
        saludEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        saludEnemy.setForeground(Color.WHITE);

        final JLabel energyEnemy = new JLabel("");
        energyEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        energyEnemy.setForeground(Color.WHITE);

        final JLabel fzaEnemy = new JLabel("");
        fzaEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        fzaEnemy.setForeground(Color.WHITE);

        final JLabel desEnemy = new JLabel("");
        desEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        desEnemy.setForeground(Color.WHITE);

        final JLabel intEnemy = new JLabel("");
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

        final JButton btnAgregar = new JButton("-->");
        btnAgregar.setIcon(new ImageIcon("recursos//flechaDer.png"));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (listMisItems.getSelectedValue() != null) {
                    dar.addElement(listMisItems.getSelectedValue());
                    if (obtener.size() != 0) {
                        if (sizeItems - dar.size() + obtener.size() <= 9) {
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

        final JButton btnSacar = new JButton("<--");
        btnSacar.setIcon(new ImageIcon("recursos//flechaIzq.png"));
        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
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
                    if (sizeItems - dar.size() + obtener.size() > 9) {
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

        // List Listener para cargar stats del item mio clickeado
        listMisItems.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
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
            public void mouseClicked(MouseEvent arg0) {
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
            public void itemStateChanged(ItemEvent arg0) {
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

        final JLabel background = new JLabel("");
        background.setIcon(new ImageIcon(MenuCarga.class.getResource("recursos//background.jpg")));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblMisItems, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(75)
                    .addComponent(lblItemsAIntercambiar, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(27)
                    .addComponent(lblItemsAObtener, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(listMisItems, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSacar, GroupLayout.PREFERRED_SIZE, BOTON_CHICO_ANCHO,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(12)
                    .addComponent(listADar, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(63)
                    .addComponent(bonusSalud, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(6)
                    .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(7)
                    .addComponent(bonusFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(155)
                    .addComponent(lblSaludEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(54)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblFzaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(39)
                            .addComponent(fzaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                                GroupLayout.PREFERRED_SIZE))))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(24)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblEnerga, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                            GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(39)
                            .addComponent(bonusInt, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                                GroupLayout.PREFERRED_SIZE)))
                    .addGap(6)
                    .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(7)
                    .addComponent(bonusDes, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addGap(44)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblListo, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(41)
                            .addComponent(cantListo, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                                GroupLayout.PREFERRED_SIZE)))
                    .addGap(14)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblEnergiaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                            GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(41)
                            .addComponent(energyEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                                GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(41)
                            .addComponent(intEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                                GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblIntEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(39)
                            .addComponent(desEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                                GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblDesEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO,
                            GroupLayout.PREFERRED_SIZE)))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(leyenda, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(63)
                    .addComponent(bonusEnergia, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(440)
                    .addComponent(listAObtener, GroupLayout.PREFERRED_SIZE, LISTA_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(24)
                    .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(440)
                    .addComponent(saludEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(301)
                    .addComponent(chckbxListo, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblMisItems, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblItemsAIntercambiar, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblItemsAObtener, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(listMisItems, GroupLayout.PREFERRED_SIZE, LISTA_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(BOTON_CHICO_ANCHO)
                            .addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, BOTON_ALTO,
                                GroupLayout.PREFERRED_SIZE)
                            .addGap(FRAME_COLUMNA1)
                            .addComponent(btnSacar, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                        .addComponent(listADar, GroupLayout.PREFERRED_SIZE, LISTA_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FRAME_COLUMNA1)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(bonusSalud, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonusFuerza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSaludEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFzaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fzaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(7)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblEnerga, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                            .addGap(7)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblInteligencia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(bonusInt, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                    GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lblDestreza, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bonusDes, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(5)
                            .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, BOTON_ALTO,
                                GroupLayout.PREFERRED_SIZE)
                            .addGap(8)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    //.addGap(1)
                                    .addComponent(lblListo, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                        GroupLayout.PREFERRED_SIZE))
                                .addComponent(cantListo, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                    GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblEnergiaEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(energyEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                    GroupLayout.PREFERRED_SIZE))
                            .addGap(7)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(intEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblIntEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                                    GroupLayout.PREFERRED_SIZE)))
                        .addComponent(desEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDesEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(4)
                    .addComponent(leyenda, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(240)
                    .addComponent(bonusEnergia, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(42)
                    .addComponent(listAObtener, GroupLayout.PREFERRED_SIZE, LISTA_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(217)
                    .addComponent(lblSalud, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(217)
                    .addComponent(saludEnemy, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(213)
                    .addComponent(chckbxListo, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(gl_contentPane);
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
    public void setCantListos(int cantListos) {
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
    public void setObtener(DefaultListModel<String> obtener) {
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