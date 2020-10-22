package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CommandVacuumOn extends InstantCommand {
	public CommandVacuumOn() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.sVacuum);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		// Robot lifts the elevator up
		// Calls SubsystemLift subsystem for pitchUp() function.
		Robot.sVacuum.powerUp();
	}
}