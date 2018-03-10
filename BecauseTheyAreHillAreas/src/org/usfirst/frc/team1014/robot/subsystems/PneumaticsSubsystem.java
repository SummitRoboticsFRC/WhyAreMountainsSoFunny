package org.usfirst.frc.team1014.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class PneumaticsSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	DoubleSolenoid cylinder = new DoubleSolenoid(1, 2);
	
	
	Compressor c = new Compressor (0);
	boolean enabled = c.enabled();
	boolean pressureSwitch = c.getPressureSwitchValue();
	double current = c.getCompressorCurrent();
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void solenoidValves() {
    	cylinder.set(DoubleSolenoid.Value.kOff);
    	cylinder.set(DoubleSolenoid.Value.kForward);
    	cylinder.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void compressorStatus() {
    	c.setClosedLoopControl(true);
    	c.setClosedLoopControl(false);
    }
}

