// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private CANSparkFlex m_motor;
  public Intake() {
    m_motor = new CANSparkFlex(Constants.Intake.MotorID, MotorType.kBrushless);

    m_motor.setSmartCurrentLimit(Constants.Intake.SmartCurrentLimit);
    m_motor.setInverted(Constants.Intake.Inverted);
    m_motor.setIdleMode(IdleMode.kBrake);
    m_motor.burnFlash();
  }


  public void SetPercentage(double percent){
    m_motor.set(percent);
  }

  public void DisableMotors(){
    m_motor.set(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
