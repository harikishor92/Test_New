package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.alberta.qa.Base.BaseTest;

public class PurchaseOrderPage extends BaseTest{
	@FindBy(xpath = "//a[contains(text(),'Add New')]")
	private WebElement addPO;

	@FindBy(xpath = "//input[@id = 'item_name']")
	private WebElement enterItemName;

	@FindBy(xpath = "//button[contains(text(),'GENERATE')]")
	private WebElement generateBtn;
	@FindBy(xpath = "//*[@id=\"history_items\"]/tr/td[9]/input")
	private WebElement enterQty;
	@FindBy(xpath = "//button[contains(text(),'Add Item')]")
	private WebElement addItemBtn;

	@FindBy(xpath = "(//span[. = 'VENDOR'])[1]")
	private WebElement clickOnVendor;
	@FindBy(xpath = "//input[@class= 'select2-search__field']")
	private WebElement enterOption;
	@FindBy(xpath = "//ul[@class= 'select2-results__options']")
	private WebElement selectOption;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div[2]/button")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//*[@id=\"purchase_order\"]/tbody/tr[1]/td[4]")
	private WebElement invoice;
	@FindBy(xpath = "//*[@id=\"purchase_order\"]/tbody/tr[1]/td[9]/a")
	private WebElement clickOnView;
	
	@FindBy(xpath = "//button[@id='export']")
	private WebElement clickOnExportToVendor;
	@FindBy(xpath = "//input[@id='send_to_ro']")
	private WebElement clickOnSendToRO;
	//Navigate to RO
	@FindBy(xpath = "//a[contains(text(),' INVENTORY')]")
	private WebElement inventoryBtn;
	@FindBy(xpath = "//a[contains(text(),' Receiving Order')]")
	private WebElement ROBtn;
	@FindBy(xpath = "//*[@id=\"receiving_order\"]/thead/tr/th[3]/div/input")
	private WebElement RO_Invoice;
	@FindBy(xpath = "(//a[.='unpaid'])[1]")
	private WebElement clickOnFirstSearch;
	@FindBy(xpath = "//select[@id = 'payment_status']")
	private WebElement selectPaymentStatus;
	@FindBy(xpath = "//input[@id = 'for_item']")
	private WebElement selectItemCheckBox;
	@FindBy(xpath = "//button[.='Yes']")
	private WebElement selectYes;
	@FindBy(xpath = "//button[.='Save/Receive']")
	private WebElement clickOnReceive;
	
	//Quick PO
	@FindBy(xpath = "//*[@id=\"main_nav\"]/div[2]/a[1]")
	private WebElement addQPO;
	@FindBy(xpath = "//*[@id=\"barcode\"]")
	private WebElement enterItemSku;
	@FindBy(xpath = "//button[contains(text(),'SEARCH UPC')]")
	private WebElement searchUPCBtn;
	@FindBy(xpath = "//input[@id = 'orderQty']")
	private WebElement enterOrderQty;
	@FindBy(xpath = "//button[contains(text(),'ADD ORDER QTY')]")
	private WebElement addOrderQtyBtn;
	@FindBy(xpath = "//*[@id=\"vendor\"]")
	private WebElement selectVendor;
	@FindBy(xpath = "//*[@id='btnSave']")
	private WebElement saveQPOBtn;



	public PurchaseOrderPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNewPO()
	{
		addPO.click();

	}
	
	public void clickOnAddNewQPO()
	{
		addQPO.click();

	}

	public void createNewPO(String itemName,String orderQty,String vendorName) throws InterruptedException{
		//Item #1
		enterItemName.sendKeys(itemName);
		Thread.sleep(2000);
		generateBtn.click();
		Thread.sleep(2000);
		enterQty.sendKeys(orderQty);
		Thread.sleep(2000);
		addItemBtn.click();
		Thread.sleep(2000);

		//Click on Vendor Dropdown
		clickOnVendor.click();
		Thread.sleep(2000);
		enterOption.sendKeys(vendorName);
		Thread.sleep(2000);
		selectOption.click();
		Thread.sleep(2000);
		saveBtn.click();
		Thread.sleep(2000);
		String inVoice = invoice.getText();
		System.out.println(inVoice);
		Thread.sleep(1000);
		clickOnView.click();
		Thread.sleep(2000);
		clickOnExportToVendor.click();
		Thread.sleep(2000);
		clickOnSendToRO.click();
		/*
		 * Thread.sleep(4000); //Navigate to RO inventoryBtn.click();
		 * Thread.sleep(2000); ROBtn.click(); Thread.sleep(2000);
		 * RO_Invoice.sendKeys(inVoice); Thread.sleep(4000); clickOnFirstSearch.click();
		 * //Thread.sleep(2000); //Select paymentStatus = new
		 * Select(selectPaymentStatus); //paymentStatus.selectByVisibleText("Paid");
		 * Thread.sleep(2000); selectItemCheckBox.click(); Thread.sleep(2000);
		 * selectYes.click(); Thread.sleep(2000); clickOnReceive.click();
		 */
		
		
	}

	public void createNewQPO(String sku1,String orderQty1,String sku2,String orderQty2,String vendorName) throws InterruptedException{
		//Item #1
		enterItemSku.sendKeys(sku1);
		Thread.sleep(3000);
		searchUPCBtn.click();
		Thread.sleep(2000);
		enterOrderQty.sendKeys(orderQty1);
		Thread.sleep(2000);
		addOrderQtyBtn.click();
		Thread.sleep(2000);
		enterItemSku.clear();
		enterItemSku.sendKeys(sku2);
		Thread.sleep(3000);
		searchUPCBtn.click();
		Thread.sleep(2000);
		enterOrderQty.clear();
		enterOrderQty.sendKeys(orderQty2);
		Thread.sleep(2000);
		addOrderQtyBtn.click();
		Thread.sleep(2000);

		//Click on Vendor Dropdown
		Thread.sleep(2000);
		Select drpVendor = new Select(selectVendor);
		drpVendor.selectByVisibleText(vendorName);
		Thread.sleep(2000);
		saveQPOBtn.click();
		Thread.sleep(2000);
		System.out.println(invoice.getText());
		
	}


}
