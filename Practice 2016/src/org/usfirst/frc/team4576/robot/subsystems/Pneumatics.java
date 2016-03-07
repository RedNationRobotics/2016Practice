package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Pneumatics extends Subsystem {
	
	private Compressor c;
	public AnalogInput psensor = new AnalogInput(1);
	//private Solenoid s0 = new Solenoid(0);/* Shifting */
    private Solenoid s2 = new Solenoid(2);/* EXTEND 2 and 4 are bigggg piston 2-extending 4-retracting*/
	private Solenoid s3 = new Solenoid(3);/* Firing */
	private Solenoid s4 = new Solenoid(4);/* RETRACT */

	@Override
	protected void initDefaultCommand() {
		c = new Compressor();
		///////////sensor0  = new AnalogPressure (0,5);
	}

	public void setAutoEnabled() {

		c.setClosedLoopControl(true);
	}

	/*public void setShift(boolean closed) {
		s0.set(closed);
	}

	public void shift() {
		s0.set(!s0.get());

	}
*/
	public void toggleComp() {
		if (c.enabled())
			c.stop();
		else
			c.start();
	}
	public void setPush(boolean closed) {
		s3.set(closed);
	}

	public void push() {
		s3.set(!s3.get());
		// Timer.delay(1);
		// s2.set(s2.get());

	}
	
	/* Check This */
	public void climb(boolean closed)
	{
		s2.set(closed);
		s4.set(!closed);
	}
	
	public void toggleClimb()
	{
		boolean b = !s2.get();
		s2.set(b);
		s4.set(!b);
	}
private AnalogInput input;
	
	/**
	 * The input voltage provided to the sensor
	 */
	private double inputVoltage = input.getVoltage();
	
	/**
	 * What to use if we are no provided with another input voltage
	 */
	//private final static double DEFAULT_VOLTAGE = 5.0;
	
	/**
	 * The slope of the conversion of the return volts to pressure. From documentation.
	 */
	private final int SLOPE = 250;
	
	/**
	 * The Y intercept of the conversion of the return volts to pressure. From the docs. 
	 */
	private final int Y_INTERCEPT = -25;
	
	double pressure = SLOPE * (psensor.getVoltage()/inputVoltage) + Y_INTERCEPT;
	
	/**
	 * Formula comes from the official documentation
	 * @return 
	 */
	public void getPressure(){
		SmartDashboard.putNumber("Pressure:", pressure); 
	}
}