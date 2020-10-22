package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CommandDisableElevatorDrive extends InstantCommand {
	public CommandDisableElevatorDrive() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.sElevator);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		// Robot lifts the elevator up
		// Calls SubsystemLift subsystem for pitchUp() function.
        Robot.sElevator.setElevatorDrive = false;
	}
}