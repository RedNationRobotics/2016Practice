	package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Pneumatics extends Subsystem {
	
	public Pneumatics() {
		psensor = new AnalogInput(0);
		//s0 = new Solenoid(0);/* Shifting */
		s2 = new Solenoid(2);/* EXTEND 2 and 4 are bigggg piston 2-extending 4-retracting*/
		s3 = new Solenoid(3);/* Firing */
		s4 = new Solenoid(4);/* RETRACT */
	}
	
	private Compressor c;
	public AnalogInput psensor;
	//private Solenoid s0;
    private Solenoid s2;
	private Solenoid s3;
	private Solenoid s4;

	
	
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
	 * please remember, when you call a method, it runs the code in the method, so since all of this code
	 * was outside of the method, in the class instead, it ran once on startup, probably before the analog 
	 * channel was even close to being initialized
	 * 
	 * you want to read the pressure value every time you call this, not once on startup
	 * 
	 * also this is a getter method, it has "get" in the name, it should return the value it is getting, not void
	 */
	public double getPressure(){
	/**
	 * The input voltage provided to the sensor
	 */
	double inputVoltage = 5;
	
	/**
	 * What to use if we are no provided with another input voltage
	 */
	//private final static double DEFAULT_VOLTAGE = 5.0;
	
	
	

	
	double pressure = (250 * (psensor.getVoltage()/inputVoltage) - 25);
	
	
	
		SmartDashboard.putNumber("Pressure:", pressure); 
		return pressure;
	}
}
