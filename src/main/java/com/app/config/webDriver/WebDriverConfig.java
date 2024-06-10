package com.app.config.webDriver;


import com.app.SpringBootSeleniumCucumberProj.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
public class WebDriverConfig {
    @Value("${browser:chrome}")
    private String browser;

    @Bean
    @Scope("webDriverScope")
    public WebDriver driver(){
        return switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new IllegalArgumentException("Impossible to create webdriver");
        };
    }
}
