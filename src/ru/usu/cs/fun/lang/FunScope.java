package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.oper.num.*;
import ru.usu.cs.fun.lang.oper.str.*;

import java.util.HashMap;
import java.util.Map;

public class FunScope implements Scope {

	private final Map<String, Term> items = new HashMap<String, Term>();

	public void add(String name, Term term) {
		if (find(name) != null)
			throw new RuntimeException("Symbol '" + name + "' has beed already defined");
		items.put(name, term);
	}

	@Override
	public Term get(String name) {
		Term result = find(name);
		if (result == null)
			throw new RuntimeException("Symbol '" + name + "' in undefined");
		return result;
	}

	// can be null
	public Term find(String name) {
		Term result = resolveConstant(name);
		if (result != null)
			return result;
		if (name.equals("="))
			return new Eq("=");
		if (name.equals("+"))
			return new Add("+");
        if (name.equals("-"))
            return new Sub("-");
        if (name.equals("*"))
            return new Mul("*");
        if (name.equals("/"))
            return new Div("/");
        if (name.equals("%"))
            return new Mod("%");
        if (name.equals(">"))
            return new More(">");
		if (name.equals("print"))
			return new Print();
        if (name.equals("len"))
			return new Len("len");
        if (name.equals("charAt"))
            return new CharAt("charAt");
        if (name.equals("concat"))
            return new Concat("concat");
        if (name.equals("substr"))
            return new SubStr("substr");
        if (name.equals("remove"))
            return new Remove("remove");
        if (name.equals("insert"))
            return new Insert("insert");
		return items.get(name);
	}
	
	private Term resolveConstant(String name) {
		return resolveBool(name);
	}

	private Term resolveBool(String name) {
		if (name.equals("true"))
			return Bool.TRUE;
		else if (name.equals("false"))
			return Bool.FALSE;
		else
			return null;
	}
}
