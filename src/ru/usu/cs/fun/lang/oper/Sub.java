package ru.usu.cs.fun.lang.oper;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.types.FunFloat;
import ru.usu.cs.fun.lang.types.Int;

public class Sub extends Operation {

    public Sub(String representation) {
        super(representation);
    }

    protected Term calculate(int arg1, int arg2) {
        return new Int(arg1 - arg2);
    }

    protected Term calculate(float arg1, float arg2) {
        return new FunFloat(arg1 - arg2);
    }
}
