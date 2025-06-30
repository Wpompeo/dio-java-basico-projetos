import br.com.dio.dao.UserDAO;
import br.com.dio.exception.EmptyStorageException;
import br.com.dio.exception.UserNotFoundException;
import br.com.dio.exception.ValidatorException;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Main {

    private final static UserDAO dao = new UserDAO();

    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {        
        while (true) {
        System.out.println("Bem vindo ao cadastro de usuários, selecione a operação desejada:");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Atualizar usuário");
        System.out.println("3 - Deletar usuário");
        System.out.println("4 - Listar usuários por id");
        System.out.println("5 - Listar todos os usuários");
        System.out.println("6 - Sair");
        var userInput = scanner.nextInt();        
            var selectedOption = MenuOption.values()[userInput - 1];
            switch (selectedOption) {
                case SAVE -> {
                    var user = dao.save(requestToSave());
                    System.out.printf("Usuário cadastrado %s%n", user);
                }
                case UPDATE -> {
                    try{
                        var user = dao.update(requestToUpdate());
                        System.out.printf("Usuário atualizado %s%n", user);
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                        continue;
                    }
                   
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("Usuário deletado com sucesso.");
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    } finally {
                        System.out.println("=============================");
                    }
                    
                }
                case FIND_BY_ID -> {
                    try {
                        var id = requestId();
                        var users = dao.findById(id);
                        System.out.printf("Usuário com id %s%n", id);
                        System.out.println(users);
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                   
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados:");
                    System.out.println("-------------------------");
                    users.forEach(System.out::println);
                     System.out.println("-----------FIM--------------");
                }
                case EXIT -> {
                    System.out.println("=============================");
                    System.out.println("Obrigado por utilizar nosso sistema!");
                    System.out.println("Saindo do sistema...");
                     System.out.println("=============================");
                    System.exit(0);
                }
            }
            System.out.println("Selecione a operação desejada:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Atualizar usuário");
            System.out.println("3 - Deletar usuário");
            System.out.println("4 - Listar usuários por id");
            System.out.println("5 - Listar todos os usuários");
            System.out.println("6 - Sair");
        }
    }

    private static UserModel requestToSave(){
        System.out.println("Digite o nome do usuário: ");
        var name = scanner.next();
        System.out.println("Digite o email do usuário: ");
        var email = scanner.next();
        System.out.println("Digite a data de nascimento do usuário (dd/MM/yyyy): ");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);    
        try {
            return validateInputs(0, name, email, birthday);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
       
    }

private static UserModel validateInputs(final long id, final String name,
                           final String email, final LocalDate birthday)throws ValidatorException {
    var user = new UserModel(0, name, email, birthday); 
    verifyModel(user);    
    return user;                          
                            
}
private static void verifyModel(UserModel user) throws ValidatorException {
    if (user.getName() == null || user.getName().isEmpty()) {
        throw new ValidatorException("Nome do usuário não pode ser vazio.");
    }
    if (user.getEmail() == null || user.getEmail().isEmpty()) {
        throw new ValidatorException("Email do usuário não pode ser vazio.");
    }
    if (user.getBirthday() == null) {
        throw new ValidatorException("Data de nascimento do usuário não pode ser vazia.");
    }
}
private static UserModel requestToUpdate(){
    System.out.println("Informe o id do usuário: ");
    var id = scanner.nextLong();
    System.out.println("Digite o nome do usuário: ");
    var name = scanner.next();
    System.out.println("Digite o email do usuário: ");
    var email = scanner.next();     
    System.out.println("Digite a data de nascimento do usuário (dd/MM/yyyy): ");
    var birthdayString = scanner.next();
    var formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
    var birthday = java.time.LocalDate.parse(birthdayString, formatter);
    try {
        return validateInputs(id, name, email, birthday);
    } catch (ValidatorException ex) {
        System.out.println(ex.getMessage());
        return null;
    }
}
    private static long requestId() {
        System.out.println("Informe o id do usuário: ");
        return scanner.nextLong();
    }

}
