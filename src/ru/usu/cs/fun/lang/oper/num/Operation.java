package ru.usu.cs.fun.lang.oper.num;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.types.FunFloat;
import ru.usu.cs.fun.lang.types.Int;

public abstract class Operation extends Term {

    protected String representation;
    
    protected final float e = 10e-5F;
    
    public Operation(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString(TermsSubstitutor substitutor) {
        return representation;
    }
    
    @Override
    public Term apply(Term arg, Scope scope) {
        return new Operation.Continuation(arg);
    }
    
    protected Term calculate(Term arg1, Term arg2, Scope scope) {
        
        arg2 = arg2.eval(scope);
        boolean b1 = arg1 instanceof FunFloat;
        boolean b2 = arg2 instanceof FunFloat;
        
        if(b1 || b2) {
            Number v1 = new Float(b1 ? ((FunFloat) arg1).value : ((Int) arg1).value);
            Number v2 = new Float(b2 ? ((FunFloat) arg2).value : ((Int) arg2).value);
            return calculate(v1.floatValue(), v2.floatValue());
        }
        else {
            int v1 = ((Int) arg1).value;
            int v2 = ((Int) arg2).value;
            return calculate(v1, v2);
        } 
    }
    
    protected abstract Term calculate(int arg1, int arg2);
    
    protected abstract Term calculate(float arg1, float arg2);
    
    protected class Continuation extends Term {
        
        private Term arg1;
        private boolean evaluated;

        public Continuation(Term arg1) {
            this.arg1 = arg1;
        }

        @Override
        public Term apply(Term arg2, Scope scope) {
            if (!evaluated) {
                arg1 = arg1.eval(scope);
                evaluated = true;
            }
            return calculate(arg1, arg2, scope);
        }

        @Override
        public String toString(TermsSubstitutor subst) {
            return Operation.this.toString() + ' ' + subst.substitute(arg1);
        }
    }
    
    protected float round (float number) {
//        DecimalFormat df = new DecimalFormat("###.##");
//        return df.format(number);
        return Math.round(number / e) * e;
    }
}
