
import de.yadrone.base.IARDrone;
import de.yadrone.base.navdata.AttitudeListener;
import de.yadrone.base.navdata.BatteryListener;

public class AttitudeListenerTest
{

	public AttitudeListenerTest(IARDrone drone)
	{
		drone.getNavDataManager().addAttitudeListener(new AttitudeListener() {
			
			public void attitudeUpdated(float pitch, float roll, float yaw)
			{
		    	//System.out.println("Pitch: " + pitch + " Roll: " + roll + " Yawn: " + yawn);
			}

			public void attitudeUpdated(float pitch, float roll) { }
			public void windCompensation(float pitch, float roll) { }
		});
		
		drone.getNavDataManager().addBatteryListener(new BatteryListener() {
			
			public void batteryLevelChanged(int percentage)
			{
				//System.out.println("Battery: " + percentage + " %");
			}
			
			public void voltageChanged(int vbat_raw) { }
		});
	}

}
