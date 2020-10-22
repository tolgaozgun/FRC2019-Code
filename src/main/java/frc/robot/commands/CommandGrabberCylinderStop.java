package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CommandGrabberCylinderStop extends InstantCommand {
	public CommandGrabberCylinderStop() {
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
		Robot.sGrabberCylinder.stop();
	}
}