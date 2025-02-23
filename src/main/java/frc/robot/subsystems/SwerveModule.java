package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {
    private final SparkMax driveSparkMax;
    private final SparkMax turningSparkMax;
    
    private final RelativeEncoder driveEncoder;
    private final AbsoluteEncoder turnEncoder;
    
    private final SparkClosedLoopController drivingClosedLoopController;
    private final SparkClosedLoopController turningClosedLoopController;

    private double chassisAngularOffset = 0;
    private SwerveModuleState targetState = new SwerveModuleState(0, new Rotation2d());

    public SwerveModule(int driveId, int turningId, double anuglarOffset){
        driveSparkMax = new SparkMax(driveId, MotorType.kBrushless);
        turningSparkMax = new SparkMax(turningId, MotorType.kBrushless);

        driveEncoder = driveSparkMax.getEncoder();
        turnEncoder = turningSparkMax.getAbsoluteEncoder();

        drivingClosedLoopController = driveSparkMax.getClosedLoopController();
        turningClosedLoopController = turningSparkMax.getClosedLoopController();


    }
}
//02.21.2025