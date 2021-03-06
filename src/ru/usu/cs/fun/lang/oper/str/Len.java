package ru.usu.cs.fun.lang.oper.str;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunString;
import ru.usu.cs.fun.lang.types.Int;

public class Len extends Operation {

    public Len(String representation) {
        super(representation, 1);
    }
        
    protected Term calculate(Term ... args) {
        FunString arg = (FunString) args[0];
        return new Int(arg.value.length());
    }
}
