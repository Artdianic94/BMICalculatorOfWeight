import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class WeightControl {
        WebDriver driver;

        @BeforeMethod
        public void setProp() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            this.driver = new ChromeDriver();
            this.driver.get("https://healthunify.com/bmicalculator/");
        }

        @Test
        public void starvationTest() {
            this.driver.findElement(By.xpath("//p/input[@name='wg']")).sendKeys("45");
            this.driver.findElement(By.xpath("//p/input[@class='innerc resform']")).sendKeys("175");
            this.driver.findElement(By.xpath("//p/input[@name='cc']")).click();
            String weightGroupName = this.driver.findElement(By.xpath("//tr/td/input [@class = 'content']")).getAttribute("value");
            Assert.assertEquals(weightGroupName, "Your category is Starvation", "BMI is calculated incorrectly");
        }

        @Test
        public void underweightTest() {
            this.driver.findElement(By.xpath("//p/input[@name='wg']")).sendKeys("50");
            this.driver.findElement(By.xpath("//p/input[@class='innerc resform']")).sendKeys("170");
            this.driver.findElement(By.xpath("//p/input[@name='cc']")).click();
            String weightGroupName = this.driver.findElement(By.xpath("//tr/td/input [@class = 'content']")).getAttribute("value");
            Assert.assertEquals(weightGroupName, "Your category is Underweight", "BMI is calculated incorrectly");
        }

        @Test
        public void normalWeightTest() {
            this.driver.findElement(By.xpath("//p/input[@name='wg']")).sendKeys("60");
            this.driver.findElement(By.xpath("//p/input[@class='innerc resform']")).sendKeys("170");
            this.driver.findElement(By.xpath("//p/input[@name='cc']")).click();
            String weightGroupName = this.driver.findElement(By.xpath("//tr/td/input [@class = 'content']")).getAttribute("value");
            Assert.assertEquals(weightGroupName, "Your category is Normal", "BMI is calculated incorrectly");
        }

        @Test
        public void overweightTest() {
            this.driver.findElement(By.xpath("//p/input[@name='wg']")).sendKeys("90");
            this.driver.findElement(By.xpath("//p/input[@class='innerc resform']")).sendKeys("185");
            this.driver.findElement(By.xpath("//p/input[@name='cc']")).click();
            String weightGroupName = this.driver.findElement(By.xpath("//tr/td/input [@class = 'content']")).getAttribute("value");
            Assert.assertEquals(weightGroupName, "Your category is Overweight", "BMI is calculated incorrectly");
        }

        @Test
        public void obeseTest() {
            this.driver.findElement(By.xpath("//p/input[@name='wg']")).sendKeys("100");
            this.driver.findElement(By.xpath("//p/input[@class='innerc resform']")).sendKeys("180");
            this.driver.findElement(By.xpath("//p/input[@name='cc']")).click();
            String weightGroupName = this.driver.findElement(By.xpath("//tr/td/input [@class = 'content']")).getAttribute("value");
            Assert.assertEquals(weightGroupName, "Your category is Obese", "BMI is calculated incorrectly");
        }

        @AfterMethod
        public void quit() {
            this.driver.quit();
        }
    }

