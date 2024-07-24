// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class CoolSetIntakePower extends InstantCommand {
  private Intake m_intake;
  double m_percent;
  /** Creates a new CoolSetIntakePower. */
  public CoolSetIntakePower(Intake intake, double percent) {
    m_intake = intake;
    addRequirements(intake);
    m_percent=percent;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intake.SetPercentage(m_percent);
  }
}
