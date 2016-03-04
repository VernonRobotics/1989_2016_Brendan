package org.usfirst.frc.team1989.robot;
	
import java.util.ArrayList;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RangeFinderCmd extends AnalogInput implements cmd {
	public ArrayList<cmd> list;
	public String type = "RangeFinderCmd";
	public int channel = -1;
	public double distance = 0;
	public double lastdistance = -1;
	private String sc;

	public RangeFinderCmd(int ch) {
		super(ch);
		channel = ch;
	    	sc = new Integer(channel).toString().trim();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void disabledInit() {
		// TODO Auto-generated method stub
		setDistance();
	}

	public void testInit() {
		setDistance();

	}

	public void teleopInit() {
		setDistance();
	}

	@Override
	public void autonomousInit() {
		// TODO Auto-generated method stub
		setDistance();
	}

	@Override
	public void autonomousPeriodic() {
		// TODO Auto-generated method stub
		setDistance();
	}

	@Override
	public void DisabledPeriodic() {
		// TODO Auto-generated method stub
		setDistance();
	}

	@Override
	public void teleopPeriodic() {
		// TODO Auto-generated method stub
		setDistance();
	}

	@Override
	public void testPeriodic() {
		// TODO Auto-generated method stub
		setDistance();
	}

	public void setDistance() {
		distance = Math.floor(getVoltage() *102.4);
		
		if (distance != lastdistance)
		{
			lastdistance = distance;
			SmartDashboard.putString("DB/String "+ sc,
					"Rangefinder " + sc + ": " + new Integer((int) distance).toString());
		}
	}
}
