package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The Class MiChat.
 */
public class MiChat extends JFrame {

	private JPanel contentPane;
	private JTextField texto;
	private Stack<String> StackTextoPrevio;
	private Stack<String> StackTextoPosterior;
	private JTextArea chat;
	private Juego juego;
	private final Gson gson = new Gson();
	private final JLabel background = new JLabel(new ImageIcon("recursos//background.jpg"));
	private DefaultCaret caret;
	Clip sonido = null;
	String cancion = "";

	/**
	 * Valor por el cual se multiplica la fuerza en cheat Bigdaddy y Tinydaddy
	 */
	private static final int DOBLEFUERZA = 2;

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
		addKeyListener(new KeyAdapter() {
			// Si se presiona la tecla escape
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (getTitle() == "Sala") {
						if (Pantalla.getVentContac() != null) {
							VentanaContactos.getBotonMc().setEnabled(true);
						}
					}
					juego.getChatsActivos().remove(getTitle());
				}
			}
		});

		this.juego = juego;
		setTitle("Mi Chat");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(COORD_X_SUP_IZQ_JFRAME, COORD_Y_SUP_IZQ_JFRAME, ANCHO_JFRAME, ALTO_JFRAME);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(
				new EmptyBorder(BORDE_ARRIBA_JFRAME, BORDE_IZQ_JFRAME, BORDE_ABAJO_JFRAME, BORDE_DER_JFRAME));
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

		StackTextoPrevio = new Stack<String>();
		StackTextoPrevio.push("");
		StackTextoPosterior = new Stack<String>();
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

		// Si se presiona la tecla enter
		texto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if (!texto.getText().equals("")) {
					if (texto.getText().charAt(0) == '/') {
						ponerCheat(texto.getText());
					} else {
						StackTextoPrevio.push(texto.getText());
						mandarMensaje();
					}
					texto.setText("");
				}
			}
		});

		// Si presiono el boton Enviar
		JButton enviar = new JButton("ENVIAR");
		enviar.setIcon(new ImageIcon("recursos//enviarButton.png"));
		enviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if (!texto.getText().equals("")) {
					if (texto.getText().charAt(0) == '/') {
						// chat.append("HOLA MUNDO");
						// texto.setText("");
						ponerCheat(texto.getText());
					} else {
						StackTextoPrevio.push(texto.getText());
						mandarMensaje();
					}
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

		// Si pulso la flecha de arriba o abajo, me carga entradas anteriores
		// que realice.
		texto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP && !StackTextoPrevio.empty()) {
					StackTextoPosterior.push(texto.getText());
					texto.setText(StackTextoPrevio.pop());
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN && !StackTextoPosterior.empty()) {
					StackTextoPrevio.push(texto.getText());
					texto.setText(StackTextoPosterior.pop());
				}
			}
		});
		try {
			sonido = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * manda el mensaje a el/los usuarios correspondientes.
	 *
	 * @return void
	 */
	public void mandarMensaje() {
		chat.append(juego.getPersonaje().getNombre() + ": " + texto.getText() + "\n");

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

	public void ponerCheat(String cheat) {
		PaquetePersonaje pjCheater = juego.getPersonaje();
		int cheatCode;
		File tom = null;
		File vap = null;
		File star = null;
		File doom = null;
		tom = new File("recursos\\tomfoolery.wav");
		vap = new File("recursos\\vaporwave.wav");
		star = new File("recursos\\starfox.wav");
		doom = new File("recursos\\doom.wav");

		if (pjCheater.getCheats().containsKey(cheat)) {
			cheatCode = pjCheater.getCheats().get(cheat);

			switch (cheat) {
			case "/iddqd":
				if (!pjCheater.getEstadoCheats(cheatCode)) {
					sonido.stop();
					sonido.close();
					cancion = "doom";
					try {
						sonido.open(AudioSystem.getAudioInputStream(doom));
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						e1.printStackTrace();
					}
					sonido.start();
					pjCheater.setEstadoCheats(cheatCode, true);
					setAnim("GodMode");
					chat.append("\n/iddqd ON");
				} else {
					pjCheater.setEstadoCheats(cheatCode, false);
					setAnim("");
					sonido.stop();
					sonido.close();
					cancion = "";
					chat.append("\n/iddqd OFF");
				}
				break;
			case "/noclip":
				if (!pjCheater.getEstadoCheats(cheatCode)) {
					juego.setCheatAtravezarParedes(true);
					setAnim("Fantasma");
					pjCheater.setEstadoCheats(cheatCode, true);
					chat.append("\n/noclip ON");
				} else {
					juego.setCheatAtravezarParedes(false);
					setAnim("");
					pjCheater.setEstadoCheats(cheatCode, false);
					chat.append("\n/noclip OFF");
				}
				break;
			case "/bigdaddy":
				if (!pjCheater.getEstadoCheats(cheatCode)) {
					pjCheater.setEstadoCheats(cheatCode, true);
					setAnim("Big");
					chat.append("\n/bigdaddy ON");
				} else {
					setAnim("");
					pjCheater.setEstadoCheats(cheatCode, false);
					chat.append("\n/bigdaddy OFF");
				}
				break;
			case "/tinydaddy":
				if (!pjCheater.getEstadoCheats(cheatCode)) {
					pjCheater.setEstadoCheats(cheatCode, true);
					setAnim("Tiny");
					chat.append("\n/tinydaddy ON");
				} else {
					setAnim("");
					pjCheater.setEstadoCheats(cheatCode, false);
					chat.append("\n/tinydaddy OFF");
				}
				break;
			case "/war aint what it used to be":
				if (!pjCheater.getEstadoCheats(cheatCode)) {
					pjCheater.setInvisible(true);
					setAnim("Invisible");
					pjCheater.setEstadoCheats(cheatCode, true);
					chat.append("\n/wawiutb ON");
				} else {
					pjCheater.setInvisible(false);
					setAnim("");
					pjCheater.setEstadoCheats(cheatCode, false);
					chat.append("\n/wawiutb OFF");
				}
				break;
			case "/tomfoolery":
				sonido.stop();
				sonido.close();
				if (!cancion.equals("tom")) {
					cancion = "tom";
					try {
						sonido.open(AudioSystem.getAudioInputStream(tom));
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sonido.start();
					chat.append("\n/tomfoolery ON");
				} else {
					chat.append("\n/tomfoolery OFF");
					cancion = "";
				}
				break;
			case "/starfox":
				sonido.stop();
				sonido.close();
				if (!cancion.equals("star")) {
					cancion = "star";
					try {
						sonido.open(AudioSystem.getAudioInputStream(star));
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sonido.start();
					chat.append("\n/starfox ON");
				} else {
					chat.append("\n/starfox OFF");
					cancion = "";
				}
				break;
			case "/vaporwave":
				sonido.stop();
				sonido.close();
				if (!cancion.equals("vap")) {
					cancion = "vap";
					try {
						sonido.open(AudioSystem.getAudioInputStream(vap));
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sonido.start();
					chat.append("\n/vaporwave ON");
				} else {
					chat.append("\n/vaporwave OFF");
					cancion = "";
				}
				break;
			}
			juego.setPersonaje(pjCheater);
			try {
				juego.getCliente().getSalida().writeObject(gson.toJson(pjCheater));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void setAnim(String tipo) {
		juego.getEstadoJuego().getEntidadPersonaje()
				.setPatronAnimaciones(Recursos.getPersonaje().get(juego.getPersonaje().getRaza() + tipo));
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
