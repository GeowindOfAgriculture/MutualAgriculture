package test;

import java.util.List;

import org.junit.Test;

import com.usc.bean.FarmlandPic;
import com.usc.dao.FarmlandPicDao;
import com.usc.daoimpl.FarmlandPicDaoImpl;

public class TestFarmlandPicDaoImpl {
	FarmlandPicDao farmlandPicDao=new FarmlandPicDaoImpl();

	@Test
	public void TestStoreFarmlandPicToURL() {
		FarmlandPic farmlandPic=new FarmlandPic();
		farmlandPic.setFarmlandId(1);
		farmlandPic.setUrl("1651651654151");
		boolean result= farmlandPicDao.storeFarmlandPicToURL(farmlandPic);
		System.out.println(result);
	}
	
	@Test
	public void TestGetFarmlandPicURLByFarmlandId(){
		List<String> urls= farmlandPicDao.getFarmlandPicURLByFarmlandId(2);
		System.out.println(urls);
	}

}
