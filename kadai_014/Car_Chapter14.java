package kadai_014;

public class Car_Chapter14 {
	
	private int gear = 1;
	private int speed = 10;
	
	public void gearChange(int afterGear) {
	switch(afterGear) {
	case 1 -> System.out.println("ギア"+ this.gear + "から" + afterGear + "に切り替えました。");
	case 2 -> System.out.println("ギア"+ this.gear + "から" + afterGear + "に切り替えました。");
	case 3 -> System.out.println("ギア"+ this.gear + "から" + afterGear + "に切り替えました。");
	case 4 -> System.out.println("ギア"+ this.gear + "から" + afterGear + "に切り替えました。");
	case 5 -> System.out.println("ギア"+ this.gear + "から" + afterGear + "に切り替えました。");
	default -> System.out.println("ギア"+ this.gear + "から" + afterGear + "に切り替えました。");
	}
   }
	
	public void run(int afterGear){ 
	switch(afterGear) {
	case 1 -> System.out.println("速度は時速10kmです");
	case 2 -> System.out.println("速度は時速20kmです");
	case 3 -> System.out.println("速度は時速30kmです");
	case 4 -> System.out.println("速度は時速40kmです");
	case 5 -> System.out.println("速度は時速50kmです");
	default -> System.out.println("速度は時速10kmです");
	}
	
	}
}
