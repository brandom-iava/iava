package com.iava.dp.behavioral.Command;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Cient {

	public static void main(String[] args) {
		Telecontrol tc = new Telecontrol();
		Light l = new Light();
		LightOnCommand lon = new LightOnCommand(l);
		
		tc.setCommand(lon);
		tc.buttonPressed();
	}
}

