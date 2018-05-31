package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDautodrive extends Command {
	double distance;
	double leftspeed;
	double rightspeed;
	double kP;
	double error;
	
	int totalleftticks;
	int objectiveticks;
	int leftticks;
	int rightticks;

    public PIDautodrive(double distance, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	// distance in meters
    	requires(Robot.driveTrain);
    	this.distance = distance;
    	this.leftspeed = speed;
    	this.rightspeed = speed;
    	kP = SmartDashboard.getNumber("kP Straight", 0.1);
    	
    	objectiveticks = (int)(distance * 360.0 / 0.478779);
    	// 0.478779 is circumference of wheel in meters
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	totalleftticks = 0;
    	//Robot.driveTrain.resetEncoders();
    	Robot.driveTrain.tank(leftspeed, rightspeed);
    	
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*Robot.driveTrain.putEncoderTicks();
    	if (Robot.driveTrain.leftTicks() >= 300) {
    		error = Robot.driveTrain.leftTicks() - Robot.driveTrain.rightTicks();
    		rightspeed += error * kP;
    		Robot.driveTrain.tank(leftspeed, rightspeed);
    		
    		totalleftticks += Robot.driveTrain.leftTicks();
    		Robot.driveTrain.resetEncoders();
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (totalleftticks >= objectiveticks);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    	//Robot.driveTrain.resetEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
