package temperaturaCelsisusFahrenheit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrincipalGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField textFieldFahrenheit;
	private JTextField textFieldCelsius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PrincipalGUI dialog = new PrincipalGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PrincipalGUI() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salir();
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Conversor temperatura");
		setBounds(100, 100, 444, 159);
		contentPanel.setBounds(0, 0, 434, 99);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setBounds(0, 97, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("Reset");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						reset();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						salir();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel labelCelsius = new JLabel("Celsius:");
			labelCelsius.setBounds(59, 13, 71, 14);
			contentPanel.add(labelCelsius);
		}
		{
			textFieldCelsius = new JTextField();
			textFieldCelsius.setText("0");
			textFieldCelsius.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent arg0) {
					aFahrenheit();
				}
			});
			textFieldCelsius.setBounds(132, 10, 236, 20);
			textFieldCelsius.setColumns(10);
			contentPanel.add(textFieldCelsius);
		}

		JLabel lblFahrenheit = new JLabel("Fahrenheit:");
		lblFahrenheit.setBounds(45, 52, 86, 14);
		contentPanel.add(lblFahrenheit);
		{
			textFieldFahrenheit = new JTextField();
			textFieldFahrenheit.setText("32");
			textFieldFahrenheit.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent arg0) {
					aCelsius();
				}
			});
			textFieldFahrenheit.setBounds(131, 49, 237, 20);
			contentPanel.add(textFieldFahrenheit);
			textFieldFahrenheit.setColumns(10);
		}
		getContentPane().add(buttonPane);
		recuperarDeFichero();
	}

	

	protected void aCelsius() {
		try {
			textFieldCelsius
					.setText(Double.toString(Temperatura.aCelsius(Double
							.parseDouble(textFieldFahrenheit.getText()))));
			textFieldFahrenheit.setText(Double.toString(Double
					.parseDouble(textFieldFahrenheit.getText())));
		} catch (NumberFormatException e) {
			JOptionPane
					.showMessageDialog(this,
							"Introduce los grados fahrenheit válidos (un número decimal)");
			textFieldFahrenheit.requestFocusInWindow();
		}
	}

	protected void aFahrenheit() {
		try {
			textFieldFahrenheit
					.setText(Double.toString(Temperatura.aFahrenheit(Double
							.parseDouble(textFieldCelsius.getText()))));
			textFieldCelsius.setText(Double.toString(Double
					.parseDouble(textFieldCelsius.getText())));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this,
					"Introduce los grados celsius válidos (un número decimal)");
			textFieldCelsius.requestFocusInWindow();
		}
	}

	protected void reset() {
		textFieldCelsius.setText("0");
		textFieldFahrenheit.setText("32");
	}

	protected void salir() {
		guardarEnFichero();
		setVisible(false);
		dispose();
		System.exit(0);
	}

	private void guardarEnFichero() {
		// TODO Auto-generated method stub
		
	}
	private void recuperarDeFichero() {
		// TODO Auto-generated method stub
		
	}
}
