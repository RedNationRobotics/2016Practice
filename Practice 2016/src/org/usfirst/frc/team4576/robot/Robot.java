package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.AutoDefence;
import org.usfirst.frc.team4576.robot.commands.AutoEnableCompressor;
import org.usfirst.frc.team4576.robot.commands.AutoLowBar;
import org.usfirst.frc.team4576.robot.commands.AutoRTerrain;
import org.usfirst.frc.team4576.robot.commands.CheeseRockWall;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4576.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Shooter shooter = new Shooter();
	public static final Elevator elevator = new Elevator();
	//public static final AnalogPressure analogPressure = new AnalogPressure();
	public static OI oi;
	public static Joystick driveStick = new Joystick(0);
	public static Joystick shooterStick = new Joystick(1);
	

	Command teleopCommand;
	Command autonomousCommand;
	Command compressorStart;
	CameraServer server;
	SendableChooser chooser;

	String VERSION = "2.0";

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		System.out.println("RNR 2016 Code Version " + VERSION + " is loading... But will it work?");
		oi = new OI();
		chooser = new SendableChooser();
		chooser.addDefault("Auto: Roll to defence", new AutoDefence());
		chooser.addObject("Auto: Cross LowBar then stop", new AutoLowBar());
		chooser.addObject("Auto: Cross RoughTerrain then stop", new AutoRTerrain());
		chooser.addObject("Auto: QUESO", new CheeseRockWall());


		
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		teleopCommand = new DriveWithJoysticks();
		compressorStart = new AutoEnableCompressor();
		autonomousCommand = new AutoDefence();
		autonomousCommand = new AutoLowBar();
		autonomousCommand = new AutoRTerrain();
		autonomousCommand = new CheeseRockWall();


		server = CameraServer.getInstance();
	    server.setQuality(15);
	        //the camera name (ex "cam0") can be found through the roborio web interface
	    server.startAutomaticCapture("cam0");
		

		// instantiate the command used for the autonomous period

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();

	}

	public void autonomousInit() {
autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
		// added <autochooser.getSelected();> might be wrong (s)
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)autonomousCommand.cancel();
		teleopCommand.start();
		compressorStart.start();

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
