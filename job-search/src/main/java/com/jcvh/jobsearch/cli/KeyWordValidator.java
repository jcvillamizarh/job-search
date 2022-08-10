package com.jcvh.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class KeyWordValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.matches("^[a-zA-Z]+[0-9]*$")){
            System.err.println("El criterio de búsqueda no es válido.");
            throw new ParameterException("Unicamente letras y números");
        }
    }
}
