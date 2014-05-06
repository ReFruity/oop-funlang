package ru.usu.cs.fun.lang.oper.rdr;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.Bool;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunReader;

public class CloseReader extends Operation {

    public CloseReader(String representation) {
        super(representation);
    }

    protected Term calculate(Term ... args) {
        ((FunReader)args[0]).scanner.close();
        return Bool.TRUE;
    }
}

