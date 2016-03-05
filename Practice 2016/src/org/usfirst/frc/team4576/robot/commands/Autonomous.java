package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Autonomous extends Command {

	// Called just before this Command runs the first time
	protected void initialize() {
		//requires(Robot.chassis);
		//requires(Robot.pneumatics);
		//requires(Robot.shooter);

		// Robot.shooter.in();
		// Timer.delay(3);

		Robot.chassis.initAuto();
		
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.chassis.setLeftRight(0,0);
		Timer.delay(.5);
		Robot.chassis.setLeftRight(0.5, -0.5);
		Timer.delay(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
