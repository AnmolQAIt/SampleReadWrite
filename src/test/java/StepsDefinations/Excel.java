package StepsDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

public class Excel 
{
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	XSSFRow row;
	Steps s;
	
	static Map <String,Object[]> testinfo = new TreeMap<String, Object[] >();
		      
	
	
	public Excel() throws IOException
	{
		
		 workbook=new XSSFWorkbook();
		 sheet=workbook.createSheet("My Test Results");
		
	    EnterData();
	    
	    
		 FileOutputStream out = new FileOutputStream(new File("/home/anmolaggarwal/Downloads/excelreadwritecreateworkbook.xlsx"));
		 workbook.write(out);
	     out.close();
	     System.out.println("createworkbook.xlsx written successfully");
	
	}
	
	
	public void EnterData()
	{
		testinfo.put("1",new Object[]{"Test Case","Result"});
	for(int i=0;i<s.count;i++)
	{
		for(Map.Entry<String, String> entry:s.m.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
				testinfo.put(String.valueOf(i+1),new Object[]{entry.getKey(),entry.getValue()});
	}}
	Set<String> keyid=testinfo.keySet();
	int rowid=0;
	for(String key:keyid)
	{
		row = sheet.createRow(rowid++);
        Object [] objectArr = testinfo.get(key);
        int cellid = 0;

        for (Object obj : objectArr) {
           Cell cell = row.createCell(cellid++);
           cell.setCellValue((String)obj);
        }
	}
	}
	
public static void main(String[] args) throws IOException 
{

}
}