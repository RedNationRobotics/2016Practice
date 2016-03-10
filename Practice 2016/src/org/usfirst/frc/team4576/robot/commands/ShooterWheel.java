package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterWheel extends Command {
	private boolean in = true;

	public ShooterWheel(boolean in) {
		this.in = in;
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		if (in) {
			Robot.shooter.in();
		} else {
			Robot.shooter.out();
		}
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		// changed to true to check issues
		return false;
	}

	@Override
	protected void end() {
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {

	}

}
