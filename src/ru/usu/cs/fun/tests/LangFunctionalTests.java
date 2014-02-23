package ru.usu.cs.fun.tests;

import org.junit.Test;

import ru.usu.cs.fun.front.Lexer;
import ru.usu.cs.fun.lang.FunLexer;
import ru.usu.cs.fun.lang.FunParser;
import ru.usu.cs.fun.lang.FunScope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class LangFunctionalTests{
    @Test
	public void testChurchArithmetics() {
		runTestsSet("church-arithmetics");
	}

    @Test
	public void testChurchBooleans() {
		runTestsSet("church-booleans");
	}

    @Test
	public void testRecursion() {
		runTestsSet("recursion");
	}

    @Test
	public void testReductionOrder() {
		runTestsSet("reduction-order");
	}

    @Test
    public void testOperations() {
        runTestsSet("operations");
    }

	private void runTestsSet(FunParser fun, FunScope scope, Lexer lexer, String expectedOutput) {
		Object result;
		String actualOutput = "";
		while ((result = fun.evalNext(lexer)) != null) {

			actualOutput = result.toString();
		}
		assertEquals(expectedOutput, actualOutput);
	}

	private void runTestsSet(String testssetName) {
		InputStream stream = getClass().getResourceAsStream("test-" + testssetName + ".txt");
		if (stream == null)
			throw new RuntimeException(testssetName + " is missing");
		BufferedReader r = new BufferedReader(new InputStreamReader(stream));
		String content = "";
		String line;
		FunScope scope = new FunScope();
		FunParser fun = new FunParser(scope);
		try {
			while ((line = r.readLine()) != null) {
				if (line.startsWith("//>")) {
					Lexer lexer = new FunLexer(content);
					try {
						runTestsSet(fun, scope, lexer, line.substring(3));
					} catch (Throwable e) {
						throw new RuntimeException("input: " + content + " -> " + e.getMessage(), e);
					}
					content = "";
				} else
					content += line + '\n';
			}
		} catch (IOException e) {
			throw new RuntimeException(testssetName + " read error");
		}
	}
}
