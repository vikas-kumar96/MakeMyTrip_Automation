package Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MakeMyTripAutomation {

    public static void main(String[] args) {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to makemytrip.com
        driver.get("https://www.makemytrip.com/");

        // Click on hotels
        WebElement hotelsTab = driver.findElement(By.xpath("//span[text()='Hotels']"));
        hotelsTab.click();

        // Enter location Munnar, Date 28 July to 31 July, Room 1, Adult 2 and apply
        WebElement locationInput = driver.findElement(By.id("city"));
        locationInput.sendKeys("Munnar");

        WebElement checkInDate = driver.findElement(By.id("checkin"));
        checkInDate.sendKeys("28-07-2024");

        WebElement checkOutDate = driver.findElement(By.id("checkout"));
        checkOutDate.sendKeys("31-07-2024");

        WebElement roomInput = driver.findElement(By.id("guest"));
        roomInput.sendKeys("1 Room, 2 Adult");

        WebElement applyButton = driver.findElement(By.xpath("//button[text()='APPLY']"));
        applyButton.click();

        // Price per night max 5000/-
        WebElement priceFilter = driver.findElement(By.xpath("//label[contains(text(),'Price per night')]"));
        priceFilter.click();

        WebElement max5000Filter = driver.findElement(By.xpath("//li[@data-cy='Price: ₹ 5000']"));
        max5000Filter.click();

        // Click on search
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();

        // Wait for search results to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hotelCardListing__titleWrapper']")));

        // Validate that the result is visible - List the hotel's name
        List<WebElement> hotelNames = driver.findElements(By.xpath("//div[@class='hotelCardListing__titleWrapper']"));
        System.out.println("List of hotels:");
        for (WebElement hotel : hotelNames) {
            System.out.println(hotel.getText());
        }

        // Filter results: breakfast include, Rating 3.5+, room view = mountain view
        WebElement breakfastInclude = driver.findElement(By.xpath("//span[text()='Breakfast Included']"));
        breakfastInclude.click();

        WebElement ratingFilter = driver.findElement(By.xpath("//label[@for='hlistpg_fr_star_category_3']"));
        ratingFilter.click();

        WebElement mountainViewFilter = driver.findElement(By.xpath("//span[text()='Mountain View']"));
        mountainViewFilter.click();

        // Select Hotel Blanket Hotel & Spa Munnar
        WebElement blanketHotel = driver.findElement(By.xpath("//span[contains(text(),'Blanket Hotel & Spa Munnar')]"));
        blanketHotel.click();

        // Add guest details and click on Pay now
        // Replace the following lines with your specific implementation for guest details and payment
        WebElement guestDetails = driver.findElement(By.xpath("//input[@id='guest_name']"));
        guestDetails.sendKeys("John Doe");

        WebElement payNowButton = driver.findElement(By.xpath("//button[text()='Pay Now']"));
        payNowButton.click();

        // Validate payment page is visible - Validate hotel name and booking dates
        WebElement hotelNameOnPaymentPage = driver.findElement(By.xpath("//h2[contains(text(),'Blanket Hotel & Spa Munnar')]"));
        System.out.println("Hotel Name on Payment Page: " + hotelNameOnPaymentPage.getText());

        WebElement bookingDatesOnPaymentPage = driver.findElement(By.xpath("//div[@class='bookingSummary']//span[contains(text(),'28 July')]"));
        System.out.println("Booking Dates on Payment Page: " + bookingDatesOnPaymentPage.getText());

        // Close the browser
        driver.quit();
    }
}
