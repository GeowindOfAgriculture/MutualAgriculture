package test;

import org.junit.Test;

import com.usc.dao.FarmlandPicDao;
import com.usc.daoimpl.FarmlandPicDaoImpl;

public class TestFarmlandPicDaoImpl {

	@Test
	public void TestStoreFarmlandPicToURL() {
		FarmlandPicDao farmlandPicDao=new FarmlandPicDaoImpl();
		int result= farmlandPicDao.storeFarmlandPicToURL("22222222");
		System.out.println(result);
	}

}
