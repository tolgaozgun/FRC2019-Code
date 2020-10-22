package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SubsystemElevator extends Subsystem{

	public static boolean setElevatorDrive = false;
	private final int levelOneHeight = 70;
	private final int levelTwoHeight = 140;
	private final int levelThreeHeight = 210;
	private final int maxDifferenceAllowance = 5; 
	private int height = 0; 
	private double altitude = 0;
    private SpeedController m_motor;
	private Joystick m_joystick;
	public static Thread thread;

    public SubsystemElevator(Joystick stick){
		m_motor = new PWMVictorSPX(RobotMap.channelElevator);
		m_joystick = stick;
    }
	public void drive(){
		thread = new Thread(() -> {
		while(setElevatorDrive){
			m_motor.set(-m_joystick.getThrottle());
			System.out.println("Throttle " + -m_joystick.getThrottle());
				Timer.delay(0.005);
		}
		});
		thread.start();
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
		altitude = SmartDashboard.getNumber("sensors/altitude",0.0);
		if(altitude == height){
//            stay();
		}else if(altitude > height){
			while(altitude - height > maxDifferenceAllowance && altitude > height){
				altitude = SmartDashboard.getNumber("sensors/altitude",0.0);
///				descend();
			}
		}else{
			while(height - altitude> maxDifferenceAllowance && height > altitude){
				altitude = SmartDashboard.getNumber("sensors/altitude",0.0);
//				ascend();
			}
		}
	}
	@Override
	public void initDefaultCommand() {
	}
}