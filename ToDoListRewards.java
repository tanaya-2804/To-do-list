import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ToDoListWithRewards {
    static ArrayList<String> tasks = new ArrayList<>();
    static String[] rewards = {
        "Great job! You're unstoppable!",
        "Woohoo! Here's your gold star ⭐.",
        "One step closer to ruling the world!",
        "You're on fire! Keep it going!"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("1. Add Task | 2. Complete Task | 3. View Tasks | 4. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": 
                    System.out.println("Enter task name: ");
                    tasks.add(scanner.nextLine());
                    break;
                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to complete.");
                    } else {
                        System.out.println("Enter task number to complete: ");
                        int taskIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (taskIndex >= 0 && taskIndex < tasks.size()) {
                            tasks.remove(taskIndex);
                            System.out.println(rewards[random.nextInt(rewards.length)]);
                        }
                    }
                    break;
                case "3":
                    if (tasks.isEmpty()) System.out.println("No tasks available.");
                    else for (int i = 0; i < tasks.size(); i++) System.out.println((i + 1) + ". " + tasks.get(i));
                    break;
                case "4": 
                    System.out.println("Goodbye!"); 
                    return;
                default: 
                    System.out.println("Invalid option.");
            }
        }
    }
}
