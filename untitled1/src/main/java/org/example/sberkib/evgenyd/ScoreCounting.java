package org.example.sberkib.evgenyd;
//дана список имен студентов и их оценок за каждый день - на выходе получить
// общее количество баллов - за первый день баллы удваиваются, за второй утраиваются и т.д.
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreCounting {
    public static void main(String[] args) {
        Map<String, List<Integer>> studentsScores = new HashMap<>();
        studentsScores.put("Alice", List.of(10, 5, 8, 7));
        studentsScores.put("Bob", List.of(9, 6, 5, 4));
        studentsScores.put("Eve", List.of(7, 8, 9, 10));

        Map<String, Integer> totalScores = calculateTotalScores(studentsScores);
        for (Map.Entry<String, Integer> entry : totalScores.entrySet()) {
            System.out.println(entry.getKey() + ": Total score = " + entry.getValue());
        }
    }

    public static Map<String, Integer> calculateTotalScores(Map<String, List<Integer>> studentsScores) {
        Map<String, Integer> totalScores = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : studentsScores.entrySet()) {
            String student = entry.getKey();
            List<Integer> dailyScores = entry.getValue();
            int total = 0;
            for (int i = 0; i < dailyScores.size(); i++) {
                total += dailyScores.get(i) * (i + 1);
            }
            totalScores.put(student, total);
        }
        return totalScores;
    }

    public static Map<String, Integer> calculateTotalScores2(List<String> students, List<List<Integer>> studentsScores) {
        return IntStream.range(0, students.size())
                .boxed()
                .collect(Collectors.toMap(
                        students::get,
                        i -> studentsScores.get(i).stream()
                                .mapToInt(score -> score * (i + 1))
                                .sum()
                ));
    }
}

