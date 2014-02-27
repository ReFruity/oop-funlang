package ru.usu.cs.fun.lang.oper;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.Int;

public class Sub extends Operation {
    @Override
    public String toString(TermsSubstitutor substitutor) {
        return "-";
    }

    @Override
    public Term apply(Term arg, Scope scope) {
        return new Continuation(arg);
    }
    
    protected Term calculate(Term arg1, Term arg2, Scope scope) {
        int v1 = ((Int) arg1).value;
        int v2 = ((Int) arg2.eval(scope)).value;
        return new Int(v1 - v2);
    }
}
