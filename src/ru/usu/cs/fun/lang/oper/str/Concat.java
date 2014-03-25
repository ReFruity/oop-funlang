package ru.usu.cs.fun.lang.oper.str;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.types.FunString;

public class Concat extends StrOperation {
    public Concat(String representation) {
        super(representation, 2);
    }

    protected Term calculate(Scope scope, Term ... args) {
        FunString arg1 = (FunString) args[0];
        FunString arg2 = (FunString) args[1].eval(scope);
        return new FunString(arg1.value.concat(arg2.value));
    }
}
