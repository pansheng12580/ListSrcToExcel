package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import util.Config;
import util.Util;

/**
 * 执行程序 1.初始化Excel文件 2.初始化Excel文件内容
 * @author pansheng
 * @time 20140523
 */
public class ListSrcToExcel {

	/**
	 * 初始化Excel文件
	 */
	public void initExcelFile(){
		//创建文件
		Boolean isCreatExcel = null;
		isCreatExcel = Util.createFile(Config.EXCEL_OUTPUT_PATH);
		if(isCreatExcel){
			Util.Log("Excel is created",Config.IS_OPEN_LOG);
		}
		
		//生成sheet
		for(String str : Config.SHEET_NAME_ARRAY){
			Util.creatSheet(Config.EXCEL_OUTPUT_PATH, str);
		}
		
	}
	
	/**
	 * 初始化Excel文件内容
	 */
	public void initExcelContent(){
		//初始化sheet与对应的绝对路径文件
		Map<String,String> map = new HashMap<String, String>();
		for(int i=0;i<Config.SHEET_NAME_ARRAY.length;i++){
			map.put(Config.SHEET_NAME_ARRAY[i], Config.PROJECT_PATH + "//" + Config.SHEET_NAME_PATH_ARRAY[i]);
		}
		
		//填充sheet对应内容
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
			Util.initSheetContent(Config.EXCEL_OUTPUT_PATH, entry.getValue(), entry.getKey());
		}
	}
	
	/**
	 * 主程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListSrcToExcel example = new ListSrcToExcel();
		example.initExcelFile();
		example.initExcelContent();
	}

}
