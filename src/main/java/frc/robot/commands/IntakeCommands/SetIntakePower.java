// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class SetIntakePower extends Command {
 /** Creates a new SetIntakePower. */
  private Intake m_intake;
  double m_percent;
  public SetIntakePower(Intake intake, double percent) {
    m_intake = intake;
    addRequirements(intake);
    m_percent = percent;
    // Use addRequirements() here to declare subsystem dependencies.
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intake.SetPercentage(m_percent);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
