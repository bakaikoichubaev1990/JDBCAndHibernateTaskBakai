package peaksoft;


import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//       userService.dropUsersTable();
//        userService.createUsersTable();
//userService.saveUser("Argen", "Abdymomunov",  (byte) 19);
//userService.saveUser("Argen", "Abdymomunov",  (byte) 19);
//userService.saveUser("Argen", "Abdymomunov",  (byte) 19);
//userService.saveUser("Argen", "Abdymomunov",  (byte) 19);
//userService.saveUser("Argen", "Abdymomunov",  (byte) 19);

        //userService.removeUserById(1);
        //System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

    }
}
