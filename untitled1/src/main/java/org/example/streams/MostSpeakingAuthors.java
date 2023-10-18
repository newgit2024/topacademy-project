package org.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostSpeakingAuthors {
    public static void main(String[] args) {
        List<String> replicas = getReplicas();
        System.out.println(findMostSpeaking(replicas, 2));
    }


    private static List<String> findMostSpeaking(List<String> replicas, int limitCount) {
        Map<String, Long> authorCounts = replicas.stream()
                .map(replica -> replica.split(": "))
                .collect(Collectors.groupingBy(
                        parts -> parts[0],
                        Collectors.counting()
                ));
        return authorCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limitCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    private static List<String> getReplicas() {
        return List.of(" Andrew: hello", " Peter: how are you", " Andrew: I'm fine", " Andrew: and you?", " John: it's a good weather today", " Joshua: yes", " Peter: yes");
    }
}


