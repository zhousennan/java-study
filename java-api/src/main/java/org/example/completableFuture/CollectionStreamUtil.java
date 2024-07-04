package org.example.completableFuture;

import org.example.future.User;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: zsn
 * @Date: 2024/5/15 16:11
 * @Description: 集合Stream流处理工具类
 * @Version: 1.0
 */
public class CollectionStreamUtil {


    /**
     * 集合转Map
     * @param collection
     * @param keyMapper
     * @return
     * @param <T>
     * @param <K>
     */
    public static <T, K> Map<K, T> collectionToMap(Collection<T> collection, Function<? super T, ? extends K> keyMapper) {
        return toMap(collection, keyMapper, Function.identity());
    }

    public static <T, K, V> Map<K, V> toMap(Collection<T> collection, Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        return toMap(collection, keyFunction, valueFunction, pickSecond());
    }

    public static <T, K, V> Map<K, V> toMap(Collection<T> collection, Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction) {
        if (CollectionUtils.isEmpty(collection)) {
            return new HashMap<>(0);
        }

        return collection.stream().collect(Collectors.toMap(keyFunction, valueFunction, mergeFunction));
    }

    public static <T> BinaryOperator<T> pickFirst() {
        return (k1, k2) -> k1;
    }

    public static <T> BinaryOperator<T> pickSecond() {
        return (k1, k2) -> k2;
    }

    /**
     * map to mapValue
     * @param map 需要转化的map
     * @param valueFunction  转化格式
     * @param mergeFunction  重复key选择
     * @return
     * @param <K>
     * @param <V>
     * @param <C>
     */
    public static <K, V, C> Map<K, C> mapConvertMapValue(Map<K, V> map, BiFunction<K, V, C> valueFunction, BinaryOperator<C> mergeFunction) {
        if (CollectionUtils.isEmpty(map)) {
            return new HashMap<>();
        }
        return map.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> valueFunction.apply(e.getKey(), e.getValue()), mergeFunction));
    }

    /**
     * map to map Property
     * @param originMap map集合
     * @param valueConverter 获取的属性
     * @return
     * @param <K>
     * @param <V>
     * @param <C>
     */
    public static <K, V, C> Map<K, C> mapConvertMapValue(Map<K, V> originMap, BiFunction<K, V, C> valueConverter) {
        return mapConvertMapValue(originMap, valueConverter, CollectionStreamUtil.pickSecond());
    }


    /**
     * Collection to list
     * @param collection
     * @return
     * @param <T>
     */
    public static <T> List<T> collectionToList(Collection<T> collection) {
        if (collection == null) {
            return new ArrayList<>();
        }
        if (collection instanceof List) {
            return (List<T>) collection;
        }
        return collection.stream().collect(Collectors.toList());
    }

    /**
     * convert collection to set
     * @param collection
     * @return
     * @param <T>
     */
    public static <T> Set<T> collectionToSet(Collection<T> collection) {
        if (collection == null) {
            return new HashSet<>();
        }
        if (collection instanceof Set) {
            return (Set<T>) collection;
        }
        return collection.stream().collect(Collectors.toSet());
    }

    /**
     * list集合转list
     * @param collection list集合
     * @param mapper 集合元素转换
     * @return
     * @param <T>
     * @param <R>
     */
    public static <T, R> List<R> listToPropertyList(List<T> collection, Function<T, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * set集合转set list
     * @param collection set集合
     * @param mapper 集合元素转换
     * @return
     * @param <T>
     * @param <R>
     */
    public static <T, R> Set<R> setListToPropertySetList(Set<T> collection, Function<T, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toSet());
    }

    /**
     * collection集合获取属性转list
     * @param collection
     * @param mapper
     * @return
     * @param <T>
     * @param <R>
     */
    public static <T, R> List<R> collectionToPropertyList(Collection<T> collection, Function<T, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * collection集合获取属性转set
     * @param collection
     * @param mapper
     * @return
     * @param <T>
     * @param <R>
     */
    public static <T, R> Set<R> collectionToPropertySet(Collection<T> collection, Function<T, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toSet());
    }


    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        users.add(new User(1, "张三", 18));

        collectionToMap(users, User::getId);

        Map<Integer, User> integerUserHashMap = new HashMap<>();

        mapConvertMapValue(integerUserHashMap, (k, v) -> v.getId());
    }
}
