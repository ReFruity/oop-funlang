package ru.usu.cs.fun.front;

public class FloatNumber extends AutomatonRecognizer {
    public FloatNumber() {
        super("float");

        transition(INITIAL_STATE, "0-9", "integer");
        transition(INITIAL_STATE, ".", "dot");

        transition("integer", "0-9", "integer");
        transition("integer", "eE", "expIndicator");
        transition("integer", "fF", "float");
        transition("integer", "dD", "double");
        transition("integer", ".", "fractional");

        transition("dot", "0-9", "fractional");

        transition("fractional", "0-9", "fractional");
        transition("fractional", "eE", "expIndicator");
        transition("fractional", "fF", "float");
        transition("fractional", "dD", "double");

        transition("expIndicator", "+-", "sign");
        transition("expIndicator", "0-9", "signedInt");

        transition("sign", "0-9", "signedInt");

        transition("signedInt", "0-9", "signedInt");
        transition("signedInt", "fF", "float");
        transition("signedInt", "dD", "double");
        
        finalStates("fractional", "signedInt", "float", "double");
    }

    @Override
    protected String getCharClass(char ch) {
        if ('0' <= ch && ch <= '9') return "0-9";
        if (ch == '+' || ch == '-') return "+-";
        if (Character.toLowerCase(ch) == 'e') return "eE";
        if (Character.toLowerCase(ch) == 'd') return "dD";
        if (Character.toLowerCase(ch) == 'f') return "fF";
        if (ch == '.') return ".";
        return "#";
    }

    @Override
    protected Float getValue(String text) {
        int reverseOffset = 0;
        if (!getCharClass(text.charAt(text.length() - 1)).equals("0-9")) reverseOffset++;
        return Float.parseFloat(text.substring(0, text.length() - reverseOffset));
    }

}
