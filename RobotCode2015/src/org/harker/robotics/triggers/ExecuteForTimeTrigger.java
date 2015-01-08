package org.harker.robotics.triggers;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExecuteForTimeTrigger extends Trigger {
    
	private Command command;
	private double durationTime;
	private double startTime;
	
	
	public ExecuteForTimeTrigger(Command c, double duration)
	{
		command = c;
		durationTime = duration;
		startTime = Timer.getFPGATimestamp();
		command.start();
		cancelWhenActive(c);
	}
	
    public boolean get() {
        return Timer.getFPGATimestamp() - startTime >= durationTime;
    }
}
