package ru.usu.cs.fun.lang.oper;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.Bool;

public class Eq extends Operation {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "=";
	}

	protected Term calculate(Term arg1, Term arg2, Scope scope) {
		return Bool.from(arg1.eval(scope).equals(arg2.eval(scope)));
	}
}
