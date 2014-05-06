package ru.usu.cs.fun.lang.oper.num;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.Operation;
import ru.usu.cs.fun.lang.types.FunFloat;
import ru.usu.cs.fun.lang.types.Int;

public abstract class ArOperation extends Operation {
    
    protected final float e = 10e-5F;
    
    public ArOperation(String representation) {
        super(representation, 2);
    }

    protected Term calculate(Term ... args) {
        
        Term arg1 = args[0], arg2 = args[1];
        
        boolean b1 = arg1 instanceof FunFloat;
        boolean b2 = arg2 instanceof FunFloat;
        
        if(b1 || b2) {
            Number v1 = new Float(b1 ? ((FunFloat) arg1).value : ((Int) arg1).value);
            Number v2 = new Float(b2 ? ((FunFloat) arg2).value : ((Int) arg2).value);
            return calculate(v1.floatValue(), v2.floatValue());
        }
        else {
            int v1 = ((Int) arg1).value;
            int v2 = ((Int) arg2).value;
            return calculate(v1, v2);
        } 
    }
    
    protected abstract Term calculate(int arg1, int arg2);
    
    protected abstract Term calculate(float arg1, float arg2);
    
    protected float round (float number) {
        return Math.round(number / e) * e;
    }
}
