public class areaQuadrado {
    public static void main(String[] args) {
        double lado;
        double area;
        System.out.println("Informe o valor do lado do quadrado: ");
        lado = Double.parseDouble(System.console().readLine());
        area = lado * lado;
        System.out.println("A área do quadrado com lado " + lado + " é " + area);
    }
}
