package br.com.dio.validator;

import br.com.dio.exception.ValidatorException;
import br.com.dio.model.UserModel;

public class UserValidator {



    private UserValidator() {
        // Private constructor to prevent instantiation
    }
    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getName()))
            throw new ValidatorException("Informe um nome válido.");       
        if (model.getName().length() <= 1)
            throw new ValidatorException("O nome do usuário deve ter mais de 1 caractere."); 
        if (stringIsBlank(model.getEmail()))
            throw new ValidatorException("Informe um email válido.");
        if (model.getEmail() == null || !model.getEmail().contains("@") || !model.getEmail().contains("."))
            throw new ValidatorException("Informe um email válido.");        

    }
    private static boolean stringIsBlank(final String value) {
        return value == null || value.isBlank();
    }
}


