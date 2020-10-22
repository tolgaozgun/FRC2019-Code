/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.CommandDisableElevatorDrive;
import frc.robot.commands.CommandEnableElevatorDrive;
import frc.robot.commands.CommandGrabberOff;
import frc.robot.commands.CommandGrabberOn;
import frc.robot.commands.CommandVisionAssist;
/*
* These imports will be needed later.
* DO NOT REMOVE
import frc.robot.commands.CommandLiftUp;
import frc.robot.commands.ExampleTrue;
import frc.robot.commands.ExampleFalse;
import frc.robot.commands.CommandLiftDown;
*/
import frc.robot.commands.CommandVisionAssist;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick stick1 = new Joystick(0);
  static Joystick stick2 = new Joystick(1);

  public static Joystick getMainJoystick(){
    return stick1;
  }
  public static Joystick getSecondJoystick(){
    return stick2;
  }
  Button btn = new JoystickButton(stick1,11);
  
  public OI(){
  
    btn.whenPressed(new CommandEnableElevatorDrive());

  // These are removed for now, because the robot doesn't have pneumatics and lift installed.
  // It will spit out errors on console if turned on.

  // When 8th button is pressed, the lift will go up.
  //  btn.whenPressed(new CommandLiftUp());
  
  // When 9th button is pressed, the lift will go down.
  //  btn2.whenPressed(new CommandLiftDown());

  
  // When 10th button is pressed, the selonoid will be turned on.
  //  btn3.whenPressed(new ExampleTrue());

  // When 10th button is pressed, the selonoid will be turned on.
  //  btn4.whenPressed(new ExampleFalse());
  }
  

  /* 
  EXAMPLES TO USE THIS OI FILE - DO NOT REMOVE
  */

  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // button.whenPressed(new ExampleCommand());


  // button.whileHeld(new ExampleCommand());


  // button.whenReleased(new ExampleCommand());
}
