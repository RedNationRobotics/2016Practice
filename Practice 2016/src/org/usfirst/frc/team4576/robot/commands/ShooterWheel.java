package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterWheel extends Command{
	private boolean in = true;
	public ShooterWheel(boolean in)
	{
		this.in = in;
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		if(in){
			Robot.shooter.in();
		}else{
			Robot.shooter.out();
		}
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
	
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//changed to true to check issues
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
