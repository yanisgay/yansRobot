// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.commands.IntakeCommands.CoolSetIntakePower;
import frc.robot.commands.IntakeCommands.DisableMotors;
import frc.robot.commands.ShlongCommand.DisableShlongMotors;
import frc.robot.commands.ShlongCommand.SetShlongPosition;
import frc.robot.commands.ShlongCommand.ShlongResetPosition;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shlong;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private CommandPS5Controller joystick;
  Intake m_intake = new Intake();
  Shlong m_shlong = new Shlong();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    joystick = new CommandPS5Controller(0);
    joystick.square().onTrue(new CoolSetIntakePower(m_intake, 0.5));
    joystick.triangle().onTrue(new DisableMotors(m_intake));
    joystick.circle().onTrue(new DisableShlongMotors(m_shlong));
    joystick.cross().onTrue(new SetShlongPosition(m_shlong, 0.15));
    SmartDashboard.putData("resetShlongsPosition", new ShlongResetPosition(m_shlong,0));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
