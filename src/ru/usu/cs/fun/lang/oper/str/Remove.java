package ru.usu.cs.fun.lang.oper.str;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.types.FunString;
import ru.usu.cs.fun.lang.types.Int;

public class Remove extends StrOperation {
    public Remove(String representation) {
        super(representation, 3);
    }

    protected Term calculate(Scope scope, Term ... args) {
        FunString arg = (FunString) args[0];
        int index = ((Int)args[1]).value;
        int count = ((Int)args[2].eval(scope)).value;
        return new FunString(arg.value.substring(0, index) + 
                arg.value.substring(index+count, arg.length()));
    }
}
