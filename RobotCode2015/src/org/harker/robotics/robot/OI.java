package org.harker.robotics.robot;

import org.harker.robotics.commands.ManualDriveCommand;
import org.harker.robotics.harkerrobolib.wrappers.GamepadWrapper;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static GamepadWrapper gamepad1 = new GamepadWrapper(RobotMap.Gamepad.GAMEPAD1_PORT);
    private ManualDriveCommand manualDrive;
    
    private static OI oi;
    
    private OI() {
    	manualDrive = new ManualDriveCommand();
    	manualDrive.start();
    	System.err.println("Manual Drive Command Initialized");
    }
    
    public static OI getInstance() {
    	if (oi == null) oi = new OI();
    	return oi;
    }
    
    public static void initialize() {
    	System.err.println("OI Initialized");
    	if (oi == null)
    		oi = new OI();
    }
}

