package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testToFindOneTaskByName() {   // Тест на  поиск простой  задачи по контексту
        SimpleTask simpleTask = new SimpleTask(3, "титул");
        Assertions.assertTrue(simpleTask.matches("титул"));
        Assertions.assertFalse(simpleTask.matches("Титул"));

    }

    @Test
    public void testToFindEpicByName() {   // Тест на поиск подзадачи (Epic) по контексту
        String[] subtasks = {"молоко", "яица", "хлеб"};
        Epic epic = new Epic(2, subtasks);
        Assertions.assertTrue(epic.matches("молоко"));
        Assertions.assertFalse(epic.matches("Молоко"));

    }

    @Test
    public void testToFindEpicByNameMeeting() {   // Тест на поиск назначенной встречи по контексту темы или проекту
        Meeting meeting = new Meeting(34, "Выкладка приложения 3й версии", "приложение Нетобанка", "четверг");
        Assertions.assertTrue(meeting.matches("3й"));
        Assertions.assertFalse(meeting.matches("3ё"));

        Assertions.assertTrue(meeting.matches("приложение"));
        Assertions.assertFalse(meeting.matches("приложенние"));

    }

    @Test
    public void testIdMeeting() { // Тест на проверку  назначенной встречи по (ID)
        Meeting meeting = new Meeting(28, "Выкладка приложения 3й версии", "приложение Нетобанка", "пятница");
        Assertions.assertEquals(28, meeting.getId());
    }

    @Test
    public void testGetTitle() { // Тест на проверку простой задачи по заголовку
        SimpleTask simpleTask = new SimpleTask(1, "позвонить родителям");
        Assertions.assertEquals("позвонить родителям", simpleTask.getTitle());

    }

    @Test
    public void testGetSubtasks() {  // Тест на проверку  назначенной встречи по массиву подзадачи
        String[] subtasks = {"молоко", "яица", "хлеб"};
        Epic epic = new Epic(32, subtasks);
        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());

    }

    @Test
    public void testGetMeeting() {  // Тест на проверку назначенной встречи по теме обсуждения проекту дате и времени старту
        Meeting meeting = new Meeting(34, "Выкладка приложения 3й версии", "приложение Нетобанка", "четверг");
        Assertions.assertEquals("Выкладка приложения 3й версии", meeting.getTopic());
        Assertions.assertEquals("приложение Нетобанка", meeting.getProject());
        Assertions.assertEquals("четверг", meeting.getStart());


    }

    @Test
    public void testSearchEmptyTaskEpic() { // Тест на проверку пустого массива в задаче
        Epic epic1 = new Epic(32, new String[]{});
        Assertions.assertFalse(epic1.matches("молоко"));

    }

}
