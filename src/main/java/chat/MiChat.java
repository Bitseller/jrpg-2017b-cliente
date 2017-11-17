package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import com.google.gson.Gson;

import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * The Class MiChat.
 */
public class MiChat extends JFrame {

    private JPanel contentPane;
    private JTextField texto;
    private JTextArea chat;
    private Juego juego;
    private final Gson gson = new Gson();
    private final JLabel background = new JLabel(new ImageIcon("recursos//background.jpg"));
    private DefaultCaret caret;
    /**
     * Posicion X desde donde se crea el frame
     */
    private static final int COORD_X_SUP_IZQ_JFRAME = 100;
    /**
     * Posicion Y desde donde se crea el frame
     */
    private static final int COORD_Y_SUP_IZQ_JFRAME = 100;
    /**
	 * Ancho del frame
	 */
    private static final int ANCHO_JFRAME = 450;
    /**
	 * Alto del frame
	 */
	private static final int ALTO_JFRAME = 300;
	/**
	 * Borde superior del frame
	 */
	private static final int BORDE_ARRIBA_JFRAME = 5;
	/**
	 * Borde izquierdo del frame
	 */
	private static final int BORDE_IZQ_JFRAME = 5;
	/**
     * Borde inferior del frame
     */
	private static final int BORDE_ABAJO_JFRAME = 5;
	/**
     * Borde derecho del frame
     */
	private static final int BORDE_DER_JFRAME = 5;
	/**
	 * Posicion X desde donde se crea el ScrollPane
	 */
	private static final int COORD_X_SUP_IZQ_SCROLLPANE = 10;
	/**
	 * Posicion Y desde donde se crea el ScrollPane
	 */
	private static final int COORD_Y_SUP_IZQ_SCROLLPANE = 11;
	/**
	 * Ancho del ScrollPane
	 */
	private static final int ANCHO_SCROLLPANE = 414;
	/**
	 * Alto del ScrollPane
	 */
	private static final int ALTO_SCROLLPANE = 201;
	/**
	 * Posicion X desde donde se crea el boton enviar
	 */
	private static final int COORD_X_SUP_IZQ_BOT_ENVIAR = 334;
	/**
	 * Posicion Y desde donde se crea el boton enviar
	 */
	private static final int COORD_Y_SUP_IZQ_BOT_ENVIAR = 225;
	/**
	 * Ancho del boton enviar
	 */
	private static final int ANCHO_BOT_ENVIAR = 81;
	/**
	 * Alto del boton enviar
	 */
	private static final int ALTO_BOT_ENVIAR = 23;
	/**
	 * Posicion X desde donde se crea el TextField
	 */
	private static final int COORD_X_SUP_IZQ_TEXTFIELD = 10;
	/**
	 * Posicion Y desde donde se crea el TextField
	 */
	private static final int COORD_Y_SUP_IZQ_TEXTFIELD = 223;
	/**
	 * Ancho del TextField
	 */
	private static final int ANCHO_TEXTFIELD = 314;
	/**
	 * Alto del TextField
	 */
	private static final int ALTO_TEXTFIELD = 27;
	/**
	 * Cantidad de columnas del TextField del chat
	 */
	private static final int COLUMNAS_TEXTFIELD = 10;
	/**
	 * Posicion X desde donde se crea el label para el fondo del chat
	 */
	private static final int COORD_X_SUP_IZQ_LABEL_FONDO = -20;
	/**
	 * Posicion Y desde donde se crea el label para el fondo del chat
	 */
	private static final int COORD_Y_SUP_IZQ_LABEL_FONDO = 0;
	/**
	 * Ancho del label para el fondo del chat
	 */
	private static final int ANCHO_LABEL_FONDO = 480;
	/**
	 * Alto del label para el fondo del chat
	 */
	private static final int ALTO_LABEL_FONDO = 283;

