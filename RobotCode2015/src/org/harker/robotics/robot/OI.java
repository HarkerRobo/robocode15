package org.harker.robotics.robot;

import org.harker.robotics.commands.ManualDriveCommand;
import org.harker.robotics.harkerrobolib.wrappers.GamepadWrapper;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public GamepadWrapper gamepad1 = new GamepadWrapper(RobotMap.Gamepad.GAMEPAD1_PORT);
    private ManualDriveCommand manualDrive;
    
    private static OI oi;
    
    private OI() {
    	manualDrive = new ManualDriveCommand();
    }
    
    public static OI getInstance() {
    	if (oi == null) oi = new OI();
    	return oi;
    }
    
    public static void initialize() {
    	if (oi == null)
    		oi = new OI();
    }
}

