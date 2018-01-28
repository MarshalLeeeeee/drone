

import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;
import de.yadrone.base.command.LEDAnimation;
import de.yadrone.base.exception.ARDroneException;
import de.yadrone.base.exception.IExceptionListener;
import de.yadrone.base.navdata.AttitudeListener;

public class TestMain
{

	public static void main(String[] args)
	{
		IARDrone drone = null;
		try
		{
			// Tutorial Section 1
			drone = new ARDrone();
			drone.addExceptionListener(new IExceptionListener() {
				public void exeptionOccurred(ARDroneException exc)
				{
					exc.printStackTrace();
				}
			});
			
			drone.start();
			
			// Tutorial Section 2
			new AttitudeListenerTest(drone);
			
			// Tutorial Section 3
  			new VideoListener(drone);
			
			// Tutorial Section 4
			//do not cancel the comment right away.when you cancel the comment?ARDrone will take off! Before do this,ensure your ARDrone is in a broad environment
 			CommanderTest commander = new CommanderTest(drone);
 			//commander.RectangleTrace();
 			//commander.TriangleTrace();
 			//commander.CircleTrace();
 			commander.EightTrace();
  			while(true)
  			{
  				System.out.println("Enter a number\n");
  				int n = System.in.read();
  				if (n == 49)
  				{
  					commander.RectangleTrace();
  				}
  				if (n == 50)
  				{
  					commander.TriangleTrace();
  				}
  				if (n == 51)
  				{
  					commander.CircleTrace();
  				}
  				if (n == 52)
  				{
  					commander.EightTrace();
  				}
  			}
 			
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		finally
		{
			if (drone != null)
				drone.stop();

			System.exit(0);
		}
	}
}
