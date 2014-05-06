package ru.usu.cs.fun.lang.oper.str;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunString;
import ru.usu.cs.fun.lang.types.Int;

public class CharAt extends Operation {
    public CharAt(String representation) {
        super(representation, 2);
    }

    protected Term calculate(Term ... args) {
        FunString arg = (FunString) args[0];
        int index = ((Int)args[1]).value;
        return new Int(arg.value.codePointAt(index));
    }
}
