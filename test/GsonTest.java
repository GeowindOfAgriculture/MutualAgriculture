package test;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.PreparedStatement;
import com.usc.bean.Agent;
import com.usc.bean.AgentResponse;
import com.usc.bean.Farmland;
import com.usc.bean.FarmlandPic;
import com.usc.bean.Order;
import com.usc.bean.OrderList;
import com.usc.bean.OrdersJson;
import com.usc.util.Constant;
import com.usc.util.DBHelper;

public class GsonTest {

	@Test
	public void creatJson() {
		// Agent agent = new Agent();
		// agent.setId(3);
		// agent.setLocation("usc.geowind");
		// agent.setName("geowind");
		// agent.setPassword("geowind");
		// agent.setTel("geowinfTel");

		Order order = new Order();
		order.setId(1);

		Gson gson = new Gson();
		String json = gson.toJson(order);
		System.out.println(json);
		// agent.setName(json);
		// System.out.println(agent.getName());
		//
		// Gson gson1 = new Gson();
		// Agent agent2 = gson1.fromJson(json, Agent.class);
		// System.out.println(agent2);

	}

	@Test
	public void GsonTest() {
		Agent agent = new Agent();
		//agent.setId(3);
		agent.setLocation("北京");
		agent.setName("中国");
		agent.setPassword("geowind");
		agent.setTel("123456");

		Gson gson = new Gson();
		String jsonString = gson.toJson(agent);
		System.out.println(jsonString);

		System.out.println("---------------");

		Agent agent2 = gson.fromJson(jsonString, Agent.class);
		System.out.println(agent2);

	}

	/**
	 * 测试客户端发布订单的订单数据封装成json
	 */
	@Test
	public void testOrderJSON() {
		List<FarmlandPic> pics = new ArrayList<FarmlandPic>();
		FarmlandPic pic = new FarmlandPic();
		// pic.setId(1);
		pic.setFarmlandId(1);
		pic.setUrl("url1");

		FarmlandPic pic1 = new FarmlandPic();
		// pic1.setId(2);
		pic1.setFarmlandId(1);
		pic1.setUrl("url2");

		FarmlandPic pic2 = new FarmlandPic();
		// pic2.setId(3);
		pic2.setFarmlandId(1);
		pic2.setUrl("url3");

		pics.add(pic2);
		pics.add(pic1);
		pics.add(pic);

		Farmland farmland = new Farmland();
		// farmland.setId(1);
		farmland.setDescription("des");
		farmland.setFarmlandPics(pics);
		farmland.setHarvestTime(new Date(new java.util.Date().getTime()));
		farmland.setLocation("loc");
		farmland.setMaturity(3);
		farmland.setPerPrice(100);
		farmland.setSize(13);
		farmland.setType("小麦");

		Order order = new Order();
		order.setState(Constant.STATE_ORDER_PENDING);
		order.setAgentId(7);
		order.setCommission(12);
		order.setFarmland(farmland);
		order.setEndTime(new Date(new java.util.Date().getTime()));
		order.setNum(10);
		order.setStartTime(new Date(new java.util.Date().getTime()));
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String jsonString = gson.toJson(order);
		System.out.println(jsonString);
	}

	@Test
	public void testGetTime() {
		Gson gson = new Gson();
		Order order = new Order();
		order.setEndTime(new Date(new java.util.Date().getTime()));
		String dataString = gson.toJson(order);
		System.out.println(dataString);
		System.out.println(new Date(new java.util.Date().getTime()));
	}

	/**
	 * url插入数据库乱码，在这儿获取数据看看是不是url编码问题
	 */
	@Test
	public void getData() {
		Connection connection = DBHelper.getConnection();
		try {
			java.sql.PreparedStatement pstmt = connection
					.prepareStatement("select * from farmland where id=5");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String type = rs.getString("type");
				System.out.println(type);
			}
		} catch (SQLException e) {
		}
	}

	@Test
	public void testparseJsonList() {
		List<Order> orders;
		String string = "{'ordersNum':1,'orders':[{'id':1,'num':10,'commission':1000000.0,'state':'Pending','endTime':'2016-01-19','startTime':'2016-01-19','farmlandId':1,'agentId':7,'machineOwnerId':0}]}";
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Type type= new TypeToken<OrdersJson>(){}.getType();
		
		OrdersJson ordersJson= gson.fromJson(string,type);
		 System.out.println("一共"+ordersJson.getOrdersNum()+"条记录");
		 orders=ordersJson.getOrders();
		 for(int i=0;i<orders.size();i++){
			 
			 Order order= orders.get(i);
			 System.out.println(order.getAgentId());;
			 System.out.println(order.getCommission());
			 System.out.println(order.getFarmlandId());
			 System.out.println(order.getId());
			 System.out.println(order.getMachineOwnerId());
			 System.out.println(order.getNum());
			 System.out.println(order.getState());
			 System.out.println(order.getEndTime());
			 System.out.println(order.getFarmland());
			 System.out.println(order.getStartTime());
		 }
	}
}
