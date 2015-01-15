package org.harker.robotics.commands;

import org.harker.robotics.robot.OI;
import org.harker.robotics.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives the robot using the controller's input. 
 */
public class ManualDriveCommand extends Command {
	
    public ManualDriveCommand() {
//    	System.err.println("Hello, world!");
//    	drivetrain = Drivetrain.getInstance();
//    	System.err.println("Hello, world2!");
//        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.err.println("Hello, world3!");
//    	System.err.println("Gyro: " + drivetrain.getCurrentHeading());
//    	drivetrain.drive(OI.gamepad1.getLeftX(), OI.gamepad1.getLeftY(),  OI.gamepad1.getRightX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //! drivetrain.getIsManualEnabled();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//drivetrain.setIsManualDriveEnabled(false);
    }
}
