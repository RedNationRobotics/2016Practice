package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDefence extends Command {

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();

	}

	@Override
	protected void execute() {
		Robot.chassis.setLeftRight(-0.5, 0.5);
		Timer.delay(1.5);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
