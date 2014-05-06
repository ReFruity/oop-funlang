package ru.usu.cs.fun.lang.oper.rdr;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunReader;
import ru.usu.cs.fun.lang.types.FunString;

import java.util.Scanner;

public class ReadLine extends Operation {
    
    public ReadLine(String representation) {
        super(representation);
    }

    protected Term calculate(Term ... args) {
        Scanner s = ((FunReader)args[0]).scanner;
        return new FunString(s.nextLine());
    }   
}
