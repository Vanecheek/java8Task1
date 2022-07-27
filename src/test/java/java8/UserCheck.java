package java8;

import java.util.ArrayList;
import java.util.List;

public interface UserCheck {
    boolean userCondition(User user);

    static List<User> getCondition(List<User> users, UserCheck userCheck){
        List<User> filtrationResult = new ArrayList<>();
        for(User user: users){
            if(userCheck.userCondition(user)) {
                filtrationResult.add(user);
                System.out.println(filtrationResult);
            }
        }
        return filtrationResult;
    }
}
