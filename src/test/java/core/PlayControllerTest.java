package core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import core.game.GameResult;
import core.game.Shape;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayControllerTest {

  @Autowired
  private MockMvc mvc;
  
  @Test
  public void testPlayWithValidRequestStatusOK() throws Exception {
	  	  
	  String inputJson = new Gson().toJson(new PlayRequest("Papier", "Klassik"));
	  
      mvc.perform(MockMvcRequestBuilders.post("/play").contentType(MediaType.APPLICATION_JSON).content(inputJson))
      .andExpect(status().isOk());     
     ;
  }
  
  @Test
  public void testPlayWithValidRequestCheckResultShortInBasicGameMode() throws Exception {
	  	  	  
	  String inputJson = new Gson().toJson( new PlayRequest("Schere", "Klassik"));
	  
	  MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/play").contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();      

	  JsonObject jsonResponseObject = new Gson().fromJson(result.getResponse().getContentAsString(), JsonObject.class);
	  
	  String opponentShape = jsonResponseObject.get("opponentShape").getAsString();
	  
	  String resultShort = jsonResponseObject.get("resultShort").getAsString();
	  
	  if (Shape.PAPER.toString().equals(opponentShape)) {
		  assertThat(GameResult.WON.toString(), is(resultShort));
		  
	  } else if (Shape.ROCK.toString().equals(opponentShape)) {
		  assertThat(GameResult.LOST.toString(), is(resultShort));
		  
	  } else {
		  assertThat(GameResult.TIE.toString(), is(resultShort));
	  }	  
  }
  
  @Test
  public void testPlayWithValidRequestCheckResultShortInAdvancedGameMode() throws Exception {
	  	  	  
	  String inputJson = new Gson().toJson( new PlayRequest("Brunnen", "Fortgeschritten"));
	  
	  MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/play").contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();      

	  JsonObject jsonResponseObject = new Gson().fromJson(result.getResponse().getContentAsString(), JsonObject.class);
	  
	  String opponentShape = jsonResponseObject.get("opponentShape").getAsString();
	  
	  String resultShort = jsonResponseObject.get("resultShort").getAsString();
	  
	  if (Shape.PAPER.toString().equals(opponentShape)) {
		  assertThat(GameResult.LOST.toString(), is(resultShort));
		  
	  } else if (Shape.ROCK.toString().equals(opponentShape)) {
		  assertThat(GameResult.WON.toString(), is(resultShort));
		  
	  } else if (Shape.SCISSOR.toString().equals(opponentShape)) {
		  assertThat(GameResult.WON.toString(), is(resultShort));  
		  
	  } else {
		  assertThat(GameResult.TIE.toString(), is(resultShort));
	  }	  
  }  
  
  @Test
  public void testPlayWithInvalidRequestStatus400ClientError() throws Exception {
	  
	  String inputJson = new Gson().toJson(new PlayRequest("Handtuch", "Fortgeschritten"));
	  
      mvc.perform(MockMvcRequestBuilders.post("/play").contentType(MediaType.APPLICATION_JSON).content(inputJson))
      .andExpect(status().is4xxClientError());     
     ;
  }
  
  @Test
  public void testPlayWithInvalidItemCheckErrorMessage() throws Exception {
	  
	  String inputJson = new Gson().toJson(new PlayRequest("Handtuch", "Fortgeschritten"));
	  
	  MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/play").contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();      
      
	  String expectedErrorMessage = "shape invalid. Valid values: Stein or Schere or Papier. In gameMode Fortgeschritten also Brunnen is valid.";
	  
	  assertThat(result.getResolvedException().getMessage(), is(expectedErrorMessage));
  }
 
  @Test
  public void testPlayWithInvalidGameModeCheckErrorMessage() throws Exception {
	  
	  String inputJson = new Gson().toJson(new PlayRequest("Stein", "Offline"));
	  
	  MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/play").contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();      
      
	  String expectedErrorMessage = "gameMode invalid. Valid values are Klassik or Fortgeschritten";
	  
	  assertThat(result.getResolvedException().getMessage(), is(expectedErrorMessage));
  }
  
}
