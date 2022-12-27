package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExport {
	static final String path = "C:\\Users\\CC-Student\\eclipse-workspace\\waage\\data\\messung.xlsx";
	public ExcelExport(){
		GUIWaagestamm waage = new GUIWaagestamm();
		// 1. Create WorkBook
		XSSFWorkbook workBook = new XSSFWorkbook();
		
		// 2. Create "Messung"-Blatt (Sheet)
		XSSFSheet sheet = workBook.createSheet("Messung");	
		
		// 3. Create Headers Row
		Row headersRow = sheet.createRow(0);		
		System.out.println("rows: " + sheet.getPhysicalNumberOfRows());
		
		// 4. Add the headers to the first row
//		for(int i=0; i<new GUIWaagestamm().table2.getColumnCount();i++) {
//		Cell cell = headersRow.createCell(i);
//		cell.setCellValue(new GUIWaagestamm().table2.getColumnName(i));
//				}

				
				// 4. Add the headers to the first row				
				
				for(int i=0; i<waage.table2.getColumnCount();i++) {
					Cell cell = headersRow.createCell(i);
					cell.setCellValue(waage.table2.getColumnName(i));
				}
		// 5. Alle Daten werden in die Cells eingetragen
		int satirNo = 1;
		System.out.println("Excel dosyasi olusturuluyor");
		
			
			Row satir = sheet.createRow(satirNo++);
			int sütunNo = 0;
//			for(Object tabloHucre : tabloSatir) {
//				Cell hucre = satir.createCell(sütunNo++);
//				if(tabloHucre instanceof String) {
//					hucre.setCellValue((String)tabloHucre);
//				}else if(tabloHucre instanceof Double) {
//					hucre.setCellValue((double) tabloHucre);
//				}
//			}
		DatabaseDAO d = new DatabaseDAO();

		for(int j = 1; j<waage.table2.getRowCount(); j++) {
		Row row = sheet.createRow(j);
		for(int k=0; k<waage.table2.getColumnCount(); k++) {
			
		Cell cell = row.createCell(k);
		if(cell.getColumnIndex()==0) {
			
			row.createCell(0).setCellValue(satirNo++);
		}
		else {
			try {
				row = sheet.createRow(satirNo++);
				row.createCell(k).setCellValue(d.rs.getString(k).toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		}
		
//				}
			}		
		
		try {
			FileOutputStream fos = new FileOutputStream(new File(path));
			
			workBook.write(fos);
			
			fos.close();
			workBook.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
