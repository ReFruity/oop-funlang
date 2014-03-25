package ru.usu.cs.fun.lang.oper.str;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

import java.util.ArrayList;
import java.util.List;

public abstract class StrOperation extends Term {
    
    protected int argsNum;
    protected String representation;
    
    StrOperation(String representation, int argsNum) {
        this.argsNum = argsNum;
        this.representation = representation;
    }

    @Override
    public String toString(TermsSubstitutor substitutor) {
        return representation;
    }
    
    @Override
    public Term apply(Term arg, Scope scope) {
        return new StrOperation.Continuation().apply(arg, scope);
    }

    protected abstract Term calculate(Scope scope, Term ... args);

    protected class Continuation extends Term {

        private List<Term> args = new ArrayList<Term>();
        private boolean evaluated;

        public Continuation() {}
        
        public Continuation(List<Term> args) {
            this.args = args;
        }

        @Override
        public Term apply(Term nextArg, Scope scope) {
            if(args.size() == argsNum - 1) {
                if (!evaluated) {
                    for (int i = 0; i < args.size(); i++)
                        args.set(i, args.get(i).eval(scope));
                    evaluated = true;
                }
                
                args.add(nextArg);
                
                Term cArgs[] = new Term[args.size()];
                args.toArray(cArgs);
    
                return calculate(scope, cArgs);
            }
            args.add(nextArg);
            return new Continuation(args);
        }

        @Override
        public String toString(TermsSubstitutor subst) {
            
            String result = StrOperation.this.toString();
            
            for (Term arg : args) {
                result += " " + subst.substitute(arg);
            }
            
            return result;
        }
    }
    
}
