package com.onssoftware.RelationalDbExercise.service;

import com.onssoftware.RelationalDbExercise.model.Database;

public class Service {

    private final Database database;

    public Service(Database database) {
        this.database = database;
    }

    public boolean query(String query) {
        return database.isAvailable();
    }

    @Override
    public String toString() {
        return "Using database with id: " + String.valueOf(database.getUniqueId());
    }
}
