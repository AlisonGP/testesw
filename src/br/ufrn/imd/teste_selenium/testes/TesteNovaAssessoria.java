package br.ufrn.imd.teste_selenium.testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteNovaAssessoria {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://testes.imd.ufrn.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNovaAcessoria() throws Exception {
    driver.get(baseUrl + "/inova/");
    driver.findElement(By.cssSelector("a > div")).click();
    driver.findElement(By.name("j_username")).clear();
    driver.findElement(By.name("j_username")).sendKeys("admin");
    driver.findElement(By.name("j_password")).clear();
    driver.findElement(By.name("j_password")).sendKeys("admin");
    driver.findElement(By.cssSelector("input.btn-login")).click();
    driver.findElement(By.xpath("//div[@id='j_idt151']/div/a/span")).click();
    driver.findElement(By.id("formEmpresa:listaEmpresas:0:avatar")).click();
    driver.findElement(By.cssSelector("div.item-interativo.atualCima > p > img")).click();
    driver.findElement(By.name("j_idt111")).click();
    driver.findElement(By.id("empresaPojo_input")).clear();
    driver.findElement(By.id("empresaPojo_input")).sendKeys("A");
    driver.findElement(By.xpath("//div[@id='empresaPojo_panel']/ul/li")).click();
    driver.findElement(By.id("assessorPojo_input")).clear();
    driver.findElement(By.id("assessorPojo_input")).sendKeys("A");
    driver.findElement(By.xpath("//div[@id='assessorPojo_panel']/ul/li[2]")).click();
    driver.findElement(By.xpath("//div[@id='tiposDeAssessoria']/span/label")).click();
    driver.findElement(By.xpath("//div[@id='tiposDeAssessoria_panel']/div[2]/ul/li/div/div[2]/span")).click();
    driver.findElement(By.id("btnAddTipoAssessoria")).click();
    driver.findElement(By.id("descricaoAssessoria")).clear();
    driver.findElement(By.id("descricaoAssessoria")).sendKeys("asdadasd");
    driver.findElement(By.id("dataReuniao_input")).click();
    driver.findElement(By.id("horaInicial_input")).click();
    driver.findElement(By.id("horaInicial_input")).clear();
    driver.findElement(By.id("horaInicial_input")).sendKeys("11:00");
    driver.findElement(By.id("horaFinal_input")).click();
    driver.findElement(By.id("horaFinal_input")).clear();
    driver.findElement(By.id("horaFinal_input")).sendKeys("07:59");
    driver.findElement(By.xpath("//form[@id='j_idt44']/div[3]")).click();
    driver.findElement(By.id("btnCadastrar")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-close")).click();
    driver.findElement(By.cssSelector("#messages2 > div.ui-messages-info.ui-corner-all > a.ui-messages-close > span.ui-icon.ui-icon-close")).click();
    driver.findElement(By.name("j_idt79")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-close")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
