package ru.usu.cs.fun.front;

public class StringToken extends AutomatonRecognizer {
    public StringToken() {
        super("str");
        
        transition(INITIAL_STATE, "\"", "string");

        transition("string", "\\", "escapeSequence");
        transition("string", "string");

        transition("escapeSequence", "tnr", "string");
        transition("escapeSequence", "\"", "string");
        transition("escapeSequence", "\\", "string");

        transition("string", "\"", "final");
        
        finalStates("final");
    }

    @Override
    protected String getCharClass(char ch) {
        if (ch == '\"') return "\"";
        if (ch == '\\') return "\\";
        if ("tnr".indexOf(ch) > -1) return "tnr";
        return "#";
    }

    @Override
    protected String getValue(String text) {
        text = text.replaceAll("\\\\n", "\n");
        text = text.replaceAll("\\\\t", "\t");
        return text.substring(1, text.length()-1);
    }
}