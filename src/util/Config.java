package util;

/**
 * �����������
 * @author pansheng
 * @time 20140523
 */
public class Config {
	/***********************************************************************************/
	/*�����ļ�˵��                                                                     */                                                                                                  */
	/*   1.����Դ�빤��·�� PROJECT_PATH											   */
	/*   2.�������Excel�ļ��ľ���·�� EXCEL_OUTPUT_PATH							   */
	/*   3.��Ӧ����sheet���ƺ͹��������·�� SHEET_NAME_ARRAY && SHEET_NAME_PATH_ARRAY */
	/***********************************************************************************/
	
	//������
	public static Boolean IS_OPEN_LOG = true;
	//Log("error message",Config.IS_OPEN_LOG);
	
	//����Excel�ļ�
	public static String PROJECT_PATH = "E://Workspaces//WebTest//Test";
	public static String EXCEL_OUTPUT_PATH = "D://ExcelOutPutFilefromjava.xls";
	
	public static String[] SHEET_NAME_ARRAY = {"���ṹ","ҳ��","CSS","JS","IMAGES"};
	public static String[] SHEET_NAME_PATH_ARRAY = {"src//com//my//test","WebRoot//pages",
		"WebRoot//css","WebRoot//js","WebRoot//images"};
}
