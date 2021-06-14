package ch05.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * [타입 안정 이종 컨테이너 패턴 예제]
 * 타입별로 즐겨 찾는 인스턴스를 저장하고 검색할 수 있는 Favorites 클래스
 */
public class Favorites {

    public Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(
                Objects.requireNonNull(type), // null 제외 보장
                type.cast(instance)); // 런타임에서 타입 안정성 확
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type)); // 동적 타입 캐스팅
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();

        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

//        f.putFavorite((Class)Integer.class, "인티저 클래스 아닌 것");

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.println(favoriteString);
        System.out.println(favoriteInteger);
        System.out.println(favoriteClass.getName());

        System.out.println(f.getFavorite(Integer.class));
    }
}
