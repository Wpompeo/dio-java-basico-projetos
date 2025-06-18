
import java.util.Scanner;

public class imc {
    public static void main(String[] args)  {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("#####################################");
            System.out.println("Seja bem vindo ao controlador de IMC!");
            System.out.println("Informe seu nome:");
            String nome = sc.nextLine();        
            System.out.println("informe seu peso em kg:");
            double peso = Double.parseDouble(sc.nextLine());  
            System.out.println("Informe sua altura em metros:");
            double altura = Double.parseDouble(sc.nextLine());
            System.out.println("#####################################");
            double imc = peso / (altura * altura);
            /*
             * 18,5 abaixo do peso
             * 18,5 a 24,9 peso normal  
             * 25,0 a 29,9 sobrepeso
             * 30,0 a 34,9 obesidade grau 1 
             * 35,0 a 39,9 obesidade grau 2 severa
             * 40,0 ou mais obesidade grau 3 mórbida
             */
            if (imc < 18.5) {
                System.out.printf("Olá %s, seu IMC é: %.2f\nClassificação: Abaixo do peso\n", nome, imc);
            } else if (imc >= 18.5 && imc < 25.0) {
                System.out.printf("Olá %s, seu IMC é: %.2f\nClassificação: Peso normal\n", nome, imc);
            } else if (imc >= 25.0 && imc < 30.0) {
                System.out.printf("Olá %s, seu IMC é: %.2f\nClassificação: Sobrepeso\n", nome, imc);
            } else if (imc >= 30.0 && imc < 35.0) {
                System.out.printf("Olá %s, seu IMC é: %.2f\nClassificação: Obesidade grau 1\n", nome, imc);
            } else if (imc >= 35.0 && imc < 40.0) {
                System.out.printf("Olá %s, seu IMC é: %.2f\nClassificação: Obesidade grau 2 severa\n", nome, imc);
            } else {
                System.out.printf("Olá %s, seu IMC é: %.2f\nClassificação: Obesidade grau 3 mórbida\n", nome, imc);
            }
        }

    }
}
