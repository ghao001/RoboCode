package asd;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Rob3 - a robot by (your name here)
 */
public class Rob3 extends Robot
{
	/**
	 * run: Rob3's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.white,Color.white,Color.white); // body,gun,radar
//		setAdjustGunForRobotTurn(true);
		// Robot main loop

		while(true) {
			// Replace the next 4 lines with any behavior you would like
			turnGunRight(20);
			}
			}
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(10);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(125);
		turnRight(135);
		ahead(125);
		
	}
	public void onHitRobot(HitRobotEvent event) {
		back(30);
		ahead(15);
	}
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		ahead(5);
		turnRight(45);
		ahead(45);
	}	
	
	public void onBulletHit(BulletHitEvent event) {
		ahead(15);
		back(15);
	}
	public void onBulletMissed(BulletMissedEvent event) {
		turnRight(90);
		ahead(100);

	
	}
}
