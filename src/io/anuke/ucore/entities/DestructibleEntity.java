package io.anuke.ucore.entities;

import io.anuke.ucore.util.Mathf;

import java.util.HashMap;
import java.util.Map;


public abstract class DestructibleEntity extends SolidEntity{
	public transient int maxhealth;
	public transient boolean dead;
	public float health;
	public Map<DamageType,Float> damageTypeDamageModifier = new HashMap<DamageType,Float>(){{
		put(DamageType.None,1f);
	}};
	
	public void onHit(SolidEntity entity){}
	public void onDeath(){}
	
	public boolean isDead(){
		return dead;
	}
	
	@Override
	public boolean collides(SolidEntity other){
		return other instanceof Damager;
	}
	
	@Override
	public void collision(SolidEntity other, float x, float y){
		if(other instanceof Damager){
			onHit(other);
			Damager dam =(Damager) other;
			damage(dam.getDamage(),dam.type);
		}
	}

	public void damage(float amount, DamageType damageType){
		health -= (amount*damageTypeDamageModifier.getOrDefault(damageType,1f));
		if(health <= 0 && !dead){
			onDeath();
			dead = true;
		}
	}
	
	public void damage(float amount){
		health -= amount;
		if(health <= 0 && !dead){
			onDeath();
			dead = true;
		}
	}
	
	public void setMaxHealth(int health){
		maxhealth = health;
		heal();
	}
	
	public void clampHealth(){
		health = Mathf.clamp(health, 0, maxhealth);
	}
	
	public float healthfrac(){
		return (float)health/maxhealth;
	}
	
	public void heal(){
		dead = false;
		health = maxhealth;
	}
}
