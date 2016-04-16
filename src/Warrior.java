
public class Warrior extends Character {
    int damageMod;
	public Warrior(int hp, int mp, int damage, String name, String type) {
		super(hp, mp, damage, name, type);
		
	}
	public  int getHP()
	{
		return HP;
	}
	public int getMP()
	{
		return MP;
	}
	public int getDMG()
	{
		return  Damage;
	}
	public String getName()
	{
		return Name;
	}
	
	public String getType()
	{
		return Type;
	}
	
}
