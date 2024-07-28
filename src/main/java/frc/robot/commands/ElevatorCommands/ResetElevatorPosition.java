// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ElevatorCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Elevator;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ResetElevatorPosition extends InstantCommand {
 private Elevator m_elevator;
  double m_position;

  public ResetElevatorPosition(Elevator elevator, double position) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevator = elevator;
    addRequirements(elevator);
    m_position = position;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_elevator.resetPosition(m_position);
  }
}

