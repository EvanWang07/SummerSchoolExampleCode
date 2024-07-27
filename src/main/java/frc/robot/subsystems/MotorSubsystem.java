// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class MotorSubsystem extends SubsystemBase { // Make sure to add the declare the constants!
  private CANSparkMax testMotor;

  public MotorSubsystem() {
      testMotor = new CANSparkMax(1, MotorType.kBrushless);
      testMotor.setInverted(TestMotorConstants.testMotorInvert);
  }

  public void setMotorSpeed(double speed) {
      testMotor.set(speed * TestMotorConstants.testMotorOutput);
  }

  public void brakeMotor() {
      testMotor.set(0);
  }

  @Override
  public void periodic() {

  }
}
