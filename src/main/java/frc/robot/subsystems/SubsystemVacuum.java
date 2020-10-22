package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class SubsystemVacuum extends Subsystem{


    Solenoid vacuumSolenoid = null;
    private final int levelOneHeight = 70;
    private final int levelTwoHeight = 140;
    private final int levelThreeHeight = 210;
    private final int maxDifferenceAllowance = 5; 
    private int height = 0; 
    private double distance = 0;
    

    public SubsystemVacuum(){
	/* Defines the Selonoid pin,
	creates a new object. */
	//	vacuumSolenoid = new Solenoid(RobotMap.VACUUM_SOLENOID);
	}
    
	public void powerUp() {
	// Whenever pitchup() is called, it will open the selenoid port.
	//vacuumSolenoid.set(true);
	}

	public void powerDown() {
	// Whenever pitchdown() is called, it will close the selenoid port.
	//vacuumSolenoid.set(false);
	}

	public void assistPower(int level){
		switch(level){
			case 1:
			height = levelOneHeight;
			break;
			case 2:
			height = levelTwoHeight;
			break;
			case 3:
			height = levelThreeHeight;
			break;
			default:
			height = 0;
			break;
		}
		distance = SmartDashboard.getNumber("sensors/distance",0.0);
		if(distance == height){

		}else if(distance > height){

		}else{
			
		}
	}

	@Override
	public void initDefaultCommand() {
	}
}