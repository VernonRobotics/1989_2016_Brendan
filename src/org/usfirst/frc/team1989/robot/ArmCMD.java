package org.usfirst.frc.team1989.robot;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;


public class ArmCMD implements cmd{
	
	CANTalon armMotor1;
	CANTalon armMotor2;
	DigitalInput armLimit;
	
	
	JsScaled driveStick;
	
	
	public ArmCMD(CANTalon armMotor1, CANTalon armMotor2, DigitalInput armLimit, JsScaled driveStick){
			this.armMotor1 = armMotor1;
			this.armMotor2 = armMotor2;
			this.armLimit = armLimit;
			this.driveStick = driveStick;
	}
	
	public void armMotorOperation(){
		if (driveStick.getRawButton(10) == true){
			armMotor1.set(0.3);
			armMotor2.set(-3);
		}
		
		else if (driveStick.getRawButton(11) == true){
			armMotor1.set(-0.3);
			armMotor2.set(0.3);
		}
		else{
			armMotor1.set(0.0);
			armMotor2.set(0.0);
		}
		if(armLimit.get() == true){
			armMotor1.set(0.0);
			armMotor2.set(0.0);
		}
	}



	public void disabledInit() {}
	public void autonomousInit() {}
	public void autonomousPeriodic() {}
	public void DisabledPeriodic() {}
	public void testInit() {}
	public void teleopInit() {}
	public void teleopPeriodic() {
		armMotorOperation();
	}
	public void testPeriodic() {}
	
	
}
