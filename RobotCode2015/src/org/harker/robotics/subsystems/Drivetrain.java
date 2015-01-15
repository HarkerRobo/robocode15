package org.harker.robotics.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.harker.robotics.robot.RobotMap.Drivetrain.*;

public class Drivetrain extends Subsystem {
	private RobotDrive robotDrive;
	private Gyro gyro;
	private boolean isManualDriveEnabled;
	private static Drivetrain drivetrain;
	private Talon leftFront, leftBack, rightFront, rightBack;
	
	private Drivetrain() {
		System.err.println("Drivetrain initialized");
		//robotDrive = new RobotDrive(LEFT_FRONT_MOTOR_CHANNEL, LEFT_BACK_MOTOR_CHANNEL,
		//								RIGHT_FRONT_MOTOR_CHANNEL, RIGHT_BACK_MOTOR_CHANNEL);
		gyro = new Gyro(GYRO_CHANNEL);
		isManualDriveEnabled = true;
	}
//	public void drive(double speed) {
//    	leftFront.set(-speed);
//    	leftBack.set(-speed);
//    	rightFront.set(speed);
//    	rightBack.set(speed);
//    }
//    
//    public void drive(double left, double right) {
//    	leftFront.set(-left);
//    	leftBack.set(-left);
//    	rightFront.set(right);
//    	rightBack.set(right);
//    }
//    
//    public void turn(int direction) {
//    	leftFront.set(-direction);
//    	leftBack.set(-direction);
////    	rightFront.set(direction);
////    	rightBack.set(direction);
//    }
//    
//    public void drive(double speed, int port) {
//    	switch(port) {
//    		case 0:
//    			leftFront.set(-speed);
//    			break;
//    		case 1: 
//    			leftBack.set(-speed);
//    			break;
//    		case 2:
//    			rightFront.set(speed);
//    			break;
//    		case 3:
//    			rightBack.set(speed);
//    			break;
//			default:
//				System.out.println("Port not found");
//    	}
//    }
    
    public void pollAllInputs() {
    	for (int i = 0; i < 10; i++) {
    		try {

    		} catch (Exception ex) {
    			System.err.println("Error with input " + i);
    		}
    	}
    }
    
	@Override
	protected void initDefaultCommand() {
		
	}
	
	/**
	 * Gets an instance of the drivetrain, automatically initializing it if it hasn't been
	 * already.
	 * @return An instance of the drivetrain
	 */
	public static Drivetrain getInstance() {
		if (drivetrain == null) 
			drivetrain = new Drivetrain();
		return drivetrain;
	}
	
	/**
	 * Initializes the drivetrain if it hasn't been already
	 */
	public static void initialize() {
		if (drivetrain == null)
			drivetrain = new Drivetrain();
		if (drivetrain == null) System.err.println("Does not wrok");
	}

	/**
	 * Drives at the given x and y velocities along with an independent rotation.
	 * @param x The desired x-velocity (between -1.0 and 1.0)
	 * @param y The desired y-velocity (between -1.0 and 1.0)
	 * @param rotation The rate of rotation independent of translation (between -1.0 and 1.0)
	 * @param gyroAngle The current angle of the robot's gyro in degrees
	 */
	public void drive(double x, double y, double rotation) {
		//Uses -y because the mecanum drive function automatically flips the sign of 
		//y as most inputs unintuitively represent forwards y motion with a negative
		//value. However, the GamepadWrapper from HarkerRoboLib performs this flip
		//as well, thus the input must be flipped once again to satisfy the robot
		//drive method
		//robotDrive.mecanumDrive_Cartesian(x, -y, rotation, getCurrentHeading());
	}
	
	/**
	 * Drives in the given direction at the inputed speed along with an independent rotation.
	 * @param magnitude The speed to move at (between -1.0 and 1.0)
	 * @param direction The direction to move in, in degrees
	 * @param rotation The speed of rotation independent of translation (between -1.0 and 1.0)
	 */
	public void drivePolar(double magnitude, double direction, double rotation) {
		robotDrive.mecanumDrive_Polar(magnitude, direction, rotation);
	}
	
	/**
	 * @return The current direction of the robot in degrees.
	 */
	public double getCurrentHeading() {
		return gyro.getAngle();
	}
	
	/**
	 * Resets the gyro such that it reports a heading of 0 degrees
	 */
	public void resetGyro() {
		gyro.reset();
	}
	
	/**
	 * @return True if the driver may manually drive the robot and false if some other 
	 * 			process is currently utilizing the drivetrain.
	 */
	public boolean getIsManualEnabled() {
		return isManualDriveEnabled;
	}
	
	/**
	 * Sets whether or not the driver is allowed to manually drive the robot.
	 * @param flag The new state of manual drive. 
	 */
	public void setIsManualDriveEnabled(boolean flag) {
		isManualDriveEnabled = false;
	}
}
