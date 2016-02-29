package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.AutoEnableCompressor;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;
//import org.usfirst.frc.team4576.robot.subsystems.OnboardAccel;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4576.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
	//public static final OnboardAccel accel = new OnboardAccel();
	
	public static OI oi;
	public static Joystick driveStick = new Joystick(0);
	public static Joystick shooterStick = new Joystick(1);
	
   Command teleopCommand;
   Command compressorStart;
 
   String VERSION = "1.43 ALPHA";
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("RNR 2016 Practice Code Version " + VERSION + " is loading... But will it work?");
		oi = new OI();
		teleopCommand = new DriveWithJoysticks();
		compressorStart = new AutoEnableCompressor();
		
		
				
        // instantiate the command used for the autonomous period
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
	}
	public void autonomousInit() {
		//added <autochooser.getSelected();> might be wrong (s)
	}

    public void teleopInit() {
		teleopCommand.start();
		compressorStart.start();
		   
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

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
