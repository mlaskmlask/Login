package com.company.database;

import com.company.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    private List<User> userList = new ArrayList<>();
    private static final UsersRepository usersRepository = new UsersRepository();

    private UsersRepository() {
        this.userList.add(new User("admin", DigestUtils.md5Hex("admin")));
    }

    public static UsersRepository getInstance() {
        return usersRepository;
    }

    public boolean authenticate(String login, String pass) {
        for (User user : this.userList) {
            if (user.getLogin().equals(login)) {
                if (user.getPass().equals(DigestUtils.md5Hex(pass))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean register(String login, String pass) {
        for (User currentUser : this.userList) {
            if (currentUser.getLogin().equals(login)) {
                return false;
            }
        }
        this.userList.add(new User(login, DigestUtils.md5Hex(pass)));
        return true;
    }
}
