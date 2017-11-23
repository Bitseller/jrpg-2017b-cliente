package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cliente.Cliente;
import frames.MenuEscape;
import juego.Juego;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The Class VentanaContactos.
 */
public class VentanaContactos extends JFrame {
    private static final int BOTON_ANCHO = 89;
    private static final int BOTON_ALTO = 23;
    private static final int SCROLL_ALTO = 188;
    private static final int SCROLL_ANCHO = 300;
    private static final int FRAME_ALTO = 273;
    private static final int FRAME_ANCHO = 327;

    private JPanel contentPane;
    private DefaultListModel<String> modelo = new DefaultListModel<String>();
    private static JList<String> list = new JList<String>();
    private static JButton botonMc;
    private JLabel background;

    /**
     * Create the frame.
     *
     * @param juego
     *            the juego
     */
    public VentanaContactos(final Cliente client) {
    	addKeyListener(new KeyAdapter() {
    		//Si se presiona la tecla escape
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
    				Pantalla.setVentContac(null);
    				dispose();
    			}
    		}
    	});
    	
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(FRAME_ANCHO, FRAME_ALTO);
        setLocationRelativeTo(null);
        setTitle("Usuarios");

        contentPane = new JPanel();
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        botonMc = new JButton("Multichat");
        botonMc.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        			if (!client.getJuego().getChatsActivos().containsKey("Sala")) { // si no esta abierto ya el multichat
            			MiChat chat = new MiChat(client.getJuego());
            			client.getJuego().getChatsActivos().put("Sala", chat);
            			chat.setTitle("Sala");
            			chat.setVisible(true);
            			botonMc.setEnabled(false); 
            		}
        		}
        	}
        });
        
        botonMc.setIcon(new ImageIcon("recursos//multichatButton.png"));
        botonMc.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(final ActionEvent e) { 
        		if (!client.getJuego().getChatsActivos().containsKey("Sala")) { // si no esta abierto ya el multichat
        			MiChat chat = new MiChat(client.getJuego());
        			client.getJuego().getChatsActivos().put("Sala", chat);
        			chat.setTitle("Sala");
        			chat.setVisible(true);
        			botonMc.setEnabled(false); 
        		}
        	}
        });
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent arg0) {
                Pantalla.setVentContac(null);
                dispose();
            }
        	@Override
        	public void windowOpened(WindowEvent arg0) {
        		botonMc.requestFocus();
        	}
        });
       

        
        // Cargo la lista de contactos
        actualizarLista(client.getJuego());
        
        // Pregunto si la ventana sala esta abierta y cancelo el boton multichat
        if (client.getJuego().getChatsActivos().containsKey("Sala")) {
            botonMc.setEnabled(false);
        } else {
            botonMc.setEnabled(true);
        }

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                if (arg0.getClickCount() == 2) {
                    if (list.getSelectedValue() != null) {
                        if (!client.getJuego().getChatsActivos().containsKey(list.getSelectedValue())) {
                            if (client.getJuego().getCliente() != null) {
                                MiChat chat = new MiChat(client.getJuego());
                                client.getJuego().getChatsActivos().put(list.getSelectedValue(), chat);
                                chat.setTitle(list.getSelectedValue());
                                chat.setVisible(true);
                            }
                        }
                    }
                }
            }
        });

        list.setModel(modelo);
        scrollPane.setViewportView(list);

        background = new JLabel(new ImageIcon("recursos//background.jpg"));
        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, SCROLL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(botonMc, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, SCROLL_ALTO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMc, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(layout);
    }

    /**
     * Actualizar lista.
     *
     * @param juego
     *            the juego
     */
    private void actualizarLista(final Juego juego) {
        if (juego.getCliente() != null) {
            synchronized (juego.getCliente()) {
                modelo.removeAllElements();
                if (juego.getPersonajesConectados() != null) {
                    for (Map.Entry<Integer, PaquetePersonaje> personaje : juego.getPersonajesConectados().entrySet()) {
                        modelo.addElement(personaje.getValue().getNombre());
                    }
                    modelo.removeElement(juego.getPersonaje().getNombre());
                    list.setModel(modelo);
                }
            }
        }
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public static JList<String> getList() {
        return list;
    }

    /**
     * Gets the boton mc.
     *
     * @return the boton mc
     */
    public static JButton getBotonMc() {
        return botonMc;
    }
}
