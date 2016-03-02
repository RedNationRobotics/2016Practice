package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;
	boolean _lastButton1 = false;
	boolean lastButton2 = false;

		public CANTalon elevL = new CANTalon(4);
		public CANTalon elevR = new CANTalon(5);
	/** save the target position to servo to */
	double targetPos1 = (double) (65.0000000/360.00000000);
	double targetPos2 = (double) (95.0000000/360.00000000);

	boolean firstRun = true;
	public Elevator() {
		// Because we are dumb, shooterElevL must follow shooterElevR on
		// Practice Bot, but vice versa on Comp Bot
		elevL.changeControlMode(CANTalon.TalonControlMode.Follower);
		elevL.set(elevR.getDeviceID());
		elevL.reverseOutput(true);
		
		/*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position
		 */
		int absolutePosition = elevR.getPulseWidthPosition() & 0xFFF; /*mask out the bottom12 bits, we don't care about the wrap arounds */
		
		/* use the low level API to set the quad encoder signal */
		elevR.setEncPosition(absolutePosition);

		/* choose the sensor and sensor direction */
		elevR.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		elevR.reverseSensor(true);
		// _talon.configEncoderCodesPerRev(XXX), // if using
		// FeedbackDevice.QuadEncoder
		// _talon.configPotentiometerTurns(XXX), // if using
		// FeedbackDevice.AnalogEncoder or AnalogPot

		/* set the peak and nominal outputs, 12V means full */
		elevR.configNominalOutputVoltage(+0f, -0f);
		elevR.configPeakOutputVoltage(+12f, -12f);
		/*
		 * set the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		elevR.setAllowableClosedLoopErr(0); /* always servo */
		/* set closed loop gains in slot0 */
		elevR.setProfile(0);
		elevR.setF(0.0);
		elevR.setP(1.0);
		elevR.setI(0.0);
		elevR.setD(0.0);
		
		
		
	}

	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void elevatorTeleop(Joystick _joy)
	{
		if(firstRun)
		{
			targetPos1 += elevR.getPosition();
			targetPos2 += elevR.getPosition();
			firstRun = !firstRun;
		}
		/* get gamepad axis */
		double leftYstick = -_joy.getAxis(AxisType.kY)/2;
		double motorOutput = elevR.getOutputVoltage() / elevR.getBusVoltage();
		boolean button1 = _joy.getRawButton(1);
		boolean button2 = _joy.getRawButton(2);
		boolean button3 = _joy.getRawButton(3);
		/* prepare line to print */
		_sb.append("45 is set to: " + targetPos1 + " which should be .125 rotations from intial\n");
		_sb.append("\tout:");
		_sb.append(motorOutput);
		_sb.append("\tpos:");
		_sb.append(elevR.getPosition());
		/* on button1 press enter closed-loop mode on target position */
		if (!_lastButton1 && button1) {
			
			elevR.changeControlMode(TalonControlMode.Position);
			elevR.set(targetPos1); /*50 rotations in either direction*/

		}
		if (!lastButton2 && button2) {
			
			elevR.changeControlMode(TalonControlMode.Position);
			elevR.set(targetPos2); /*50 rotations in either direction*/

		}
		
		if (button3) {
			elevR.changeControlMode(TalonControlMode.PercentVbus);
		}
		
		if(elevR.getControlMode() == TalonControlMode.PercentVbus) elevR.set(leftYstick);
		/* if Talon is in position closed-loop, print some more info */
		if (elevR.getControlMode() == TalonControlMode.Position) {
			/* append more signals to print when in speed mode. */
			_sb.append("\terrNative:");
			_sb.append(elevR.getClosedLoopError());
			_sb.append("\ttrg:");
			_sb.append(targetPos1);
		}
		/*
		 * print every ten loops, printing too much too fast is generally bad for performance
		 */
		if (++_loops >= 10) {
			_loops = 0;
			//System.out.println(_sb.toString());
		}
		_sb.setLength(0);
		/* save button state for on press detect */
		_lastButton1 = button1;
		lastButton2 = button2;
	}
	public void up() {
		// shooterElevR.set(-.5);
		elevL.set(-.25);

	}

	public void down() {
		// shooterElevR.set(.5);
		elevL.set(.25);

	}

	public void stop() {
		elevL.set(0);
	}

	@Deprecated
	public void gamePadControl(Joystick stick) {

		// System.out.println("gamepad control");
		// System.out.println(stick.getRawAxis(3) + " " + stick.getRawAxis(2));
		if (stick.getRawAxis(3) - stick.getRawAxis(2) < 0 && stick.getRawAxis(3) - stick.getRawAxis(2) > -0.1) {
			// shooterElevR.set(0);
			elevR.set(0);
			return;
		}

		if (stick.getRawAxis(3) - stick.getRawAxis(2) > 0 && stick.getRawAxis(3) - stick.getRawAxis(2) < 0.1) {
			// shooterElevR.set(0);
			elevR.set(0);
			return;
		}

		elevR.set(stick.getRawAxis(3) - stick.getRawAxis(2));
		// shooterElevL.set(stick.getRawAxis(3) - stick.getRawAxis(2));
	}

}
