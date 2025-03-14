package org.knit.sem2.lab1.task1;

class Director extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 50000; // Директор одобряет до 50,000
    }

    @Override
    protected void approve(int amount, String description) {
        System.out.println("Директор одобрил запрос \"" + description + "\" на $" + amount);
    }
}
