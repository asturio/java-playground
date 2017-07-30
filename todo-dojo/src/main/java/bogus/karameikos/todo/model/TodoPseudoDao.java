package bogus.karameikos.todo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoPseudoDao {
    private static final List<Todo> todoList = new ArrayList<>();
    private static int maxId = 0;

    public int size() {
        return todoList.size();
    }

    public void add(Todo todo) {
        if (todo != null) {
            todoList.add(todo);
//        synchronized (todoList) {
            todo.setId(++maxId);
//        }
        }


    }

    public List<Todo> getAll() {
        return Collections.unmodifiableList(todoList);
    }
}
