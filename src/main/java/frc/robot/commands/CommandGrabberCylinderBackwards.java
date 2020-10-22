package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CommandGrabberCylinderBackwards extends InstantCommand {
	public CommandGrabberCylinderBackwards() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.sGrabberCylinder);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		// Robot lifts the elevator up
		// Calls Subsystem Grabber Cylinder subsystem for pitchUp() function.
		Robot.sGrabberCylinder.setClosed();
	}
}