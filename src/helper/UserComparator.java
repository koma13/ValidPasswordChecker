package helper;

import model.User;

import java.util.Comparator;

/**
 * Created by Mariia_Kogut on 11/26/2015.
 */
public class UserComparator implements Comparator<User>{

    @Override
    public int compare(User o1, User o2) {

        int nameCompare = o1.getName().compareTo(o2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        } else {
            return o1.getLogin().compareTo(o2.getLogin());
        }
    }

}
