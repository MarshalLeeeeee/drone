
import de.yadrone.base.IARDrone;
import de.yadrone.base.command.CommandManager;
import de.yadrone.base.command.LEDAnimation;

public class CommanderTest
{

	private IARDrone drone;

	public CommanderTest(IARDrone drone)
	{
		this.drone = drone;
	}

	public void animateLEDs()
	{
		drone.getCommandManager().setLedsAnimation(LEDAnimation.BLINK_ORANGE, 3, 10);
	}
	
	public void takeOffAndLand()
	{
		drone.getCommandManager().takeOff();
		drone.getCommandManager().waitFor(5000);
		drone.getCommandManager().landing();
	}
	
	public void leftRightForwardBackward()
	{
		final CommandManager cmd = drone.getCommandManager();
		final int speed = 30; // percentage of max speed
			
		cmd.takeOff().doFor(5000);
		
		cmd.goLeft(speed).doFor(1000);
		cmd.hover().doFor(2000);
		
		cmd.goRight(speed).doFor(1000);
		cmd.hover().doFor(2000);
		
		cmd.forward(speed).doFor(2000);
		cmd.hover().doFor(1000);
		
		cmd.backward(speed).doFor(2000);
		cmd.hover().doFor(2000);
		
		cmd.landing();
		
		// alternative: asynchronous call
//		cmd.takeOff();
//		cmd.schedule(5000, new Runnable() { // schedule to be executed in 5 secs
//			public void run()
//			{
//				cmd.goLeft(speed);
//				// [...]
//			}			
//		});
	}
	

	public void RectangleTrace()
	{
		final CommandManager cmd = drone.getCommandManager();
		
		cmd.takeOff().doFor(3000);
		cmd.hover().doFor(3000);
		
		cmd.forward(20).doFor(2000);
		cmd.hover().doFor(3000);
		cmd.spinLeft(40).doFor(2000);
		cmd.hover().doFor(2000);
		
		cmd.forward(20).doFor(2000);
		cmd.hover().doFor(3000);
		cmd.spinLeft(40).doFor(2000);
		cmd.hover().doFor(2000);
		
		cmd.forward(20).doFor(2000);
		cmd.hover().doFor(3000);
		cmd.spinLeft(40).doFor(2000);
		cmd.hover().doFor(2000);
		
		cmd.forward(20).doFor(2000);
		cmd.hover().doFor(3000);
		cmd.spinLeft(40).doFor(2000);
		cmd.hover().doFor(2000);
		
		cmd.landing().doFor(3000);
	}
	
	public void TriangleTrace()
	{
		final CommandManager cmd = drone.getCommandManager();
		
		cmd.takeOff().doFor(3000);
		cmd.hover().doFor(3000);
		
		cmd.forward(20).doFor(2000);
		cmd.hover().doFor(3000);
		
		cmd.spinLeft(40).doFor(3000);
		cmd.hover().doFor(2000);
		
		cmd.forward(20).doFor(2000);
		cmd.hover().doFor(3000);
		
		cmd.spinLeft(40).doFor(3000);
		cmd.hover().doFor(2000);
		
		cmd.forward(20).doFor(2000);
		cmd.hover().doFor(3000);
		
		cmd.spinLeft(40).doFor(3000);
		cmd.hover().doFor(2000);
		
		cmd.landing().doFor(3000);
	}
	
	public void CircleTrace()
	{
		final CommandManager cmd = drone.getCommandManager();
		
		cmd.takeOff().doFor(3000);
		cmd.hover().doFor(3000);
		
		for(int n = 0 ; n < 360 ; n++)
		{
			cmd.forward(10).doFor(25);
			cmd.spinLeft(100).doFor(10);
		}
		cmd.hover().doFor(3000);
		
		cmd.landing().doFor(3000);
	}
	
	public void EightTrace()
	{
		final CommandManager cmd = drone.getCommandManager();
		
		cmd.takeOff().doFor(3000);
		cmd.hover().doFor(1000);
		
		for(int n = 0 ; n < 270 ; n++)
		{
			cmd.forward(10).doFor(25);
			cmd.spinLeft(100).doFor(10);
		}
		cmd.hover().doFor(1000);
		
		cmd.forward(10).doFor(2864);
		cmd.hover().doFor(1000);
		
		for(int n = 0 ; n < 270 ; n++)
		{
			cmd.forward(10).doFor(25);
			cmd.spinRight(100).doFor(10);
		}
		cmd.hover().doFor(1000);
		
		cmd.forward(10).doFor(2864);
		cmd.hover().doFor(1000);
		
		cmd.landing().doFor(3000);
		
	}
}
