// Source File Name:   CollectionUtils.java

package com.iava.utils;

import java.util.*;

// Referenced classes of package jbc.util:
//            ObjectUtils

public abstract class CollectionUtils {

	public CollectionUtils() {
	}

	public static boolean isEmpty(Collection collection) {
		return collection == null || collection.isEmpty();
	}

	public static boolean isEmpty(Map map) {
		return map == null || map.isEmpty();
	}

	public static boolean containsInstance(Collection collection, Object element) {
		if (collection != null) {
			for (Iterator it = collection.iterator(); it.hasNext();) {
				Object candidate = it.next();
				if (candidate == element)
					return true;
			}

		}
		return false;
	}

	public static boolean contains(Iterator iterator, Object element) {
		if (iterator != null)
			while (iterator.hasNext()) {
				Object candidate = iterator.next();
				if (ObjectUtils.nullSafeEquals(candidate, element))
					return true;
			}
		return false;
	}

	public static boolean contains(Enumeration enumeration, Object element) {
		if (enumeration != null)
			while (enumeration.hasMoreElements()) {
				Object candidate = enumeration.nextElement();
				if (ObjectUtils.nullSafeEquals(candidate, element))
					return true;
			}
		return false;
	}

	public static boolean hasUniqueObject(Collection collection) {
		if (isEmpty(collection))
			return false;
		boolean hasCandidate = false;
		Object candidate = null;
		for (Iterator it = collection.iterator(); it.hasNext();) {
			Object elem = it.next();
			if (!hasCandidate) {
				hasCandidate = true;
				candidate = elem;
			} else if (candidate != elem)
				return false;
		}

		return true;
	}

	public static Object findValueOfType(Collection collection, Class type)
			throws IllegalArgumentException {
		if (isEmpty(collection))
			return null;
		Class typeToUse = ((Class) (type == null ? java.lang.Object.class
				: type));
		Object value = null;
		for (Iterator it = collection.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (typeToUse.isInstance(obj)) {
				if (value != null)
					throw new IllegalArgumentException((new StringBuilder(
							"More than one value of type ["))
							.append(typeToUse.getName()).append("] found")
							.toString());
				value = obj;
			}
		}

		return value;
	}

	public static Object findValueOfType(Collection collection, Class types[])
			throws IllegalArgumentException {
		if (isEmpty(collection) || ObjectUtils.isEmpty(types))
			return null;
		for (int i = 0; i < types.length; i++) {
			Object value = findValueOfType(collection, types[i]);
			if (value != null)
				return value;
		}

		return null;
	}

	public static List arrayToList(Object source) {
		return Arrays.asList(ObjectUtils.toObjectArray(source));
	}

	public static void mergePropertiesIntoMap(Properties props, Map map) {
		if (map == null)
			throw new IllegalArgumentException("Map must not be null");
		if (props != null) {
			String key;
			for (Enumeration en = props.propertyNames(); en.hasMoreElements(); map
					.put(key, props.getProperty(key)))
				key = (String) (String) en.nextElement();

		}
	}

	public static boolean containsAny(Collection source, Collection candidates) {
		if (isEmpty(source) || isEmpty(candidates))
			return false;
		for (Iterator it = candidates.iterator(); it.hasNext();)
			if (source.contains(it.next()))
				return true;

		return false;
	}

	public static Object findFirstMatch(Collection source, Collection candidates) {
		if (isEmpty(source) || isEmpty(candidates))
			return null;
		for (Iterator it = candidates.iterator(); it.hasNext();) {
			Object candidate = it.next();
			if (source.contains(candidate))
				return candidate;
		}

		return null;
	}
}
