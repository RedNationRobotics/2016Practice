package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class SecondaryClimb extends Command{

	public SecondaryClimb()
	{
		requires(Robot.pneumatics);
	}
	@Override
	protected void initialize() {
		Robot.pneumatics.secondaryclimb();
		//System.out.println("button pressed. value changing to: " + value);
	}

	@Override
	protected void execute() {
		    }

	@Override
	protected boolean isFinished() {
		return true;
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
