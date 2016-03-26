package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoRTerrain extends Command {

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
		Robot.chassis.setLeftRight(0.4,-0.4);
		Timer.delay(4);
		Robot.chassis.setLeftRight(0, 0);

	}

	@Override
	protected boolean isFinished() {

		return true;
	}

	@Override
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);
		
	}

	@Override
	protected void interrupted() {

	}

}