package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.runnable.RunnableVisionAssist;


public class SubsystemVisionAssist extends Subsystem{

    public static Thread autonomousThread;
    private static RunnableVisionAssist autonomousRunnable;
    double visionDistance;

    public SubsystemVisionAssist(){

    }
    public void getNear(){
        autonomousRunnable = new RunnableVisionAssist();
        autonomousThread = new Thread(autonomousRunnable);
        autonomousThread.start();
    }

    


	@Override
	public void initDefaultCommand() {

	}
}