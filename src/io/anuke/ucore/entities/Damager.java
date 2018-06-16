package io.anuke.ucore.entities;

public interface Damager{
	DamageType type = DamageType.none;
	int getDamage();
}
