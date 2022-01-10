package aoc.year2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;

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
	private boolean includeSlow = false;
	
	@Test
	public void day01() throws Exception {
		runTask("day01/task-a.fpl", "day01/test-input.txt", FplInteger.valueOf(7));
		runTask("day01/task-a.fpl", "day01/task-input.txt", FplInteger.valueOf(1342));
		runTask("day01/task-b.fpl", "day01/test-input.txt", FplInteger.valueOf(5));
		// This needs a larger Stack: -Xss10m
		if (includeSlow) {
			runTask("day01/task-b.fpl", "day01/task-input.txt", FplInteger.valueOf(1378));
		}
	}
	
	@Test
	public void day02() throws Exception {
		runTask("day02/task-a.fpl", "day02/test-input.txt", FplInteger.valueOf(150));
		runTask("day02/task-a.fpl", "day02/task-input.txt", FplInteger.valueOf(1660158));
		runTask("day02/task-b.fpl", "day02/test-input.txt", FplInteger.valueOf(900));
		runTask("day02/task-b.fpl", "day02/task-input.txt", FplInteger.valueOf(1604592846));
	}
	
	@Test
	public void day03() throws Exception {
		runTask("day03/task-a.fpl", "day03/test-input.txt", FplInteger.valueOf(198));
		runTask("day03/task-a.fpl", "day03/task-input.txt", FplInteger.valueOf(1307354));
		runTask("day03/task-b.fpl", "day03/test-input.txt", FplInteger.valueOf(230));
		runTask("day03/task-b.fpl", "day03/task-input.txt", FplInteger.valueOf(482500));
	}
	
	@Test
	public void day04() throws Exception {
		runTask("day04/task-a.fpl", "day04/test-input.txt", FplInteger.valueOf(4512));
		runTask("day04/task-a.fpl", "day04/task-input.txt", FplInteger.valueOf(87456));
		runTask("day04/task-b.fpl", "day04/test-input.txt", FplInteger.valueOf(1924));
		runTask("day04/task-b.fpl", "day04/task-input.txt", FplInteger.valueOf(15561));
	}
	
	@Test
	public void day05() throws Exception {
		runTask("day05/task-a.fpl", "day05/test-input.txt", FplInteger.valueOf(5));
		runTask("day05/task-a.fpl", "day05/task-input.txt", FplInteger.valueOf(6572));
		runTask("day05/task-b.fpl", "day05/test-input.txt", FplInteger.valueOf(12));
		runTask("day05/task-b.fpl", "day05/task-input.txt", FplInteger.valueOf(21466));
	}
	
	@Test
	public void day06() throws Exception {
		runTask("day06/task-a.fpl", "day06/test-input.txt", FplInteger.valueOf(5934));
		runTask("day06/task-a.fpl", "day06/task-input.txt", FplInteger.valueOf(380758));
		runTask("day06/task-b.fpl", "day06/test-input.txt", FplInteger.valueOf(26984457539L));
		runTask("day06/task-b.fpl", "day06/task-input.txt", FplInteger.valueOf(1710623015163L));
	}
	
	@Test
	public void day07() throws Exception {
		runTask("day07/task-a.fpl", "day07/test-input.txt", FplInteger.valueOf(37));
		runTask("day07/task-a.fpl", "day07/task-input.txt", FplInteger.valueOf(337488));
		runTask("day07/task-b.fpl", "day07/test-input.txt", FplInteger.valueOf(168));
		if (includeSlow) {
		runTask("day07/task-b.fpl", "day07/task-input.txt", FplInteger.valueOf(89647695));
		}
	}
	
	@Test
	public void day08() throws Exception {
		runTask("day08/task-a.fpl", "day08/test-input.txt", FplInteger.valueOf(26));
		runTask("day08/task-a.fpl", "day08/task-input.txt", FplInteger.valueOf(452));
		runTask("day08/task-b.fpl", "day08/test-input.txt", FplInteger.valueOf(61229));
		runTask("day08/task-b.fpl", "day08/task-input.txt", FplInteger.valueOf(1096964));
	}
	
	@Test
	public void day09() throws Exception {
		runTask("day09/task-a.fpl", "day09/test-input.txt", FplInteger.valueOf(15));
		runTask("day09/task-a.fpl", "day09/task-input.txt", FplInteger.valueOf(530));
		runTask("day09/task-b.fpl", "day09/test-input.txt", FplInteger.valueOf(1134));
		runTask("day09/task-b.fpl", "day09/task-input.txt", FplInteger.valueOf(1019494));
	}
	
	@Test
	public void day10() throws Exception {
		runTask("day10/task-a.fpl", "day10/test-input.txt", FplInteger.valueOf(26397));
		runTask("day10/task-a.fpl", "day10/task-input.txt", FplInteger.valueOf(392139));
		runTask("day10/task-b.fpl", "day10/test-input.txt", FplInteger.valueOf(288957));
		runTask("day10/task-b.fpl", "day10/task-input.txt", FplInteger.valueOf(4001832844L));
	}
	
	@Test
	public void day11() throws Exception {
		runTask("day11/task-a.fpl", "day11/test-input.txt", FplInteger.valueOf(1656));
		runTask("day11/task-a.fpl", "day11/task-input.txt", FplInteger.valueOf(1694));
		runTask("day11/task-b.fpl", "day11/test-input.txt", FplInteger.valueOf(195));
		runTask("day11/task-b.fpl", "day11/task-input.txt", FplInteger.valueOf(346));
	}
	
	@Test
	public void day12() throws Exception {
		runTask("day12/task-a.fpl", "day12/test-input.txt", FplInteger.valueOf(10));
		runTask("day12/task-a.fpl", "day12/test-input2.txt", FplInteger.valueOf(19));
		runTask("day12/task-a.fpl", "day12/test-input3.txt", FplInteger.valueOf(226));
		runTask("day12/task-a.fpl", "day12/task-input.txt", FplInteger.valueOf(3495));
		
		runTask("day12/task-b.fpl", "day12/test-input.txt", FplInteger.valueOf(36));
		runTask("day12/task-b.fpl", "day12/test-input2.txt", FplInteger.valueOf(103));
		runTask("day12/task-b.fpl", "day12/test-input3.txt", FplInteger.valueOf(3509));
		if (includeSlow) {
			runTask("day12/task-b.fpl", "day12/task-input.txt", FplInteger.valueOf(94849));
		}
	}
	
	@Test
	public void day13() throws Exception {
		runTask("day13/task-a.fpl", "day13/task-input.txt", FplInteger.valueOf(765));
		runTask("day13/task-b.fpl", "day13/test-input.txt", FplInteger.valueOf(16));
		runTask("day13/task-b.fpl", "day13/task-input.txt", FplInteger.valueOf(98));
	}
	
	@Test
	public void day14() throws Exception {
		runTask("day14/task-a.fpl", "day14/test-input.txt", FplInteger.valueOf(1588));
		runTask("day14/task-a.fpl", "day14/task-input.txt", FplInteger.valueOf(3247));
		runTask("day14/task-b.fpl", "day14/test-input.txt", FplInteger.valueOf(2188189693529L));
		runTask("day14/task-b.fpl", "day14/task-input.txt", FplInteger.valueOf(4110568157153L));
	}
	
	@Test
	public void day15() throws Exception {
		runTask("day15/task-a.fpl", "day15/test-input.txt", FplInteger.valueOf(40));
		if (includeSlow) {
			runTask("day15/task-a.fpl", "day15/task-input.txt", FplInteger.valueOf(462));
		}
		runTask("day15/task-b.fpl", "day15/test-input.txt", FplInteger.valueOf(315));
		runTask("day15/task-b.fpl", "day15/task-input.txt", FplInteger.valueOf(2846));
	}
	
	@Test
	public void day16() throws Exception {
		runTask("day16/task-a.fpl", "day16/task-input.txt", FplInteger.valueOf(947));
		runTask("day16/task-b.fpl", "day16/task-input.txt", FplInteger.valueOf(660797830937L));
	}
	
	@Test
	public void day17() throws Exception {
		runTask("day17/task-a.fpl", "unused.txt", FplInteger.valueOf(19503));
		runTask("day17/task-b.fpl", "unused.txt", FplInteger.valueOf(5200));
	}
	
	@Test
	public void day18() throws Exception {
		runTask("day18/task-a.fpl", "day18/test-input.txt", FplInteger.valueOf(4140));
		if (includeSlow) {
			runTask("day18/task-a.fpl", "day18/task-input.txt", FplInteger.valueOf(3699));
		}
		runTask("day18/task-b.fpl", "day18/test-input.txt", FplInteger.valueOf(3993));
		if (includeSlow) {
			runTask("day18/task-b.fpl", "day18/task-input.txt", FplInteger.valueOf(4735));
		}
	}
	
	//@Test
	public void day19() throws Exception {
		runTask("day19/task-a.fpl", "day19/test-input.txt", FplInteger.valueOf(0));
		runTask("day19/task-a.fpl", "day19/task-input.txt", FplInteger.valueOf(0));
		runTask("day19/task-b.fpl", "day19/test-input.txt", FplInteger.valueOf(0));
		runTask("day19/task-b.fpl", "day19/task-input.txt", FplInteger.valueOf(0));
	}
	
	//@Test
	public void day20() throws Exception {
		runTask("day20/task-a.fpl", "day20/test-input.txt", FplInteger.valueOf(0));
		runTask("day20/task-a.fpl", "day20/task-input.txt", FplInteger.valueOf(0));
		runTask("day20/task-b.fpl", "day20/test-input.txt", FplInteger.valueOf(0));
		runTask("day20/task-b.fpl", "day20/task-input.txt", FplInteger.valueOf(0));
	}
	
	//@Test
	public void day21() throws Exception {
		runTask("day21/task-a.fpl", "day21/test-input.txt", FplInteger.valueOf(0));
		runTask("day21/task-a.fpl", "day21/task-input.txt", FplInteger.valueOf(0));
		runTask("day21/task-b.fpl", "day21/test-input.txt", FplInteger.valueOf(0));
		runTask("day21/task-b.fpl", "day21/task-input.txt", FplInteger.valueOf(0));
	}
	
	//@Test
	public void day22() throws Exception {
		runTask("day22/task-a.fpl", "day22/test-input.txt", FplInteger.valueOf(0));
		runTask("day22/task-a.fpl", "day22/task-input.txt", FplInteger.valueOf(0));
		runTask("day22/task-b.fpl", "day22/test-input.txt", FplInteger.valueOf(0));
		runTask("day22/task-b.fpl", "day22/task-input.txt", FplInteger.valueOf(0));
	}
	
	//@Test
	public void day23() throws Exception {
		runTask("day23/task-a.fpl", "day23/test-input.txt", FplInteger.valueOf(0));
		runTask("day23/task-a.fpl", "day23/task-input.txt", FplInteger.valueOf(0));
		runTask("day23/task-b.fpl", "day23/test-input.txt", FplInteger.valueOf(0));
		runTask("day23/task-b.fpl", "day23/task-input.txt", FplInteger.valueOf(0));
	}
	
	//@Test
	public void day24() throws Exception {
		runTask("day24/task-a.fpl", "day24/test-input.txt", FplInteger.valueOf(0));
		runTask("day24/task-a.fpl", "day24/task-input.txt", FplInteger.valueOf(0));
		runTask("day24/task-b.fpl", "day24/test-input.txt", FplInteger.valueOf(0));
		runTask("day24/task-b.fpl", "day24/task-input.txt", FplInteger.valueOf(0));
	}
	
	//@Test
	public void day25() throws Exception {
		runTask("day25/task-a.fpl", "day25/test-input.txt", FplInteger.valueOf(0));
		runTask("day25/task-a.fpl", "day25/task-input.txt", FplInteger.valueOf(0));
		runTask("day25/task-b.fpl", "day25/test-input.txt", FplInteger.valueOf(0));
		runTask("day25/task-b.fpl", "day25/task-input.txt", FplInteger.valueOf(0));
	}
	
	private void runTask(String sourceFileName, String inputFileName, FplValue expectedResult) throws Exception {
		File baseDir = new File("src/main/resources/2021");
		FplEngine engine = new DefaultFplEngine();
		Scope scope = engine.getScope();
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
