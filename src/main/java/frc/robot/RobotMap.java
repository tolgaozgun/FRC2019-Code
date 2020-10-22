/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
  public static final int channelFrontLeft = 0;
  public static final int channelRearLeft = 2;
  public static final int channelFrontRight = 1;
  public static final int channelRearRight = 3;
  public static final int channelElevator = 5;
  public static final int channelElevatorCylinder = 11;
  public static final int channelElevatorCylinderTwo = 6;

  public static final int channelMainJoystick = 0; 
  public static final int channelSecondJoystick = 1; 

  // Selenoid pins
  // will be needed when the selenoids are connected to the robot.
	public static final int FRONT_LIFT_SOLENOID_DEPLOY = 0;
	public static final int REAR_LIFT_SOLENOID_DEPLOY = 1;
	public static final int GRABBER_SOLENOID = 2;
	public static final int VACUUM_SOLENOID = 3;
}
