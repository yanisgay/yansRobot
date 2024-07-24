// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.lib;

import com.revrobotics.SparkPIDController;

/** Add your docs here. */
public class PIDGains {
    public final double p;
    public final double i;
    public final double d;

    public PIDGains(double _p, double _i, double _d) {
    p = _p;
    i = _i;
    d = _d;
    }

    public static void setSparkMaxGains(SparkPIDController controller, PIDGains _gains) {
    controller.setP(_gains.p);
    controller.setI(_gains.i);
    controller.setD(_gains.d);
  }
}