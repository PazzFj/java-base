package net.pazz.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author: Peng Jian
 * @date: 2018/6/15 10:39
 * @description:
 */
public final class Argument {

    private Argument() {}

    public static void notNull(Object object, String message, Object... args) {
        if (object == null)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void notEmpty(Collection<?> object, String message, Object... args) {
        if (object == null || object.size() == 0)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void notEmpty(Map<?, ?> object, String message, Object... args) {
        if (object == null || object.size() == 0)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void notEmpty(Object[] object, String message, Object... args) {
        if (object == null || object.length == 0)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void notEmpty(CharSequence object, String message, Object... args) {
        if (object == null || object.length() == 0)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void hasText(String object, String message, Object... args) {
        if (object == null || object.length() == 0 || object.trim().length() == 0)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void isTrue(boolean object, String message, Object... args) {
        if (! object)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void isFalse(boolean object, String message, Object... args) {
        if (object)
            throw new IllegalArgumentException(String.format(message, args));
    }

    public static void notEmptyElements(Collection<?> object, String message, Object... args) {
        notEmpty(object, message, args);
        for (Object element : object) {
            if (element instanceof CharSequence)
                notEmpty((CharSequence)element, message, args);
            else
                notNull(element, message, args);
        }
    }

    public static void notEmptyElements(Map<?, ?> object, String message, Object... args) {
        notEmpty(object, message, args);
        for (Object element : object.values()) {
            if (element instanceof CharSequence)
                notEmpty((CharSequence)element, message, args);
            else
                notNull(element, message, args);
        }
    }

    public static void notEmptyElements(Object[] object, String message, Object... args) {
        notEmpty(object, message, args);
        for (Object element : object) {
            if (element instanceof CharSequence)
                notEmpty((CharSequence)element, message, args);
            else
                notNull(element, message, args);
        }
    }

}
