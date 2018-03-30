package io.anuke.ucore.function;

import com.badlogic.gdx.graphics.Color;

import io.anuke.ucore.core.Effects.Effect;

public interface EffectProvider{
	void createEffect(Effect effect, Color color, float x, float y, float rotation, int dimension);
}
