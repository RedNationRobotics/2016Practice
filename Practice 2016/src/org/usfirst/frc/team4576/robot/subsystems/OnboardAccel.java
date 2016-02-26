package org.usfirst.frc.team4576.robot.subsystems;

/*import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;


//public class OnboardAccel extends Subsystem {

//Put methods for controlling this subsystem
// here. Call these from Commands.
	
	//the following declares our variables, follows OOP fully and
	//dependency injection archetype (https://en.wikipedia.org/wiki/Dependency_injection)
	//declaring our variables in the class type and keeping them private allows access
	//throughout the class, and ensures no outside meddling
	//if someone needs something, they call our getter method, which ensures they
	//have an object lock and handle before they can modify it,
	//if there were concurrency issues they would be synchronized
	
	//private BuiltInAccelerometer accel;
	//private double accelerationX;
	//private double accelerationY;
	//private double accelerationZ;

	
	//Constructor
	//this runs once as the class is assembled into an object as soon as "new Accelerometer()" is called
	//currently we are only instantiating our values so that they are no longer null, and we can begin operating
	//on the accel object
	
	//public OnboardAccel()
	//{
	//	accel = new BuiltInAccelerometer();
	//	accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
	//	accelerationX = 0;
	//	accelerationY = 0;
	//	accelerationZ = 0;
	//}
	//polls accelerometer for data and stores it in our double values
	//public void refresh() {
	/*	accelerationX = accel.getX();
			accelerationY = accel.getY();
	/
			
		accelerationZ = accel.getZ();
	}
	//returns a handle to the BuiltInAccelerometer object accel for manual control
	public BuiltInAccelerometer getBuiltInAccelerometer()
	{
		return accel;
	}
	//simple data getters for x, y, and Z values;
	public double getX()
	{
		return accelerationX;
	}
	public double getY()
	{
		return accelerationY;
	}
	public double getZ()
	{
		return accelerationZ;
	//gets all the data at once in a simple map
	//see javadocs online for reference
	public Map<AccelValues,Double> getMap()
	{
	
		Map<AccelValues,Double> accelValues = new HashMap<AccelValues,Double>();
		accelValues.put(AccelValues.X,getX());
		accelValues.put(AccelValues.Y,getY());
		accelValues.put(AccelValues.Z,getZ());
	
		//double x = accelValues.get(AccelValues.X);
		return accelValues;
	}
	
	
	//bullshit, not used
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	
	}
	//enumeration of constant names for different values of acceleration
public enum AccelValues
{
	X,
	Y,
	Z;
}*/

