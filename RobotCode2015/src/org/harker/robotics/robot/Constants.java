package org.harker.robotics.robot;

import edu.wpi.first.wpilibj.Preferences;

/**
 *
 * @author atierno
 * @author Manan
 */
public final class Constants {

    private Constants() {}

    private static Preferences prefs;

    public static void updateConstants () {
        if (prefs == null)
            initializePreferences();
        General.updateConstants();
        Drivetrain.updateConstants();
    }

    private static void initializePreferences () {
        prefs = Preferences.getInstance();
    }
    
    public static class General {
        public static boolean DEBUG;
        
        private static void updateConstants() {
            DEBUG = prefs.getBoolean("gn_debug", false);
        }
    }

    public static class Drivetrain {
        public static double LEFT_ENC_DIST_PER_PULSE, RIGHT_ENC_DIST_PER_PULSE;
        public static double LOW_SPEED_SCALING, HIGH_SPEED_SCALING;
        public static double ENCODER_RATE_SCALING;
        public static double MANUAL_OVERRIDE_RESET_THRESHOLD, MANUAL_OVERRIDE_THRESHOLD;
        public static double TURN_TO_ANGLE_ERROR;
        public static double DRIVE_TO_POINT_SCALING, DRIVE_TO_POINT_THRESHOLD;
        public static boolean LEFT_BACK_MOTOR_FLIPPED, LEFT_FRONT_MOTOR_FLIPPED, RIGHT_BACK_MOTOR_FLIPPED, RIGHT_FRONT_MOTOR_FLIPPED;

        private static void updateConstants () { //TODO: Test for proper values
            // -----------------------------
            //	Encoder Distance per Pulse:
            //	    experimental values: ticks per cycle * distance moved (manually) / encoder pulses
            //      This should be in meters per second
            // -----------------------------
            LEFT_ENC_DIST_PER_PULSE = prefs.getDouble("dt_leftEncDistPerPulse", 1 * 2 / 3);
            RIGHT_ENC_DIST_PER_PULSE = prefs.getDouble("dt_rightEncDistPerPulse", 1 * 2 / 3);

            //Scaling inputs from the gamepad (high speed and low speed).
            LOW_SPEED_SCALING = prefs.getDouble("dt_lowSpeedScaling", .5);
            HIGH_SPEED_SCALING = prefs.getDouble("dt_highSpeedScaling", 1);

            //Scaling for the encoders.
            ENCODER_RATE_SCALING = prefs.getDouble("dt_encoderRateScaling", 2);

            //Thresholds before returning control of drivetrain back to the user.
            MANUAL_OVERRIDE_RESET_THRESHOLD = prefs.getDouble("dt_manualOverrideResetThreshold", .1);
            MANUAL_OVERRIDE_THRESHOLD = prefs.getDouble("dt_manualOverrideThreshold", .5);

            //The accepted error when attempting to turn to a given angle.
            TURN_TO_ANGLE_ERROR = prefs.getDouble("dt_turnToAngleError", Math.PI / 12);

            //Scale factor for the drive to point command and distance threshold for offset.
            DRIVE_TO_POINT_SCALING = prefs.getDouble("dt_driveToPointScaling", .1);
            DRIVE_TO_POINT_THRESHOLD = prefs.getDouble("dt_driveToPointThreshold", .1);

            //Whether or not to flip the directions of the motors.
            LEFT_BACK_MOTOR_FLIPPED = prefs.getBoolean("dt_leftBackFlipped", false);
            LEFT_FRONT_MOTOR_FLIPPED = prefs.getBoolean("dt_leftFrontFlipped", false);
            RIGHT_BACK_MOTOR_FLIPPED = prefs.getBoolean("dt_rightBackFlipped", false);
            RIGHT_FRONT_MOTOR_FLIPPED = prefs.getBoolean("dt_rightFrontFlipped", false);
        }
    }
}

