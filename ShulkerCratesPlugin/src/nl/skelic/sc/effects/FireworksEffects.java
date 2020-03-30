package nl.skelic.sc.effects;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworksEffects {
	
	private static FireworksEffects fireworksEffects;
	
	private ArrayList<Color> colors = new ArrayList<Color>();
	private ArrayList<FireworkEffect.Type> types = new ArrayList<FireworkEffect.Type>();
	
	private FireworksEffects() {}
	
	public void createFireworks(Location location) {
		Firework firework = location.getWorld().spawn(location, Firework.class);
		FireworkMeta fireworkMeta = firework.getFireworkMeta();	
		
		fireworkMeta.setPower(1);
		fireworkMeta.addEffect(FireworkEffect.builder().with(getRandomType()).withColor(getRandomColor()).build());
		firework.setFireworkMeta(fireworkMeta);
		firework.detonate();
	}
	
	public void createFireworks(Location location, Color color) {
		Firework firework = location.getWorld().spawn(location, Firework.class);
		FireworkMeta fireworkMeta = firework.getFireworkMeta();	
		
		fireworkMeta.setPower(1);
		fireworkMeta.addEffect(FireworkEffect.builder().with(Type.BALL).withColor(color).build());
		firework.setFireworkMeta(fireworkMeta);
		firework.detonate();
	}
	
	public void createFireworks(Location location, Color color, Type type) {
		Firework firework = location.getWorld().spawn(location, Firework.class);
		FireworkMeta fireworkMeta = firework.getFireworkMeta();	
		
		fireworkMeta.setPower(1);
		fireworkMeta.addEffect(FireworkEffect.builder().with(type).withColor(color).build());
		firework.setFireworkMeta(fireworkMeta);
		firework.detonate();
	}
	
	public void addColors() {
		colors.add(Color.WHITE);
		colors.add(Color.PURPLE);
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.AQUA);
		colors.add(Color.BLUE);
		colors.add(Color.FUCHSIA);
		colors.add(Color.GRAY);
		colors.add(Color.LIME);
		colors.add(Color.MAROON);
		colors.add(Color.YELLOW);
		colors.add(Color.SILVER);
		colors.add(Color.TEAL);
		colors.add(Color.ORANGE);
		colors.add(Color.OLIVE);
		colors.add(Color.NAVY);
		colors.add(Color.BLACK);
	}
	
	public void addTypes() {
		types.add(FireworkEffect.Type.BURST);
		types.add(FireworkEffect.Type.BALL);
		types.add(FireworkEffect.Type.BALL_LARGE);
		types.add(FireworkEffect.Type.CREEPER);
		types.add(FireworkEffect.Type.STAR);
	}
	
	public FireworkEffect.Type getRandomType() {
		int size = types.size();
		Random random = new Random();
		FireworkEffect.Type randomType = types.get(random.nextInt(size));
		
		return randomType;
	}
	
	public Color getRandomColor() {
		int size = types.size();
		Random random = new Random();
		Color randomColor = colors.get(random.nextInt(size));
		
		return randomColor;
	}
	
	public static FireworksEffects getFireworksEffects() {
		if(fireworksEffects == null) {
			fireworksEffects = new FireworksEffects();
		}
		
		return fireworksEffects;
	}
	
}
