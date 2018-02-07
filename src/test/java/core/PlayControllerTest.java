package core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayControllerTest {

  @Autowired
  private MockMvc mvc;
  
  @Test
  public void getPlay() throws Exception {
	  
	  PlayRequest playRequest = new PlayRequest("Schere", "Klassik");
	  
	  Gson gson = new Gson();
	  String json = gson.toJson(playRequest);
	  
      mvc.perform(MockMvcRequestBuilders.post("/play").contentType(MediaType.APPLICATION_JSON).content(json))
      .andExpect(status().isOk());     
     ;
  }
  
	
}
