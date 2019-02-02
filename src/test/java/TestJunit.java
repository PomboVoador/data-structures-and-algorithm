/**
 * @version 1.0
 * @title: TestJunit
 * @desc:
 * @package: PACKAGE_NAME
 * @author: chang.xu
 * @date: 2019/01/31 22:04
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestJunit {

	String message = "Hello World";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testPrintMessage() {
		message = "New Word";
		assertEquals(message,messageUtil.printMessage());
	}
}
