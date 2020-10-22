/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.subsystems.*;



import frc.robot.commands.Dashboard;

//import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Defining the OI.java file.
  public static OI m_oi;

  // Vision thread for the camera.

  // Defining the Subsystems in main Robot file.
  public static SubsystemDrive sDrive;
  public static SubsystemLift sLift;
  public static SubsystemGrabber sGrabber;
  public static SubsystemElevator sElevator;
  public static SubsystemGrabberCylinder sGrabberCylinder;
  public static SubsystemVisionAssist sVisionAssist;
  public static SubsystemVacuum sVacuum;
  public boolean setElevatorDrive;
  public static Thread m_visionThread;


  // Chooser to put into autonomous mode, FRC default.
  // Do not remove, will be removed later.
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {

    
  // Pointing the Subsystems.
    sDrive = new SubsystemDrive(OI.getMainJoystick());
    sVisionAssist = new SubsystemVisionAssist();
    sLift = new SubsystemLift();
    sGrabber = new SubsystemGrabber();
    sVacuum = new SubsystemVacuum();
    sElevator = new SubsystemElevator(OI.getSecondJoystick());
    sGrabberCylinder = new SubsystemGrabberCylinder();
    m_oi = new OI();



  // Enabling camera stream in a thread.
    m_visionThread = new Thread(() -> {
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      camera.setResolution(640, 480);
    });
    m_visionThread.setDaemon(true);
    m_visionThread.start();
    
    // Initializing the Dashboard.
    Dashboard.init();
  }

  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }
  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    // Update the dashboard when teleop starts.
    Dashboard.update();


}

  @Override
  public void teleopPeriodic() {

    // Update the dashboard while teleop is running.
    Dashboard.update();
    
   Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
