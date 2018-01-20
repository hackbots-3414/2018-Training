package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
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

	public Robot() {
		myRobot.setExpiration(0.1);
	}

	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto modes", chooser);
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
			
			
				
			myRobot.tankDrive(1.0, 1.0);
			Timer.delay(5.0);
			
			myRobot.tankDrive(0,1.0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 1.0);
			Timer.delay(2);
			myRobot.tankDrive(0, 0);	
			
			myRobot.tankDrive(0, 1.0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 1.0);
			Timer.delay(5.0);
			
			myRobot.tankDrive(0,1.0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 1.0);
			Timer.delay(2);
			myRobot.tankDrive(0, 0);	
			
			myRobot.tankDrive(0, 1.0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 1.0);
			Timer.delay(2.0);
			
			myRobot.tankDrive(0,1.0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 1.0);
			Timer.delay(2);
			myRobot.tankDrive(0, 0);	
			
			myRobot.tankDrive(0, 1.0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 1.0);
			Timer.delay(11.5);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0,1.0);
			Timer.delay(3);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0,1.0);
			Timer.delay(3);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0, 0);
			Timer.delay(1);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0,1.0);
			Timer.delay(3);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0,0.0);	
			Timer.delay(2.5);
			myRobot.tankDrive(0, 0);
			
			myRobot.tankDrive(1.0,1.0);
			Timer.delay(9);
			myRobot.tankDrive(0.0, 0.0);
			
	}
	
	/**
	 * Runs the motors with arcade steering.
	 */
	@Override
	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			/*myRobot.arcadeDrive(stick); // drive with arcade style (use right
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



