package test;

import org.junit.Test;

import com.google.gson.Gson;
import com.usc.bean.Agent;

public class GsonTest {

	@Test
	public void creatJson() {
		Agent agent = new Agent();
		agent.setId(3);
		agent.setLocation("usc.geowind");
		agent.setName("geowind");
		agent.setPassword("geowind");
		agent.setTel("geowinfTel");
		
		Gson gson = new Gson();
		String json = gson.toJson(agent);
		System.out.println(json);
		agent.setName(json);
		System.out.println(agent.getName());
		
		Gson gson1 = new Gson();
		Agent agent2 = gson1.fromJson(json, Agent.class);
		System.out.println(agent2);
		
	}
	
	@Test
	public void GsonTest(){
		Agent agent = new Agent();
		agent.setId(3);
		//agent.setLocation("usc.geowind");
		agent.setName("geowind");
		agent.setPassword("geowind");
		//agent.setTel("geowinfTel");
		
		Gson gson=new Gson();
		String jsonString= gson.toJson(agent);
		System.out.println(jsonString);
		
		System.out.println("---------------");
		
		Agent agent2= gson.fromJson(jsonString, Agent.class);
		System.out.println(agent2);
		
	}

}
