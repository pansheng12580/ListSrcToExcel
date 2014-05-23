package util;

/**
 * 程序控制配置
 * @author pansheng
 * @time 20140523
 */
public class Config {
	/***********************************************************************************/
	/*配置文件说明                                                                     */                                                                                                  */
	/*   1.配置源码工程路径 PROJECT_PATH											   */
	/*   2.配置输出Excel文件的绝对路径 EXCEL_OUTPUT_PATH							   */
	/*   3.对应配置sheet名称和工程中相对路径 SHEET_NAME_ARRAY && SHEET_NAME_PATH_ARRAY */
	/***********************************************************************************/
	
	//调试用
	public static Boolean IS_OPEN_LOG = true;
	//Log("error message",Config.IS_OPEN_LOG);
	
	//生成Excel文件
	public static String PROJECT_PATH = "E://Workspaces//WebTest//Test";
	public static String EXCEL_OUTPUT_PATH = "D://ExcelOutPutFilefromjava.xls";
	
	public static String[] SHEET_NAME_ARRAY = {"包结构","页面","CSS","JS","IMAGES"};
	public static String[] SHEET_NAME_PATH_ARRAY = {"src//com//my//test","WebRoot//pages",
		"WebRoot//css","WebRoot//js","WebRoot//images"};
}
