package ru.usu.cs.fun.lang.oper;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.types.Int;

public class Div extends Operation {
    
    public Div(String representation) {
        super(representation);
    }

    protected Term calculate(int arg1, int arg2) {
        return new Int(arg1 / arg2);
    }

    protected Term calculate(float arg1, float arg2) {
        return new ru.usu.cs.fun.lang.types.Float(round(arg1 / arg2));
    }
}
