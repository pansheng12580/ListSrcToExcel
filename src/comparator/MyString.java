package comparator;

import java.io.File;

/**
 * �ȽϹ����࣬���ݴ����ļ������Ƿ���.��������
 * @author pansheng
 * @time 20140523
 */
public class MyString {
	private File mFile;
	public MyString(File file){
		this.mFile = file;
	}
	public File getmFile() {
		return mFile;
	}
	public void setmFile(File mFile) {
		this.mFile = mFile;
	}
	public int getSize(){
		if (mFile.getName().contains("."))
			return 0;
		else 
			return 1;
	}
}
