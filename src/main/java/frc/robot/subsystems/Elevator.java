// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  private TalonFX m_slaveMotor;
  private TalonFX m_masterMotor;
  private TalonFXConfiguration m_motorConfiguration;
  private PositionVoltage m_positionControl = new PositionVoltage(0);
  public Elevator() {
    m_masterMotor = new TalonFX(Constants.Elevator.MasterMotorID);
    m_slaveMotor = new TalonFX(Constants.Elevator.SlaveMotorID);
    m_motorConfiguration = new TalonFXConfiguration();
    m_motorConfiguration.CurrentLimits
    .withSupplyCurrentLimitEnable(Constants.Elevator.CurrentLimitEnable)
    .withSupplyCurrentLimit(Constants.Elevator.SupplyCurrentLimit);

    m_motorConfiguration.SoftwareLimitSwitch
    .withForwardSoftLimitEnable(Constants.Elevator.ForwardSoftLimitEnable)
    .withForwardSoftLimitThreshold(Constants.Elevator.ForwardSoftLimitThreshold)
    .withReverseSoftLimitEnable(Constants.Elevator.ReverseSoftLimitEnable)
    .withReverseSoftLimitThreshold(Constants.Elevator.ReverseSoftLimitThreshold);

    m_motorConfiguration.Feedback.withSensorToMechanismRatio(Constants.Elevator.SensorToMechanismRatio);
    m_motorConfiguration.MotorOutput.withNeutralMode(NeutralModeValue.Brake);

    m_motorConfiguration.Slot0.withKP(Constants.Elevator.KP);
    m_motorConfiguration.Slot0.withKI(Constants.Elevator.KI);
    m_motorConfiguration.Slot0.withKD(Constants.Elevator.KD);
    m_motorConfiguration.Slot0.withKS(Constants.Elevator.KS);
    m_motorConfiguration.Slot0.withKV(Constants.Elevator.KV);
    m_motorConfiguration.Slot0.withKG(Constants.Elevator.KG);
    m_motorConfiguration.Slot0.withGravityType(GravityTypeValue.Elevator_Static);

    m_slaveMotor.setControl(new Follower(Constants.Elevator.MasterMotorID, false));
    m_masterMotor.getConfigurator().apply(m_motorConfiguration);
    m_slaveMotor.getConfigurator().apply(m_motorConfiguration);

  }

  public void setPercentage(double percent){
    m_masterMotor.set(percent);
  }

  public void setPosition(double position){
    m_masterMotor.setControl(m_positionControl.withSlot(0).withPosition(position));
  }

  public void disableMotors(){
    m_masterMotor.disable();
  }

  public double unitsToRotations(double position){
    return (position/(Constants.Elevator.SprocketDiameter*Math.PI));

  }

  public double rotationToUnits(double rotation){
    return (rotation*Constants.Elevator.SprocketDiameter*Math.PI);
  }

  public void resetPosition(double position){
    m_masterMotor.setPosition(unitsToRotations(position));

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}


// dim * PI * Rotation = position
// Rotation = position / (dim * PI)