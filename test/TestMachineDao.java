package test;

import java.util.List;

import org.junit.Test;

import com.usc.bean.Machine;
import com.usc.bean.MachinePic;
import com.usc.daoimpl.MachineDao;

public class TestMachineDao {
	MachineDao machineDao=new MachineDao();

	@Test
	public void testregisterMachine() {
		Machine machine=new Machine();
		machine.setDes("坏了");
		machine.setMachineOwnerId(1);
		machine.setModel("三无牌");
		machine.setUserAge(2);
		int id= machineDao.registerMachine(machine);
		System.out.println(id);
	}
	
	@Test
	public void teststoreMachinePicToURL(){
		MachinePic machinePic=new MachinePic();
		machinePic.setMachineId(2);
		machinePic.setUrl("222222");
		boolean result= machineDao.storeMachinePicToURL(machinePic);
		System.out.println(result);
	}
	
	@Test
	public void testgetMachinePicById(){
		List<String> urls= machineDao.getMachinePicByMachineId(3);
		System.out.println(urls);
	}

}
