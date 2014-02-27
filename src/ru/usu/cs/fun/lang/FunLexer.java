package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.front.*;

public class FunLexer extends GenericLexer {
	private static Recognizer[] recognizers;

	static {
		Recognizer let = new Word("let");
		Recognizer fun = new Word("fun");
		Recognizer eq = new Word(":=");
		Recognizer semicolon = new Word(";");
		Recognizer open = new Word("(");
		Recognizer close = new Word(")");
		Recognizer intNumber = new IntNumber();
		Recognizer floatNumber = new FloatNumber();
		Recognizer name = new FunName();
		Recognizer space = new Space();
		recognizers = new Recognizer[] { let, fun, eq, semicolon, open, close, intNumber, floatNumber, name, space };
	}

	public FunLexer(String text) {
		super(text, recognizers);
	}

}
