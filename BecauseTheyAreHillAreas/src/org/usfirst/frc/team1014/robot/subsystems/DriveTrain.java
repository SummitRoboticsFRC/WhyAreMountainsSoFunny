package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.Robot;
import org.usfirst.frc.team1014.robot.RobotMap;
import org.usfirst.frc.team1014.robot.commands.DriveTrainControllerDrive;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//test Anton
	//test Larry
	//test Daphne
	//test Eirean
	//test Team Laptop new
	//test John

    public WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(RobotMap.frontLeftMotor);
    public WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(RobotMap.backLeftMotor);
    //public SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    public WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(RobotMap.frontRightMotor);
    public WPI_TalonSRX backRightMotor = new WPI_TalonSRX(RobotMap.backRightMotor);
    //public SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRightMotor, backRightMotor);	 
    public DifferentialDrive robotDrive = new DifferentialDrive(backLeftMotor, backRightMotor);

    double kP;
    double kI;
    double straightAdjustment;
	double turnDamp;
	double speedDamp;
	double speedF;
	double speedT;
	double error;
	//double distancePerPulse;
	
	//Encoder encoderLeft;
	//Encoder encoderRight;
	
	
    public DriveTrain() {
    	
    	frontLeftMotor.set(ControlMode.Follower, RobotMap.backLeftMotor);
    	frontRightMotor.set(ControlMode.Follower, RobotMap.backRightMotor);
    	
    	backRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	backLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	
    	/*encoderLeft = new Encoder(1, 2, false, Encoder.EncodingType.k4X); 
    	encoderRight = new Encoder(3, 4, false, Encoder.EncodingType.k4X);
    	encoderLeft.setMaxPeriod(10);
    	encoderRight.setMaxPeriod(10);*/
    	
    	//distancePerPulse = SmartDashboard.getNumber("Distance per pulse", 1);

	// roborDrive.setSafetyEnabled(false); if needed to stop jumpyness

    }

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new DriveTrainControllerDrive());
    	//encoderLeft.setDistancePerPulse(distancePerPulse);
    	//encoderRight.setDistancePerPulse(distancePerPulse);
    	//resetEncoders();

    }
    public void tank(double left, double right) {
    		robotDrive.tankDrive(left, right);
    	
    }
    public void stop() {
    		robotDrive.tankDrive(0, 0);
    }
    
    public void turn() {
    	
    }
    
    public void doNothing() {}
    
    public void driveController(XboxController xboxController) {
    	turnDamp = SmartDashboard.getNumber("Turn Damp", 0.5);
    	speedDamp = SmartDashboard.getNumber("Speed Damp", 0.5);
    	
    	speedF = -1*speedDamp*xboxController.getY(Hand.kRight);
    	speedT = -1*turnDamp*xboxController.getX(Hand.kLeft);
    	
    	robotDrive.arcadeDrive(speedF, speedT, true);
    }
    
    //below are encoder methods
    public void resetEncoders() {
    	Robot.driveTrain.backRightMotor.setSelectedSensorPosition(0, 0, 10);
		Robot.driveTrain.backLeftMotor.setSelectedSensorPosition(0, 0, 10);
    }
    /*
    public double leftTicks() {
    	return (double)encoderLeft.get();
    }
    	
    public double rightTicks() {
    	return (double)encoderRight.get();
    }
    
    public void putEncoderTicks() {
    	SmartDashboard.putNumber("Left Encoder ticks", (double)encoderLeft.get());
    	SmartDashboard.putNumber("Right Encoder ticks", (double)encoderRight.get());
     }*/
    
    }
    

