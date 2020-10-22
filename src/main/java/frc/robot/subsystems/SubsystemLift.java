package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class SubsystemLift extends Subsystem{


    Solenoid frontSolenoid = null;   
    Solenoid rearSolenoid = null;    
    

    public SubsystemLift(){
	/* Defines the Selonoid pin,
	creates a new object. */
	//	frontSolenoid = new Solenoid(RobotMap.FRONT_LIFT_SOLENOID_DEPLOY);
	//	rearSolenoid = new Solenoid(RobotMap.REAR_LIFT_SOLENOID_DEPLOY);
    }
	public void rearPitchUp() {
	// Whenever pitchup() is called, it will open the selenoid port.
	//rearSolenoid.set(true);
	
	}
	public void rearPitchDown() {
	// Whenever pitchup() is called, it will open the selenoid port.
	//	rearSolenoid.set(false);
	}
	public void frontPitchUp() {
	// Whenever pitchup() is called, it will open the selenoid port.
	//	frontSolenoid.set(true);
	}

	public void frontPitchDown() {
	// Whenever pitchdown() is called, it will close the selenoid port.
	//	frontSolenoid.set(false);
	}

	@Override
	public void initDefaultCommand() {
	}
}