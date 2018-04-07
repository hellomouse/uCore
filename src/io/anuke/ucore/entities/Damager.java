package io.anuke.ucore.entities;

public interface Damager{
	DamageType type = DamageType.None;
	int getDamage();
}
