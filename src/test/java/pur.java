/**
 * Created by Trevor on 3/29/2019.
 */
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import static java.lang.System.getProperty;

public class pur {
    WebDriver driver ;
   static long startTime=System.currentTimeMillis();
    static long end;




    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    @Before
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        driver = new ChromeDriver();
        //uncomment this if u using safari on mac and comment the above code = driver = new ChromeDriver();
        // driver = driver = new SafariDriver();
        driver.get("https://www.purina.co.uk");
        driver.manage().window().maximize();

    }
    @Test
    public void testHeaderFooterLinks () throws Exception
    {

       // long start = System.currentTimeMillis();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block-purinamainfooterfirstline\"]/ul/li[1]/a")));
        this.takeSnapShot(driver, "target//landing_page.png") ;
        driver.findElement(By.xpath("//*[@id=\"__ghostery-close-icon-line1\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block-views-block-nppe-tile-grid-block-2\"]/div/div/header/div/h2")));
        driver.findElement(By.xpath("//*[@id=\"block-purinamainfooterfirstline\"]/ul/li[1]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block-breadcrumbs\"]/nav/ul/li[2]/a")));
        Assert.assertEquals("Our Cat and Dog Food Brands",driver.findElement(By.xpath("//*[@id=\"block-landingpagebootstrapparagraphs\"]/div[1]/div/div/div/h1")).getText());
        this.takeSnapShot(driver, "target//brands_page.png") ;

        driver.findElement(By.xpath("//*[@id=\"block-purinamainfooterfirstline\"]/ul/li[2]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block-breadcrumbs\"]/nav/ul/li[2]/a ")));
        Assert.assertEquals("Everything You Need To Know About Cats",driver.findElement(By.xpath("//*[@id=\"block-landingpagebootstrapparagraphs\"]/div[1]/div/div/div/h1")).getText());
        this.takeSnapShot(driver, "target//cats_page.png") ;

        driver.findElement(By.xpath("//*[@id=\"block-purinamainfooterfirstline\"]/ul/li[3]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block-breadcrumbs\"]/nav/ul/li[2]/a")));
        Assert.assertEquals("Everything You Need To Know About Dogs",driver.findElement(By.xpath("//*[@id=\"block-landingpagebootstrapparagraphs\"]/div[1]/div/div/div/h1")).getText());
        this.takeSnapShot(driver, "target//dogs_page.png") ;

        driver.findElement(By.xpath("//*[@id=\"block-purinamainfooterfirstline\"]/ul/li[4]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block-breadcrumbs\"]/nav/ul/li[2]/a")));
        Assert.assertEquals("EXPERTS IN NUTRITION",driver.findElement(By.xpath("//*[@id=\"block-breadcrumbs\"]/nav/ul/li[2]/a")).getText());
        this.takeSnapShot(driver, "target//MEETPURINA_page.png") ;

        driver.findElement(By.xpath("//*[@id=\"block-purinamainfooterfirstline\"]/ul/li[5]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/router-view/breadcrumb/div/ul/li[2]/a")));
        Assert.assertEquals("WHAT WOULD YOU LIKE TO TELL US?",driver.findElement(By.xpath("/html/body/div[1]/div[2]/router-view/div/div/section/div[1]/div/div/h2")).getText());
        this.takeSnapShot(driver, "target//contact_us_page.png") ;
        //driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[1]/a/img")).click();
        // a new addded
        driver.quit();

        /*  long end  = System.currentTimeMillis();
        double dur=(double) (end-start)/1000;
        int duration= (int) dur;

        System.out.println(duration+ " s");
        System.out.println(dur);
        System.out.println(end);  */

    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination

        File DestFile=new File(fileWithPath);
        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }


    @After
    public  void afterTest(){

    try {
        //define a HTML String Builder
        StringBuilder htmlStringBuilder=new StringBuilder();
        //append html header and title
        htmlStringBuilder.append("<html><head><title>Selenium Test </title></head>");

        htmlStringBuilder.append("<center><h1>Automation Results </h1></br></br>");
        //append body
        htmlStringBuilder.append("<body>");
        //append table
        htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
        //append row
        htmlStringBuilder.append("<tr><td><b>TestId</b></td><td><b>TestName</b></td><td><b>Status<td><b>Execution Time</b></td></tr>");
        //append row

        end  = System.currentTimeMillis();
        double dur=(double) (end-startTime)/1000;
        int duration= (int) dur;

        htmlStringBuilder.append("<tr><td>001</td><td>Screen Verifications</td><td>Passed<td><b>"+duration+"</td></tr>");
        //append row
        //htmlStringBuilder.append("<tr><td>002</td><td>Logout</td><td>Passed</td></tr>");
        //close html file
        htmlStringBuilder.append("</table></br>");
        htmlStringBuilder.append("<img src='d://pie.png' alt='image' />");
        htmlStringBuilder.append("</body></center></html>");

        //write html string content to a file
        WriteToFile(htmlStringBuilder.toString(),"testfile.html");
        System.out.println(duration+ " s");
        System.out.println(dur);
        System.out.println(end);


    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator+fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator+ "backup_"+fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();


    }


}
