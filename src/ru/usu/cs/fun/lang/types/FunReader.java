package ru.usu.cs.fun.lang.types;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class FunReader extends Term {

    public Scanner scanner;

    public FunReader(String file, String encoding) {
        try {
            scanner = new Scanner(new File(file), encoding);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FunReader(InputStream stream) {
        try {
            scanner = new Scanner(stream);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FunReader(String str) {
        try {
            scanner = new Scanner(str);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public String toString(TermsSubstitutor subst) {
        if (scanner != null)
            return "FunReader; " + scanner.toString();
        else 
            return "Unopened FunReader";
    }
}