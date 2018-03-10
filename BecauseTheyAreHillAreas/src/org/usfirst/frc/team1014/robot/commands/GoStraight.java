package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GoStraight extends Command {

	double speedF;
	double accumulatedError;
	double adjustmentSpeed;
	double kP;
	double kI;
	double t;
	
    public GoStraight(double speedF) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.driveTrain);
    		this.speedF = speedF;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.reset();
    	accumulatedError = 0;
    	setTimeout(t);
    	kP = SmartDashboard.getNumber("kP Straight", 0.1);
    	kI = SmartDashboard.getNumber("kI Straight", 0.01);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		accumulatedError += Robot.gyro.getAngle();
    		adjustmentSpeed = kP * Robot.gyro.getAngle() + kI * accumulatedError;
    		Robot.driveTrain.tank (speedF, speedF * (1 + adjustmentSpeed));
    		if (Robot.gyro.getAngle() == 0) {
    			accumulatedError = 0;
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
