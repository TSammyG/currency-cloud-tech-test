package java.stepdef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.runtime.snippets.Concatenator;
import cucumber.api.java.en.Then;

public class CurrencyCloudTechTest {
	
	
	
	
	//parameters.put("s.goodland@hotmail.co.uk", "1257b7f731c5bd4e8cda2de05279415da5ee90855d230db37624c3350fe10462");

	URL url;
	

	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		url = new URL("https://devapi.currencycloud.com/v2/authenticate/api");
	}

	@When("^I submit a Login ID and API key$")
	public void i_submit_a_Login_ID_and_API_key() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		
	    Map<String, String> login = new HashMap<>();
	    Map<String, String> api = new HashMap<>();
	    
	    login.put("login_id", "s.goodland@hotmail.co.uk");
	    api.put("api_key", "1257b7f731c5bd4e8cda2de05279415da5ee90855d230db37624c3350fe10462");
	    
	    con.setDoOutput(true);
	    
	    DataOutputStream out = new DataOutputStream(con.getOutputStream());
	    out.writeBytes(ParameterStringBuilder.getParamsString(login));
	    out.flush();
	    out.close();
	    
	    
	    
	}

	@Then("^I will be returned an authentication token\\.$")
	public void i_will_be_returned_an_authentication_token() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
	    int status = con.getResponseCode();
	    BufferedReader in = new BufferedReader(
	    		new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer content = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	    	content.append(inputLine);
	    }
	    in.close();
	    
	    Reader streamReader = null;
	    
	    if (status > 299) {
	    	streamReader = new InputStreamReader(con.getErrorStream());
	    }
	    else {
	    	streamReader = new InputStreamReader(con.getInputStream());
	    }
	    
	}

	@Given("^A successful login authentication$")
	public void a_successful_login_authentication() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I create a quote for selling GBP and buying USD with the sell side$")
	public void i_create_a_quote_for_selling_GBP_and_buying_USD_with_the_sell_side() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^I can verify the buy amount is correct to the rate$")
	public void i_can_verify_the_buy_amount_is_correct_to_the_rate() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Given("^a successful login authentication$")
	public void another_successful_login_authentication() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("^I create a new quote for selling GBP and buying USD with the sell side$")
	public void i_create_a_new_quote_for_selling_GBP_and_buying_USD_with_the_sell_side() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^I can verify the buy amount does not match the rate and end the API session$")
	public void i_can_verify_the_buy_amount_does_not_match_the_rate_and_end_the_API_session() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		//con.setRequestProperty("X-Auth-Token", "application/json");
		//String contentType = con.getHeaderField("X-Auth-Token");
	}
	
}
