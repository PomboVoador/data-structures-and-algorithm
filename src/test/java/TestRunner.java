import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @version 1.0
 * @title: TestRunner
 * @desc:
 * @package: PACKAGE_NAME
 * @author: chang.xu
 * @date: 2019/01/31 22:05
 */
public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestJunit.class);
		for (Failure failure :
				result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
