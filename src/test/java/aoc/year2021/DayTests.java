package aoc.year2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.codecentric.fpl.DefaultFplEngine;
import de.codecentric.fpl.EvaluationException;
import de.codecentric.fpl.FplEngine;
import de.codecentric.fpl.data.Scope;
import de.codecentric.fpl.datatypes.AbstractFunction;
import de.codecentric.fpl.datatypes.FplInteger;
import de.codecentric.fpl.datatypes.FplString;
import de.codecentric.fpl.datatypes.FplValue;
import de.codecentric.fpl.io.BomAwareReader;
import de.codecentric.fpl.parser.Parser;
import de.codecentric.fpl.parser.Position;
import de.codecentric.fpl.parser.Scanner;

public class DayTests {
	private File baseDir;
	private FplEngine engine;
	private Scope scope;
	
	@BeforeEach
	public void startEngine() {
		baseDir = new File("src/main/resources/2021"); 
		engine = new DefaultFplEngine();
		scope = engine.getScope();
	}
	
	@AfterEach
	public void destroyEngine() {
		// just a little help for the garbage collector
		engine = null;
		scope = null;
	}
	
	@Test
	public void day01TestA() throws Exception {
		runTask("day01/task-a.fpl", "day01/test-input.txt", FplInteger.valueOf(7));
	}
	
	@Test
	public void day01TaskA() throws Exception {
		runTask("day01/task-a.fpl", "day01/task-input.txt", FplInteger.valueOf(1342));
	}
	
	@Test
	public void day01TestB() throws Exception {
		runTask("day01/task-b.fpl", "day01/test-input.txt", FplInteger.valueOf(5));
	}
	
	@Test
	public void day01TaskB() throws Exception {
		runTask("day01/task-b.fpl", "day01/task-input.txt", FplInteger.valueOf(1378));
	}
	
	
	private void runTask(String sourceFileName, String inputFileName, FplValue expectedResult) throws Exception {
		File sourceFile = new File(baseDir, sourceFileName);
		boolean firstExpression = true;
		FplValue expression = null;
		try (InputStream is = new FileInputStream(sourceFile);
				Reader rd = new BomAwareReader(is);
				Parser parser = new Parser(new Scanner(sourceFileName, rd))) {
			try {
				scope.put("input-file-name", new FplString(new File(baseDir, inputFileName).getPath()));
				while (parser.hasNext()) {
					expression = parser.next();
					if (expression != null) {
						expression = engine.evaluate(expression);
					}
						if (!firstExpression) {
							System.out.println();
						}
						if (expression == null) {
							System.out.println("nil");
						} else {
							System.out.println(expression.toString());
						}
					firstExpression = false;
				}
			} catch (EvaluationException e) {
				Position p = FplEngine.findPosition(expression);
				e.add(new StackTraceElement(AbstractFunction.FPL, "top-level", p.getName(), p.getLine()));
				System.out.println(e.getMessage());
				System.out.println(e.stackTraceAsString());
			} catch (Throwable e) {
				System.out.println(e.getMessage());
				e.printStackTrace(System.out);
			}
		}
		assertEquals(expectedResult, scope.get("result"));
	}
}
