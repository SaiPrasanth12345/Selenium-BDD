package StepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import general.CommonMethods;
import general.searchTextPojo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {

	CommonMethods comm = new CommonMethods();

	@Given("I to launch the google page")
	public void i_to_launch_the_google_page() {
		System.out.println("12345");
		comm.googleLaunch();
		
		HooksClass hkc = new HooksClass();
		hkc.logMessage("Google Launched");
		hkc.attachScreenshot();
	}

	@When("I search for the text {string} in the search box")
	public void i_search_for_the_text_in_the_search_box(String text) {
		comm.searchGoogleText(text);
	}

	@Then("Search is displayed")
	public void search_is_displayed() {
		Assert.assertTrue("Search is Displayed", comm.searchDisplayed());
		System.out.println("Search String: " + comm.getTextResult());
	}

	@When("I search for the text in the search box through excel")
	public void i_search_for_the_text_in_the_search_box_through_excel() throws Exception {
		System.out.println("Excel Sheet Value: ");
		comm.getDataFromExcel().forEach(i -> System.out.println(i));
		comm.searchGoogleTextusingJavaScript(comm.getDataFromExcel().get(1));
	}

	@When("I search for the text in the search box through datatable")
	public void i_search_for_the_text_in_the_search_box_through_datatable(DataTable dataTable) {
		List<List<String>> searchKeys = dataTable.asLists();
		String text = searchKeys.get(1).get(0);
		System.out.println("DataTable Text" + text);
		comm.searchGoogleText(text);
	}

	@When("I search for the text by joininig SearchText through datatable")
	public void i_search_for_the_text_by_joininig_search_text_through_datatable(DataTable dataTable) {
		List<searchTextPojo> textpojo = new ArrayList<>();

		// This method is currently depriciated
		/*
		 * textpojo = dataTable.asList(searchTextPojo.class);
		 */

		// So using List to convert to Pojo
		List<List<String>> searchList = dataTable.asLists();
		for (int i = 0; i < searchList.size(); i++) {
			textpojo.add(new searchTextPojo(searchList.get(i).get(0), searchList.get(i).get(1)));
		}
		String text = textpojo.get(1).getSearchWord1() + " " + textpojo.get(1).getSearchWord2();
		System.out.println("Pojo Class Text: " + text);
		comm.searchGoogleText(text);
	}
	
	@Given("Navigate to amazon website")
	public void navigate_to_amazon_website() {
		comm.amazonLaunch();
	}
	@When("Add the Product")
	public void add_the_product() {
	    	comm.addProduct();
	}

	@Then("validate for amazon Product")
	public void validate_for_amazon_product() {
		// validate 2 items are present in the cart
		String cartcount = comm.validateCartCount();
		Assert.assertEquals(cartcount, "2");

		// validate for item present in cart
		boolean itemDislpayed = comm.validateCart();
		Assert.assertTrue(itemDislpayed);
	}
}
