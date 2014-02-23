package ru.usu.cs.fun.front;

import ru.usu.cs.fun.lang.FunLexer;
import org.junit.Test;
import static org.junit.Assert.*;

public class GenericLexerTest {
    @Test
	public void testSpace(){
		FunLexer lexer = new FunLexer(" let");
		assertEquals("let", lexer.current().getType());
	}
	
    @Test
	public void test(){
        FunLexer lexer = new FunLexer("let a\t:=\r\nfun (x) x;");
		assertEquals("let", lexer.current().getType());
		assertEquals("name", lexer.readNext().getType());
		assertEquals("a", lexer.current().getText());
		assertEquals(":=", lexer.readNext().getType());
		assertEquals("fun", lexer.readNext().getType());
		assertEquals("(", lexer.readNext().getType());
		assertEquals("name", lexer.readNext().getType());
		assertEquals(")", lexer.readNext().getType());
		assertEquals("name", lexer.readNext().getType());
		assertEquals(";", lexer.readNext().getType());
	}
}
