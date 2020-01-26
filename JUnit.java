package org.JUnit;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JUnit extends BaseClass{
	
	public static String getInput(int rowNo,int cellNo) throws Throwable {
	      String str=null;
	      
	      File loc=new File("C:\\Users\\Jayanthan\\eclipse-workspace\\SampleMaven\\TestData\\excelread1.xlsx");
			FileInputStream stream=new FileInputStream(loc);
			Workbook w=new XSSFWorkbook(stream);
			Sheet sh = w.getSheet("Sheet1");
			Row r = sh.getRow(rowNo);
			Cell c = r.getCell(cellNo);
			int type = c.getCellType();
			if(type==1) {
				 str = c.getStringCellValue();
			}
			else if(type==0) {
				if(DateUtil.isCellDateFormatted(c))
				{
					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yy");
					str = sim.format(dateCellValue);
				}
				else {
					double numericCellValue = c.getNumericCellValue();
					long l=(long)numericCellValue;
					str = String.valueOf(l);
				}
			}
	      return str;
	      
		}
	
    static WebDriver driver;
    @BeforeClass
    public static void browserLaunch() {
    	getDriver();
        getUrl("https://www.adactin.com/HotelApp/");

	}
    @AfterClass
   public static void quit() {
   quitBrowser();
	}
    @Before
    public void startTime() {
    Date d=new Date();
    System.out.println(d);
	}
    @After
    public void endTime() {
    	Date d=new Date();
        System.out.println(d);
	}
    @Test
    public void loginPage() throws Throwable {
    	LoginPage page=new LoginPage();
     type(page.getTxtUserName(), getInput(1, 0));
     type(page.getTxtPassword(),getInput(1, 1));
	 click(page.getLoginBtn());
    
	}
    
    @Test
    public void searchHotel() {
    	SearchHotel h=new SearchHotel();
		selectbyIndex(h.getLoc(), 1);
		selectbyIndex(h.getHotels(), 2);
		selectbyIndex(h.getRoomType(), 2);
		selectbyIndex(h.getRoomNo(), 1);
		type(h.getCheckinDate(), "28/01/2020");
		type(h.getCheckoutDate(),"30/01/2020");
		selectbyIndex(h.getAdultRoom(), 3);
		selectbyIndex(h.getChildRoom(), 2);
		click(h.getSearch());
	}
    @Test
    public void selectHotel() {
      SelectHotel sh=new SelectHotel();
      click(sh.getRadio());
	  click(sh.getSelectHotel());
	}
    @Test
    public void bookHotel() throws Throwable {
    BookHotel bh=new BookHotel();
    type(bh.getFirstName(), getInput(1, 2));
	type(bh.getLastName(),getInput(1, 3));
	type(bh.getAddress(), getInput(1, 4));
	type(bh.getCc(),getInput(1, 5));
    selectbyIndex(bh.getCcType(), 1);	
    selectbyIndex(bh.getCcExpMonth(), 4);
    selectbyIndex(bh.getCcExpYear(), 10);
    type(bh.getCvv(), getInput(1, 6));
    click(bh.getBookNow());   
    
	}
    
    @Test
    public void orderNo() {
     OrderNo o=new OrderNo();
     WebElement orderNo2 = o.getOrderNo();
     String string1 = orderNo2.getAttribute("value");
     System.out.println(string1);
    // String orderno = o.getOrderNo().getAttribute("value");
    // System.out.println(orderno);
	}
    
}

