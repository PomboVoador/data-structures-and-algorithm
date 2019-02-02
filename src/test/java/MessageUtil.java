/**
 * @version 1.0
 * @title: MessageUtil
 * @desc:
 * @package: PACKAGE_NAME
 * @author: chang.xu
 * @date: 2019/01/31 22:04
 */
/*
 * This class prints the given message on console.
 */
public class MessageUtil {

	private String message;

	//Constructor
	//@param message to be printed
	public MessageUtil(String message){
		this.message = message;
	}

	// prints the message
	public String printMessage(){
		System.out.println(message);
		return message;
	}
}
