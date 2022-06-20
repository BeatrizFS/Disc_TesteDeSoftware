package com.example.tdd.utilis;

import java.util.function.Predicate;

public class TelefoneValidador implements Predicate<String> {

    @Override
    public boolean test(String telefone) {
        if (telefone.startsWith("+55") &&
                telefone.length() == 13){
            return true;
        }
        return false;
    }
}
