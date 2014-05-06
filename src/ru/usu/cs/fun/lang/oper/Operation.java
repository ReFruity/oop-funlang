package ru.usu.cs.fun.lang.oper;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Operation extends Term {

    protected int argsNum;
    protected String representation;

    public Operation(String representation, int argsNum) {
        this.argsNum = argsNum;
        this.representation = representation;
    }

    public Operation(String representation) {
        this.argsNum = 1;
        this.representation = representation;
    }

    @Override
    public String toString(TermsSubstitutor substitutor) {
        return representation;
    }

    @Override
    public Term apply(Term arg, Scope scope) {
        if (argsNum == 1)
            return calculate(arg.eval(scope));
        else
            return new Continuation(arg);
    }

    protected abstract Term calculate(Term ... args);

    protected class Continuation extends Term {
        
        private boolean evaluated = false;
        private int argsLeft = argsNum - 1;
        private Continuation prev = null;
        private Term arg;

        public Continuation(Term arg) {
            this.arg = arg;
        }

        public Continuation(Term arg, Continuation prev) {
            this.arg = arg;
            this.argsLeft = (prev.argsLeft - 1);
            this.prev = prev;
        }
        
        @Override
        public Term apply(Term nextArg, Scope scope) {
            
            if(this.argsLeft == 1) {
                
                List<Term> argsList = new ArrayList<Term>();
                Continuation current = this;
                
                nextArg = nextArg.eval(scope);
                argsList.add(nextArg);
                
                if (!current.evaluated) {
                    current.arg = current.arg.eval(scope);
                    current.evaluated = true;
                }
                argsList.add(current.arg);
                
                while (current.prev != null) {
                    current = current.prev;
                    if (!current.evaluated) {
                        current.arg = current.arg.eval(scope);
                        current.evaluated = true;
                    }
                    argsList.add(current.arg);
                }
                
                Collections.reverse(argsList);
                Term[] args = new Term[argsList.size()];
                argsList.toArray(args);
                return calculate(args);
            }
            else {
                return new Continuation(nextArg, this);
            }
        }

        @Override
        public String toString(TermsSubstitutor subst) {
            if (prev == null) 
                return Operation.this.toString() + " " + subst.substitute(arg);
            else
                return prev.toString() + " " + subst.substitute(arg);
        }
    }

}
