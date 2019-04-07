package list;

import com.changxu.list.MyArrayList;
import junit.framework.TestCase;

public class MyArrayListTest extends TestCase {



    public void test() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();

        for (int i = 0; i < 1000; i++) {
            myArrayList.add(i);
        }

        for (int i = 999; i >= 0; i--) {
            Integer remove = myArrayList.remove(i);
            System.out.println(remove);

        }







    }

}
