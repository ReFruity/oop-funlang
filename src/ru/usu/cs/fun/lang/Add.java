package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class Add extends Operation {
	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "+";
	}

	protected Term calculate(Term arg1, Term arg2, Scope scope) {
		int v1 = ((Int) arg1).value;
		int v2 = ((Int) arg2.eval(scope)).value;
		return new Int(v1 + v2);
	}
}
