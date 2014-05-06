package ru.usu.cs.fun.lang.oper.str;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunString;
import ru.usu.cs.fun.lang.types.Int;

public class Insert extends Operation {
    public Insert(String representation) {
        super(representation, 3);
    }

    protected Term calculate(Term ... args) {
        FunString arg1 = (FunString) args[0];
        FunString arg2 = (FunString) args[1];
        int index = ((Int)args[2]).value;
        return new FunString(arg1.value.substring(0, index) + arg2.value 
                + arg1.value.substring(index, arg1.length()));
    }
}
