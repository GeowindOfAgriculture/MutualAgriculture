package test;

import java.sql.Date;

import org.junit.Test;

import com.usc.bean.Farmland;
import com.usc.dao.FarmlandDao;
import com.usc.daoimpl.FarmlandDaoImpl;

public class TestFarmlandDaoImpl {
	FarmlandDao farmlandDao=new FarmlandDaoImpl();
	@Test
	public void TestAddFarmlandInfo() {
		Farmland farmland=new Farmland();
		farmland.setDescription("快熟了");
		farmland.setHarvestTime(new Date(new java.util.Date().getTime()));
		farmland.setLocation("衡阳");
		farmland.setMaturity(3);
		farmland.setPerPrice(100);
		farmland.setSize(10);
		farmland.setType("小麦");
		int id= farmlandDao.addFarmlandInfo(farmland);
		System.out.println(id);
	}

}
