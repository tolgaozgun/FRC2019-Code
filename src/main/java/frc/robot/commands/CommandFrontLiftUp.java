package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CommandFrontLiftUp extends InstantCommand {
	public CommandFrontLiftUp() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.sLift);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		// Robot lifts the elevator up
		// Calls SubsystemLift subsystem for pitchUp() function.
		Robot.sLift.frontPitchUp();
	}
}