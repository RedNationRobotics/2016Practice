package org.usfirst.frc.team4576.robot.subsystems;


import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
		
	public Shooter() {
			
		shooterWheelR.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterWheelR.set(shooterWheelL.getDeviceID());
		shooterWheelR.reverseOutput(true);
		
	}
	

	CANTalon shooterWheelL = new CANTalon(6);
	CANTalon shooterWheelR = new CANTalon(7);
	
	
	@Override
	protected void initDefaultCommand() {

	}
	
	
	
	public void in(){
		shooterWheelL.set(-1);
		//shooterWheelR.set(1);
				
		
	}
	
	public void out(){
		shooterWheelL.set(1);
		//shooterWheelR.set(-1);
				
	} 

	public void stop() {
		//shooterElevL.set(0);
		shooterWheelL.set(0);
		
	}
	

}
	

