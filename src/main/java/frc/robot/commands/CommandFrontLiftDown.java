package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CommandFrontLiftDown extends InstantCommand {
	public CommandFrontLiftDown() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.sLift);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		// Robot lifts the elevator down
		// Calls SubsystemLift subsystem for pitchDown() function.
		Robot.sLift.frontPitchDown();
	}
}