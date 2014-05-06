package ru.usu.cs.fun.lang.oper.rdr;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.Bool;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunReader;

import java.util.Scanner;

public class IsEnd extends Operation {

    public IsEnd(String representation) {
        super(representation);
    }

    protected Term calculate(Term ... args) {
        Scanner s = ((FunReader)args[0]).scanner;
        return s.hasNext() ? Bool.FALSE : Bool.TRUE;
    }
}
