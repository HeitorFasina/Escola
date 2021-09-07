package biosim;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormAnimal extends JFrame implements ActionListener {
	static Scanner scan = new Scanner(System.in);
	static Animal animal;
	static ArrayList<Animal> animais = new ArrayList<Animal>();
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnPeixe, btnSapo, btnPassaro, btnStart;
	private JTextArea console;
	private JTextField txtNamePeixe, txtNameSapo, txtNamePassaro, txtPosPeixe, txtPosSapo, txtPosPassaro, txtTime;
	private JScrollPane scroll;

	FormAnimal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BioSim \"GUI\"");
		setSize(800, 650);
		panel = new JPanel();
		setContentPane(panel);
		setLocationRelativeTo(null);
		setLayout(null);

		btnPeixe = new JButton("Criar peixe");
		btnPeixe.setBounds(90, 420, 200, 30);
		panel.add(btnPeixe);

		btnSapo = new JButton("Criar sapo");
		btnSapo.setBounds(90, 460, 200, 30);
		panel.add(btnSapo);
		
		btnPassaro = new JButton("Criar passaro");
		btnPassaro.setBounds(90, 500, 200, 30);
		panel.add(btnPassaro);

		console = new JTextArea();
		console.setEnabled(false);
		scroll = new JScrollPane(console);
		scroll.setBounds(90, 10, 600, 400);
		panel.add(scroll);
		
		txtNamePeixe = new JTextField();
		txtNamePeixe.setToolTipText("Nome");
		txtNamePeixe.setBounds(300, 420, 190, 30);
		panel.add(txtNamePeixe);
		
		txtPosPeixe = new JTextField();
		txtPosPeixe.setToolTipText("Posição. Ex.: 2 0");
		txtPosPeixe.setBounds(500, 420, 190, 30);
		panel.add(txtPosPeixe);
		
		txtNameSapo = new JTextField();
		txtNameSapo.setToolTipText("Nome");
		txtNameSapo.setBounds(300, 460, 190, 30);
		panel.add(txtNameSapo);
		
		txtPosSapo = new JTextField();
		txtPosSapo.setToolTipText("Posição. Ex.: 2 0");
		txtPosSapo.setBounds(500, 460, 190, 30);
		panel.add(txtPosSapo);
		
		txtNamePassaro = new JTextField();
		txtNamePassaro.setToolTipText("Nome");
		txtNamePassaro.setBounds(300, 500, 190, 30);
		panel.add(txtNamePassaro);
		
		txtPosPassaro = new JTextField();
		txtPosPassaro.setToolTipText("Posição. Ex.: 2 0");
		txtPosPassaro.setBounds(500, 500, 190, 30);
		panel.add(txtPosPassaro);
		
		btnStart = new JButton("Iniciar simulação");
		btnStart.setBounds(265, 540, 200, 30);
		panel.add(btnStart);
		
		txtTime = new JTextField();
		txtTime.setToolTipText("Minutos");
		txtTime.setBounds(475, 540, 40, 30);
		panel.add(txtTime);

		btnPeixe.addActionListener(this);
		btnSapo.addActionListener(this);
		btnPassaro.addActionListener(this);
		btnStart.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String con = "";
		
		if (e.getSource() == btnPeixe) {
			try {
				String array[] = new String[2];
				array = txtPosPeixe.getText().split(" ");
				
				animal = new Animal();
				animal.setName(txtNamePeixe.getText());
				animal.setClassAnimal("Peixe");
				animal.setPosXPeixe(Integer.valueOf(array[0]));
				animal.setPosYPeixe(Integer.valueOf(array[1]));
				
				animais.add(animal);
				txtNamePeixe.setText(null);
				txtPosPeixe.setText(null);
				con += "Peixe criado\n";
				console.setText(con);
			}
			catch (Exception ex) {
				con += "Ocorreu um erro: " + ex + "\n";
				console.setText(con);
			}
		}
		else { if (e.getSource() == btnSapo) {
			try {
				String array[] = new String[2];
				array = txtPosSapo.getText().split(" ");
				
				animal = new Animal();
				animal.setName(txtNameSapo.getText());
				animal.setClassAnimal("Sapo");
				animal.setPosXSapo(Integer.valueOf(array[0]));
				animal.setPosYSapo(Integer.valueOf(array[1]));
				
				animais.add(animal);
				txtNameSapo.setText(null);
				txtPosSapo.setText(null);
				con += "Sapo criado\n";
				console.setText(con);
			}
			catch (Exception ex) {
				con += "Ocorreu um erro: " + ex + "\n";
				console.setText(con);
			}
		}
		else { if (e.getSource() == btnPassaro) {
			try {
				String array[] = new String[2];
				array = txtPosPassaro.getText().split(" ");
				
				animal = new Animal();
				animal.setName(txtNamePassaro.getText());
				animal.setClassAnimal("Passaro");
				animal.setPosXPassaro(Integer.valueOf(array[0]));
				animal.setPosYPassaro(Integer.valueOf(array[1]));
				
				animais.add(animal);
				txtNamePassaro.setText(null);
				txtPosPassaro.setText(null);
				con += "Passaro criado\n";
				console.setText(con);
			}
			catch (Exception ex) {
				con += "Ocorreu um erro: " + ex + "\n";
				console.setText(con);
			}
		}
		else { if (e.getSource() == btnStart) {
			try {
				for (int c = 0; c < Integer.valueOf(txtTime.getText()); c++) {
					for (Animal a : animais) {
						if (a.getClassAnimal() == "Peixe") {
							a.moverPeixe(a.getPosXPeixe(), a.getPosYPeixe());
							con += "O Peixe " + a.getName() + " nadou para o ponto (" + a.getPosXPeixe() + "," + a.getPosYPeixe() + ").\n";
						}
						if (a.getClassAnimal() == "Sapo") {
							a.moverSapo(a.getPosXSapo(), a.getPosYSapo());
							con += "O Sapo " + a.getName() + " pulou para o ponto (" + a.getPosXSapo() + "," + a.getPosYSapo() + ").\n";
						}
						if (a.getClassAnimal() == "Passaro") {
							a.moverPassaro(a.getPosXPassaro(), a.getPosYPassaro());
							con += "O Passaro " + a.getName() + " voou para o ponto (" + a.getPosXPassaro() + "," + a.getPosYPassaro() + ").\n";
						}
						
						console.setText(con);
					}
					
					Thread.sleep(1000);
				}
				txtTime.setText(null);
			}
			catch (Exception ex) {
				con += "Ocorreu um erro: " + ex + "\n";
				console.setText(con);
			}
		}}}}
	}
	
	public static void main(String[] args) {
		new FormAnimal().setVisible(true);
	}
}