package ru.usu.cs.fun.lang.types;

import ru.usu.cs.fun.back.TermsSubstitutor;

public class FunFloat extends DataType {

    public final float value;

    public FunFloat(float value) {
        super();
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof FunFloat) {
            return value == ((FunFloat) obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return java.lang.Float.floatToIntBits(value);
    }

    @Override
    public java.lang.String toString(TermsSubstitutor subst) {
        return value + "";
    }
    
    public float getValue() {
        return value;
    }

}
