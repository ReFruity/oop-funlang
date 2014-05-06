package ru.usu.cs.fun.lang.oper.num;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.types.FunFloat;
import ru.usu.cs.fun.lang.types.Int;

public class Mod extends ArOperation {

    public Mod(String representation) {
        super(representation);
    }

    protected Term calculate(int arg1, int arg2) {
        return new Int(arg1 % arg2);
    }

    protected Term calculate(float arg1, float arg2) {
        return new FunFloat(arg1 % arg2);
    }
}
