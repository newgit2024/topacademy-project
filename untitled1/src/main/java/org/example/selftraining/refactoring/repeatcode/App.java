package org.example.selftraining.refactoring.repeatcode;

public class App {
    public static void main(String[] args) {
        /*1.
        public void processUserData(User user) {
            if (user.isAdmin()) {
                // код для обработки данных администратора
                log.info("Processing admin data");
                // ...
            } else {
                // код для обработки данных обычного пользователя
                log.info("Processing regular user data");
                // ...
            }
        }*/

        /*2.
        public void processUserData(User user) {
            if (user.isAdmin()) {
                processAdminData(user);
            } else {
                processRegularUserData(user);
            }
        }

        private void processAdminData(User user) {
            log.info("Processing admin data");
            // ...
        }

        private void processRegularUserData(User user) {
            log.info("Processing regular user data");
            // ...
        }*/




    }
}
