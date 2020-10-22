package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class SubsystemGrabber extends Subsystem{


	
    	Solenoid grabbersolenoid = null;    
    /* Grabber is the arm=opener solenoid.*/

    public SubsystemGrabber(){
	/* Defines the Selonoid pin,
	creates a new object. */
        //grabbersolenoid = new Solenoid(RobotMap.GRABBER_SOLENOID);
    }
	public void powerUp() {
	// Whenever powerUp() is called, it will open the selenoid port.
       // grabbersolenoid.set(true);
	}

	public void powerDown() {
	// Whenever powerDown() is called, it will close the selenoid port.
        //grabbersolenoid.set(false);
	}

	@Override
	public void initDefaultCommand() {
	}
}