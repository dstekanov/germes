package org.itsimulator.germes.app.infra.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Contains utility functions of the general purpose
 *
 * @author Morenets
 */
public class CommonUtil {
	private CommonUtil() {
	}

	/**
	 * Returns not-null unmodifiable copy of the source set
	 *
	 * @param source Set
	 * @return unmodifiableSet
	 */
	public static <T> Set<T> getSafeSet(Set<T> source) {
		return Collections.unmodifiableSet(Optional.ofNullable(source).orElseGet(Collections::emptySet));
	}

	/**
	 * Returns not-null unmodifiable copy of the source list
	 *
	 * @param source List
	 * @return unmodifiableList
	 */
	public static <T> List<T> getSafeList(List<T> source) {
		return Collections.unmodifiableList(Optional.ofNullable(source).orElseGet(Collections::emptyList));
	}
}
