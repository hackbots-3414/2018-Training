package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the RobotDrive class. The
 * SampleRobot class is the base of a robot application that will automatically
 * call your Autonomous and OperatorControl methods at the right time as
 * controlled by the switches on the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're
 * inexperienced, don't. Unless you know what you are doing, complex code will
 * be much more difficult under this system. Use IterativeRobot or Command-Based
 * instead if you're new.
 */
public class Robot extends SampleRobot {
	RobotDrive myRobot = new RobotDrive(1, 2);
	XboxController stick = new XboxController(0);
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	SendableChooser<String> chooser = new SendableChooser<>();
	private Encoder rightEncoder = new Encoder(1, 2, false, EncodingType.k4X);
	private Encoder leftEncoder = new Encoder(3, 4, false, EncodingType.k4X);
	public AnalogGyro gyro = new AnalogGyro(2);
	public Robot() {
		myRobot.setExpiration(0.1);
	}

	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto modes", chooser);
		
		rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		rightEncoder.setDistancePerPulse(
				(4.0/* in */ * Math.PI) / (360.0 * 12.0/* in/ft */));
		leftEncoder.setDistancePerPulse(
				(4.0/* in */ * Math.PI) / (360.0 * 12.0/* in/ft */));
		
		
	}
	public void DriveForward(double dist){
	System.out.println("Enter drive forward");
		leftEncoder.reset();
	
		Timer.delay(0.1);
		System.out.println(leftEncoder.getDistance());
		Timer.delay(0.01);
		while(dist-leftEncoder.getDistance()>0){
			myRobot.tankDrive(1, 1);
			System.out.println(leftEncoder.getDistance());	
			Timer.delay(0.01);
			
		}	
			myRobot.tankDrive(0,0);
			System.out.println("Exit drive forward");
	}
	public void DriveLeft(double angle){
		System.out.println("Enter drive left");
	double CAngle = gyro.getAngle();
	double stopAngle = CAngle + angle;
	if(stopAngle < -1){
		stopAngle = stopAngle + 720;
	}
			double nowAngle = CAngle;
			if(nowAngle<-1){
				nowAngle = nowAngle+720;
			} 
		
		System.out.println("Now" + nowAngle + ", Stop" + stopAngle);
		Timer.delay(0.01);
		while(stopAngle<nowAngle){
			myRobot.tankDrive(-1, 1);
			System.out.println("Now" + nowAngle + ", Stop" + stopAngle);
			Timer.delay(0.01);
		}	
		System.out.println("Now" + nowAngle + ", Stop" + stopAngle);
		myRobot.tankDrive(0,0);
		System.out.println("Exit drive left");

	}
	public void DriveRight(double rightangle){
		System.out.println("Enter drive right");
		double CAngle = gyro.getAngle();
		double StopAngle = CAngle + rightangle;
		if(StopAngle < -1){
			StopAngle = StopAngle + 720;
		}
			double NowAngle = CAngle;
			if(NowAngle<0){
				NowAngle = NowAngle+720;
			}
		Timer.delay(0.01);
		
		Timer.delay(0.1);
		

		
		
		while(StopAngle<NowAngle){
			
		
			myRobot.tankDrive(0.5, -0.5);
			System.out.println("Now" + NowAngle + ", Stop" + StopAngle);
			Timer.delay(0.1);
	
			}
		
	myRobot.tankDrive(0,0);
	System.out.println("Exit drive right");
	System.out.println("Stop" + NowAngle + ", Now" + StopAngle);

	}
	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * if-else structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomous() {
			
			 myRobot.setSafetyEnabled(true);
			 
			DriveForward(5);
			DriveLeft(40);
			DriveRight(40);
			
			/*DriveForward(15);
			DriveLeft(30);
			DriveForward(15);
			DriveLeft(30);
			DriveForward(10);
			DriveLeft(45);
			DriveForward(6);
			DriveLeft(15);
			DriveForward(25);
			DriveRight(22);
			DriveForward(10);
			DriveRight(50);
		/*	DriveForward(5);
			DriveLeft(5);
			DriveForward(15);
			DriveLeft(3);
			DriveForward(7);
			DriveLeft(3);
			DriveForward(7);
			DriveLeft(3);
			DriveForward(4);
			DriveLeft(4);
			DriveForward(32);
			DriveRight(3);
			DriveForward(10);
			DriveRight(3);
			DriveForward(9);
			DriveRight(3);
			DriveForward(4);
			DriveRight(4);
			DriveForward(3);
			DriveRight(1);
			DriveForward(15);
		*/	

		
	}
	
	/**
	 * Runs the motors with arcade steering.
	 */
	@Override
	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			/*myRobot.arcadeDrive(stick); // drive with arcade 		myRobot.tankDrive(0, 0);
style (use right
										// stick) */
			myRobot.tankDrive(stick.getRawAxis(3), stick.getRawAxis(1));
			Timer.delay(0.005); // wait for a motor update time
		}
		
	}

	/**
	 * Runs during test mode
	 */
	@Override
	public void test() {
	}
}



