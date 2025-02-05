package ru.nedorezova.groupingByProblems;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByProblem10 {

    record Student(String name, int course, int score){}

    //Задача 10: Группировка студентов по курсу и вывод максимального балла в каждой группе
    //Представим, что у вас есть список студентов, каждый студент имеет имя, курс и балл.
    //Нужно сгруппировать студентов по курсу и найти максимальный балл среди студентов каждого курса.

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", 1, 90),
                new Student("Bob", 2, 85),
                new Student("Charlie", 1, 95),
                new Student("David", 2, 92),
                new Student("Eve", 3, 88),
                new Student("Frank", 3, 92)
        );

        Map<Integer, Optional<Student>> maxScoreByCourse = getMaxByScoreByCourse(students);

        System.out.println(maxScoreByCourse);
        /* Вывод:
        {1=Optional[Student[name=Charlie, course=1, score=95]],
        2=Optional[Student[name=David, course=2, score=92]],
        3=Optional[Student[name=Frank, course=3, score=92]]}
        */
    }

    private static Map<Integer, Optional<Student>> getMaxByScoreByCourse(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::course,
                        Collectors.maxBy(Comparator.comparingInt(Student::score))
                ));
    }


}
