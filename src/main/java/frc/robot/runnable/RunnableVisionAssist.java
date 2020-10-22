package frc.robot.runnable;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class RunnableVisionAssist implements Runnable {

    double visionDistance = 0.0;


    public RunnableVisionAssist() {
        
    }

    public void run() {
        while(!Robot.sVisionAssist.autonomousThread.isInterrupted()){
                String visionDistanceString = SmartDashboard.getString("vision/distance", "0.0");
                try{
                    visionDistance = Double.valueOf(visionDistanceString);
                }catch(Exception e){
                    e.printStackTrace();
                    visionDistance = 0.0;
                }
                if(visionDistance == 0.0 || visionDistance < 5.0){
                    Robot.sDrive.visionDrive = false;
                    Robot.sDrive.distance = 0;
                    Robot.sVisionAssist.autonomousThread.interrupt();
                }
                else if(visionDistance > 150.0){
                    Robot.sDrive.visionDrive = true;
                    Robot.sDrive.distance = 6;
                    
                }else if(visionDistance > 120.0){
                    Robot.sDrive.visionDrive = true;
                    Robot.sDrive.distance = 5;

                }else if(visionDistance > 90.0){
                    Robot.sDrive.visionDrive = true;
                    Robot.sDrive.distance = 4;

                }else if(visionDistance > 60.0){
                    Robot.sDrive.visionDrive = true;
                    Robot.sDrive.distance = 3;

                }else if(visionDistance > 30.0){
                    Robot.sDrive.visionDrive = true;
                    Robot.sDrive.distance = 2;

                }else if(visionDistance > 5.0){
                    Robot.sDrive.visionDrive = true;
                    Robot.sDrive.distance = 1;
                }
            Timer.delay(0.005);
        }
    }
}