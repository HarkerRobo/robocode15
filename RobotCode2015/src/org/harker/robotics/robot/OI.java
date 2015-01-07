package org.harker.robotics.robot;

import org.harker.robotics.commands.ExampleCommand;
import org.harker.robotics.harkerrobolib.wrappers.GamepadWrapper;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public GamepadWrapper gamepad1 = new GamepadWrapper(RobotMap.Gamepad.GAMEPAD1_PORT);
    private static OI oi;
    
    private OI() {
    	
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

