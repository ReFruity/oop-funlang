package ru.usu.cs.fun.lang.oper.str;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.types.FunString;
import ru.usu.cs.fun.lang.types.Int;

public class SubStr extends  StrOperation {
    
    public SubStr(String representation) {
        super(representation, 3);
    }

    protected Term calculate(Scope scope, Term ... args) {
        FunString str = (FunString)args[0];
        int sIndex = ((Int)args[1]).value;  
        int count = ((Int)args[2].eval(scope)).value;  
        return new FunString(str.value.substring(sIndex, sIndex + count));
    }
}
