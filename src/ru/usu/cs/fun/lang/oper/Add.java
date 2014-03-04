package ru.usu.cs.fun.lang.oper;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.types.Float;
import ru.usu.cs.fun.lang.types.Int;

public class Add extends Operation {
    
    public Add(String representation) {
        super(representation);
    }
    
	protected Term calculate(int arg1, int arg2) {
		return new Int(arg1 + arg2);
	}

    protected Term calculate(float arg1, float arg2) {
        return new Float(arg1 + arg2);
    }
}
