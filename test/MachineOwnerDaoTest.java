package test;

import org.junit.Test;

import com.usc.bean.MachineOwner;
import com.usc.daoimpl.MachineDao;
import com.usc.daoimpl.MachineOwnerDao;

public class MachineOwnerDaoTest {
	// @Test
	public void isExistTest() {
		MachineOwnerDao machineOwnerDao = new MachineOwnerDao();
		System.out.println(machineOwnerDao.isExist("15580253453"));
	}

	// @Test
	public void register() {
		MachineOwnerDao machineOwnerDao = new MachineOwnerDao();
		MachineOwner m = new MachineOwner();
		// m.setId(1);
		m.setLocation("usc.geowind");
		m.setName("gaosi");
		m.setPassword("geowind");
		m.setRemarks1("m1");
		m.setRemarks2("m2");
		m.setRemarks3("m3");
		m.setTel("15580253451");
		System.out.println(machineOwnerDao.register(m));
	}

	// @Test
	public void login() {
		MachineOwner machineOwner = new MachineOwner();
		MachineOwnerDao dao = new MachineOwnerDao();
		machineOwner.setName("gaosi");
		machineOwner.setPassword("");
		System.out.println(dao.login(machineOwner));
	}

	@Test
	public void selectMachineOwerInfo() {
		MachineOwnerDao dao = new MachineOwnerDao();
		MachineOwner owner = new MachineOwner();
		owner.setId(2);
		System.out.println(dao.selectMachineOwerInfo(owner));
	}
	
	@Test
	public void testgetMachineOwnerIdByTel(){
		MachineDao dao=new MachineDao();
		int id= dao.getMachineOwnerIdByTel("1234");
		System.out.println(id);
	}

}
