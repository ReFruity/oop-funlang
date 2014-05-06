package ru.usu.cs.fun.lang.oper.rdr;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunReader;
import ru.usu.cs.fun.lang.types.FunString;

public class OpenString extends Operation {

    public OpenString(String representation) {
        super(representation);
    }

    protected Term calculate(Term ... args) {
        String str = ((FunString)args[0]).value;
        return new FunReader(str);
    }
}
