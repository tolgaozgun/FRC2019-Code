package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CommandMecanumDrive extends Command{

    public CommandMecanumDrive(){
        requires(Robot.sDrive);
    }
    @Override
    protected void initialize(){

    }
    @Override
    protected void execute(){
        // Calls the SubsystemDrive subsystem for mechanumDrive() function
        // with the input of Joystick(0)
        // m_oi is the OI.java file where getMainJoystick() function is defined.
        Robot.sDrive.mechanumDrive();
    }
    @Override
    protected boolean isFinished(){
        return false;    
    }
    @Override
    protected void end(){
    }
    @Override
    protected void interrupted(){
        end();
    }
}