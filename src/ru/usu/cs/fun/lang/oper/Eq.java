package ru.usu.cs.fun.lang.oper;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.Bool;

public class Eq extends Operation {

    public Eq(String representation) {
        super(representation);
    }
    
    protected Term calculate(Term arg1, Term arg2, Scope scope) {
        return Bool.from(arg1.eval(scope).equals(arg2.eval(scope)));
    }

    protected Term calculate(int arg1, int arg2) {
        return Bool.from(arg1 == arg2);
    }

    protected Term calculate(float arg1, float arg2) {
        return Bool.from(Math.abs(arg1 - arg2) < e);
    }
}
