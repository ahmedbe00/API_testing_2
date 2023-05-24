package placelab.utilities;

import java.security.SecureRandom;
import java.util.Random;

public class RandomGenerator {

        private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz1234567890";
        private static final int EMAIL_LENGTH = 10;
    private static final String CHARACTERS2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    private static final int PASSWORD_LENGTH = 8;

        public static String generateRandomEmail() {
            StringBuilder email = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < EMAIL_LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                char randomChar = CHARACTERS.charAt(randomIndex);
                email.append(randomChar);
            }

            email.append("@example.com");

            return email.toString();
        }
    public static String generateRandomPassword() {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }

        public static void main(String[] args) {
            String randomEmail = generateRandomEmail();
            String randomPassword = generateRandomPassword();
        }
    }


