package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CommandGrabberOn extends InstantCommand {
	public CommandGrabberOn() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.sGrabber);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		// Robot lifts the elevator up
		// Calls SubsystemLift subsystem for pitchUp() function.
		Robot.sGrabber.powerUp();
	}
}