package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;


public class SubsystemGrabberCylinder extends Subsystem{


    private SpeedController m_motor,m_motorTwo;
    private Joystick m_joystick;
    

    public SubsystemGrabberCylinder(){
	/* Defines the Selonoid pin,
    creates a new object. */
        m_motor = new PWMVictorSPX(RobotMap.channelElevatorCylinder);
        m_motorTwo = new PWMVictorSPX(RobotMap.channelElevatorCylinderTwo);
    }
	public void setRunning() {
        m_motor.set(0.5);
        m_motorTwo.set(-0.5);
    }
    public void setClosed(){
        m_motor.set(-0.5);
        m_motorTwo.set(0.5);
    }
    public void stop(){
        m_motor.set(0.0);
        m_motorTwo.set(0.0);
    }

	@Override
	public void initDefaultCommand() {
	}
}