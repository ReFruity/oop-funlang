package ru.usu.cs.fun.lang.oper.rdr;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunString;
import ru.usu.cs.fun.lang.types.FunReader;

public class OpenReader extends Operation {
    
    public OpenReader(String representation) {
        super(representation, 2);
    }

    protected Term calculate(Term ... args) {
        String file = ((FunString)args[0]).value;
        String encoding = ((FunString)args[1]).value;
        return new FunReader(file, encoding);
    }
}
