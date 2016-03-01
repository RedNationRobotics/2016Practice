package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithJoysticks extends Command {
	
	int loops = 0;
	
	public DriveWithJoysticks(){
		//Need requires to run command
		requires(Robot.chassis);
		requires(Robot.elevator);
		//requires(Robot.shooter); //<======HERE IS YOUR PROBLEM, IT WILL CANCEL THIS TASK WHEN ANY OTHER TASK REQUIRING SHOOTER RUNS (I.E. YOUR BUTTONS)
        Robot.chassis.initTeleop();
        
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.chassis.normalDrive();
    	//Robot.accel.refresh();

    	//SmartDashboard.putNumber("accelX: ",Robot.accel.getX());
    	//SmartDashboard.putNumber("accelY: ",Robot.accel.getY());
    	//SmartDashboard.putNumber("accelZ: ",Robot.accel.getZ());
		
		// gamePadControl required in execute loop
		//Robot.elevator.gamePadControl(Robot.shooterStick);
		
		Robot.elevator.elevatorTeleop(Robot.shooterStick);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
