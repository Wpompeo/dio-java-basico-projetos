public class diferentAge {
    public static void main(String[] args) {
        int age1;
        int age2;   
        System.out.println("Informe a primeira idade: ");
        age1 = Integer.parseInt(System.console().readLine());
        System.out.println("Informe a segunda idade: ");        
        age2 = Integer.parseInt(System.console().readLine());
        System.out.println("A diferença entre as idades é " + Math.abs(age1 - age2) + " anos.");
    }
}
