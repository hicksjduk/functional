package uk.org.thehickses.functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public interface Curry
{
    public static <T, R> Supplier<R> of(Function<? super T, R> func, T arg)
    {
        return () -> func.apply(arg);
    }
    
    public static <T, U, R> Function<U, R> ofFirst(BiFunction<? super T, U, R> func, T arg1)
    {
        return arg2 -> func.apply(arg1, arg2);
    }
    
    public static <T, U, R> Function<T, R> ofSecond(BiFunction<T, ? super U, R> func, U arg2)
    {
        return arg1 -> func.apply(arg1, arg2);
    }

    public static <T, U, R> Supplier<R> ofBoth(BiFunction<? super T, ? super U, R> func, T arg1, U arg2)
    {
        return () -> func.apply(arg1, arg2);
    }

    public static <T> Supplier<T> of(UnaryOperator<T> func, T arg)
    {
        return () -> func.apply(arg);
    }
    
    public static <T> UnaryOperator<T> ofFirst(BinaryOperator<T> func, T arg1)
    {
        return arg2 -> func.apply(arg1, arg2);
    }
    
    public static <T> UnaryOperator<T> ofSecond(BinaryOperator<T> func, T arg2)
    {
        return arg1 -> func.apply(arg1, arg2);
    }

    public static <T> Supplier<T> ofBoth(BinaryOperator<T> func, T arg1, T arg2)
    {
        return () -> func.apply(arg1, arg2);
    }

    public static <T> IntSupplier of(ToIntFunction<? super T> func, T arg)
    {
        return () -> func.applyAsInt(arg);
    }
    
    public static <T, U> ToIntFunction<U> ofFirst(ToIntBiFunction<? super T, U> func, T arg1)
    {
        return arg2 -> func.applyAsInt(arg1, arg2);
    }
    
    public static <T, U> ToIntFunction<T> ofSecond(ToIntBiFunction<T, ? super U> func, U arg2)
    {
        return arg1 -> func.applyAsInt(arg1, arg2);
    }
    
    public static <T, U> IntSupplier ofBoth(ToIntBiFunction<? super T, ? super U> func, T arg1, U arg2)
    {
        return () -> func.applyAsInt(arg1, arg2);
    }

    public static <T> Supplier<T> of(IntFunction<T> func, int arg)
    {
        return () -> func.apply(arg);
    }

    public static IntSupplier of(IntUnaryOperator func, int arg)
    {
        return () -> func.applyAsInt(arg);
    }
    
    public static IntUnaryOperator ofFirst(IntBinaryOperator func, int arg1)
    {
        return arg2 -> func.applyAsInt(arg1, arg2);
    }
    
    public static IntUnaryOperator ofSecond(IntBinaryOperator func, int arg2)
    {
        return arg1 -> func.applyAsInt(arg1, arg2);
    }
    
    public static IntSupplier ofBoth(IntBinaryOperator func, int arg1, int arg2)
    {
        return () -> func.applyAsInt(arg1, arg2);
    }
}
