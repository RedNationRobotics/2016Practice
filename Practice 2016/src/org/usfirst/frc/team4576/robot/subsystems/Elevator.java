package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
    
	public Elevator() {
		//Because we are dumb, shooterElevL must follow shooterElevR on Practice Bot, but vice versa on Comp Bot
				ElevL.changeControlMode(CANTalon.TalonControlMode.Follower);
				ElevL.set(ElevR.getDeviceID());
				ElevL.reverseOutput(true);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon ElevL = new CANTalon(4);
	public CANTalon ElevR = new CANTalon(5);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void up() {
		//shooterElevR.set(-.5);
		ElevL.set(-.25);
		

	}

	public void down() {
		//shooterElevR.set(.5);
		ElevL.set(.25);
		
	}
	
	public void stopElev() {
		ElevL.set(0);
	}	
	
	public void gamePadControl(Joystick stick)
	{
		
		//System.out.println("gamepad control");
		//System.out.println(stick.getRawAxis(3) +  " " + stick.getRawAxis(2));
			if(stick.getRawAxis(3) - stick.getRawAxis(2) < 0 && stick.getRawAxis(3) - stick.getRawAxis(2) > -0.1)
			{
				//shooterElevR.set(0);
				ElevR.set(0);
				return;
			}
		
		
		
			if(stick.getRawAxis(3) - stick.getRawAxis(2) > 0 && stick.getRawAxis(3) - stick.getRawAxis(2) < 0.1)
			{
				//shooterElevR.set(0);
				ElevR.set(0);
				return;
			} 
		
		
		ElevR.set(stick.getRawAxis(3) - stick.getRawAxis(2));
		//shooterElevL.set(stick.getRawAxis(3) - stick.getRawAxis(2));
	}

}

