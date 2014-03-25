package ru.usu.cs.fun.lang.types;

import ru.usu.cs.fun.back.TermsSubstitutor;

public class FunString extends DataType {
    public final String value;

    public FunString(String value) {
        super();
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) 
            return false;
        if (obj instanceof FunString) {
            return value == ((FunString) obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString(TermsSubstitutor subst) {
        return "\"" + value + "\"";
    }
    
    public int length() {
        return value.length();
    }
}
