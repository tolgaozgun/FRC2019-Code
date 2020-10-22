
package frc.robot.commands;
// this import will be needed later.
//import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.runnable.RunnableDashboard;


public class Dashboard extends Command {

		public static NetworkTable dashboardTable;
		public static NetworkTableInstance dashboard;
		public static NetworkTableEntry autoMode,climberMotor,gyroAngle,matchTime,motorFrontLeft,motorFrontRight,motorRearLeft,motorRearRight;
        public static Thread dashboardThread;
        private static RunnableDashboard dashboardRunnable;
        public Dashboard() {
        }
        
        @Override
        protected void initialize() {
        }
        
        @Override
        protected void execute() {
            /* 
            
                TO BE ADDED LATER,
                DO NOT REMOVE!


             SmartDashboard.putData(Robot.mecanumDrive);
             SmartDashboard.putData(Robot.gearMechanism);
             SmartDashboard.putData(Robot.climber);

             //SmartDashboard.putString("Gear Piston Position", Robot.gearMechanism.getValue());*/
        }
        
        @Override
        protected boolean isFinished() {
                return false;
        }
        
        @Override
        protected void interrupted() {
        }
        
        public static void init(){
            // Defines the modes to select from in the Dashboard.

            dashboardRunnable = new RunnableDashboard();
            dashboardThread = new Thread(dashboardRunnable);
            dashboardThread.start();
            // Calls for update() function, to update other variables.

        }
        
        public static void update(){

            /*
            This would normally update the Dashboard with motor speed data, but removed for now.
            Might be added later.

            SmartDashboard.putNumber("motors/FrontLeftMotor",Robot.sDrive.getFrontLeftSpeed());
            SmartDashboard.putNumber("motors/FrontRighttMotor",Robot.sDrive.getFrontRightSpeed());
            SmartDashboard.putNumber("motors/RearLeftMotor",Robot.sDrive.getRearLeftSpeed());
            SmartDashboard.putNumber("motors/RearRightMotor",Robot.sDrive.getFrontLeftSpeed());
            */
            
            
        }

        public static void getAngle(){

        }
}

