package frc.robot.runnable;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Dashboard;

public class RunnableDashboard implements Runnable {

    double visionDistance = 0.0;
    Joystick joystick = new Joystick(RobotMap.channelMainJoystick);
    private boolean switchToggle, visionToggle,elevatorToggle, liftToggle,driveToggle,cameraToggle;
    public RunnableDashboard() {
        
    }

    public void run() {
        String[] autonomousModeStrings = {"TELEOP","AUTO: Rocket","AUTO: Pickup Station","AUTO: HAB Platform"};

        // Uploads the string to the dashboard.
        SmartDashboard.putStringArray("autonomous/modes",autonomousModeStrings);

        // Defines the default string.
        SmartDashboard.putString("currentlySelectedMode","TELEOP");

        while(!Dashboard.dashboardThread.isInterrupted()){

            double angle = Robot.sDrive.getAngle();
            double turningAngle = Robot.sDrive.getTurningAngle();
            boolean slowMode = Robot.sDrive.getSlowMode();
            double accelX = Robot.sDrive.ahrs.getWorldLinearAccelX();
            double accelY = Robot.sDrive.ahrs.getWorldLinearAccelY();
            double accelZ = Robot.sDrive.ahrs.getWorldLinearAccelZ();

            
            SmartDashboard.putNumber("elevator/throttle", joystick.getThrottle());
            SmartDashboard.putNumber("drive/turningAngle", turningAngle);
            SmartDashboard.putNumber("drive/gyroAngle",angle);
            SmartDashboard.putBoolean("drive/slowMode",slowMode);
            SmartDashboard.putNumber("drive/accelX",accelX);
            SmartDashboard.putNumber("drive/accelY",accelY);
            SmartDashboard.putNumber("drive/accelZ",accelZ);
            SmartDashboard.putNumber("diagnostic/batteryVoltage",RobotController.getBatteryVoltage());
            SmartDashboard.putNumber("diagnostic/inputVoltage",RobotController.getInputVoltage());
            SmartDashboard.putNumber("diagnostic/inputCurrent",RobotController.getInputCurrent());
            switchToggle = SmartDashboard.getBoolean("toggle/switch",true);

            //Robot.sElevator.switchDisable = !switchToggle;

            visionToggle = SmartDashboard.getBoolean("toggle/vision",false);
            if(!visionToggle){
                if(!Robot.sVisionAssist.autonomousThread.isInterrupted()){
                    Robot.sVisionAssist.autonomousThread.interrupt();
                    visionToggle = false;
                }
            }else{
                if(Robot.sVisionAssist.autonomousThread.isAlive()){
                    Robot.sVisionAssist.getNear();
                }
            }
/*
            elevatorToggle = SmartDashboard.getBoolean("toggle/elevator", true);
            if(!elevatorToggle){
                Robot.sElevator.setElevatorDrive = false;
            }else{
                if(!Robot.sElevator.thread.isAlive()){
                    Robot.sElevator.setElevatorDrive = true;
                    Robot.sElevator.drive();
                }
            }
           /*
            liftToggle = SmartDashboard.getBoolean("toggle/lift",false);
            
            if(!liftToggle){
                if(Robot.sLift.liftEnable){
                    Robot.sLift.liftEnable = false;
                }
            }else{
                if(!Robot.sLift.liftEnable){
                    Robot.sLift.liftEnable = true;
                    Robot.sLift.liftRun();
                }
            }*/
            driveToggle = SmartDashboard.getBoolean("toggle/drive", true);

            if(driveToggle){
                if(!Robot.sDrive.enableDrive){
                    Robot.sDrive.enableDrive = true;
                    Robot.sDrive.mechanumDrive();
                }
            }else{
                if(Robot.sDrive.enableDrive){
                    Robot.sDrive.enableDrive = false;
                }

            cameraToggle = SmartDashboard.getBoolean("toggle/camera",false);
            
            if(!cameraToggle){
                if(!Robot.m_visionThread.isAlive()){
                    Robot.m_visionThread.start();
                }else{
                    if(!Robot.m_visionThread.isInterrupted()){
                        Robot.m_visionThread.interrupt();
                    }
                }
        }

            Timer.delay(0.1);
        }  
    }
}

}