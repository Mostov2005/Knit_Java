package org.knit.sem2.lab1.task1;

public class Task2_1 {

    public static void main(String[] args) {
        // Создаем обработчиков
        Approver junior = new JuniorManager();
        Approver senior = new SeniorManager();
        Approver director = new Director();

        // Устанавливаем цепочку: junior -> senior -> director
        junior.setNextApprover(senior);
        senior.setNextApprover(director);

        Problem problem1 = new Problem("Кредит", 100);
        Problem problem2 = new Problem("Кредит", 9000);
        Problem problem3 = new Problem("Кредит", 49000);
        Problem problem4 = new Problem("Кредит", 99000);


        // Запросы на одобрение разных сумм
        junior.processRequest(problem1);   // Младший менеджер одобряет
        junior.processRequest(problem2);  // Старший менеджер одобряет
        junior.processRequest(problem3); // Директор одобряет
        junior.processRequest(problem4); // Превышает лимит – запрос отклонен
    }
}

