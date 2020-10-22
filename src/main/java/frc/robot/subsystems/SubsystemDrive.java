package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;

import frc.robot.commands.CommandMecanumDrive;
import frc.robot.OI;
import frc.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.DriverStation;



public class SubsystemDrive extends Subsystem implements PIDOutput{

    private PWMVictorSPX frontLeftMotor,frontRightMotor,rearLeftMotor,rearRightMotor;
    public static AHRS ahrs;

    PIDController turnController, moveController;
    double rotateToAngleRate;
    
    private MecanumDrive m_robotDrive;
    private boolean slowMode = false;
    public boolean visionDrive = false;
    public int distance = 0;
    public static  double turningAngle = 0;
    public static double gyroAngle = 0;
    public static boolean enableDrive = true;

    static  double kP = -0.005;
    static  double kI = 0.000000;
    static  double kD = -0.020;//-0.0235 optimal for 180
    static  double kF = 0.0;

    static final double kToleranceDegrees = 0.00f;
    private boolean setP = false;
    private boolean setP2 = false;
    private Joystick stick;

    public SubsystemDrive(Joystick stick){
        this.stick = stick;
        frontLeftMotor = new PWMVictorSPX(RobotMap.channelFrontLeft);
        frontRightMotor = new PWMVictorSPX(RobotMap.channelFrontRight);
        rearLeftMotor = new PWMVictorSPX(RobotMap.channelRearLeft);
        rearRightMotor = new PWMVictorSPX(RobotMap.channelRearRight);

        
        // Importing the NavX module.
        try {
            ahrs = new AHRS(SPI.Port.kMXP); 
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        }



        // Creating a MecanumDrive object, allowing us to control the robot.
        m_robotDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

        turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);
        
        //ahrs.setPIDSourceType(PIDSourceType.kRate);
        
    }


    
    public double getAngle(){
        return ahrs.getAngle();
    }
    public double getTurningAngle(){
        return turningAngle;
    }

    public boolean getSlowMode(){
        return slowMode;
    }


    public void mechanumDrive(){
        if(!enableDrive){
            return;
        }

        m_robotDrive.setSafetyEnabled(true);
          boolean rotateToAngle = false;
          
          if(visionDrive){
              double xSpeed;
              switch(distance){
                    case 1:
                        xSpeed = 0.2;
                        break;
                    case 2:
                        xSpeed = 0.22;
                        break;
                    case 3:
                        xSpeed = 0.25;
                        break;
                    case 4:
                        xSpeed = 0.3;
                        break;
                    case 5:
                        xSpeed = 0.35;
                        break;
                    case 6:
                        xSpeed = 0.4;
                        break;
                    default:
                        xSpeed = 0;
                        break;
              }
            try {
            m_robotDrive.driveCartesian(0.0, xSpeed,0.0);
        } catch( RuntimeException ex ) {
            DriverStation.reportError("Error communicating with drive system:  " + ex.getMessage(), true);
        }
            Timer.delay(0.005);
        }else{      


          if ( stick.getRawButton(1)) {
              ahrs.reset();
          }


          if ( stick.getRawButton(3)) {
              turnController.setSetpoint(0.0f);
              setP = true;
              if(!rotateToAngle){
                  turningAngle = 0;
            }
            rotateToAngle = true;
          } else if ( stick.getRawButton(6)) {
              
              turnController.setSetpoint(90.0f);
              setP = true;
              if(!rotateToAngle){
                  turningAngle = 90;
            }
            rotateToAngle = true;
          } else if ( stick.getRawButton(4)) {
            
              turnController.setSetpoint(179.9f);
              setP = true;
              if(!rotateToAngle){
                  turningAngle = 180;
            }
            rotateToAngle = true;
          } else if ( stick.getRawButton(5)) {
            
              turnController.setSetpoint(-90.0f);
              setP = true;
              if(!rotateToAngle){
                  turningAngle = 270;
            }
            rotateToAngle = true;
          }
          else if ( stick.getRawButton(6)) {
            
              turnController.setSetpoint(61.25f);
              setP = true;
              if(!rotateToAngle){
                  turningAngle = 61.25;
            }
            rotateToAngle = true;
          }
          else if ( stick.getRawButton(7)) {

              turnController.setSetpoint(118.75f);
              setP = true;
              if(!rotateToAngle){
                  turningAngle = 118.75;
            }
            rotateToAngle = true;
              
          }
          else{
               turnController.reset();
               setP2 =true; 
            }
            if(setP&&setP2){
                if (Math.abs(turnController.getError())>100){
                    turnController.setP(-0.004);
                }  else turnController.setP(-0.005);          
                setP = false;
                setP2 = false;
            }
        // Deadzone ve yavaşlatma butonu
        double currentX;
        double currentY;
        double range = 0.5;

            
        if(stick.getRawButton(9)){ // yavaşlatma bölümü
            slowMode = !slowMode;
        }

        

        if(slowMode){
        currentX = scaleBetween(-stick.getX(), -1.0, 1.0, -range, range);
        currentY = scaleBetween(stick.getY(), -1.0, 1.0, -range, range);
        SmartDashboard.putBoolean("drive/slowMode", true);
        }else{
            currentX = -stick.getX();
            currentY =  stick.getY()<0.0 && stick.getY()>-0.15656 ? 0 : stick.getY(); // deadzone y ekseni.
            SmartDashboard.putBoolean("drive/slowMode", false);
            //System.out.print("Current y   "+currentY);
        }
            

    

            double currentRotationRate;
            if ( rotateToAngle ) {
                turnController.enable();
                currentRotationRate = rotateToAngleRate;
            } else {
                turnController.disable();
                currentRotationRate = getActivated(2, -stick.getTwist(),OI.getMainJoystick()); 
            }
            try {
  
                m_robotDrive.driveCartesian(currentX, currentY, 
                currentRotationRate);
            } catch( RuntimeException ex ) {
                DriverStation.reportError("Error communicating with drive system:  " + ex.getMessage(), true);
            }
            Timer.delay(0.005);	
        	}	// wait for a motor update time
        
        }

    



    /*
    *   Default Command to use this Subsystem.
    *   We will be calling CommandMecanumDrive to access this subsystem.
    */
    @Override
    public void initDefaultCommand(){
        setDefaultCommand(new CommandMecanumDrive());
    }

    public double getActivated(int button,double input, Joystick stick){

        // If provided button is clicked,
        // disable twist block.
        if (stick.getRawButton(button)){
            return input;
        }
       else return 0;
      }
      public void pidWrite(double output) {
        rotateToAngleRate = output;
        SmartDashboard.putNumber("drive/errorRemainingAngle", turnController.getError());
        //System.out.println("Pid output " +output +"  "+turnController.getError()+"  "+turnController.get());
    }
    double scaleBetween(double unscaledNum,double  min, double max,double minAllowed,double  maxAllowed) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
      }
}