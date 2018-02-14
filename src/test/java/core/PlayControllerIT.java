package core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import core.game.GameResult;
import core.game.Shape;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayControllerIT {

    @LocalServerPort
    private int port;

    private URI serviceURI;

    @Before
    public void setUp() throws Exception {
        this.serviceURI = new URI("http://localhost:" + port + "/play");
    }

    @Test
    public void testPlayWithValidRequestStatusOK() throws Exception {
    	
    	RestTemplate restTemplate = new RestTemplate();
    		
    	ResponseEntity<PlayResponse> response = restTemplate.exchange(serviceURI, HttpMethod.POST, new HttpEntity<>(new PlayRequest("Papier", "Klassik")), PlayResponse.class);
    	   	
    	assertThat(response.getStatusCode(), is(HttpStatus.OK));    	
    }
    
    @Test
    public void testPlayWithInvalidRequestHttpStatusBadRequest() throws Exception {
  	   	  
    	RestTemplate restTemplate = new RestTemplate();
	 	
    	try {
  		
    		restTemplate.exchange(serviceURI, HttpMethod.POST, new HttpEntity<>(new PlayRequest("Handtuch", "Fortgeschritten")), PlayResponse.class);
  	  	 		
    	} catch (HttpClientErrorException ex) {
  		
    		assertThat(ex.getStatusCode(), is(HttpStatus.BAD_REQUEST)); 
    	}  	
    
    }

    @Test
    public void testPlayWithInvalidItemCheckErrorMessage() throws Exception {
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String expectedErrorMessage = "shape invalid. Valid values: Stein or Schere or Papier. In gameMode Fortgeschritten also Brunnen is valid.";
    	
    	try {
      		
    		restTemplate.exchange(serviceURI, HttpMethod.POST, new HttpEntity<>(new PlayRequest("Handtuch", "Fortgeschritten")), PlayResponse.class);
  	  	 		
    	} catch (HttpClientErrorException ex) {
    		
    		JsonObject jsonResponseObject = new Gson().fromJson(ex.getResponseBodyAsString(), JsonObject.class);
    		  
    		String errorMessage = jsonResponseObject.get("message").getAsString();
		
    		assertThat(errorMessage, is(expectedErrorMessage)); 
    	}  
    }
   
    @Test
    public void testPlayWithInvalidGameModeCheckErrorMessage() throws Exception {
  	  
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String expectedErrorMessage = "gameMode invalid. Valid values are Klassik or Fortgeschritten";
    	
    	try {
      		
    		restTemplate.exchange(serviceURI, HttpMethod.POST, new HttpEntity<>(new PlayRequest("Stein", "Offline")), PlayResponse.class);
  	  	 		
    	} catch (HttpClientErrorException ex) {
    		
    		JsonObject jsonResponseObject = new Gson().fromJson(ex.getResponseBodyAsString(), JsonObject.class);
    		  
    		String errorMessage = jsonResponseObject.get("message").getAsString();
		
    		assertThat(errorMessage, is(expectedErrorMessage)); 
    	}  
    	
    }
    
    
    @Test
    public void testPlayWithValidRequestCheckResultShortInBasicGameMode() throws Exception {
  	  	  	 
    	RestTemplate restTemplate = new RestTemplate();
		
    	ResponseEntity<PlayResponse> response = restTemplate.exchange(serviceURI, HttpMethod.POST, new HttpEntity<>(new PlayRequest("Schere", "Klassik")), PlayResponse.class);
     	
  	  	if (Shape.PAPER.toString().equals(response.getBody().getOpponentShape())) {
  		  assertThat(GameResult.WON.toString(), is(response.getBody().getResultShort()));
  		  
  	  	} else if (Shape.ROCK.toString().equals(response.getBody().getOpponentShape())) {
  		  assertThat(GameResult.LOST.toString(), is(response.getBody().getResultShort()));
  		  
  	  	} else {
  		  assertThat(GameResult.TIE.toString(), is(response.getBody().getResultShort()));
  	  	}	  
    }
    
    @Test
    public void testPlayWithValidRequestCheckResultShortInAdvancedGameMode() throws Exception {
  	  	  	
    	RestTemplate restTemplate = new RestTemplate();
		
    	ResponseEntity<PlayResponse> response = restTemplate.exchange(serviceURI, HttpMethod.POST, new HttpEntity<>(new PlayRequest("Brunnen", "Fortgeschritten")), PlayResponse.class);
   	  
  	  	if (Shape.PAPER.toString().equals(response.getBody().getOpponentShape())) {
  		  assertThat(GameResult.LOST.toString(), is(response.getBody().getResultShort()));
  		  
  	  	} else if (Shape.ROCK.toString().equals(response.getBody().getOpponentShape())) {
  		  assertThat(GameResult.WON.toString(), is(response.getBody().getResultShort()));
  		  
  	  	} else if (Shape.SCISSOR.toString().equals(response.getBody().getOpponentShape())) {
  		  assertThat(GameResult.WON.toString(), is(response.getBody().getResultShort()));  
  		  
  	  	} else {
  		  assertThat(GameResult.TIE.toString(), is(response.getBody().getResultShort()));
  	  	}	  
    }  
}
