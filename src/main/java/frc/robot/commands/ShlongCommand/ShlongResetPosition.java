// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShlongCommand;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shlong;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShlongResetPosition extends InstantCommand {

  private Shlong m_shlong;
  double m_position;

  public ShlongResetPosition(Shlong shlong, double position) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shlong = shlong;
    addRequirements(shlong);
    m_position = position;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shlong.resetPosition(m_position);
  }
}
