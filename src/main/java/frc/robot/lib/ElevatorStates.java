// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.lib;

import frc.robot.Constants;

/** Add your docs here. */
public enum ElevatorStates {
    FLOOR(Constants.ElevatorStates.FloorPosition),
    MID(Constants.ElevatorStates.MidPosition),
    AMP(Constants.ElevatorStates.AmpPosition);
    
    private double position;
    ElevatorStates(double position){
        this.position = position;
    }

    public double getPosition(){
        return position;
    }
};
