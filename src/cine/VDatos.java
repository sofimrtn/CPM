package cine;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VDatos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelDatosPersonales;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JPanel panelDatosPelicula;
	private JLabel lblTitulo;
	private JLabel lblSala;
	private JLabel lblNEntradas;
	private JLabel lblPrecioFinal;
	@SuppressWarnings("rawtypes")
	private JList listExtra;
	private JLabel lblExtra;
	private JTextField txtExtra;
	private JTextField txtPrecioFinal;
	private JTextField txtEntradas;
	private JTextField txtSala;
	private JTextField txtTitulo;
	
	private VPrincipal v;

	/**
	 * Create the dialog.
	 */
	public VDatos(VPrincipal ventanaPrincipal) {
		setBounds(new Rectangle(0, 0, 470, 442));
		this.v = ventanaPrincipal;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VDatos.class.getResource("/img/cine.png")));
		JDialog.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.api.skin.GeminiSkin");
		setTitle("Cine EII Oviedo: Introduci\u00F3n Datos");
		setResizable(false);
		setBounds(100, 100, 371, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getPanelDatosPersonales());
		contentPanel.add(getPanelDatosPelicula());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setMnemonic('p');
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						comprobarCampos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setMnemonic('n');
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						v.inicializar();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private JPanel getPanelDatosPersonales() {
		if (panelDatosPersonales == null) {
			panelDatosPersonales = new JPanel();
			panelDatosPersonales.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDatosPersonales.setBounds(10, 11, 342, 90);
			panelDatosPersonales.setLayout(null);
			panelDatosPersonales.add(getLblNombre());
			panelDatosPersonales.add(getLblApellidos());
			panelDatosPersonales.add(getTxtNombre());
			panelDatosPersonales.add(getTxtApellidos());
		}
		return panelDatosPersonales;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(22, 26, 56, 14);
		}
		return lblNombre;
	}
	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(22, 55, 56, 14);
		}
		return lblApellidos;
	}
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setToolTipText("Introduzca nombre");
			txtNombre.setBounds(110, 23, 148, 20);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	private JTextField getTxtApellidos() {
		if (txtApellidos == null) {
			txtApellidos = new JTextField();
			txtApellidos.setToolTipText("Introduzca apellido");
			txtApellidos.setBounds(110, 53, 148, 20);
			txtApellidos.setColumns(10);
		}
		return txtApellidos;
	}
	private JPanel getPanelDatosPelicula() {
		if (panelDatosPelicula == null) {
			panelDatosPelicula = new JPanel();
			panelDatosPelicula.setBorder(new TitledBorder(null, "Datos pel\u00EDcula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDatosPelicula.setBounds(10, 112, 342, 257);
			panelDatosPelicula.setLayout(null);
			panelDatosPelicula.add(getLblTitulo());
			panelDatosPelicula.add(getLblSala());
			panelDatosPelicula.add(getLblNEntradas());
			panelDatosPelicula.add(getLblPrecioFinal());
			panelDatosPelicula.add(getListExtra());
			panelDatosPelicula.add(getLblExtra());
			panelDatosPelicula.add(getTxtExtra());
			panelDatosPelicula.add(getTxtPrecioFinal());
			panelDatosPelicula.add(getTxtEntradas());
			panelDatosPelicula.add(getTxtSala());
			panelDatosPelicula.add(getTxtTitulo());
		}
		return panelDatosPelicula;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("T\u00EDtulo: ");
			lblTitulo.setBounds(23, 25, 46, 14);
		}
		return lblTitulo;
	}
	private JLabel getLblSala() {
		if (lblSala == null) {
			lblSala = new JLabel("Sala:");
			lblSala.setBounds(23, 50, 46, 14);
		}
		return lblSala;
	}
	private JLabel getLblNEntradas() {
		if (lblNEntradas == null) {
			lblNEntradas = new JLabel("N\u00BA Entradas");
			lblNEntradas.setBounds(23, 75, 77, 14);
		}
		return lblNEntradas;
	}
	private JLabel getLblPrecioFinal() {
		if (lblPrecioFinal == null) {
			lblPrecioFinal = new JLabel("Precio final: ");
			lblPrecioFinal.setBounds(23, 100, 70, 14);
		}
		return lblPrecioFinal;
	}
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private JList getListExtra() {
		if (listExtra == null) {
			listExtra = new JList();
			listExtra.setToolTipText("Lista de extras");
			listExtra.setModel(new AbstractListModel() {
				String[] values = new String[] {"Agua", "Cocacola", "Refresco de Naranja", "Refresco de Lim\u00F3n", "Gominolas", "Palomitas"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			listExtra.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String extra = String.valueOf(listExtra.getSelectedValue());
					txtExtra.setText(extra);
				}
			});
			listExtra.setBounds(187, 124, 145, 122);
		}
		return listExtra;
	}
	private JLabel getLblExtra() {
		if (lblExtra == null) {
			lblExtra = new JLabel("Extra:");
			lblExtra.setToolTipText("");
			lblExtra.setBounds(23, 125, 46, 14);
		}
		return lblExtra;
	}
	private JTextField getTxtExtra() {
		if (txtExtra == null) {
			txtExtra = new JTextField();
			txtExtra.setToolTipText("A\u00F1ade tu extra gratis");
			txtExtra.setEditable(false);
			txtExtra.setBounds(23, 150, 128, 20);
			txtExtra.setColumns(10);
		}
		return txtExtra;
	}
	private JTextField getTxtPrecioFinal() {
		if (txtPrecioFinal == null) {
			txtPrecioFinal = new JTextField();
			txtPrecioFinal.setEditable(false);
			txtPrecioFinal.setText(v.getPrecio());
			txtPrecioFinal.setBounds(120, 97, 137, 20);
			txtPrecioFinal.setColumns(10);
		}
		return txtPrecioFinal;
	}
	private JTextField getTxtEntradas() {
		if (txtEntradas == null) {
			txtEntradas = new JTextField();
			txtEntradas.setEditable(false);
			txtEntradas.setText(v.getEntradas());
			txtEntradas.setBounds(120, 72, 137, 20);
			txtEntradas.setColumns(10);
		}
		return txtEntradas;
	}
	private JTextField getTxtSala() {
		if (txtSala == null) {
			txtSala = new JTextField();
			txtSala.setEditable(false);
			txtSala.setText(v.getSala());
			txtSala.setBounds(120, 47, 137, 20);
			txtSala.setColumns(10);
		}
		return txtSala;
	}
	private JTextField getTxtTitulo() {
		if (txtTitulo == null) {
			txtTitulo = new JTextField();
			txtTitulo.setEditable(false);
			txtTitulo.setText(v.getTitulo());
			txtTitulo.setBounds(120, 22, 137, 20);
			txtTitulo.setColumns(10);
		}
		return txtTitulo;
	}
	
	public void comprobarCampos() {
		if(txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			dispose();
			v.inicializar();
		}
	}
}
