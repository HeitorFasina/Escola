import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> uf = new ArrayList<>();
    ArrayList<String> nome = new ArrayList<>();
    ArrayList<String> pop = new ArrayList<>();
    Scanner leia = new Scanner(System.in);
    int x = 0;

    while (x == 0) {
      System.out.println("Digite a UF da cidade: ");
      uf.add(leia.next());
      System.out.println("Digite o nome da cidade: ");
      nome.add(leia.next());
      System.out.println("Digite a população da cidade: ");
      pop.add(leia.next());
      System.out.println("Deseja continuar adicionando cidades?\nDigite 0 para sim e qualquer outro número inteiro para não: ");
      x = leia.nextInt();         
    }

    System.out.println("UF\tNome\tPopulação");
    for (int c = 0; c < uf.size(); c++) {
      System.out.print(uf.get(c)+"\t");
      System.out.print(nome.get(c)+"\t");
      System.out.print(pop.get(c));
    }
  }
}
