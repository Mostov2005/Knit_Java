package org.knit.sem2.lab1.task1;

// Конкретные обработчики
class JuniorManager extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 1000;
    }

    protected void approve(int amount, String description) {
        System.out.println("Младший менеджер одобрил \"" + description + "\" на $" + amount);
    }
}