    /**
     * Create the frame.
     *
     * @param juego
     *            the juego
     */
    public MiChat(final Juego juego) {
        this.juego = juego;
        setTitle("Mi Chat");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(COORD_X_SUP_IZQ_JFRAME, COORD_Y_SUP_IZQ_JFRAME, ANCHO_JFRAME, ALTO_JFRAME);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(BORDE_ARRIBA_JFRAME, BORDE_IZQ_JFRAME, BORDE_ABAJO_JFRAME, BORDE_DER_JFRAME));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(COORD_X_SUP_IZQ_SCROLLPANE, COORD_Y_SUP_IZQ_SCROLLPANE, ANCHO_SCROLLPANE, ALTO_SCROLLPANE);
        contentPane.add(scrollPane);

        chat = new JTextArea();
        chat.setEditable(false);
        scrollPane.setViewportView(chat);
        caret = (DefaultCaret) chat.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        texto = new JTextField();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(final WindowEvent e) {
                texto.requestFocus();
            }

            @Override
            public void windowClosing(final WindowEvent e) {
                if (getTitle() == "Sala") {
                    if (Pantalla.getVentContac() != null) {
                        VentanaContactos.getBotonMc().setEnabled(true);
                    }
                }
                juego.getChatsActivos().remove(getTitle());
            }
        });

        //SI TOCO ENTER
        texto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (!texto.getText().equals("")) {
                	mandarMensaje();
                    texto.setText("");       
                }
            }
        });

        //SI TOCO ENVIAR
        JButton enviar = new JButton("ENVIAR");
        enviar.setIcon(new ImageIcon("recursos//enviarButton.png"));
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (!texto.getText().equals("")) {
                	mandarMensaje();
                    texto.setText("");       
                }
            }
        });
        enviar.setBounds(COORD_X_SUP_IZQ_BOT_ENVIAR, COORD_Y_SUP_IZQ_BOT_ENVIAR, ANCHO_BOT_ENVIAR, ALTO_BOT_ENVIAR);
        contentPane.add(enviar);
        texto.setBounds(COORD_X_SUP_IZQ_TEXTFIELD, COORD_Y_SUP_IZQ_TEXTFIELD, ANCHO_TEXTFIELD, ALTO_TEXTFIELD);
        contentPane.add(texto);
        texto.setColumns(COLUMNAS_TEXTFIELD);
        background.setBounds(COORD_X_SUP_IZQ_LABEL_FONDO, COORD_Y_SUP_IZQ_LABEL_FONDO, ANCHO_LABEL_FONDO,
            ALTO_LABEL_FONDO);
        contentPane.add(background);
    }

    
    /**
     * manda el mensaje a el/los usuarios correspondientes.
     *
     * @return void
     */
    public void mandarMensaje(){
        chat.append( juego.getPersonaje().getNombre() + ": " + texto.getText() + "\n");

        juego.getCliente().getPaqueteMensaje().setUserEmisor(juego.getPersonaje().getNombre());
        juego.getCliente().getPaqueteMensaje().setUserReceptor(getTitle());
        juego.getCliente().getPaqueteMensaje().setMensaje(texto.getText());

        // MANDO EL COMANDO PARA QUE ENVIE EL MSJ
        juego.getCliente().getPaqueteMensaje().setComando(Comando.TALK);
        // El user receptor en espacio indica que es para todos
        if (getTitle() == "Sala") {
            juego.getCliente().getPaqueteMensaje().setUserReceptor(null);
        }

        try {
            juego.getCliente().getSalida().writeObject(gson.toJson(juego.getCliente().getPaqueteMensaje()));
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Error al enviar mensaje");

        }

    }
    
    
    /**
     * Gets the chat.
     *
     * @return the chat
     */
    public JTextArea getChat() {
        return chat;
    }

    /**
     * Gets the texto.
     *
     * @return the texto
     */
    public JTextField getTexto() {
        return texto;
    }
}
