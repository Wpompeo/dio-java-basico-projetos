public class baseAltura {
    public static void main(String[] args) {
        double base;
        double altura;
        double area;
        System.out.println("Informe o valor da base do triângulo: ");
        base = Double.parseDouble(System.console().readLine());
        System.out.println("Informe o valor da altura do triângulo: ");
        altura = Double.parseDouble(System.console().readLine());
        area = (base * altura) / 2;
        System.out.println("A área do triângulo com base " + base + " e altura " + altura + " é " + area);
    }
}
