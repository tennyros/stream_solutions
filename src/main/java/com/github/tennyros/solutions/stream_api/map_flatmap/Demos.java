package com.github.tennyros.solutions.stream_api.map_flatmap;

import java.util.List;
import java.util.stream.Collectors;

public class Demos {

    public static void main(String[] args) {
        List<String> words = List.of("hello", "world");

        List<List<Character>> mapResult = words.stream()
                .map(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println(mapResult);

        List<Character> flatMapResult = words.stream()
                .flatMap(word -> word.chars()
                        .mapToObj(c -> (char) c))
                .collect(Collectors.toList());

        System.out.println(flatMapResult);

    }

}
