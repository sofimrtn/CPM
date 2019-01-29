package cine;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.jvnet.substance.SubstanceLookAndFeel;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.net.URL;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Rectangle;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;

public class VPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private MuestraDescripcion m;
	private Cartelera cartelera;
	private JPanel contentPane;
	private JPanel panelNorte;
	private JLabel lblIcon;
	private JLabel lblTitulo;
	private JPanel panelOeste;
	private JLabel lblGenero;
	private JCheckBox chckbxAventuras;
	private JCheckBox chckbxComedia;
	private JCheckBox chckbxDrama;
	private JCheckBox chckbxMusical;
	private JPanel panelEste;
	private JPanel panel3D;
	private JPanel panelEntradas;
	private JPanel panelPrecio;
	private JPanel panelBotones;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtPrecioFinal;
	private JLabel lblEntradas;
	private JSpinner spinnerEntradas;
	private JLabel lbl3D;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JPanel panelRadioBotones;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelCentro;
	
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;
	private JTextArea txtrCodigoYSinopsis;
	private JTable tableCartelera;
	private JMenuBar menuBar;
	private JMenu mnHome;
	private JMenuItem mntmReset;
	private JMenuItem mntmSalir;
	private JMenu mnConfig;
	private JMenuItem mntmAyuda;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					VPrincipal frame = new VPrincipal();
					frame.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.api.skin.GeminiSkin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VPrincipal() {
		setBounds(new Rectangle(0, 0, 560, 450));
		cartelera = new Cartelera();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VPrincipal.class.getResource("/img/cine.png")));
		setTitle("Cine EII Oviedo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 452);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelOeste(), BorderLayout.WEST);
		contentPane.add(getPanelEste(), BorderLayout.EAST);
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		
		anadirFilas(chckbxAventuras.isSelected(),chckbxComedia.isSelected(),chckbxDrama.isSelected(),chckbxMusical.isSelected());
		
		cargaAyuda();
		
	}

	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setLayout(new GridLayout(0, 2, 0, 0));
			panelNorte.add(getLblIcon());
			panelNorte.add(getLblTitulo());
		}
		return panelNorte;
	}
	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("");
			lblIcon.setToolTipText("Cine EII Oviedo");
			lblIcon.setIcon(new ImageIcon(VPrincipal.class.getResource("/img/cine.png")));
			lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIcon;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Cine EII Oviedo");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Stencil", Font.PLAIN, 25));
		}
		return lblTitulo;
	}
	private JPanel getPanelOeste() {
		if (panelOeste == null) {
			panelOeste = new JPanel();
			panelOeste.setLayout(new GridLayout(5, 1, 0, 0));
			panelOeste.add(getLblGenero());
			panelOeste.add(getChckbxAventuras());
			panelOeste.add(getChckbxComedia());
			panelOeste.add(getChckbxDrama());
			panelOeste.add(getChckbxMusical());
		}
		return panelOeste;
	}
	private JLabel getLblGenero() {
		if (lblGenero == null) {
			lblGenero = new JLabel(" G\u00E9nero:  ");
			lblGenero.setToolTipText("Filtra por g\u00E9nero");
		}
		return lblGenero;
	}
	private JCheckBox getChckbxAventuras() {
		if (chckbxAventuras == null) {
			chckbxAventuras = new JCheckBox("Aventuras");
			chckbxAventuras.setMnemonic('v');
			chckbxAventuras.setSelected(true);
			chckbxAventuras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarFilaTipo();
				}
			});
			
		}
		return chckbxAventuras;
	}
	private JCheckBox getChckbxComedia() {
		if (chckbxComedia == null) {
			chckbxComedia = new JCheckBox("Comedia");
			chckbxComedia.setMnemonic('m');
			chckbxComedia.setSelected(true);
			chckbxComedia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarFilaTipo();
				}
			});
			
		}
		return chckbxComedia;
	}
	private JCheckBox getChckbxDrama() {
		if (chckbxDrama == null) {
			chckbxDrama = new JCheckBox("Drama");
			chckbxDrama.setMnemonic('d');
			chckbxDrama.setSelected(true);
			chckbxDrama.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarFilaTipo();
				}
			});
			
		}
		return chckbxDrama;
	}
	private JCheckBox getChckbxMusical() {
		if (chckbxMusical == null) {
			chckbxMusical = new JCheckBox("Musical");
			chckbxMusical.setMnemonic('s');
			chckbxMusical.setSelected(true);
			chckbxMusical.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarFilaTipo();
				}
			});
		}
		return chckbxMusical;
	}
	private JPanel getPanelEste() {
		if (panelEste == null) {
			panelEste = new JPanel();
			panelEste.setLayout(new GridLayout(4, 1, 0, 0));
			panelEste.add(getPanel3D());
			panelEste.add(getPanelEntradas());
			panelEste.add(getPanelPrecio());
			panelEste.add(getPanelBotones());
		}
		return panelEste;
	}
	private JPanel getPanel3D() {
		if (panel3D == null) {
			panel3D = new JPanel();
			panel3D.setLayout(new GridLayout(2, 1, 0, 0));
			panel3D.add(getLbl3D());
			panel3D.add(getPanelRadioBotones());
		}
		return panel3D;
	}
	private JPanel getPanelEntradas() {
		if (panelEntradas == null) {
			panelEntradas = new JPanel();
			panelEntradas.setLayout(new GridLayout(2, 1, 0, 0));
			panelEntradas.add(getLblEntradas());
			panelEntradas.add(getSpinnerEntradas());
		}
		return panelEntradas;
	}
	private JPanel getPanelPrecio() {
		if (panelPrecio == null) {
			panelPrecio = new JPanel();
			panelPrecio.setToolTipText("");
			panelPrecio.setBorder(new TitledBorder(null, "Precio final", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panelPrecio.add(getTxtPrecioFinal());
		}
		return panelPrecio;
	}
	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.add(getBtnAceptar());
			panelBotones.add(getBtnCancelar());
		}
		return panelBotones;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					muestraDialogo();
				}
			});
			btnAceptar.setEnabled(false);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inicializar();
				}
			});
		}
		return btnCancelar;
	}
	private JTextField getTxtPrecioFinal() {
		if (txtPrecioFinal == null) {
			txtPrecioFinal = new JTextField();
			txtPrecioFinal.setToolTipText("Precio final de la pelicula");
			txtPrecioFinal.setHorizontalAlignment(SwingConstants.CENTER);
			txtPrecioFinal.setEditable(false);
			txtPrecioFinal.setColumns(10);
		}
		return txtPrecioFinal;
	}
	private JLabel getLblEntradas() {
		if (lblEntradas == null) {
			lblEntradas = new JLabel("N\u00BA Entradas:");
			lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
			lblEntradas.setEnabled(false);
		}
		return lblEntradas;
	}
	private JSpinner getSpinnerEntradas() {
		if (spinnerEntradas == null) {
			spinnerEntradas = new JSpinner();
			spinnerEntradas.setToolTipText("Numero de entradas");
			spinnerEntradas.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					if(rdbtnSi.isSelected()) {
						String precio = String.valueOf(cartelera.getPrecioConTresDe((int)spinnerEntradas.getValue()));
						txtPrecioFinal.setText(precio);
					}else if(rdbtnNo.isSelected()) {
						String precio = String.valueOf(cartelera.getPrecio((int)spinnerEntradas.getValue()));
						txtPrecioFinal.setText(precio);
					}else {
						String precio = String.valueOf(cartelera.getPrecio((int)spinnerEntradas.getValue()));
						txtPrecioFinal.setText(precio);
					}
				}
			});
			spinnerEntradas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerEntradas.setEnabled(false);
		}
		return spinnerEntradas;
	}
	private JLabel getLbl3D() {
		if (lbl3D == null) {
			lbl3D = new JLabel("Ver pel\u00EDcula en 3D:");
			lbl3D.setToolTipText("Marca si quiere ver la pel\u00EDcula en 3D");
			lbl3D.setEnabled(false);
			lbl3D.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl3D;
	}
	private JRadioButton getRdbtnSi() {
		if (rdbtnSi == null) {
			rdbtnSi = new JRadioButton("S\u00ED");
			rdbtnSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String precio = String.valueOf(cartelera.getPrecioConTresDe((int)spinnerEntradas.getValue()));
					txtPrecioFinal.setText(precio);
					btnAceptar.setEnabled(true);
				}
			});
			buttonGroup.add(rdbtnSi);
			rdbtnSi.setEnabled(false);
			rdbtnSi.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return rdbtnSi;
	}
	private JRadioButton getRdbtnNo() {
		if (rdbtnNo == null) {
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String precio = String.valueOf(cartelera.getPrecio((int)spinnerEntradas.getValue()));
					txtPrecioFinal.setText(precio);
					btnAceptar.setEnabled(true);
				}
			});
			buttonGroup.add(rdbtnNo);
			rdbtnNo.setEnabled(false);
		}
		return rdbtnNo;
	}
	private JPanel getPanelRadioBotones() {
		if (panelRadioBotones == null) {
			panelRadioBotones = new JPanel();
			panelRadioBotones.add(getRdbtnSi());
			panelRadioBotones.add(getRdbtnNo());
		}
		return panelRadioBotones;
	}
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new GridLayout(2, 1, 0, 0));
			panelCentro.add(getScrollPane_1());
			panelCentro.add(getTxtrCodigoYSinopsis());
		}
		return panelCentro;
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(tableCartelera);
			scrollPane.setViewportView(getTableCartelera());
		}
		return scrollPane;
	}
	private JTextArea getTxtrCodigoYSinopsis() {
		if (txtrCodigoYSinopsis == null) {
			txtrCodigoYSinopsis = new JTextArea();
			txtrCodigoYSinopsis.setToolTipText("codigo y sinopsis");
			txtrCodigoYSinopsis.setWrapStyleWord(true);
			txtrCodigoYSinopsis.setLineWrap(true);
			txtrCodigoYSinopsis.setEditable(false);
		}
		return txtrCodigoYSinopsis;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JTable getTableCartelera() {
		if (tableCartelera == null) {
			String[] col = {"Titulo","Genero","Sala","3D"};
			modeloTabla= new ModeloNoEditable(col,0);
			tableCartelera = new JTable(modeloTabla);
			//tableCartelera.addMouseListener(m);
			tableCartelera.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String tresde = String.valueOf(tableCartelera.getValueAt(tableCartelera.getSelectedRow(), 3));
					String titulo = String.valueOf(tableCartelera.getValueAt(tableCartelera.getSelectedRow(), 0));
					if(tresde.equals("S")) {
						rdbtnSi.setEnabled(true);
						rdbtnNo.setEnabled(true);
						lbl3D.setEnabled(true);
					}else if(tresde.equals("N")) {
						rdbtnSi.setEnabled(false);
						rdbtnNo.setEnabled(false);
						lbl3D.setEnabled(false);
						btnAceptar.setEnabled(true);
					}
					txtPrecioFinal.setText(String.valueOf(cartelera.getPrecio((int)spinnerEntradas.getValue())));
					txtrCodigoYSinopsis.setText(cartelera.muestraSinopsis(titulo));
					lblEntradas.setEnabled(true);
					spinnerEntradas.setEnabled(true);
				}
			});
			
			tableCartelera.getTableHeader().setReorderingAllowed(false);
			tableCartelera.setRowSorter(new TableRowSorter(modeloTabla));
		}
		return tableCartelera;
	}
	
	private void anadirFilas(boolean aventuras, boolean comedia, boolean drama, boolean musical) {
		Object[] filas = new Object[4];
		List<Pelicula> peliculas = Cartelera.getPeliculas();
		for(Pelicula p:peliculas) {
			String genero = p.getGenero();
			if((aventuras && genero.equals("Aventuras"))|| (comedia && genero.equals("Comedia"))|| 
					(drama && genero.equals("Drama"))|| (musical && genero.equals("Musical"))) {
				filas[0] = p.getTitulo();
				filas[1] = p.getGenero();
				filas[2] = p.getSala();
				filas[3] = p.getTresde();
				modeloTabla.addRow(filas);
			}
		}
	}
	
	private void mostrarFilaTipo() {
		modeloTabla.getDataVector().clear();
		anadirFilas(chckbxAventuras.isSelected(),chckbxComedia.isSelected(),chckbxDrama.isSelected(),chckbxMusical.isSelected());
		modeloTabla.fireTableDataChanged();
	}
	
	void inicializar() {
		chckbxAventuras.setSelected(true);
		chckbxComedia.setSelected(true);
		chckbxDrama.setSelected(true);
		chckbxMusical.setSelected(true);
		btnAceptar.setEnabled(false);
		
		rdbtnSi.setEnabled(false);
		rdbtnNo.setEnabled(false);
		lbl3D.setEnabled(false);
		
		txtPrecioFinal.setText("");
		txtrCodigoYSinopsis.setText("");
		
		buttonGroup.clearSelection();
		
		lblEntradas.setEnabled(false);
		spinnerEntradas.setEnabled(false);
		
		tableCartelera.clearSelection();
		tableCartelera.grabFocus();
		
		anadirFilas(chckbxAventuras.isSelected(),chckbxComedia.isSelected(),chckbxDrama.isSelected(),chckbxMusical.isSelected());
		
	}
	
	public void muestraDialogo() {
		VDatos dialogo = new VDatos(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setModal(true);
		dialogo.setVisible(true);
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnHome());
			menuBar.add(getMnConfig());
		}
		return menuBar;
	}
	private JMenu getMnHome() {
		if (mnHome == null) {
			mnHome = new JMenu("Home");
			mnHome.setMnemonic('h');
			mnHome.add(getMntmReset());
			mnHome.add(getSeparator());
			mnHome.add(getMntmSalir());
		}
		return mnHome;
	}
	private JMenuItem getMntmReset() {
		if (mntmReset == null) {
			mntmReset = new JMenuItem("Reset");
			mntmReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inicializar();
				}
			});
			mntmReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		}
		return mntmReset;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		}
		return mntmSalir;
	}
	private JMenu getMnConfig() {
		if (mnConfig == null) {
			mnConfig = new JMenu("Configuraci\u00F3n");
			mnConfig.setMnemonic('c');
			mnConfig.add(getMntmAyuda());
		}
		return mnConfig;
	}
	private JMenuItem getMntmAyuda() {
		if (mntmAyuda == null) {
			mntmAyuda = new JMenuItem("Ayuda");
			mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmAyuda;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	
	public String getTitulo() {
		return String.valueOf(tableCartelera.getValueAt(tableCartelera.getSelectedRow(), 0));
	}
	
	public String getSala() {
		return String.valueOf(tableCartelera.getValueAt(tableCartelera.getSelectedRow(), 2));
	}
	
	public String getEntradas() {
		return String.valueOf(spinnerEntradas.getValue());
	}
	
	public String getPrecio() {
		return txtPrecioFinal.getText();
	}
	
	void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			 }

		    catch(Exception e){
		      		System.out.println("Ayuda no encontrada");
		      		return;
		        }

		   HelpBroker hb = hs.createHelpBroker();

		   hb.enableHelpKey(getRootPane(),"principal", hs);
		   hb.enableHelpOnButton(getMntmAyuda(), "principal", hs);
		   
		 }
	
//	abstract class MuestraDescripcion implements MouseListener{
//
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			String titulo = String.valueOf(tableCartelera.getValueAt(tableCartelera.getSelectedRow(), 0));
//			txtrCodigoYSinopsis.setText(cartelera.muestraSinopsis(titulo));
//		}
//		
//	}
}
