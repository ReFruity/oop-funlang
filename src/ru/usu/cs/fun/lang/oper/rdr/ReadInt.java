package ru.usu.cs.fun.lang.oper.rdr;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunReader;
import ru.usu.cs.fun.lang.types.Int;

public class ReadInt extends Operation {
    
    public ReadInt(String representation) {
        super(representation);
    }

    protected Term calculate(Term ... args) {
        FunReader r = (FunReader)args[0];
        return new Int(r.scanner.nextInt());
    }
}
