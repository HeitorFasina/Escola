package arquivotxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LerEscreverTXT {
	BufferedReader br;
	BufferedWriter bw;
	String arch = "./bd/arquivo.txt";
	
	void save(String content, String patch) {
		
		try {
			bw = new BufferedWriter(new FileWriter(patch, true));
			bw.write(content);
			
			bw.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar aquivo:" + e);
		}
	}
	
	String open(String patch) {
		String x = "";
		
		try {
			br = new BufferedReader(new FileReader(patch));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				x += line + "\n";
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado:" + e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir aquivo:" + e);
		}
		
		return x;
	}
}