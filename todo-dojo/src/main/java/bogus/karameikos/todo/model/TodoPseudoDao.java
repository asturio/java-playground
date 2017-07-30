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
            todo.setId(++maxId);
            todoList.add(cloneTodo(todo));
//        synchronized (todoList) {
//        }
        }
    }

    public List<Todo> getAll() {
        return Collections.unmodifiableList(todoList);
    }

    private Todo cloneTodo(Todo source) {
        Todo target = null;
        if (source != null) {
            target = new Todo();
            target.setName(source.getName());
            target.setBeschreibung(source.getBeschreibung());
            target.setId(source.getId());
        }
        return target;
    }
}
