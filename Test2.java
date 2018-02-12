package HGL;

import robocode.*;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import robocode._RobotBase;

import java.awt.*;
import java.util.*;

public class Test2 extends Robot
{
    boolean movingForward;
    double bearingFromGun;
    double absoluteBearing;
    Random rand;
    String trackName;
    public void run()
    {
        rand=new Random();
        trackName=null;
        setAdjustGunForRobotTurn(true);
        movingForward=true;
        int i=0;
        while(true)
        {
            turnGunRight(360);
            turnRight(bearingFromGun);
            ahead(30+rand.nextInt(30));
            turnGunRight(bearingFromGun);

        }
    }
    public void onScannedRobot(ScannedRobotEvent e) 
    {
        absoluteBearing = getHeading() + e.getBearing();
		bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
        if (trackName == null) {
			trackName = e.getName();
		}
        if (Math.abs(bearingFromGun) <= 3) {
			turnGunRight(bearingFromGun);
            fire(3);
            if(e.getDistance()>300)
            {
                turnRight(e.getBearing());
                ahead(e.getDistance()-200);
                return;
            }
        }
        else {
			turnGunRight(bearingFromGun);
		}
        if (bearingFromGun == 0) {
			scan();
        }
    }
    public void onHitWall(HitWallEvent e) 
	{
		if (movingForward) {
			back(150);
			movingForward = false;
		} else {
			ahead(150);
			movingForward = true;
		}
	}
    public void onHitRobot(HitRobotEvent e) 
    {
		if (trackName != null && !trackName.equals(e.getName())) 
        {
			out.println("Tracking " + e.getName() + " due to collision");
		}
		trackName = e.getName();

		turnGunRight(bearingFromGun);
		fire(3);
		back(50);
	}
        
}
