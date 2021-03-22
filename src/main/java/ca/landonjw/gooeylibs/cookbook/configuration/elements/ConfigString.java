package ca.landonjw.gooeylibs.cookbook.configuration.elements;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A {@link ConfigElement} that stores a boolean value.
 *
 * @author landonjw
 */
public class ConfigString extends ConfigElement<String> {

	/**
	 * Default constructor.
	 *
	 * @param path  the path to the value in configuration, periods are used to signify a jump in objects.
	 * @param value the value stored in the element
	 */
	public ConfigString(@Nonnull String path, @Nullable String value) {
		super(path, value);
	}

	/** {@inheritDoc} */
	@Override
	public void setValue(@Nonnull JsonElement data) {
		if(data.isJsonPrimitive() && data.getAsJsonPrimitive().isString()) {
			setValue(data.getAsString());
		}
	}

	/** {@inheritDoc} */
	@Override
	public JsonElement serialize() {
		return (value != null) ? new JsonPrimitive(value) : JsonNull.INSTANCE;
	}

}
