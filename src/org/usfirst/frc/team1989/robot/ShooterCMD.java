package org.usfirst.frc.team1989.robot;

// All Imports - Will remove unecessary later
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ShooterCMD implements cmd {
	
	CANTalon shootMotor1;
	CANTalon shootMotor2;
	CANTalon elevator;
	DigitalInput elevLimit;
	JsScaled driveStick;
	Servo s1;
	Timer t1 = new Timer();
	
	public ShooterCMD(CANTalon shootMotor1, CANTalon shootMotor2, CANTalon elevator, DigitalInput elevLimit, JsScaled driveStick, Servo s1){
		this.shootMotor1 = shootMotor1;
		this.shootMotor2 = shootMotor2;
		this.elevator = elevator;
		this.elevLimit = elevLimit;
		this.driveStick = driveStick;
		this.s1 = s1;
		
	}
	public void temp(){
			if (driveStick.getRawButton(5) == true) {
				s1.set(0);
			} else if (driveStick.getRawButton(6) == true) {
				s1.set(1);
			}
			
			// Shooting Logic
			

			
			
	}
	public void elevatorOperation(){
		if(driveStick.getPOV(0) == 180){
			elevator.set(.2);
		}else if(driveStick.getPOV(0) == 0){
			elevator.set(-.2);
		}else{
			elevator.set(0);
		}
		if(elevLimit.get()){
			elevator.set(0.0);
		}
	}
	
	public void shootMotorOperation(){
		if (driveStick.getRawButton(5) == true) {
			// Motors for pickup
			shootMotor1.set(-.35);
			shootMotor2.set(.35);
		} else if (driveStick.getRawButton(3)) {
			// Motors for shoot
			shootMotor1.set(1);
			shootMotor2.set(-1);
		} else {
			// Stop the motors
			shootMotor1.set(0);
			shootMotor2.set(0);
		}
	}
	
	public void servoOperation(){
		
		if(driveStick.getRawButton(1) == true){
			s1.set(1);
			t1.start();
			
			
		}
	}
	/* Teleop Init and Teleop Periodic */
	public void teleopInit(){
		// Once we have a limit switch then make the elevator start at the bottom.
		s1.set(0);
	}
    public void teleopPeriodic(){
    	if(t1.get() > .2 ){
    		s1.set(0);
    		t1.stop();
    		t1.reset();
    	}
		
    	servoOperation();
    	elevatorOperation();
    	shootMotorOperation();
    }

    
    public void autonomousPeriodic(){}
    public void DisabledPeriodic(){}
    public void testInit(){}
    public void testPeriodic(){}
    public void disabledInit(){}
    public void autonomousInit(){}
}

