package com.everest.utility;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelDataReader(String xlFilePath) throws Exception
	    {
	        fis = new FileInputStream(xlFilePath);
	        workbook = new XSSFWorkbook(fis);
	        fis.close();
	    }

	public Object getCellData(String sheetName, String colName, int rowNum)
	    {
	    	
	    	 int col_Num;
	        try
	        {
	        	 Object value=null;
	          col_Num = -1;
	            sheet = workbook.getSheet(sheetName);
	            row = sheet.getRow(0);
	            for(int i = 0; i < row.getLastCellNum(); i++)
	            {
	                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
	                    col_Num = i;
	            }
	 
	            row = sheet.getRow(rowNum - 1);
	          Cell  cell = row.getCell(col_Num);
	          
	          if(cell!=null) {
	         
	          int cellType = cell.getCellType() == Cell.CELL_TYPE_FORMULA 
	        		    ? cell.getCachedFormulaResultType() : cell.getCellType();
	        		switch (cellType) {
	        		    case Cell.CELL_TYPE_BOOLEAN: 
	        		          value=cell.getBooleanCellValue();  
	        		       break;

	        		    case Cell.CELL_TYPE_STRING:
	        		    	value= cell.getStringCellValue();
	        		    	System.out.println(value);
	        		     break;
	        		     
	        		    case Cell.CELL_TYPE_NUMERIC:
	        		    	value=cell.getNumericCellValue();
	        		        
	        		        
	        		      
	        		} 	
	        		        
	        		}
	            
	            return value;
	      
	        }
	        
	      
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";

}

	    
	    }
	
	
	public int getLastRowNumber(String sheetName) {
	 	 try {
			Object value = null;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);			
			return sheet.getLastRowNum();			
		} catch (Exception e) {
			 e.printStackTrace();
	            
		}
		return 0;
		
	}
	
	
	
	

	
	
	}