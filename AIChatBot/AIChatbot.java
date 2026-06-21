package codealpha;

import java.util.Scanner;
import java.time.LocalDateTime;

class ChatBot {

    public String getResponse(String message) {

        message = message.toLowerCase();

        if (message.contains("hello") || message.contains("hi")) {
            return "Hello! How can I help you today?";
        }

        else if (message.contains("how are you")) {
            return "I am doing great. Thank you for asking!";
        }

        else if (message.contains("your name")) {
            return "My name is CodeAlpha AI ChatBot.";
        }

        else if (message.contains("java")) {
            return "Java is an Object-Oriented Programming language used for developing applications.";
        }

        else if (message.contains("oops")) {
            return "OOPS stands for Object Oriented Programming System.";
        }

        else if (message.contains("internship")) {
            return "Internships help students gain practical industry experience.";
        }

        else if (message.contains("time")) {
            return "Current Date and Time: " + LocalDateTime.now();
        }

        else if (message.contains("help")) {
            return "You can ask me about Java, OOPS, Internship, Time, or general greetings.";
        }

        else if (message.contains("bye")) {
            return "Goodbye! Have a wonderful day.";
        }

        else {
            return "Sorry, I don't understand that. Type 'help' for suggestions.";
        }
    }
}

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChatBot bot = new ChatBot();

        System.out.println("================================");
        System.out.println("     CODEALPHA AI CHATBOT");
        System.out.println("================================");
        System.out.println("Type 'bye' to exit.");
        System.out.println();

        while (true) {

            System.out.print("You: ");
            String userInput = sc.nextLine();

            String response = bot.getResponse(userInput);

            System.out.println("Bot: " + response);

            if (userInput.equalsIgnoreCase("bye")) {
                break;
            }
        }

        sc.close();
    }
}