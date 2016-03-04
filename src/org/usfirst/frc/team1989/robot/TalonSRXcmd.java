package org.usfirst.frc.team1989.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TalonSRXcmd extends TalonSRX implements cmd {
    public JsScaled joystick;
    public double speed = .75;
    public DigitalInput Fwd;
    public DigitalInput Rev;
    public double currspeed = 0;
    private double lastspeed = -1;
    public String dispchannel = "3"; // set to -1 to disable display
    private boolean LastRev = true;
    private boolean LastFwd = true;
    public boolean SwFwd;
    public boolean SwRev;

    public TalonSRXcmd(int channel) {
	super(channel);
;	// TODO Auto-generated constructor stub
    }

    @Override
    public void disabledInit() {
	// TODO Auto-generated method stub
	set(0);
    }

    @Override
    public void autonomousInit() {
	// TODO Auto-generated method stub
	currspeed = 0;
	set(0);
    }

    @Override
    public void autonomousPeriodic() {
	getSw();
// note button one is  array pos 0
	if (joystick.buttons[4]) {
	    if (SwFwd || joystick.buttons[6]) {
		currspeed = speed;
	    } else {
		currspeed = 0.1;
	    }

	} else if (joystick.buttons[5]) {
	    if (SwRev || joystick.buttons[6]) {
		currspeed = 0 - speed/4;
	    } else {
		currspeed = 0.10;
	    }
	} else {
	    currspeed = 0.10;
	}

    }

    @Override
    public void DisabledPeriodic() {
	// TODO Auto-generated method stub
	currspeed = 0;
	set(0);
    }

    @Override
    public void testInit() {
	// TODO Auto-generated method stub
	currspeed = 0;
	set(0);
    }

    @Override
    public void teleopInit() {
	// TODO Auto-generated method stub

    }

    @Override
    public void teleopPeriodic() {
	// TODO Auto-generated method stub
	set(Setspeed());
    }

    @Override
    public void testPeriodic() {
	// TODO Auto-generated method stub
	set(Setspeed());
    }

    private void getSw() {
	SwFwd = !Fwd.get();
	SwRev = !Rev.get();
    }

    // button 7 overrides  limitswitches
    private double Setspeed() {
	getSw();

	if (joystick.getRawButton(5)) {
	    if (SwFwd || joystick.getRawButton(7)) {
		currspeed = speed;
	    } else {
		currspeed = 0.1;
	    }

	} else if (joystick.getRawButton(6)) {
	    if (SwRev || joystick.getRawButton(7)) {
		currspeed = 0 - speed/4;
	    } else {
		currspeed = 0.10;
	    }
	} else {
	    currspeed = 0.10;
	}
	display();
	return currspeed;
    }

    public void Setjoystick(JsScaled js) {
	// TODO Auto-generated method stub
	joystick = js;
    }

    public void Setswitches(DigitalInput sFwd, DigitalInput sRev) {
	Fwd = sFwd;
	Rev = sRev;
	LastFwd = !Fwd.get(); // set inverse so we display
	LastRev = !Rev.get();
	getSw();
    }

    private void display() {
	getSw();
	if (dispchannel != ""
		&& (LastFwd != SwFwd || LastRev != SwRev || lastspeed != currspeed)) {

	    SmartDashboard.putBoolean("DB/Button " + dispchannel, SwFwd);

	    SmartDashboard.putBoolean("DB/LED " + dispchannel, SwRev);
	    SmartDashboard.putNumber("DB/Slider " + dispchannel,
		    2.5 + currspeed * 2.5);
	    // Scale to stop is middle of slider -1/1 are full right and left
	}
	LastFwd = SwFwd;
	LastRev = SwRev;
	lastspeed = currspeed;
    }
}