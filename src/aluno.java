public class aluno {
    public static void main(String[] args) {
        String nome;
        int anoNascimento;
        int anoAtual;
        System.out.println ("Informe seu nome: ");
        nome = System.console().readLine();
        System.out.println ("Informe seu ano de nascimento: ");
        anoNascimento = Integer.parseInt(System.console().readLine());
        System.out.println ("Informe o ano atual: ");
        anoAtual = Integer.parseInt(System.console().readLine());
        System.out.println ("O aluno " + nome +" nasceu em " + anoNascimento + " e tem " + (anoAtual - anoNascimento) + " anos de idade.");
    }
}
