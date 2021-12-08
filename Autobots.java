package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class Autobots extends LinearOpMode{

    private DcMotor LB, LF, RB, RF;
    private DcMotorSimple intake = null;
    private DcMotorSimple carousel = null;

    @Override
    public void runOpMode()

    {

        LF = hardwareMap.get(DcMotor.class, "motorFrontLeft");
        LB = hardwareMap.get(DcMotor.class, "motorBackLeft");
        RF = hardwareMap.get(DcMotor.class, "motorFrontRight");
        RB = hardwareMap.get(DcMotor.class, "motorBackRight");
        intake = hardwareMap.get(DcMotorSimple.class, "intake");
        carousel = hardwareMap.get(DcMotorSimple.class, "carousel");



        carousel.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
////        // FORWARD
//                move(-1,1,-1,1, 0 ,800);
////        //LEFT
//                move(0, 0, 1, 1 , 0, 1750);
////        //INTAKE
//                move(-1,1,-1,1, 0 ,1000);
//                move(0,0,0,0,1,1900);




        //Carousel
        move(0,0,0,0,0,1, 5000);
        //forward
        move(-1,1,1,-1, 0 ,0, 1170);
        //left
        move(-1,-1,-1,-1,0,0,967);
        //forward
        move(-1,1,1,-1, 0 ,0,900);
        //intake
        move(0,0,0,0, 1 ,0,550);




    }
    public void move(double RB, double RF, double LB, double LF, double intake, double carousel,  int sleepMS)

    {

        this.LF.setPower(LF);
        this.RF.setPower(RF);
        this.LB.setPower(LB);
        this.RB.setPower(RB);
        this.intake.setPower(intake);
        this.carousel.setPower(carousel);
        sleep(sleepMS);
    }


}
