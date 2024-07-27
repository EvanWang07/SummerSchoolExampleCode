// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RunForTen extends Command {
  private MotorSubsystem m_subsystem;
  private Timer tenSec = new Timer(); // Notice that I moved the Timer object declaration here, which seemed to solve the earlier issues

  public RunForTen(MotorSubsystem subsystem) {
    m_subsystem = subsystem;
    tenSec.start();
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      tenSec.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_subsystem.setMotorSpeed(1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      m_subsystem.brakeMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return tenSec.hasElapsed(10.0);
  }
}
