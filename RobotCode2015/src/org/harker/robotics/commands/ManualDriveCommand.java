package org.harker.robotics.commands;

import org.harker.robotics.robot.OI;
import org.harker.robotics.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives the robot using the controller's input. 
 */
public class ManualDriveCommand extends Command {

	private Drivetrain drivetrain;
	private OI oi;
	
    public ManualDriveCommand() {
    	drivetrain = Drivetrain.getInstance();
    	oi = OI.getInstance();
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.drive(oi.gamepad1.getLeftX(), oi.gamepad1.getLeftY(),
    						oi.gamepad1.getRightX(), drivetrain.getCurrentHeading());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ! drivetrain.getIsManualEnabled();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.setIsManualDriveEnabled(false);
    }
}
