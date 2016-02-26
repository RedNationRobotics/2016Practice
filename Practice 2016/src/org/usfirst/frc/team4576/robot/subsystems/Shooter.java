package org.usfirst.frc.team4576.robot.subsystems;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
		
	public Shooter() {
		//super("Shooter", 1.0, 0.0, 0.0);
		
		shooterWheelR.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterWheelR.set(shooterWheelL.getDeviceID());
		shooterWheelR.reverseOutput(true);
		
		shooterElevR.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterElevR.set(shooterElevL.getDeviceID());
		shooterElevR.reverseOutput(true);
	}
	
	CANTalon shooterElevL = new CANTalon(4);
	CANTalon shooterElevR = new CANTalon(5);
	CANTalon shooterWheelL = new CANTalon(6);
	CANTalon shooterWheelR = new CANTalon(7);
	
	
//double Kp;					
//double Ki;					
//double Kd;					
										
//PIDController shooterPID = new PIDController(Kp,Ki,Kd,null,shooterElevR);  //PID (P,I,D,INPUT,OUTPUT) null= encoder handle

	
	
	
	//double currentAmps = shooterWheelR.getOutputCurrent();
	//DigitalInput d6 = new DigitalInput(8);
	//DigitalInput d7 = new DigitalInput(9);
	
	@Override
	protected void initDefaultCommand() {

	}

	public void up() {
		//shooterElevR.set(-.5);
		shooterElevL.set(.5);
		

	}

	public void down() {
		//shooterElevR.set(.5);
		shooterElevL.set(-.5);
		
	}
	public void in(){
		shooterWheelL.set(-.5);
		//shooterWheelR.set(.5);
				
		
	}
	
	public void out(){
		shooterWheelL.set(.5);
		//shooterWheelR.set(-.5);
				
	} 

	public void stopWheel() {
		//shooterElevL.set(0);
		shooterWheelL.set(0);
		
	}
	//Added this method to separate Wheel and Elev stop command
	public void stopElev() {
		shooterElevL.set(0);
	}	
	
	public void gamePadControl(Joystick stick)
	{
		
		//System.out.println("gamepad control");
		//System.out.println(stick.getRawAxis(3) +  " " + stick.getRawAxis(2));
			/*if(stick.getRawAxis(3) - stick.getRawAxis(2) < 0 && stick.getRawAxis(3) - stick.getRawAxis(2) > -0.1)
			{
				//shooterElevR.set(0);
				shooterElevL.set(0);
				return;
			}
		
		
		
			if(stick.getRawAxis(3) - stick.getRawAxis(2) > 0 && stick.getRawAxis(3) - stick.getRawAxis(2) < 0.1)
			{
				//shooterElevR.set(0);
				shooterElevL.set(0);
				return;
			} */
		
		
		//shooterElevR.set(stick.getRawAxis(3) - stick.getRawAxis(2));
		shooterElevL.set(stick.getRawAxis(3) - stick.getRawAxis(2));
	}

	

	

	}
	

