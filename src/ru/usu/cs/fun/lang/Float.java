package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public class Float extends Term {

    public final float value;

    public Float(float value) {
        super();
        this.value = value;
    }

    @Override
    public String toString(TermsSubstitutor subst) {
        return value + "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof Float) {
            return value == ((Float) obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return java.lang.Float.floatToIntBits(value);
    }

    @Override
    public Term substitute(String name, Term value) {
        return this;
    }

}
