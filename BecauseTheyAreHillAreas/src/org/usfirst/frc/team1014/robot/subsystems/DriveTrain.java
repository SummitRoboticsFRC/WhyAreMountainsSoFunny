package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//test
	

    Talon frontLeftMotor;
    Talon backLeftMotor;
    SpeedControllerGroup leftMotors;
    Talon frontRightMotor;
    Talon backRightMotor;
    SpeedControllerGroup rightMotors;
    DifferentialDrive robotDrive;

    public DriveTrain() {
	
    	frontLeftMotor = new Talon(RobotMap.frontLeftMotor); 
    	backLeftMotor = new Talon(RobotMap.backLeftMotor); 
    	leftMotors = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    	
    	frontRightMotor = new Talon(RobotMap.frontRightMotor);
	backRightMotor = new Talon(RobotMap.backRightMotor); 
	rightMotors = new SpeedControllerGroup(frontRightMotor, backRightMotor);
	
	robotDrive = new DifferentialDrive(leftMotors, rightMotors);

	// roborDrive.setSafetyEnabled(false); if needed to stop jumpyness

    }

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void smth() {
    	
    }
}
