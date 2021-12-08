package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//blah blah blah

@TeleOp
public class DriverControlledMecanum extends LinearOpMode {


    private DcMotorSimple Intake = null;

    private DcMotorSimple Arm = null;

    CRServo Carousel;

    @Override
    public void runOpMode() {

        DcMotor motorLF = hardwareMap.get(DcMotor.class, "motorFrontLeft");
        DcMotor motorLB = hardwareMap.get(DcMotor.class, "motorBackLeft");
        DcMotor motorRF = hardwareMap.get(DcMotor.class, "motorFrontRight");
        DcMotor motorRB = hardwareMap.get(DcMotor.class, "motorBackRight");

        //Intake
        Intake = hardwareMap.get(DcMotorSimple.class, "intake");

        Intake.setDirection(DcMotorSimple.Direction.FORWARD);

        //Arm
        Arm = hardwareMap.get(DcMotorSimple.class, "arm");

        Arm.setDirection(DcMotorSimple.Direction.FORWARD);


        //Carousel
        Carousel = hardwareMap.get(CRServo.class, "carousel");

        Carousel.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        if (isStopRequested()) return;


        while (opModeIsActive()) {
            double y = gamepad1.left_stick_x;
            double x = gamepad1.left_stick_y * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;


            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x - rx) / denominator;
            double backLeftPower = (y - x - rx) / denominator;
            double frontRightPower = (y - x + rx) / denominator;
            double backRightPower = (y + x + rx) / denominator;


            motorLF.setPower(frontLeftPower);
            motorLB.setPower(backLeftPower);
            motorRF.setPower(frontRightPower);
            motorRB.setPower(backRightPower);

            //Intake
            double intakePower = gamepad2.left_stick_y;

            Intake.setPower(intakePower);

            //Arm
            double armPower = gamepad2.right_stick_y;

            Arm.setPower(armPower);

            //Carousel


            if (gamepad2.a == true) {
                Carousel.setPower(-1);

            }
            else {
                Carousel.setPower(0);

                }





            telemetry.addData("LF Power:", motorLF.getPower());
            telemetry.addData("LB Power:", motorLB.getPower());
            telemetry.addData("RF Power:", motorRF.getPower());
            telemetry.addData("RB Power:", motorRB.getPower());
            telemetry.addData("Intake Power: ", Intake.getPower());
            telemetry.addData("Arm Power:", Arm.getPower());
            telemetry.update();



        }
    }
}
