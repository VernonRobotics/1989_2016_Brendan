package org.usfirst.frc.team1989.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDriveCmd implements cmd {

	public String type = "arcadeDriveCmd";
	public ArrayList<cmd> list;
	JsScaled driveStick;
	RobotDrive rd;

	
	
	/*
	 * Main controller for use.  Basasd on 4 motors anda  speed controller.
	 */
	public ArcadeDriveCmd(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor, JsScaled driveStick) {
		rd = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		this.driveStick = driveStick;
	}
		
	// Included for completeness, but unused
	public ArcadeDriveCmd(SpeedController leftMotor, SpeedController rightMotor, JsScaled driveStick) {
		rd = new RobotDrive(leftMotor, rightMotor);
		this.driveStick = driveStick;
	}
	public ArcadeDriveCmd(int leftMotorChannel, int rightMotorChannel, JsScaled driveStick) {
		rd = new RobotDrive(leftMotorChannel, rightMotorChannel);
		this.driveStick = driveStick;
	}
	
	
	public ArcadeDriveCmd(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor, JsScaled driveStick) {
		rd = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		this.driveStick = driveStick;
	}
	
	// Autonomous Function - Arcade Drive dependency
	public void arcadeDrive(double magnitude, double twist){
		
		rd.arcadeDrive(magnitude, twist);
	}

	@Override
	public void disabledInit() {
		// TODO Auto-generated method stub
		arcadeDrive(0, 0);

	}

	@Override
	public void autonomousInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void autonomousPeriodic() {
		
		arcadeDrive(driveStick.pY, driveStick.pTwist);
		// TODO Auto-generated method stub

	}

	@Override
	public void DisabledPeriodic() {
		arcadeDrive(0, 0);
	}

	
	@Override
	public void testInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teleopInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teleopPeriodic() {
		// TODO Auto-generated method stub
		arcadeDrive(0 - driveStick.sgetY(), 0-driveStick.sgetTwist());
	}

	@Override
	public void testPeriodic() {
		// TODO Auto-generated method stub
		arcadeDrive(0 - driveStick.sgetY(), 0-driveStick.sgetTwist());
		
	}
}