package java8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUsers {
    User first = new User(24,78,"Gena","ITshnik", true);
    User second = new User(18,45,"Lena","PR", false);
    User third = new User(11,90,"Vanya","PM", true);
    User fourth = new User(13,150,"Ksyuha","Businessman", false);
    User fifth = new User(45,49,"Lesha","Architector", true);
    User sixth = new User(54,56,"Vadym","Car maker", true);
    User seventh = new User(12,78,"Vanya","ITshnik", true);
    User eighth = new User(32,98,"Vanek","ITshnik", true);
    User ninth = new User(14,78,"Kiril","Lyoha", true);
    User tenth = new User(65,73,"Gena","ITshnik", true);
    User eleventh = new User(32,163,"Gena","Police", true);
    User twelfth = new User(12,45,"Vova","ITshnik", true);
    User thirteenth = new User(15,23,"Mark","ITshnik", true);
    User fourteenth = new User(19,65,"Den","ITshnik", true);
    User fifteenth = new User(15,23,"Bodya","ITshnik", true);

    List<User> users = Arrays.asList(first,second,third,fourth,fifth,sixth,seventh, eighth,
            ninth, tenth, eleventh, twelfth, thirteenth,fourteenth, fifteenth);

    @Test
    public void testFilterByName(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.getName() == "Vanek";
            }
        });

        for(User user: res){
            Assert.assertEquals(user.getName(),"Vanek");
        }
    }

    @Test
    public void testFilterByAge(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.getAge() == 18;
            }
        });

        for(User user: res){
            Assert.assertEquals(user.getAge(),18);
        }
    }

    @Test
    public void testFilterBySex(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.isSex();
            }
        });

        for(User user: res){
            Assert.assertTrue(user.isSex());
        }
    }

    @Test
    public void testFilterBySpeciality(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.getSpeciality() == "Police";
            }
        });

        for(User user: res){
            Assert.assertEquals(user.getSpeciality(),"Police");
        }
    }

    @Test
    public void testFilterByWeight(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.getWeight() <= 100;
            }
        });

        for(User user: res){
            Assert.assertTrue(user.getWeight() <= 100);
        }
    }

    @Test
    public void testFilterByBigITshnik(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.getAge() >= 18 && user.getSpeciality() == "ITshnik";
            }
        });

        for(User user: res){
            Assert.assertTrue(user.getAge() >= 18 && user.getSpeciality() == "ITshnik");
        }
    }

    @Test
    public void testFilterByMaleITshnik(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.isSex() && user.getSpeciality() == "ITshnik";
            }
        });

        for(User user: res){
            Assert.assertTrue(user.isSex() && user.getSpeciality() == "ITshnik");
        }
    }

    @Test
    public void testFilterByFemaleITshnik(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return !user.isSex() && user.getSpeciality() == "ITshnik";
            }
        });

        for(User user: res){
            Assert.assertTrue(!user.isSex() && user.getSpeciality() == "ITshnik");
        }
    }

    @Test
    public void testFilterByFirstLetter(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.getName().startsWith("V");
            }
        });

        for(User user: res){
            Assert.assertTrue(user.getName().startsWith("V"));
        }
    }

    @Test
    public void testFilterByBigPolice(){
        List<User> res = UserCheck.getCondition(users, new UserCheck() {
            @Override
            public boolean userCondition(User user) {
                return user.getSpeciality() == "Police" && user.getWeight() >= 100;
            }
        });

        for(User user: res){
            Assert.assertTrue(user.getSpeciality() == "Police" && user.getWeight() >= 100);
        }
    }
}
