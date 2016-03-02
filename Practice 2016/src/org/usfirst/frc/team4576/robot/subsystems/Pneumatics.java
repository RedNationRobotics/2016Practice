package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	private Compressor c;
	private Solenoid s0 = new Solenoid(0);// Shifting
    private Solenoid s2 = new Solenoid(2);/* 2 and 4 are bigggg piston 2-extending 4-retracting*/
	private Solenoid s3 = new Solenoid(3);// Firing

	@Override
	protected void initDefaultCommand() {
		c = new Compressor();
	}

	public void setAutoEnabled() {

		c.setClosedLoopControl(true);
	}

	public void setClimb(boolean closed) {
		s2.set(closed);
	}

	public void Climb() {
		s2.set(!s2.get());
	}

	public void setShift(boolean closed) {
		s0.set(closed);
	}

	public void shift() {
		s0.set(!s0.get());

	}

	public void setPush(boolean closed) {
		s3.set(closed);
	}

	public void push() {
		s3.set(!s3.get());
		// Timer.delay(1);
		// s2.set(s2.get());

	}
}