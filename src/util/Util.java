package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Util {
	
	/**
	 * 设置指定单元格内容
	 * @param filePath
	 * @param sheetName
	 * @param vertical
	 * @param horizontal
	 * @param value
	 */
	public static void setCellValue(String filePath,String sheetName,int vertical,int horizontal,String value){
		InputStream is = null;
		FileOutputStream os = null;
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		HSSFCell cell = null;
		try {
		  is = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    try {
			workbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    sheet = workbook.getSheet(sheetName);
	    cell = sheet.getRow(horizontal).getCell(vertical);
		cell.setCellValue(value);
		try {
			os = new FileOutputStream(filePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			workbook.write(os);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			is.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建文件，文件存在删除再重新创建
	 * @param filePath
	 * @return
	 */
	public static Boolean createFile(String filePath){
		File file = new File(filePath);
		if(file.exists()){
			try{
				if(file.delete()){
					Log("file exist,delete file success",Config.IS_OPEN_LOG);
				}
				else{
					Log("file exist,delete file fail",Config.IS_OPEN_LOG);
				}
			}catch(SecurityException e){
				e.printStackTrace();
			}
		}
		
		try {
			if(file.createNewFile()){
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log("file is can not create",Config.IS_OPEN_LOG);
			return false;
		}catch(SecurityException e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * 返回指定路径所有文件
	 * @param filePath
	 * @return
	 */
	public static File[] getFileArray(String filePath){
		File file = new File(filePath);
		File[] files = file.listFiles();
		/************************************************/
		//排序算法 将同目录下文件夹放在文件的后面
//		List<MyString> list = new ArrayList<MyString>();
//		for(File temfile : files){
//			list.add(new MyString(temfile));
//		}
//		Collections.sort(list, new MyComparator());
//		for(int i=0;i<list.size();i++){
//			files[i] = list.get(i).getmFile();
//		}
		/************************************************/
		return files;
	}
	
	/**
	 * 创建sheet分页
	 * @param filePath
	 * @param strArray
	 */
	public static void creatSheet(String filePath,String sheetName){
		InputStream is = null;
		FileOutputStream os = null;
		HSSFWorkbook workbook = null;
		try {
		  is = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new HSSFWorkbook(is);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    if(workbook == null){
	    	workbook = new HSSFWorkbook();
	    }
	    
	    workbook.createSheet(sheetName);
	    
		try {
			os = new FileOutputStream(filePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			workbook.write(os);
			Log("creat sheet name--" + sheetName + "--success",Config.IS_OPEN_LOG);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			is.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建单元格
	 * @param filePath
	 * @param sheetName
	 * @param vertical
	 * @param horizontal
	 * @param value
	 */
    public static void createCell(String filePath,String sheetName,int vertical,int horizontal,String value){
    	InputStream is = null;
		FileOutputStream os = null;
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		HSSFCell cell = null;
		HSSFRow row = null;
		try {
		  is = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    try {
			workbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    sheet = workbook.getSheet(sheetName);
	    sheet.setColumnWidth(vertical, 4000);
	    row = sheet.createRow(horizontal);
	    cell = row.createCell(vertical);
	    cell.setCellValue(value);
	    
		try {
			os = new FileOutputStream(filePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			workbook.write(os);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			is.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 初始化sheet内容，遍历四层目录
     * @param filePath
     * @param contentPath
     * @param sheetName
     */
    public static void initSheetContent(String filePath,String contentPath,String sheetName){
    	int horizontal = 0;
		int vertical = 0;
		for(File file : Util.getFileArray(contentPath)){
			if(file.isDirectory()){
				Util.createCell(filePath, sheetName,  ++vertical, ++horizontal,file.getName());
				for(File file2 : Util.getFileArray(contentPath+"//"+file.getName())){
					if(file2.isDirectory()){
						Util.createCell(filePath, sheetName,  ++vertical, ++horizontal,file2.getName());
						for(File file3 : Util.getFileArray(contentPath+"//"+file.getName()+"//"+file2.getName())){
							if(file3.isDirectory()){
								Util.createCell(filePath, sheetName,  ++vertical, ++horizontal,file3.getName());
								for(File file4 : Util.getFileArray(contentPath+"//"+file.getName()+"//"+file2.getName()+"//"+file3.getName())){
									Util.createCell(filePath, sheetName,  ++vertical, ++horizontal,file4.getName());
									--vertical;
								}
								--vertical;
							}
							if(!file3.isDirectory()){
								Util.createCell(filePath,sheetName,  ++vertical, ++horizontal,file3.getName());
								--vertical;
							}
						}
						--vertical;
					}
					if(!file2.isDirectory()){
						Util.createCell(filePath,sheetName,  ++vertical, ++horizontal,file2.getName());
						--vertical;
					}
				}
				--vertical;
			}
			if(!file.isDirectory()){
				Util.createCell(filePath,sheetName,  ++vertical, ++horizontal,file.getName());
				--vertical;
			}
		}
    	
    }
	
	
	/**
	 * 打印log日志信息开关
	 * @param msg
	 * @param isOpen
	 */
	public static void Log(String msg,Boolean isOpen){
		if(isOpen){
			System.out.println(msg);
		}
	}
}
