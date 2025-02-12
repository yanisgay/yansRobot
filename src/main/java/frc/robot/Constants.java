// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class  Intake {
    public static final int MotorID = 25;
    public static final int SmartCurrentLimit = 40;
    public static final boolean Inverted = true;
    
  }

  public static class Shlong{
    public static final int LeftMotorID = 26;
    public static final int RightMotorID = 27;
    public static final int SmartCurrentLimit = 40;
    public static final boolean leftInverted = true;
    public static final boolean rightInverted = false;
    public static final double P = 0.65;
    public static final double I = 0;
    public static final double D = 0;
    public static final double PositionConversionFactor = 0.045466 * Math.PI;
  }

   public static class Elevator{
    public static final int MasterMotorID = 5;
    public static final int SlaveMotorID = 6;
    public static final double SensorToMechanismRatio = 12.17;
    public static final double SprocketDiameter = 0.0363728;
    public static final double KP = 3;
    public static final double KI = 0.1;
    public static final double KD = 1;
    public static final double KS = 0;
    public static final double KV = 0;
    public static final double KG = 0.18;
    public static final double SupplyCurrentLimit = 40;
    public static final boolean CurrentLimitEnable = true;
    public static final boolean ForwardSoftLimitEnable = true;
    public static final double ForwardSoftLimitThreshold = 0.85;
    public static final boolean ReverseSoftLimitEnable = true;
    public static final double ReverseSoftLimitThreshold = 0;
   }


   public static class ElevatorStates{
    public static final double FloorPosition = 0.0;
    public static final double AmpPosition = 0.85;
    public static final double MidPosition = 0.4;


   }








}
