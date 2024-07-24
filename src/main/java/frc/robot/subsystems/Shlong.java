// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.lib.PIDGains;

public class Shlong extends SubsystemBase {

  private CANSparkFlex m_rightMotor;
  private CANSparkFlex m_leftMotor;
  private SparkPIDController m_rightController;
  private SparkPIDController m_leftController;
  private PIDGains m_pidGains;
  
  /** Creates a new Shlong. */
  public Shlong() {
     m_rightMotor = new CANSparkFlex(Constants.Shlong.RightMotorID, MotorType.kBrushless);
     m_rightMotor.getEncoder().setPositionConversionFactor(Constants.Shlong.PositionConversionFactor);
     m_leftMotor = new CANSparkFlex(Constants.Shlong.LeftMotorID, MotorType.kBrushless);
     m_leftMotor.getEncoder().setPositionConversionFactor(Constants.Shlong.PositionConversionFactor);
     
     m_pidGains = new PIDGains(Constants.Shlong.P, Constants.Shlong.I, Constants.Shlong.D);

     m_rightMotor.setSmartCurrentLimit(Constants.Shlong.SmartCurrentLimit);
     m_rightMotor.setInverted(Constants.Shlong.rightInverted);
     m_rightMotor.setIdleMode(IdleMode.kBrake);
     
     m_rightController = m_rightMotor.getPIDController();
     PIDGains.setSparkMaxGains(m_rightController, m_pidGains);
     m_rightMotor.burnFlash();

     m_leftMotor.setSmartCurrentLimit(Constants.Shlong.SmartCurrentLimit);
     m_leftMotor.setInverted(Constants.Shlong.leftInverted);
     m_leftMotor.setIdleMode(IdleMode.kBrake);
     
     m_leftController = m_leftMotor.getPIDController();
     PIDGains.setSparkMaxGains(m_leftController, m_pidGains);
     m_leftMotor.burnFlash();
  }

  public void setPercentage(double percent){
    m_rightMotor.set(percent);
    m_leftMotor.set(percent);
  }

  public void setPosition(double position){
    m_leftController.setReference(position, ControlType.kPosition);
    m_rightController.setReference(position, ControlType.kPosition);

  }

  public void disableMotors(){
    m_rightMotor.set(0);
    m_leftMotor.set(0);
  }

  public void resetPosition(double position){
    m_rightMotor.getEncoder().setPosition(position);
    m_leftMotor.getEncoder().setPosition(position);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("shlongRightPosition", m_rightMotor.getEncoder().getPosition());
    SmartDashboard.putNumber("shlongleftPosition", m_leftMotor.getEncoder().getPosition());
  }
}
