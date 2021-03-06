package net.coderbot.iris.gl.uniform;

import java.util.function.Supplier;

import org.lwjgl.opengl.GL20;

import net.minecraft.util.math.Vec2f;

public class Vector2Uniform extends Uniform {
	private Vec2f cachedValue;
	private final Supplier<Vec2f> value;

	Vector2Uniform(int location, Supplier<Vec2f> value) {
		super(location);

		this.cachedValue = null;
		this.value = value;

	}

	@Override
	public void update() {
		Vec2f newValue = value.get();

		if (cachedValue == null || !newValue.equals(cachedValue)) {
			cachedValue = newValue;
			GL20.glUniform2f(this.location, newValue.x, newValue.y);
		}
	}
}
