package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.Climbing;
import org.usfirst.frc.team4576.robot.commands.ShooterWheel;
//import org.usfirst.frc.team4576.robot.commands.ToggleCompressor;
import org.usfirst.frc.team4576.robot.commands.Push;
import org.usfirst.frc.team4576.robot.commands.Shift;
//import org.usfirst.frc.team4576.robot.subsystems.Shooter;
import org.usfirst.frc.team4576.robot.commands.ShooterStop;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
// Button Values:
//
// 1: A
// 2: B
// 3: X
// 4: Y
// 5: Left Bumper
// 6: Right Bumper
// 7: Back
// 8: Start
// 9: Left Joystick pressed down
// 10: Right Joystick pressed down
//
//
// Axis values:
//
// 1 - LeftX
// 2 - LeftY
// 3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
// 4 - RightX
// 5 - RightY
// 6 - DPad Left/Right
//
// CREATING BUTTONS
//
// One type of button is a joystick button which is any button on a joystick.
// You create one by telling it which joystick it's on and which button
// number it is.
// Joystick stick = new Joystick(port);
// Button button = new JoystickButton(stick, buttonNumber);

// There are a few additional built in buttons you can use. Additionally,
// by subclassing Button you can create custom triggers and bind those to
// commands the same as any other Button.

//// TRIGGERING COMMANDS WITH BUTTONS
// Once you have a button, it's trivial to bind it to a button in one of
// three ways:

// Start the command when the button is pressed and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenPressed(new ExampleCommand());

// Run the command while the button is being held down and interrupt it once
// the button is released.
// button.whileHeld(new ExampleCommand());

// Start the command when the button is released  and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenReleased(new ExampleCommand());
public class OI {
	// Example of a button assigned to the left bumper-
	Button ssRB = new JoystickButton(Robot.shooterStick, 5);
	Button ssLB = new JoystickButton(Robot.shooterStick, 6);
	Button ssR3 = new JoystickButton(Robot.shooterStick, 10);
	
	Button dsY = new JoystickButton(Robot.driveStick, 4);
	Button dsX = new JoystickButton(Robot.driveStick, 3);
	Button dsB = new JoystickButton(Robot.driveStick, 2);

	public OI() {
		ssRB.whenPressed(new ShooterWheel(true));
		ssLB.whenPressed(new ShooterWheel(false));
		ssRB.whenReleased(new ShooterStop());
		ssLB.whenReleased(new ShooterStop());
		ssR3.whenPressed(new Push());
		ssR3.whenReleased(new Push());
		dsX.whenPressed(new Shift());
		///dsB.whenPressed(new ToggleCompressor());
		dsY.whenPressed(new Climbing());
		
	}
}