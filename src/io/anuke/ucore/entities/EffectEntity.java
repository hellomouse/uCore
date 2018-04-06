package io.anuke.ucore.entities;

import com.badlogic.gdx.graphics.Color;

import io.anuke.ucore.core.Effects;
import io.anuke.ucore.core.Effects.Effect;

public class EffectEntity extends TimedEntity{
	public Effect renderer;
	public Color color = Color.WHITE;
	public float rotation = 0f;
	public int dimension;
	
	public EffectEntity(Effect effect, int dimension){
		renderer = effect;
		lifetime = effect.lifetime;
		this.dimension = dimension;
	}
	
	public EffectEntity(Effect effect, Color color, float rotation, int dimension){
		this(effect,dimension);
		this.color = color;
		this.rotation = rotation;
	}
	
	@Override
	public void drawOver(){
		Effects.renderEffect(id, renderer, color, time, rotation, x, y);
	}
	
}
