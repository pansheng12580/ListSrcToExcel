package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import util.Config;
import util.Util;

/**
 * ִ�г��� 1.��ʼ��Excel�ļ� 2.��ʼ��Excel�ļ�����
 * @author pansheng
 * @time 20140523
 */
public class ListSrcToExcel {

	/**
	 * ��ʼ��Excel�ļ�
	 */
	public void initExcelFile(){
		//�����ļ�
		Boolean isCreatExcel = null;
		isCreatExcel = Util.createFile(Config.EXCEL_OUTPUT_PATH);
		if(isCreatExcel){
			Util.Log("Excel is created",Config.IS_OPEN_LOG);
		}
		
		//����sheet
		for(String str : Config.SHEET_NAME_ARRAY){
			Util.creatSheet(Config.EXCEL_OUTPUT_PATH, str);
		}
		
	}
	
	/**
	 * ��ʼ��Excel�ļ�����
	 */
	public void initExcelContent(){
		//��ʼ��sheet���Ӧ�ľ���·���ļ�
		Map<String,String> map = new HashMap<String, String>();
		for(int i=0;i<Config.SHEET_NAME_ARRAY.length;i++){
			map.put(Config.SHEET_NAME_ARRAY[i], Config.PROJECT_PATH + "//" + Config.SHEET_NAME_PATH_ARRAY[i]);
		}
		
		//���sheet��Ӧ����
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
			Util.initSheetContent(Config.EXCEL_OUTPUT_PATH, entry.getValue(), entry.getKey());
		}
	}
	
	/**
	 * ���������
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListSrcToExcel example = new ListSrcToExcel();
		example.initExcelFile();
		example.initExcelContent();
	}

}
