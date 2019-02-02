package setandmap;

import com.changxu.setandmap.LinkedListMap;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @version 1.0
 * @title: MapTest
 * @desc: map测试类
 * @package: setandmap
 * @author: chang.xu
 * @date: 2019/01/29 18:01
 */
public class MapTest {

	@Test
	public void linkedListMapTest(){
		System.out.println("Pride and Prejudice");
		ArrayList<String> words = new ArrayList<String>();
		if (FileOperation.readFile("pride-and-prejudice.txt", words)){
			System.out.println("Total words: " + words.size());

			LinkedListMap<String, Integer> map = new LinkedListMap<String, Integer>();
			for (String word: words){
				if (map.containsKey(word)){
					map.replace(word, map.get(word) + 1);
				}else {
					map.put(word, 1);
				}
			}
			System.out.println("Total different words: " + map.size());

			System.out.println("Frequency of Pride: " + map.get("pride"));

			System.out.println("Frequency of Prejudice: " + map.get("prejudice"));
		}

	}
}
