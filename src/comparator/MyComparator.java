package comparator;

import java.util.Comparator;

/**
 * 重写比较方法
 * @author pansheng
 * @time 20140523
 */
public class MyComparator implements Comparator<MyString>{

	@Override
	public int compare(MyString o1, MyString o2) {
		// TODO Auto-generated method stub
		return o1.getSize() >= o2.getSize() ? 1 : -1;
	}

}
