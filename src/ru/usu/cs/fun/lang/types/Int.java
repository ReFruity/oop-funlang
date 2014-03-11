package ru.usu.cs.fun.lang.types;

import ru.usu.cs.fun.back.TermsSubstitutor;

import java.lang.*;

public class Int extends DataType {

	public final int value;

	public Int(int value) {
		super();
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Int) {
			return value == ((Int) obj).value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value;
	}

    @Override
    public java.lang.String toString(TermsSubstitutor subst) {
        return value + "";
    }

    public int getValue() {
        return value;
    }

}
