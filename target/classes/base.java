package resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public static WebDriver driver;
    public Properties prop;


    public WebDriver invokebrowser() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Nandhu\\E2EProject\\src\\main\\java\\resources\\objects.properties");
        prop.load(fis);
        String browsername = prop.getProperty("browser");

        if(browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","D:\\Nandhu\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

//    @DataProvider
//    public ArrayList<String> getdata() throws IOException {
//
//        FileInputStream fis = new FileInputStream("D:\\Nandhu\\E2EProject\\src\\main\\java\\resources\\Data Sheet.xlsx");
//        XSSFWorkbook xl = new XSSFWorkbook(fis);
//        int num = xl.getNumberOfSheets();
//
//        ArrayList <String> a = new ArrayList<String>();
//        for(int i=0;i<num;i++) {
//
//            String shName = xl.getSheetAt(i).getSheetName();
//            XSSFSheet sheet = xl.getSheetAt(i);
//
//            if (shName.equalsIgnoreCase("Sheet1")) {
//                Iterator<Row> row = sheet.iterator();
//                Row firstrow = row.next();
//                Iterator<Cell> cells = firstrow.cellIterator();
//                int k = 0;
//                int col = 0;
//
//                while (cells.hasNext()) {
//                    String val = cells.next().getStringCellValue();
//                    if (val.equalsIgnoreCase("Testcase")) {
//                        col = k;
//                    }
//                    k++;
//                }
//                while (row.hasNext()) {
//                    Row r = row.next();
//                    if (r.getCell(col).getStringCellValue().equalsIgnoreCase("Purchase")) {
//                        Iterator<Cell> cv = r.cellIterator();
//                        while (cv.hasNext()) {
//                            System.out.println(cv.next().getStringCellValue());
//                            a.add(cv.next().getStringCellValue());
//                        }
//                    }
//                }
//
//            }
//
//        }
//
//        return a;
//    }

    @DataProvider
    public Object[][] getdata(){

        Object [] [] a = new Object[2][2];

        a[0][0] = "abc11@gmail.com";
        a[0][1]= "abc1";
        a[1][0] = "abc12@gmail.com";
        a[1][1]= "abc2";

        return a;
    }


    public void Screenshot(String result) throws IOException {

        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("D:\\Nandhu\\Screenshot Failed"));

    }
}
