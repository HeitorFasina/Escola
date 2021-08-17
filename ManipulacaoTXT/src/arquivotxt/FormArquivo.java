package arquivotxt;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormArquivo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static LerEscreverTXT read;
	private JPanel panel;
	private JButton btnRead, btnSave, btnInfo;
	private JTextArea txtArea;
	private JTextField info;
	private JScrollPane scroll;
	private JFileChooser patch;
	private File file;

	FormArquivo() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Manipulação Txt \"GUI\"");
		setSize(800, 600);
		panel = new JPanel();
		setContentPane(panel);
		setLocationRelativeTo(null);
		setLayout(null);

		btnRead = new JButton("Carregar arquivo");
		btnRead.setBounds(90, 420, 200, 30);
		panel.add(btnRead);

		btnSave = new JButton("Salva dados em um arquivo");
		btnSave.setBounds(300, 420, 200, 30);
		panel.add(btnSave);
		
		btnInfo = new JButton("Contar número de linhas e de caracteres");
		btnInfo.setBounds(90, 460, 410, 30);
		panel.add(btnInfo);
		
		info = new JTextField();
		info.setEnabled(false);
		info.setBounds(510, 420, 180, 30);
		panel.add(info);

		txtArea = new JTextArea("");
		scroll = new JScrollPane(txtArea);
		scroll.setBounds(90, 10, 600, 400);
		panel.add(scroll);

		btnRead.addActionListener(this);
		btnSave.addActionListener(this);
		btnInfo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnRead) {
			patch = new JFileChooser();
			
			if (patch.showOpenDialog(this) == 0) {
				file = patch.getSelectedFile();
				txtArea.setText(read.open(file.getAbsolutePath()));
			}
		}
		
		if (e.getSource() == btnSave) {
			patch = new JFileChooser();
			
			if (patch.showSaveDialog(this) == 0) {
				file = patch.getSelectedFile();
				read.save(txtArea.getText(),file.getAbsolutePath());
			}
		}
		
		if (e.getSource() == btnInfo) {
			String text = txtArea.getText();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(text);
			int lines = 0;
			
			while (scanner.hasNextLine() != false) {
				scanner.nextLine();
				lines++;
			}
			
			info.setText("linhas:" + lines + "\t" + "letras:" + text.length());
		}
	}

	public static void main(String[] args) {
		
		read = new LerEscreverTXT();
		new FormArquivo().setVisible(true);
	}

}