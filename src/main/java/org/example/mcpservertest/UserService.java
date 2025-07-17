package org.example.mcpservertest;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    {
        users.add(new User(1L, "user1"));
        users.add(new User(2L, "user2"));
        users.add(new User(3L, "user3"));
        users.add(new User(4L, "user4"));
        users.add(new User(5L, "user5"));
    }

    @Tool(description = "Get all users on database")
    public List<User> getAllUsers() {
        return users;
    }

    @Tool(description = "Get user by id")
    public User getUserById(@ToolParam(description = "Id the user to get") long id) {
        return users.stream()
                .filter(user -> user.id() == id)
                .findFirst()
                .orElse(null);
    }

    @Tool(description = "Create user in database")
    public User createUser(@ToolParam(description = "Name of user to create") String name) {
        long id = System.currentTimeMillis();
        User user = new User(id, name);
        this.users.add(user);
        return user;
    }



}
